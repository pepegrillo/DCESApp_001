package pck_WS;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;

import org.json.me.JSONArray;
import org.json.me.JSONObject;

import pck_SG.ProductoFiltroSG;
import configurations.ConexionController;
import configurations.Strings;

public class ProductoFiltroCx {
	
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
	
	public ProductoFiltroCx(String idMunicipio, String selectedValue1, String selectedValue2, String selectedValue3){
		
		ProductoFiltroSG productofiltro = new ProductoFiltroSG();
		
		try{
			
			connectionURL = Strings.HTTP_SW+"getListaDeProductosFiltro/"+idMunicipio+"/"+selectedValue1+"/"+selectedValue2+"/"+selectedValue3+tipoConexion;

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
	            
	            JSONArray jsonMainArr = objeto2.getJSONArray("msg");
			
            	for (int i = 0; i < jsonMainArr.length(); i++) {
	            	
	            	JSONObject childJSONObject = jsonMainArr.getJSONObject(i);
	            	
	            	IdProducto.addElement(childJSONObject.get("idProducto"));
	            	Producto.addElement(childJSONObject.get("producto"));
	            	Marca.addElement(childJSONObject.get("marca"));
	            	Presentacion.addElement(childJSONObject.get("presentacion"));
	            	Precio.addElement(childJSONObject.get("precioProducto"));
	            	PrecioPromo.addElement(childJSONObject.get("precioProm"));
	            	Nombre.addElement(childJSONObject.get("nombre"));
	            	Latitud.addElement(childJSONObject.get("altitud"));
	            	Longitud.addElement(childJSONObject.get("longitud"));
	            	Fecha.addElement(childJSONObject.get("fechadeSondeo"));
	            
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
	

