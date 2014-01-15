package listaProductos;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;

import org.json.me.JSONArray;
import org.json.me.JSONObject;

import configurations.ConexionController;
import configurations.Strings;

public class ListaProductosCx {
	
	private String connectionURL;
	private HttpConnection conn;
	private InputStream is;
	private ByteArrayOutputStream bos;
	private String response;
	
	String tipoConexion = ConexionController.getConnectionString()[0];
	String getTipo = ConexionController.getConnectionString()[1];
	
	Vector IdLista     = new Vector();
	Vector NombreLista = new Vector();
	
	public ListaProductosCx(){
		
		ListaProductosSG listadecompras = new ListaProductosSG();
		
		try{
			
			connectionURL = Strings.HTTP_SW+"getListaDeCompra/1"+tipoConexion;

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
	            String resultado2 = objeto2.getString("msg");
	            
	            JSONObject objeto3 =  new  JSONObject ( resultado2 );
	            
	            JSONArray jsonMainArr = objeto3.getJSONArray("ListaDeCompras");
			
            	for (int i = 0; i < jsonMainArr.length(); i++) {
	            	
	            	JSONObject childJSONObject = jsonMainArr.getJSONObject(i);
	            	
	            	IdLista.addElement(childJSONObject.get("idLista"));
	            	NombreLista.addElement(childJSONObject.get("nombreLista"));
	            
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
		
		listadecompras.setIdLista(IdLista);
		listadecompras.setNombreLista(NombreLista);    
		
	}

}
	

