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
import net.rim.device.api.database.DatabaseIOException;
import net.rim.device.api.database.Row;
import net.rim.device.api.database.Statement;
import net.rim.device.api.io.URI;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.Status;

import org.json.me.JSONArray;
import org.json.me.JSONObject;

import pck_SG.ProductoSG;
import configurations.ConexionController;
import configurations.DbSql;
import configurations.Strings;

public class ProductoCx {
	
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
	
	ProductoSG producto = new ProductoSG();
	//private Database sqliteDB;
	
	//String idporcategoria;
	
	public ProductoCx(String idPorCategoria){
		
		//idporcategoria = idPorCategoria;
		
		//descargarDatos(idPorCategoria);
		//cargarDatos(idPorCategoria);
		/*try{
		URI uri = URI.create(path.Path());
		sqliteDB = DatabaseFactory.open(uri);
		}catch(Exception e)
		{
			Dialog.alert("error en la base de datos"+e.getMessage());	
		}
		try{
			
			Statement se = sqliteDB.createStatement(statement.SelectProducto(idPorCategoria));
			se.prepare();
			Cursor c = se.getCursor();
			Row r;
			while(c.next()){
				r = c.getRow();
				incremento ++;
				Dialog.alert("sip entro>"+statement.SelectProducto(idPorCategoria)+"<");
			}
			c.close();
			se.close();
			
			//Dialog.alert("entro>"+statement.SelectProducto(idPorCategoria)+"<");
			if(incremento == 0){
				if(getTipo.equals("wifi")){
					Status.show(Strings.MSG_DESCARGANDO);
					//eliminarDatos();
					descargarDatos(idPorCategoria);
				}else if(getTipo.equals("BIBS")){
					Status.show(Strings.MSG_DESCARGANDO_SLOW);
					//eliminarDatos();
					descargarDatos(idPorCategoria);
				}else{
					Status.show(Strings.CONEXION_DESCONECTED);
					//onClose();
				}
			//Sí hay datos
			}else if(incremento >= 1){
				if(getTipo.equals("wifi")){
					Status.show(Strings.MSG_DESCARGANDO);
					//eliminarDatos();
					descargarDatos(idPorCategoria);
					
				}else{
					cargarDatos(idPorCategoria);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			Dialog.alert("error en la cerrar de datos"+e.getMessage());
			try {
				sqliteDB.close();
			} catch (DatabaseIOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			try {
				sqliteDB.close();
			} catch (DatabaseIOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
		try{
			URI uri = URI.create(path.Path());
			Database sqliteDB = DatabaseFactory.open(uri);
			Statement se = sqliteDB.createStatement(statement.SelectProducto(idPorCategoria));
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
					eliminarDatos(idPorCategoria);
					descargarDatos(idPorCategoria);
				}else if(getTipo.equals("BIBS")){
					Status.show(Strings.MSG_DESCARGANDO_SLOW);
					eliminarDatos(idPorCategoria);
					descargarDatos(idPorCategoria);
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
					eliminarDatos(idPorCategoria);
					descargarDatos(idPorCategoria);
					
				}else{					
					cargarDatos(idPorCategoria);
					 //Dialog.alert("no tengo inter "+incremento);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			errorMessage = "En este momento no se pueden \n mostrar datos " +
        		"intentelo de nuevo más tarde";
		}
		
	}
	
	public void descargarDatos(String idporcategoria){
		
		try{
			
			connectionURL = Strings.HTTP_SW+"getListaDeProductosPorCategoria/"+idporcategoria+tipoConexion;

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
		            	
		            	//IdProducto.addElement(childJSONObject.get("idProducto"));
		            	//Nombre.addElement(childJSONObject.get("nombre"));
		            	try{
			            	URI uri1 = URI.create(path.Path());
							Database sqliteDB1 = DatabaseFactory.open(uri1);
							Statement in = sqliteDB1.createStatement(
									statement.InsertProducto(idporcategoria,
															childJSONObject.getString("idProducto"),
															childJSONObject.getString("nombre")));
							//Dialog.alert(in+"");
							in.prepare();
							in.execute();
							in.close(); 
							sqliteDB1.close();
		            	}catch (Exception e){
		            		errorMessage = "En este momento no se pueden \n mostrar datos " +
				            		"intentelo de nuevo más tarde";
		 	     		}
		            
	            	}
	            	
	            	cargarDatos(idporcategoria);
            	
	            }else if (errorCode.equals("1")){
		            errorMessage = "En este momento no se pueden \n mostrar datos " +
		            		"intentelo de nuevo más tarde";
	            	
	            }
	        }
	            
	       
	        
	        }catch (Exception e) {
				// TODO: handle exception
	        	errorMessage = "En este momento no se pueden \n mostrar datos " +
	            		"intentelo de nuevo más tarde";
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
	
	public void cargarDatos(String idporcategoria){
		
		try{
			URI uri = URI.create(path.Path());
			Database sqliteDB = DatabaseFactory.open(uri);

          		Statement selectR = sqliteDB.createStatement(statement.SelectProducto(idporcategoria));
          		//Dialog.alert("Entro a la base"+statement.SelectProducto(idporcategoria));
          		selectR.prepare();
                       Cursor cursorR = selectR.getCursor();
                       Row rc;
                       //int i = 0;
                       while(cursorR.next()){
                           rc = cursorR.getRow();
                           IdProducto.addElement(rc.getString(1));
                           Nombre.addElement(rc.getString(2));
                           //Dialog.alert("recorriendo "+rc.getString(1)+rc.getString(2));
                       }
                       selectR.close();
                       cursorR.close();
                       sqliteDB.close();
                       errorCode = "0";
		}catch(Exception e){
			errorMessage = "En este momento no se pueden \n mostrar datos " +
            		"intentelo de nuevo más tarde";
		}finally{
			producto.setIdProducto(IdProducto);
			producto.setNombre(Nombre);
			producto.seterrorCode(errorCode);
			producto.seterrorMessage(errorMessage);
			
		}
	}
	
	
	public void eliminarDatos(String idporcategoria){
		
		try{
        	URI uri1 = URI.create(path.Path());
			Database sqliteDB1 = DatabaseFactory.open(uri1);
			Statement dt = sqliteDB1.createStatement(statement.DeleteProducto(idporcategoria));
			
			dt.prepare();
			dt.execute();
			dt.close(); 
			sqliteDB1.close();
    	}catch (Exception e){
 			//Dialog.alert("error elements habits "+e.getMessage());
 		}
		
	}

}
	

