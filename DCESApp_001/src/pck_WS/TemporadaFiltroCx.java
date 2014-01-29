package pck_WS;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;

import net.rim.device.api.database.Cursor;
import net.rim.device.api.database.Database;
import net.rim.device.api.database.DatabaseFactory;
import net.rim.device.api.database.Row;
import net.rim.device.api.database.Statement;
import net.rim.device.api.io.URI;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.Status;

import org.json.me.JSONArray;
import org.json.me.JSONObject;

import pck_SG.FiltroSG;
import configurations.ConexionController;
import configurations.DbSql;
import configurations.Strings;

public class TemporadaFiltroCx {

	
	private String connectionURL;
	private HttpConnection conn;
	private InputStream is;
	private ByteArrayOutputStream bos;
	private String response;
	
	String tipoConexion = ConexionController.getConnectionString()[0];
	String getTipo = ConexionController.getConnectionString()[1];
	
	public Vector IdMunicipio   = new Vector();
	public Vector Municipio     = new Vector();
	
	public String errorCode    = new String();
	public String errorMessage = new String();
	
	DbSql path = new DbSql();
	DbSql statement = new DbSql();
	private int incremento;
	
	FiltroSG filtro = new FiltroSG();
	
	public TemporadaFiltroCx(String idCategoria){
		
		try{
			URI uri = URI.create(path.Path());
			Database sqliteDB = DatabaseFactory.open(uri);
			Statement se = sqliteDB.createStatement(statement.SelectTemporadaMunicipio(idCategoria));
			se.prepare();
			Cursor c = se.getCursor();
			Row r;
			while(c.next()){
				r = c.getRow();
				incremento ++;
			}
			c.close();
			se.close();
			sqliteDB.close();
			if(incremento == 0){
				if(getTipo.equals("wifi")){
					Status.show(Strings.MSG_DESCARGANDO);
					eliminarDatos(idCategoria);
					descargarDatos(idCategoria);
				}else if(getTipo.equals("BIBS")){
					Status.show(Strings.MSG_DESCARGANDO_SLOW);
					eliminarDatos(idCategoria);
					descargarDatos(idCategoria);
				}else{
					Status.show(Strings.CONEXION_DESCONECTED);
					errorMessage = "En este momento no se pueden \n mostrar datos " +
		            		"intentelo de nuevo más tarde";
					//onClose();
				}
			//Sí hay datos
			}else if(incremento >= 1){
				if(getTipo.equals("wifi")){
					Status.show(Strings.MSG_DESCARGANDO);
					eliminarDatos(idCategoria);
					descargarDatos(idCategoria);
					
				}else{					
					cargarDatos(idCategoria);
					 //Dialog.alert("no tengo inter "+incremento);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			errorMessage = "En este momento no se pueden \n mostrar datos " +
            		"intentelo de nuevo más tarde";
		}
		
	}
	
	public void descargarDatos(String idcategoria){
		

		try{
			
			connectionURL = "http://observatoriodeprecios.defensoria.gob.sv/v1/getFiltroMunicipios/"+idcategoria+"/"+tipoConexion;

	        conn = (HttpConnection) Connector.open(connectionURL);
	        conn.setRequestProperty("Content-Type","application/json");
	       // System.out.println("Response code : "+conn.getResponseCode());

	        if(conn.getResponseCode() == HttpConnection.HTTP_OK)
	        {

	            is = conn.openInputStream();
	            int ch=-1;
	            bos = new ByteArrayOutputStream();
	            while((ch = is.read())!=-1)
	            {
	                bos.write(ch);
	            }
	            response = new String(bos.toByteArray(),"UTF-8");
	            
	            JSONObject objeto1 =  new  JSONObject ( response );
	            String resultado1  = objeto1.getString("response");
	            	            	            
	            JSONObject objeto2 =  new  JSONObject ( resultado1 );
	            errorCode    = objeto2.getString("errorCode");
	            errorMessage = objeto2.getString("errorMessage");
	            
	            if(errorCode.equals("0")){
	            
		            JSONArray jsonMainArr = objeto2.getJSONArray("msg");
				
	            	for (int i = 0; i < jsonMainArr.length(); i++) {
		            	
		            	JSONObject childJSONObject = jsonMainArr.getJSONObject(i);
		            	
		            	try{
		            		URI uri1 = URI.create(path.Path());
		            		Database sqliteDB1 = DatabaseFactory.open(uri1);
		            		Statement in = sqliteDB1.createStatement(
		            				statement.InsertTemporadaMunicipio(idcategoria,
		            						childJSONObject.getString("idMunicipio"),
		            						childJSONObject.getString("municipio")));
		            		in.prepare();
							in.execute();
							in.close(); 
							sqliteDB1.close();
		            	}catch (Exception e) {
							// TODO: handle exception
		            		errorMessage = "En este momento no se pueden \n mostrar datos " +
				            		"intentelo de nuevo más tarde";
						}
		            	
		            
	            	}
	            	
	            	cargarDatos(idcategoria);
	            	
	            }else if (errorCode.equals("1")){
		            errorMessage = "En este momento no se pueden \n mostrar datos " +
		            		"intentelo de nuevo más tarde";
	            	
	            }
	        }
	            
	        }catch (Exception e) {
				// TODO: handle exception
	        	Dialog.alert("descargar datos "+e.getMessage());
			}finally{
				if(conn != null)
					try {
						conn.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            if(is != null)
					try {
						is.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            if(bos != null)
					try {
						bos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		
	}
	
	public void cargarDatos(String idcategoria){
		
		try{
			URI uri = URI.create(path.Path());
			Database sqliteDB = DatabaseFactory.open(uri);
			
			Statement selectR = sqliteDB.createStatement(statement.SelectTemporadaMunicipio(idcategoria));
			selectR.prepare();
			Cursor cursorR = selectR.getCursor();
			Row rc;
			
			while(cursorR.next()){
				rc = cursorR.getRow();
				IdMunicipio.addElement(rc.getString(1));
				Municipio.addElement(rc.getString(2));
			}
			
            selectR.close();
            cursorR.close();
            sqliteDB.close();
            errorCode = "0";
		}catch (Exception e) {
			// TODO: handle exception
			Dialog.alert("cargar datos "+e.getMessage());
			errorMessage = "En este momento no se pueden \n mostrar datos " +
            		"intentelo de nuevo más tarde";
		}finally{
			filtro.setIdMunicipio(IdMunicipio);
			filtro.setMunicipio(Municipio);
			filtro.seterrorCode(errorCode);
			filtro.seterrorMessage(errorMessage);
		}
		
	}
	
	public void eliminarDatos(String idcategoria){
		
		try{
        	URI uri1 = URI.create(path.Path());
			Database sqliteDB1 = DatabaseFactory.open(uri1);
			Statement dt = sqliteDB1.createStatement(statement.DeleteTemporadaMunicipio(idcategoria));
			
			dt.prepare();
			dt.execute();
			dt.close(); 
			sqliteDB1.close();
    	}catch (Exception e){
 			//Dialog.alert("error elements habits "+e.getMessage());
 		}
		
	}
	
}
