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
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.Status;

import org.json.me.JSONArray;
import org.json.me.JSONObject;

import pck_SG.ProductoSG;
import pck_SG.SearchProductoSG;
import configurations.ConexionController;
import configurations.DbSql;
import configurations.Strings;

public class SearchProductoCx {
	
	private String connectionURL;
	private HttpConnection conn;
	private InputStream is;
	private ByteArrayOutputStream bos;
	private String response;
	
	String tipoConexion = ConexionController.getConnectionString()[0];
	String getTipo = ConexionController.getConnectionString()[1];
	
	public Vector IdProducto   = new Vector();
	public Vector Nombre       = new Vector(); 
	
	public String errorCode    = new String();
	public String errorMessage = new String();
	
	DbSql path = new DbSql();
	DbSql statement = new DbSql();
	private int incremento;
	
	SearchProductoSG searchproducto = new SearchProductoSG();
	
	public SearchProductoCx(String idCategoria, String PalabraFiltro){
		
		try{
			URI uri = URI.create(path.Path());
			Database sqliteDB = DatabaseFactory.open(uri);
			Statement se = sqliteDB.createStatement(statement.SelectBusqueda(idCategoria,PalabraFiltro));
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
					descargarDatos(idCategoria,PalabraFiltro);
				}else if(getTipo.equals("BIBS")){
					Status.show(Strings.MSG_DESCARGANDO_SLOW);
					eliminarDatos(idCategoria);
					descargarDatos(idCategoria,PalabraFiltro);
				}else{
					Status.show(Strings.CONEXION_DESCONECTED);
					if (Display.getWidth() == 320) {
						errorMessage = "noInter_320.png";
					}
					if (Display.getWidth() == 360) {
						errorMessage = "noInter_360.png";
					}
					if (Display.getWidth() == 480) {
						errorMessage = "noInter_480.png";
					}
					if (Display.getWidth() == 640) {
						errorMessage = "noInter.png";
					}
					//cargarDatos(idCategoria,PalabraFiltro);
					//errorMessage = "Conectese a una red de internet para hacer una búsqueda actualizada.";
					//onClose();
				}
			//Sí hay datos
			}else if(incremento >= 1){
				if(getTipo.equals("wifi")){
					Status.show(Strings.MSG_DESCARGANDO);
					eliminarDatos(idCategoria);
					descargarDatos(idCategoria,PalabraFiltro);
					
				}else{
					cargarDatos(idCategoria,PalabraFiltro);
					 //Dialog.alert("no tengo inter "+incremento);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			if (Display.getWidth() == 320) {
				errorMessage = "noData1_320.png";
			}
			if (Display.getWidth() == 360) {
				errorMessage = "noData1_360.png";
			}
			if (Display.getWidth() == 480) {
				errorMessage = "noData1_480.png";
			}
			if (Display.getWidth() == 640) {
				errorMessage = "noData1.png";
			}
		}
		
	}
	
	
	public void descargarDatos(String idcategoria, String palabrafiltro){
		

		
		try{
			
			connectionURL = Strings.HTTP_SW+"getListaDeProductosPorCategoriaPorNombre/"+idcategoria+"/"+palabrafiltro+tipoConexion;

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
	            	            	            
	            JSONObject objeto2  =  new  JSONObject ( resultado1 );
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
		            				statement.InsertBusqueda(idcategoria, palabrafiltro,
		            						childJSONObject.getString("idProducto"),
		            						childJSONObject.getString("nombre")));
		            		in.prepare();
							in.execute();
							in.close(); 
							sqliteDB1.close();
		            	}catch (Exception e) {
							// TODO: handle exception
		            		if (Display.getWidth() == 320) {
		        				errorMessage = "noData1_320.png";
		        			}
		        			if (Display.getWidth() == 360) {
		        				errorMessage = "noData1_360.png";
		        			}
		        			if (Display.getWidth() == 480) {
		        				errorMessage = "noData1_480.png";
		        			}
		        			if (Display.getWidth() == 640) {
		        				errorMessage = "noData1.png";
		        			}
						}
		            	
		            	//IdProducto.addElement(childJSONObject.get("idProducto"));
		            	//Nombre.addElement(childJSONObject.get("nombre"));
		            
	            	}
            	
	            	cargarDatos(idcategoria,palabrafiltro);
	            	
	            }else if (errorCode.equals("1")){
	            	if (Display.getWidth() == 320) {
	    				errorMessage = "noData1_320.png";
	    			}
	    			if (Display.getWidth() == 360) {
	    				errorMessage = "noData1_360.png";
	    			}
	    			if (Display.getWidth() == 480) {
	    				errorMessage = "noData1_480.png";
	    			}
	    			if (Display.getWidth() == 640) {
	    				errorMessage = "noData1.png";
	    			}
	            	
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
			
			/*searchproducto.setIdProducto(IdProducto);
			searchproducto.setNombre(Nombre);
			searchproducto.seterrorCode(errorCode);
			searchproducto.seterrorMessage(errorMessage);*/
		
	}
	
	
	public void cargarDatos(String idcategoria, String palabrafiltro){
		
		try{
			URI uri = URI.create(path.Path());
			Database sqliteDB = DatabaseFactory.open(uri);
			
			Statement selectR = sqliteDB.createStatement(statement.SelectBusqueda(idcategoria,palabrafiltro));
			selectR.prepare();
			Cursor cursorR = selectR.getCursor();
			Row rc;
			
			while(cursorR.next()){
				rc = cursorR.getRow();
				IdProducto.addElement(rc.getString(2));
				Nombre.addElement(rc.getString(3));
			}
			
            selectR.close();
            cursorR.close();
            sqliteDB.close();
            errorCode = "0";
		}catch (Exception e) {
			// TODO: handle exception
			if (Display.getWidth() == 320) {
				errorMessage = "noData1_320.png";
			}
			if (Display.getWidth() == 360) {
				errorMessage = "noData1_360.png";
			}
			if (Display.getWidth() == 480) {
				errorMessage = "noData1_480.png";
			}
			if (Display.getWidth() == 640) {
				errorMessage = "noData1.png";
			}
		}finally{
			searchproducto.setIdProducto(IdProducto);
			searchproducto.setNombre(Nombre);
			searchproducto.seterrorCode(errorCode);
			searchproducto.seterrorMessage(errorMessage);
		}
		
	}
	
	
	public void eliminarDatos(String idcategoria){
		
		try{
        	URI uri1 = URI.create(path.Path());
			Database sqliteDB1 = DatabaseFactory.open(uri1);
			Statement dt = sqliteDB1.createStatement(statement.DeleteBusqueda(idcategoria));
			
			dt.prepare();
			dt.execute();
			dt.close(); 
			sqliteDB1.close();
    	}catch (Exception e){
 			//Dialog.alert("error elements habits "+e.getMessage());
    		if (Display.getWidth() == 320) {
				errorMessage = "noData1_320.png";
			}
			if (Display.getWidth() == 360) {
				errorMessage = "noData1_360.png";
			}
			if (Display.getWidth() == 480) {
				errorMessage = "noData1_480.png";
			}
			if (Display.getWidth() == 640) {
				errorMessage = "noData1.png";
			}
 		}
		
	}

}
	

