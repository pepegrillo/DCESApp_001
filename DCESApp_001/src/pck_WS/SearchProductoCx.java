package pck_WS;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;

import org.json.me.JSONArray;
import org.json.me.JSONObject;

import pck_SG.ProductoSG;
import pck_SG.SearchProductoSG;
import configurations.ConexionController;
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
	
	public SearchProductoCx(String idcategoria, String PalabraFiltro){
		
		SearchProductoSG searchproducto = new SearchProductoSG();
		
		try{
			
			connectionURL = Strings.HTTP_SW+"getListaDeProductosPorCategoriaPorNombre/"+idcategoria+"/"+PalabraFiltro+tipoConexion;

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
	            
	            JSONArray jsonMainArr = objeto2.getJSONArray("msg");
			
            	for (int i = 0; i < jsonMainArr.length(); i++) {
	            	
	            	JSONObject childJSONObject = jsonMainArr.getJSONObject(i);
	            	
	            	IdProducto.addElement(childJSONObject.get("idProducto"));
	            	Nombre.addElement(childJSONObject.get("nombre"));
	            
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
			
			searchproducto.setIdProducto(IdProducto);
			searchproducto.setNombre(Nombre);
			searchproducto.seterrorCode(errorCode);
			searchproducto.seterrorMessage(errorMessage);
		
	}

}
	

