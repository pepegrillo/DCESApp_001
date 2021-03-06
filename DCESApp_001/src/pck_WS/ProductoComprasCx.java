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
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.Status;

import org.json.me.JSONArray;
import org.json.me.JSONObject;

import pck_SG.ProductoComprasSG;
import pck_SG.RutaComprasSG;
import configurations.ConexionController;
import configurations.DbSql;
import configurations.Metodo;
import configurations.Strings;

public class ProductoComprasCx {
	
	private String connectionURL;
	private HttpConnection conn;
	private InputStream is;
	private ByteArrayOutputStream bos;
	private String response;
	
	String tipoConexion = ConexionController.getConnectionString()[0];
	String getTipo = ConexionController.getConnectionString()[1];
	Metodo request = new Metodo();
	
	public Vector IdArticulo		= new Vector();
	public Vector NombreArticulo	= new Vector();
	public Vector MarcaArticulo	= new Vector();
	
	public String errorCode    = new String();
	public String errorMessage = new String();
	
	public String hashKey    = new String();
	
	DbSql path = new DbSql();
	DbSql statement = new DbSql();
	private int incremento;
	
	//String hashKey;
	
	ProductoComprasSG productocompras = new ProductoComprasSG();
	
	public ProductoComprasCx(String IdListaReturn){
		
		try{
			URI uri = URI.create(path.Path());
			Database sqliteDB = DatabaseFactory.open(uri);
			
			Statement se = sqliteDB.createStatement(statement.SelectProductoCompras(IdListaReturn));
			se.prepare();
			Cursor c = se.getCursor();
			Row r;
			while(c.next()){
				r = c.getRow();
				incremento ++;
			}
			c.close();
			se.close();
			
			Statement sf = sqliteDB.createStatement(statement.SelectHashKey());
			sf.prepare();
			Cursor cf = sf.getCursor();
			Row rf;
			while(cf.next()){
				rf = cf.getRow();
				hashKey = rf.getString(0);
				//incremento ++;
			}
			cf.close();
			sf.close();
			
			sqliteDB.close();
			
			if(incremento == 0){
				if(getTipo.equals("wifi")){
					Status.show(Strings.MSG_DESCARGANDO);
					eliminarDatos(IdListaReturn);
					descargarDatos(IdListaReturn,hashKey);
				}else if(getTipo.equals("BIBS")){
					Status.show(Strings.MSG_DESCARGANDO_SLOW);
					eliminarDatos(IdListaReturn);
					descargarDatos(IdListaReturn,hashKey);
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
					//onClose();
				}
			//S� hay datos
			}else if(incremento >= 1){
				if(getTipo.equals("wifi")){
					Status.show(Strings.MSG_DESCARGANDO);
					eliminarDatos(IdListaReturn);
					descargarDatos(IdListaReturn,hashKey);
					
				}else{					
					cargarDatos(IdListaReturn);
					 //Dialog.alert("no tengo inter "+incremento);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			if (Display.getWidth() == 320) {
				errorMessage = "noData_320.png";
			}
			if (Display.getWidth() == 360) {
				errorMessage = "noData_360.png";
			}
			if (Display.getWidth() == 480) {
				errorMessage = "noData_480.png";
			}
			if (Display.getWidth() == 640) {
				errorMessage = "noData.png";
			}
		}
		
	}
	
	
	public void descargarDatos(String IdListaReturn, String hashKey){
		

		try{
			
			connectionURL = Strings.HTTP_SW+"getListaDeComprasProductos/"+hashKey+"/"+IdListaReturn+tipoConexion;
			
			//Dialog.alert(connectionURL+"<<URL");
			
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
	            
	            //JSONObject temporalError = new  JSONObject ( response );
	            
	            //errorCode    = temporalError.getString("errotCode");
	            //errorMessage = temporalError.getString("errorMessage");
	            
	            JSONObject objeto1 =  new  JSONObject ( response );
	            String resultado1  = objeto1.getString("response");
	            //Dialog.alert(resultado1+"<<");
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
		            				statement.InsertProductoCompras(childJSONObject.getString("idArticulo"),
		            						childJSONObject.getString("nombre"),
		            						childJSONObject.getString("marca"),
		            						IdListaReturn));
		            		//Dialog.alert(in+"");
		            		in.prepare();
							in.execute();
							in.close(); 
							sqliteDB1.close();
		            	}catch (Exception e) {
							// TODO: handle exception
		            		if (Display.getWidth() == 320) {
		        				errorMessage = "noData_320.png";
		        			}
		        			if (Display.getWidth() == 360) {
		        				errorMessage = "noData_360.png";
		        			}
		        			if (Display.getWidth() == 480) {
		        				errorMessage = "noData_480.png";
		        			}
		        			if (Display.getWidth() == 640) {
		        				errorMessage = "noData.png";
		        			}
						}
		            			            
	            	}
	            	
