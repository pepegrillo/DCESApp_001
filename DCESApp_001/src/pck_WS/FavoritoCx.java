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
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.Status;

import org.json.me.JSONArray;
import org.json.me.JSONObject;

import pck_SG.FavoritoSG;
import configurations.ConexionController;
import configurations.DbSql;
import configurations.Metodo;
import configurations.Strings;

public class FavoritoCx {
	
	private String connectionURL;
	private HttpConnection conn;
	private InputStream is;
	private ByteArrayOutputStream bos;
	private String response;
	
	String tipoConexion = ConexionController.getConnectionString()[0];
	String getTipo = ConexionController.getConnectionString()[1];
	Metodo request = new Metodo();
	
	public Vector IdProducto   = new Vector();
	public Vector Producto     = new Vector();
	public Vector Marca        = new Vector();
	public Vector Presentacion = new Vector();
	public Vector Precio       = new Vector();
	public Vector PrecioPromo  = new Vector();
	public Vector Nombre       = new Vector();
	public Vector Latitud      = new Vector();
	public Vector Longitud     = new Vector();
	public Vector Fecha        = new Vector();
	
	public String errorCode    = new String();
	public String errorMessage = new String();
	
	public String hashKey    = new String();
	
	DbSql path = new DbSql();
	DbSql statement = new DbSql();
	private int incremento;
	
	//String hashKey;
	
	FavoritoSG favorito = new FavoritoSG();
	
	public FavoritoCx(){
		
		try{
			URI uri = URI.create(path.Path());
			Database sqliteDB = DatabaseFactory.open(uri);
			
			Statement se = sqliteDB.createStatement(statement.SelectFavoritos());
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
					Status.show(Strings.MSG_DESCARGANDO,Bitmap.getPredefinedBitmap(Bitmap.HOURGLASS),1000);
					eliminarDatos();
					descargarDatos(hashKey);
				}else if(getTipo.equals("BIBS")){
					Status.show(Strings.MSG_DESCARGANDO_SLOW,Bitmap.getPredefinedBitmap(Bitmap.HOURGLASS),1000);
					eliminarDatos();
					descargarDatos(hashKey);
				}else{
					Status.show(Strings.CONEXION_DESCONECTED);
					errorMessage = "En este momento no se pueden \n mostrar datos " +
		            		"intentelo de nuevo más tarde";
					//onClose();
				}
			//Sí hay datos
			}else if(incremento >= 1){
				if(getTipo.equals("wifi")){
					Status.show(Strings.MSG_DESCARGANDO,Bitmap.getPredefinedBitmap(Bitmap.HOURGLASS),1000);
					eliminarDatos();
					descargarDatos(hashKey);
					
				}else{					
					cargarDatos();
					 //Dialog.alert("no tengo inter "+incremento);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			errorMessage = "En este momento no se pueden \n mostrar datos " +
            		"intentelo de nuevo más tarde";
		}
		
	}
	
	
	public void descargarDatos(String hashKey){
		

		try{
			
			connectionURL = Strings.HTTP_SW+"getElementosFavoritos/"+hashKey+tipoConexion;
			
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
		            				statement.InsertFavorito(hashKey,
		            						childJSONObject.getString("idArticulo"),
		            						childJSONObject.getString("producto"),
		            						childJSONObject.getString("marca"),
		            						childJSONObject.getString("presentacion"),
		            						childJSONObject.getString("establecimiento"),
		            						childJSONObject.getString("precio"),
		            						childJSONObject.getString("precioProm"),
		            						childJSONObject.getString("altitud"),
		            						childJSONObject.getString("longitud"),
		            						childJSONObject.getString("fechaSondeo")));
		            		//Dialog.alert(in+"");
		            		in.prepare();
							in.execute();
							in.close(); 
							sqliteDB1.close();
		            	}catch (Exception e) {
							// TODO: handle exception
		            		errorMessage = "En este momento no se pueden \n mostrar datos " +
				            		"intentelo más tarde";
						}
		            			            
	            	}
	            	
	            	cargarDatos();
	            
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
	
	public void cargarDatos(){
		
		try{
			URI uri = URI.create(path.Path());
			Database sqliteDB = DatabaseFactory.open(uri);
			
			Statement selectR = sqliteDB.createStatement(statement.SelectFavoritos());
			selectR.prepare();
			Cursor cursorR = selectR.getCursor();
			Row rc;
			
			while(cursorR.next()){
				rc = cursorR.getRow();
				IdProducto.addElement(rc.getString(1));
				Producto.addElement(rc.getString(2));
				Marca.addElement(rc.getString(3));
				Presentacion.addElement(rc.getString(4));
				Nombre.addElement(rc.getString(5));
				Precio.addElement(rc.getString(6));
				PrecioPromo.addElement(rc.getString(7));
				Latitud.addElement(rc.getString(8));
				Longitud.addElement(rc.getString(9));
				Fecha.addElement(rc.getString(10));
				//Dialog.alert("SQL<"+rc);
			}
			
            selectR.close();
            cursorR.close();
            sqliteDB.close();
            errorCode = "0";
		}catch (Exception e) {
			// TODO: handle exception
			Dialog.alert("cargar datos "+e.getMessage());
			errorMessage = "No hay datos disponible para la búsqueda realizada, " +
            		"intentelo más tarde";
		}finally{
			favorito.setIdProducto(IdProducto);
			favorito.setProducto(Producto);
			favorito.setMarca(Marca);
			favorito.setPresentacion(Presentacion);
			favorito.setPrecio(Precio);
			favorito.setPrecioPromo(PrecioPromo);
			favorito.setNombre(Nombre);
			favorito.setLatitud(Latitud);
			favorito.setLongitud(Longitud);
			favorito.setFecha(Fecha);
			
			favorito.seterrorCode(errorCode);
			favorito.seterrorMessage(errorMessage);
			
			favorito.sethashKey(hashKey);
		}
		
	}
	
	public void eliminarDatos(){
		
		try{
        	URI uri1 = URI.create(path.Path());
			Database sqliteDB1 = DatabaseFactory.open(uri1);
			Statement dt = sqliteDB1.createStatement(statement.DeleteFavorito());
			
			dt.prepare();
			dt.execute();
			dt.close(); 
			sqliteDB1.close();
    	}catch (Exception e){
 			//Dialog.alert("error elements habits "+e.getMessage());
    		errorMessage = "En este momento no se pueden \n mostrar datos " +
            		"intentelo de nuevo más tarde";
 		}
		
	}
	
