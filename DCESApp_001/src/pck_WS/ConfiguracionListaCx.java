package pck_WS;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;

import net.rim.device.api.database.Cursor;
import net.rim.device.api.database.Database;
import net.rim.device.api.database.DatabaseFactory;
import net.rim.device.api.database.Row;
import net.rim.device.api.database.Statement;
import net.rim.device.api.io.URI;
import net.rim.device.api.ui.component.Status;

import org.json.me.JSONArray;
import org.json.me.JSONObject;

import pck_SG.ConfiguracionListaSG;
import configurations.ConexionController;
import configurations.DbSql;
import configurations.Metodo;
import configurations.Strings;

public class ConfiguracionListaCx {
	
	private String connectionURL;
	private HttpConnection conn;
	private InputStream is;
	private ByteArrayOutputStream bos;
	private String response;
	
	String tipoConexion = ConexionController.getConnectionString()[0];
	String getTipo = ConexionController.getConnectionString()[1];
	Metodo request = new Metodo();
	
	public String rutas		= new String();
	public String alertas	= new String();
	public String productos = new String();
	
	public String errorCode    = new String();
	public String errorMessage = new String();
	
	public String hashKey    = new String();
	
	DbSql path = new DbSql();
	DbSql statement = new DbSql();
	
	//String hashKey;
	
	ConfiguracionListaSG configurarlista = new ConfiguracionListaSG();
	
	public ConfiguracionListaCx(String idLista){
		
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
			
			
				if(getTipo.equals("wifi")){
					descargarDatos(hashKey, idLista);
				}else if(getTipo.equals("BIBS")){
					Status.show(Strings.MSG_DESCARGANDO_SLOW);
					descargarDatos(hashKey,idLista);
				}else{
					Status.show(Strings.CONEXION_DESCONECTED);
				}
			
		}catch (Exception e) {
			// TODO: handle exception
			Status.show("=CATCH PRIMERO");
		}
		
	}
	
	
	public void descargarDatos(String hashKey, String idlista){
		

		try{
			
			connectionURL = "http://observatoriodeprecios.defensoria.gob.sv/v1/getNotifiacionesAlertasPorMiembro/"+hashKey+"/"+idlista+"/"+tipoConexion;
			
			
	        conn = (HttpConnection) Connector.open(connectionURL);
	        conn.setRequestProperty("Content-Type","application/json");

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
	            
	            	String mensaje = objeto2.getString("msg");
	            	
	            	JSONObject objeto3 =  new  JSONObject ( mensaje );	            	
						            	
		            	rutas 		= objeto3.getString("rutas");
		            	alertas 	= objeto3.getString("alertas");
		            	productos 	= objeto3.getString("productos");
	            	
	            
	            }else if (errorCode.equals("1")){
	            	Status.show(Strings.CONEXION_DESCONECTED);
	            	
	            	
	            }
	        }
	            
	        }catch (Exception e) {
				// TODO: handle exception
	        	Status.show(Strings.CONEXION_DESCONECTED);
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
		
		configurarlista.setRutas(rutas);
		configurarlista.setAlertas(alertas);
		configurarlista.setProductos(productos);
		
		configurarlista.setErrorCode(errorCode);
		configurarlista.setErrorMessage(errorMessage);
		
	}
	
	

}
	

