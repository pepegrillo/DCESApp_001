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

import pck_SG.ProductoFiltroSG;
import configurations.ConexionController;
import configurations.DbSql;
import configurations.Strings;

public class TemporadaProductoFiltroCx {
	
	private String connectionURL;
	private HttpConnection conn;
	private InputStream is;
	private ByteArrayOutputStream bos;
	private String response;
	
	String tipoConexion = ConexionController.getConnectionString()[0];
	String getTipo = ConexionController.getConnectionString()[1];
	
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
	
	DbSql path = new DbSql();
	DbSql statement = new DbSql();
	private int incremento;
	
	ProductoFiltroSG productofiltro = new ProductoFiltroSG();
	
	public TemporadaProductoFiltroCx(String idMunicipio, String idProducto, String selectedValue2, String selectedValue3){
		
		try{
			URI uri = URI.create(path.Path());
			Database sqliteDB = DatabaseFactory.open(uri);
			Statement se = sqliteDB.createStatement(statement.SelectProductoFiltrado(idMunicipio, idProducto, selectedValue2, selectedValue3));
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
					eliminarDatos(idMunicipio, idProducto, selectedValue2, selectedValue3);
					descargarDatos(idMunicipio, idProducto, selectedValue2, selectedValue3);
				}else if(getTipo.equals("BIBS")){
					Status.show(Strings.MSG_DESCARGANDO_SLOW);
					eliminarDatos(idMunicipio, idProducto, selectedValue2, selectedValue3);
					descargarDatos(idMunicipio, idProducto, selectedValue2, selectedValue3);
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
					eliminarDatos(idMunicipio, idProducto, selectedValue2, selectedValue3);
					descargarDatos(idMunicipio, idProducto, selectedValue2, selectedValue3);
					
				}else{					
					cargarDatos(idMunicipio, idProducto, selectedValue2, selectedValue3);
					 //Dialog.alert("no tengo inter "+incremento);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			errorMessage = "En este momento no se pueden \n mostrar datos " +
            		"intentelo de nuevo más tarde";
		}
		
	}
	
	
	public void descargarDatos(String idmunicipio, String idproducto, String selectedvalue2, String selectedvalue3){
		

		try{
			
			connectionURL = Strings.HTTP_SW+"getListaDeProductosFiltro/"+idmunicipio+"/"+idproducto+"/"+selectedvalue2+"/"+selectedvalue3+tipoConexion;

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
		            				statement.InsertProductoFiltrado(idmunicipio,idproducto,selectedvalue2,selectedvalue3,
		            						childJSONObject.getString("idProducto"),
		            						childJSONObject.getString("producto"),
		            						childJSONObject.getString("marca"),
		            						childJSONObject.getString("presentacion"),
		            						childJSONObject.getString("precioProducto"),
		            						childJSONObject.getString("precioProm"),
		            						childJSONObject.getString("nombre"),
		            						childJSONObject.getString("altitud"),
		            						childJSONObject.getString("longitud"),
		            						childJSONObject.getString("fechadeSondeo")));
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
		            	
		            	/*IdProducto.addElement(childJSONObject.get("idProducto"));
		            	Producto.addElement(childJSONObject.get("producto"));
		            	Marca.addElement(childJSONObject.get("marca"));
		            	Presentacion.addElement(childJSONObject.get("presentacion"));
		            	Precio.addElement(childJSONObject.get("precioProducto"));
		            	PrecioPromo.addElement(childJSONObject.get("precioProm"));
		            	Nombre.addElement(childJSONObject.get("nombre"));
		            	Latitud.addElement(childJSONObject.get("altitud"));
		            	Longitud.addElement(childJSONObject.get("longitud"));
		            	Fecha.addElement(childJSONObject.get("fechadeSondeo"));*/
		            
	            	}
	            	
	            	cargarDatos(idmunicipio, idproducto, selectedvalue2, selectedvalue3);
	            
	            }else if (errorCode.equals("1")){
		            errorMessage = "En este momento no se pueden \n mostrar datos " +
		            		"intentelo de nuevo más tarde";
	            	
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
		
			/*productofiltro.setIdProducto(IdProducto);
			productofiltro.setProducto(Producto);
			productofiltro.setMarca(Marca);
			productofiltro.setPresentacion(Presentacion);
			productofiltro.setPrecio(Precio);
			productofiltro.setPrecioPromo(PrecioPromo);
			productofiltro.setNombre(Nombre);
			productofiltro.setLatitud(Latitud);
			productofiltro.setLongitud(Longitud);
			productofiltro.setFecha(Fecha);
			
			productofiltro.seterrorCode(errorCode);
			productofiltro.seterrorMessage(errorMessage);*/
		
	}
	
	public void cargarDatos(String idmunicipio, String idproduto, String selectedvalue2, String selectedvalue3){
		
		try{
			URI uri = URI.create(path.Path());
			Database sqliteDB = DatabaseFactory.open(uri);
			
			Statement selectR = sqliteDB.createStatement(statement.SelectProductoFiltrado(idmunicipio, idproduto, selectedvalue2, selectedvalue3));
			selectR.prepare();
			Cursor cursorR = selectR.getCursor();
			Row rc;
			
			while(cursorR.next()){
				rc = cursorR.getRow();
				IdProducto.addElement(rc.getString(4));
				Producto.addElement(rc.getString(5));
				Marca.addElement(rc.getString(6));
				Presentacion.addElement(rc.getString(7));
				Precio.addElement(rc.getString(8));
				PrecioPromo.addElement(rc.getString(9));
				Nombre.addElement(rc.getString(10));
				Latitud.addElement(rc.getString(11));
				Longitud.addElement(rc.getString(12));
				Fecha.addElement(rc.getString(13));
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
			productofiltro.setIdProducto(IdProducto);
			productofiltro.setProducto(Producto);
			productofiltro.setMarca(Marca);
			productofiltro.setPresentacion(Presentacion);
			productofiltro.setPrecio(Precio);
			productofiltro.setPrecioPromo(PrecioPromo);
			productofiltro.setNombre(Nombre);
			productofiltro.setLatitud(Latitud);
			productofiltro.setLongitud(Longitud);
			productofiltro.setFecha(Fecha);
			
			productofiltro.seterrorCode(errorCode);
			productofiltro.seterrorMessage(errorMessage);
		}
		
	}
	
	public void eliminarDatos(String idmunicipio, String idproduto, String selectedvalue2, String selectedvalue3){
		
		try{
        	URI uri1 = URI.create(path.Path());
			Database sqliteDB1 = DatabaseFactory.open(uri1);
			Statement dt = sqliteDB1.createStatement(statement.DeleteProductoFiltrado(idmunicipio, idproduto, selectedvalue2, selectedvalue3));
			
			dt.prepare();
			dt.execute();
			dt.close(); 
			sqliteDB1.close();
    	}catch (Exception e){
 			//Dialog.alert("error elements habits "+e.getMessage());
 		}
		
	}

}
	