public void guardarFavoritos(String HashKey, String idProducto, String idEstablecimiento, String Nombre){
		
		if(getTipo.equals("wifi") || getTipo.equals("BIBS")){
        	
        	Status.show("Guardando...");
        	
        	try{
				URI uri = URI.create(path.Path());
				Database sqliteDB = DatabaseFactory.open(uri);

	          		Statement selectR = sqliteDB.createStatement(statement.SelectUserHashKey());
	          		selectR.prepare();
	                       Cursor cursorR = selectR.getCursor();
	                       Row rc;
	                       //int i = 0;
	                       while(cursorR.next()){
	                           rc = cursorR.getRow();
	                           HashKey = rc.getString(0);
	                       }
	                       selectR.close();
	                       cursorR.close();
	                       sqliteDB.close();
	                       
	                       String url = Strings.HTTP_SW+"postElementosFavoritos"+tipoConexion;
		   					String json = "'hashKey':'"+HashKey+"'," +
		   								"'idArticulo':'"+idProducto+"'," +
		   								"'idEstablecimiento':'"+idEstablecimiento+"'";
		   					//Dialog.alert("Favoritos<"+json+">");
		   					String response = request.POST(url,json);
		   					//Dialog.alert("RESPONSE>"+response+"<");
		   					JSONObject objeto1 =  new  JSONObject ( response );
		   		            String resultado1 = objeto1.getString("response");		            
		   		            JSONObject objeto2 =  new  JSONObject ( resultado1 );    		           
		   		            int errorcode  = objeto2.getInt("errorCode");
		   		            //Dialog.alert("aqui se muestra el error "+errorcode);
		   		            if(errorcode == 0){
		   		            	//Dialog.alert(objeto2.getString("errorMessage"));
		   		            	Status.show(Nombre+" ha sido guardado satisfactoriamente.");
		   		            }else if(errorcode == 5){
		   		            	Status.show(Nombre+" ya ha sido guardado en Favoritos.",5000);
		   		            }else{
		   		            	Dialog.alert("ERROR CODE Ha ocurrido algo inesperado, inténtelo de nuevo.");
		   		            }
	                      
			}catch(Exception e){
				Dialog.alert(Strings.CONEXION_UNEXPECTED+" "+e.getMessage());
			}finally{
			}
    	
    	}else{
    		Status.show(Strings.CONEXION_DESCONECTED);
    	}
	}

}
	

