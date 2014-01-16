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

import pck_SG.CategoriaProductoSG;

import configurations.ConexionController;
import configurations.DbSql;
import configurations.Strings;

public class CategoriaProductoCx {
	
	private String connectionURL;
	private HttpConnection conn;
	private InputStream is;
	private ByteArrayOutputStream bos;
	private String response;
	
	String tipoConexion = ConexionController.getConnectionString()[0];
	String getTipo = ConexionController.getConnectionString()[1];
	
	public Vector IdCategoria   = new Vector();
	public Vector Categoria     = new Vector();
	
	public String errorCode    = new String();
	public String errorMessage = new String();
	
	DbSql path = new DbSql();
	DbSql statement = new DbSql();
	private int incremento;
	
	CategoriaProductoSG categoria = new CategoriaProductoSG();
	
	public CategoriaProductoCx(){
		
		try{
			URI uri = URI.create(path.Path());
			Database sqliteDB = DatabaseFactory.open(uri);
			Statement se = sqliteDB.createStatement(statement.SelectCategoriaProducto());
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
					eliminarDatos();
					descargarDatos();
				}else if(getTipo.equals("BIBS")){
					Status.show(Strings.MSG_DESCARGANDO_SLOW);
					eliminarDatos();
					descargarDatos();
				}else{
					Status.show(Strings.CONEXION_DESCONECTED);
					errorMessage = "En este momento no se pueden \n mostrar datos " +
		            		"intentelo más tarde";
					//onClose();
				}
			//Sí hay datos
			}else if(incremento >= 1){
				if(getTipo.equals("wifi")){
					Status.show(Strings.MSG_DESCARGANDO);
					eliminarDatos();
					descargarDatos();
					
				}else{
					cargarDatos();
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			errorMessage = "En este momento no se pueden \n mostrar datos " +
            		"intentelo más tarde";
		}
		
		
	
	}
	
	public void descargarDatos(){
		try{
			
			connectionURL = Strings.HTTP_SW+"getCategorias"+tipoConexion;

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
		            	
		            	/*IdCategoria.addElement(childJSONObject.get("idCategoria"));
		            	Categoria.addElement(childJSONObject.get("categoria"));*/
		            	try{
			            	URI uri1 = URI.create(path.Path());
							Database sqliteDB1 = DatabaseFactory.open(uri1);
							Statement in = sqliteDB1.createStatement(statement.InsertCategoriaProducto(childJSONObject.getString("idCategoria"),childJSONObject.getString("categoria")));
							//HAAAY SOY EL HIJO DE LAS MIL REVERENDAS PUTAS
							in.prepare();
							in.execute();
							in.close(); 
							sqliteDB1.close();
		            	}catch (Exception e){
		 	     			//Dialog.alert("error elements habits "+e.getMessage());
		 	     		}
		            
	            	}
	            	
	            	cargarDatos();
	            	
	            }else if (errorCode.equals("1")){
		            errorMessage = "En este momento no se pueden \n mostrar datos " +
		            		"intentelo más tarde";
	            	
	            }
	        }
	            
	        
	        }catch (Exception e) {
				// TODO: handle exception
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
	
		public void cargarDatos(){
			//Dialog.alert("Entro a la base");
			try{
				URI uri = URI.create(path.Path());
				Database sqliteDB = DatabaseFactory.open(uri);

	          		Statement selectR = sqliteDB.createStatement(statement.SelectCategoriaProducto());
	          		selectR.prepare();
	                       Cursor cursorR = selectR.getCursor();
	                       Row rc;
	                       //int i = 0;
	                       while(cursorR.next()){
	                           rc = cursorR.getRow();
	                           IdCategoria.addElement(rc.getString(0));
	                           Categoria.addElement(rc.getString(1));
	                       }
	                       selectR.close();
	                       cursorR.close();
	                       sqliteDB.close();
	                       errorCode = "0";
			}catch(Exception e){
				Dialog.alert(e.getMessage());
				errorMessage = "En este momento no se pueden \n mostrar datos " +
	            		"intentelo más tarde";
			}finally{
				categoria.setIdCategoria(IdCategoria);
				categoria.setCategoria(Categoria); 
				categoria.seterrorCode(errorCode);
				categoria.seterrorMessage(errorMessage);
			}
		}
		
		public void eliminarDatos(){
			
			try{
            	URI uri1 = URI.create(path.Path());
				Database sqliteDB1 = DatabaseFactory.open(uri1);
				Statement dt = sqliteDB1.createStatement(statement.DeleteCategoriaProducto());
				//HAAAY SOY EL HIJO DE LAS MIL REVERENDAS PUTAS
				dt.prepare();
				dt.execute();
				dt.close(); 
				sqliteDB1.close();
        	}catch (Exception e){
     			//Dialog.alert("error elements habits "+e.getMessage());
     		}
			
		}

}
	