	            	cargarDatos(IdListaReturn);
	            
	            }else if (errorCode.equals("1")){
	            	if (Display.getWidth() == 320) {
	    				errorMessage = "noData_320.png";
	    			}
	    			if (Display.getWidth() == 360) {
	    				errorMessage = "noData_360.png";
	    			}
	    			if (Display.getWidth() == 480) {
	    				errorMessage = "noData_480.png";
	    			}
	    			if (Display.getWidth() == 640) {
	    				errorMessage = "noData.png";
	    			}
	            	
	            }else {
	            	if (Display.getWidth() == 320) {
	    				errorMessage = "noData_320.png";
	    			}
	    			if (Display.getWidth() == 360) {
	    				errorMessage = "noData_360.png";
	    			}
	    			if (Display.getWidth() == 480) {
	    				errorMessage = "noData_480.png";
	    			}
	    			if (Display.getWidth() == 640) {
	    				errorMessage = "noData.png";
	    			}
	            }
	        }
	            
	        }catch (Exception e) {
				// TODO: handle exception
	        	if (Display.getWidth() == 320) {
					errorMessage = "noData_320.png";
				}
				if (Display.getWidth() == 360) {
					errorMessage = "noData_360.png";
				}
				if (Display.getWidth() == 480) {
					errorMessage = "noData_480.png";
				}
				if (Display.getWidth() == 640) {
					errorMessage = "noData.png";
				}
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
	
	public void cargarDatos(String IdListaReturn){
		
		try{
			URI uri = URI.create(path.Path());
			Database sqliteDB = DatabaseFactory.open(uri);
			
			Statement selectR = sqliteDB.createStatement(statement.SelectProductoCompras(IdListaReturn));
			selectR.prepare();
			Cursor cursorR = selectR.getCursor();
			Row rc;
			
			while(cursorR.next()){
				rc = cursorR.getRow();
				IdArticulo.addElement(rc.getString(0));
				NombreArticulo.addElement(rc.getString(1));
				MarcaArticulo.addElement(rc.getString(2));
				//Dialog.alert("SQL<"+rc);
			}
			
            selectR.close();
            cursorR.close();
            sqliteDB.close();
            errorCode = "0";
		}catch (Exception e) {
			// TODO: handle exception
			if (Display.getWidth() == 320) {
				errorMessage = "noData_320.png";
			}
			if (Display.getWidth() == 360) {
				errorMessage = "noData_360.png";
			}
			if (Display.getWidth() == 480) {
				errorMessage = "noData_480.png";
			}
			if (Display.getWidth() == 640) {
				errorMessage = "noData.png";
			}
		}finally{
			productocompras.setIdArticulo(IdArticulo);
			productocompras.setNombreArticulo(NombreArticulo);
			productocompras.setMarcaArticulo(MarcaArticulo);
			
			productocompras.seterrorCode(errorCode);
			productocompras.seterrorMessage(errorMessage);
			
			productocompras.sethashKey(hashKey);
		}
		
	}
	
	public void eliminarDatos(String idLista){
		
		try{
        	URI uri1 = URI.create(path.Path());
			Database sqliteDB1 = DatabaseFactory.open(uri1);
			Statement dt = sqliteDB1.createStatement(statement.DeleteProductoCompras(idLista));
			
			dt.prepare();
			dt.execute();
			dt.close(); 
			sqliteDB1.close();
    	}catch (Exception e){
 			//Dialog.alert("error elements habits "+e.getMessage());
    		if (Display.getWidth() == 320) {
				errorMessage = "noData_320.png";
			}
			if (Display.getWidth() == 360) {
				errorMessage = "noData_360.png";
			}
			if (Display.getWidth() == 480) {
				errorMessage = "noData_480.png";
			}
			if (Display.getWidth() == 640) {
				errorMessage = "noData.png";
			}
 		}
		
	}
	

	//ELIMINAR PRODUCTOS
		public void eliminarProducto(String idLista, String idArticulo){
			
			try{
				URI uri = URI.create(path.Path());
				Database sqliteDB = DatabaseFactory.open(uri);
							
				Statement sf = sqliteDB.createStatement(statement.SelectHashKey());
				sf.prepare();
				Cursor cf = sf.getCursor();
				Row rf;
				while(cf.next()){
					rf = cf.getRow();
					hashKey = rf.getString(0);
					//incremento ++;
				}
				cf.close();
				sf.close();
				
				sqliteDB.close();
				
				connectionURL = Strings.HTTP_SW+"deleteElementoLista/"+hashKey+"/"+idArticulo+"/"+idLista+tipoConexion;
				
				//Dialog.alert(connectionURL+"<<URL");
				
		        conn = (HttpConnection) Connector.open(connectionURL);
		        conn.setRequestProperty("Content-Type","application/json");
		        conn.setRequestMethod("DELETE");
		        //Dialog.alert("Response code : "+conn.getResponseCode());

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
		            	Status.show("Producto eliminado correctamente.");
		            	//errorMessage = "Establecimiento eliminado correctamente.";
		            	
		            }else if (errorCode.equals("1")){
		            	Status.show("En este momento no se pueden \n mostrar datos " +
			            		"int�ntelo de nuevo.");
		            	if (Display.getWidth() == 320) {
		    				errorMessage = "noData_320.png";
		    			}
		    			if (Display.getWidth() == 360) {
		    				errorMessage = "noData_360.png";
		    			}
		    			if (Display.getWidth() == 480) {
		    				errorMessage = "noData_480.png";
		    			}
		    			if (Display.getWidth() == 640) {
		    				errorMessage = "noData.png";
		    			}
			            //errorMessage = "En este momento no se pueden \n mostrar datos " +
			            		//"int�ntelo de nuevo.";
		            	
		            }
		        }
		            
		        }catch (Exception e) {
		        	if (Display.getWidth() == 320) {
						errorMessage = "noData_320.png";
					}
					if (Display.getWidth() == 360) {
						errorMessage = "noData_360.png";
					}
					if (Display.getWidth() == 480) {
						errorMessage = "noData_480.png";
					}
					if (Display.getWidth() == 640) {
						errorMessage = "noData.png";
					}
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
			
				//rutacompras.seterrorCode(errorCode);
				//rutacompras.seterrorMessage(errorMessage);
			
		}
		

}
	

