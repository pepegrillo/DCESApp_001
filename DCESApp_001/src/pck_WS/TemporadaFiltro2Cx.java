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

import pck_SG.Filtro2SG;
import configurations.ConexionController;
import configurations.DbSql;
import configurations.Strings;

public class TemporadaFiltro2Cx {

	
	private String connectionURL;
	private HttpConnection conn;
	private InputStream is;
	private ByteArrayOutputStream bos;
	private String response;
	
	String tipoConexion = ConexionController.getConnectionString()[0];
	String getTipo = ConexionController.getConnectionString()[1];
	
	public Vector IdTipoSondeo   = new Vector();
	public Vector TipoSondeo     = new Vector();
	
	public Vector IdArticulo     = new Vector();
	public Vector Presentacion   = new Vector();
	
	public String errorCode    = new String();
	public String errorMessage = new String();
	
	DbSql path = new DbSql();
	DbSql statement = new DbSql();
	private int incremento;
	private int incremento2;
	
	Filtro2SG filtro2 = new Filtro2SG();
	
	public TemporadaFiltro2Cx(String idMunicipio){
		
		try{
			URI uri = URI.create(path.Path());
			Database sqliteDB = DatabaseFactory.open(uri);
			
			Statement se = sqliteDB.createStatement(statement.SelectFiltro2(idMunicipio));
			se.prepare();
			Cursor c = se.getCursor();
			Row r;
			while(c.next()){
				r = c.getRow();
				incremento ++;
			}
			c.close();
			se.close();
			
			Statement se2 = sqliteDB.createStatement(statement.SelectFiltro3(idMunicipio));
			se2.prepare();
			Cursor c2 = se2.getCursor();
			Row r2;
			while(c2.next()){
				r2 = c2.getRow();
				incremento2 ++;
			}
			c2.close();
			se2.close();
			
			sqliteDB.close();
			if((incremento == 0)&&(incremento2 == 0)){
				if(getTipo.equals("wifi")){
					Status.show(Strings.MSG_DESCARGANDO);
					eliminarDatos(idMunicipio);
					descargarDatos(idMunicipio);
					//Dialog.alert("si tengo inter saul pepe"+incremento);
				}else if(getTipo.equals("BIBS")){
					Status.show(Strings.MSG_DESCARGANDO_SLOW);
					eliminarDatos(idMunicipio);
					descargarDatos(idMunicipio);
					//Dialog.alert("no tengo inter rojo "+incremento);
				}else{
					Status.show(Strings.CONEXION_DESCONECTED);
					errorMessage = "En este momento no se pueden \n mostrar datos " +
		            		"intentelo de nuevo m�s tarde";
					//Dialog.alert("no tengo inter no hay "+incremento);
					//onClose();
				}
			//S� hay datos
			}else if((incremento >= 1)&&(incremento2 >= 1)){
				if(getTipo.equals("wifi")){
					Status.show(Strings.MSG_DESCARGANDO);
					eliminarDatos(idMunicipio);
					descargarDatos(idMunicipio);
					//Dialog.alert("no tengo inter descargar "+incremento);
					
				}else{					
					cargarDatos(idMunicipio);
					errorMessage = "No se encontrar�n datos disponibles.";
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			errorMessage = "En este momento no se pueden \n mostrar datos " +
        		"intentelo de nuevo m�s tarde";
		}
		
	
	}

	public void descargarDatos(String idmunicipio){
		
		try{
			
			connectionURL = Strings.HTTP_SW+"getFiltrosBusqueda/"+idmunicipio+"/"+tipoConexion;

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
	            
		            String resultado2  =  objeto2.getString("msg");
		            
		            JSONObject objeto3 =  new  JSONObject ( resultado2 );
		            
		            JSONArray jsonArrSondeo = objeto3.getJSONArray("tiposSondeos");
				
	            	for (int i = 0; i < jsonArrSondeo.length(); i++) {
		            	
		            	JSONObject childJSONObject = jsonArrSondeo.getJSONObject(i);
		            			            	
		            	//IdTipoSondeo.addElement(childJSONObject.get("idTipoSondeo"));
		            	//TipoSondeo.addElement(childJSONObject.get("tipoSondeo"));
		            	
		            	try{
			            	URI uri1 = URI.create(path.Path());
							Database sqliteDB1 = DatabaseFactory.open(uri1);
							Statement in = sqliteDB1.createStatement(
									statement.InsertEstablecimiento(idmunicipio,
															childJSONObject.getString("idTipoSondeo"),
															childJSONObject.getString("tipoSondeo")));
							//Dialog.alert(in+"<combo1");
							in.prepare();
							in.execute();
							in.close(); 
							sqliteDB1.close();
		            	}catch (Exception e){
		            		errorMessage = "No hay datos disponible para la b�squeda realizada, " +
				            		"intentelo m�s tarde";
		 	     		}
		            
	            	}
	            	
	            	//cargarDatos(idmunicipio);
	            	
	            	JSONArray jsonArrPresentacion = objeto3.getJSONArray("presentacion");
	    			
	            	for (int i = 0; i < jsonArrPresentacion.length(); i++) {
		            	
		            	JSONObject childJSONObject = jsonArrPresentacion.getJSONObject(i);
		            	
		            	//IdArticulo.addElement(childJSONObject.get("idArticulo"));
		            	//Presentacion.addElement(childJSONObject.get("presentacion"));
		            	
		            	try{
			            	URI uri2 = URI.create(path.Path());
							Database sqliteDB2 = DatabaseFactory.open(uri2);
							Statement in2 = sqliteDB2.createStatement(
									statement.InsertPresentacion(idmunicipio,
															childJSONObject.getString("idArticulo"),
															childJSONObject.getString("presentacion")));
							//Dialog.alert(in2+"<combo2");
							in2.prepare();
							in2.execute();
							in2.close();
							sqliteDB2.close();
		            	}catch (Exception e){
		            		errorMessage = "En este momento no se pueden \n mostrar datos " +
				            		"intentelo de nuevo m�s tarde";
		 	     		}
		            
	            	}
	            	
	            	cargarDatos(idmunicipio);
	            	
	            }else if (errorCode.equals("1")){
		            errorMessage = "En este momento no se pueden \n mostrar datos " +
		            		"intentelo de nuevo m�s tarde";
	            	
	            }
            
	        }
	            
	        }catch (Exception e) {
				// TODO: handle exception
	        	errorMessage = "En este momento no se pueden \n mostrar datos " +
	            		"intentelo de nuevo m�s tarde";
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
	
	public void cargarDatos(String idmunicipio){
		
		try{
			URI uri = URI.create(path.Path());
			Database sqliteDB = DatabaseFactory.open(uri);

      		Statement selectR = sqliteDB.createStatement(statement.SelectFiltro2(idmunicipio));
      		//Dialog.alert("Entro a la base"+statement.SelectFiltro2(idmunicipio));
      		selectR.prepare();
                   Cursor cursorR = selectR.getCursor();
                   Row rc;
                   //int i = 0;
                   while(cursorR.next()){
                       rc = cursorR.getRow();
                       IdTipoSondeo.addElement(rc.getString(1));
                       TipoSondeo.addElement(rc.getString(2));
                       //Dialog.alert("recorriendo combo 1>"+rc.getString(1)+rc.getString(2));
                   }
                   selectR.close();
                   cursorR.close();
                   //sqliteDB.close();
                   
                   
                   
           Statement selectR2 = sqliteDB.createStatement(statement.SelectFiltro3(idmunicipio));
           //Dialog.alert("Entro a la base"+statement.SelectFiltro3(idmunicipio));
           selectR2.prepare();
           		Cursor cursorR2 = selectR2.getCursor();
           		Row rc2;
           		//int i = 0;
           		while(cursorR2.next()){
           			rc2 = cursorR2.getRow();
           			IdArticulo.addElement(rc2.getString(1));
           			Presentacion.addElement(rc2.getString(2));
           			//Dialog.alert("recorriendo combo 2>"+rc2.getString(1)+rc2.getString(2));
           		}
           		selectR2.close();
           		cursorR2.close();
           		
           		sqliteDB.close();
           		
           		errorCode = "0";
		}catch(Exception e){
			errorMessage = "En este momento no se pueden \n mostrar datos " +
            		"intentelo de nuevo m�s tarde";
		}finally{
			filtro2.setIdTipoSondeo(IdTipoSondeo);
			filtro2.setTipoSondeo(TipoSondeo);
			
			filtro2.setIdArticulo(IdArticulo);
			filtro2.setPresentacion(Presentacion);
			
			filtro2.seterrorCode(errorCode);
			filtro2.seterrorMessage(errorMessage);
			
		}
		
	}
	
	public void eliminarDatos(String idmunicipio){
		
		try{
        	URI uri1 = URI.create(path.Path());
			Database sqliteDB1 = DatabaseFactory.open(uri1);
			
			Statement dt = sqliteDB1.createStatement(statement.DeleteEstablecimiento(idmunicipio));			
			dt.prepare();
			dt.execute();
			dt.close(); 
			
			Statement dt2 = sqliteDB1.createStatement(statement.DeletePresentacion(idmunicipio));			
			dt2.prepare();
			dt2.execute();
			dt2.close();
			
			sqliteDB1.close();
    	}catch (Exception e){
 			//Dialog.alert("error elements habits "+e.getMessage());
 		}
		
	}
	
	
}
