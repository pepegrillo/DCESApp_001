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
import net.rim.device.api.ui.component.Status;

import org.json.me.JSONArray;
import org.json.me.JSONObject;

import pck_SG.CotizarListaDetalleSG;
import configurations.ConexionController;
import configurations.DbSql;
import configurations.Metodo;
import configurations.Strings;

public class CotizarListaDetalleCx {
	
	private String connectionURL;
	private HttpConnection conn;
	private InputStream is;
	private ByteArrayOutputStream bos;
	private String response;
	
	String tipoConexion = ConexionController.getConnectionString()[0];
	String getTipo = ConexionController.getConnectionString()[1];
	Metodo request = new Metodo();
	
	public Vector idArticulo			= new Vector();
	public Vector nombre				= new Vector();
	public Vector presentacion			= new Vector();
	public Vector marca					= new Vector();
	public Vector precio				= new Vector();
	public Vector fechaSondeo			= new Vector();
	public Vector estadoExistencia		= new Vector();
	
	public String errorCode    = new String();
	public String errorMessage = new String();
	
	public String hashKey    = new String();
	
	DbSql path = new DbSql();
	DbSql statement = new DbSql();
	
	//String hashKey;
	
	CotizarListaDetalleSG cotizarlistadetalle = new CotizarListaDetalleSG();
	
	public CotizarListaDetalleCx(String idLista, String idestablecimiento){
		
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
					descargarDatos(hashKey, idLista,idestablecimiento);
				}else if(getTipo.equals("BIBS")){
					Status.show(Strings.MSG_DESCARGANDO_SLOW);
					descargarDatos(hashKey,idLista,idestablecimiento);
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
	
	
	public void descargarDatos(String hashKey, String idlista, String idestablecimiento){
		

		try{
			
			connectionURL = Strings.HTTP_SW+"getDetalleCotizacionEstablecimientosLista/"+hashKey+"/"+idlista+"/"+idestablecimiento+"/"+tipoConexion;
			
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
		            	
		            	idArticulo.addElement(childJSONObject.getString("idArticulo"));
		            	nombre.addElement(childJSONObject.getString("nombre"));
		            	presentacion.addElement(childJSONObject.getString("presentacion"));
		            	marca.addElement(childJSONObject.getString("marca"));
		            	precio.addElement(childJSONObject.getString("precio"));
		            	fechaSondeo.addElement(childJSONObject.getString("fechaSondeo"));
		            	estadoExistencia.addElement(childJSONObject.getString("estadoExistencia"));
		            			            	
		            			            			            
	            	}
	            	
	            	//cargarDatos();
	            
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
		
		cotizarlistadetalle.setIdArticulo(idArticulo);
		cotizarlistadetalle.setNombre(nombre);
		cotizarlistadetalle.setPresentacion(presentacion);
		cotizarlistadetalle.setMarca(marca);
		cotizarlistadetalle.setPrecio(precio);
		cotizarlistadetalle.setFechaSondeo(fechaSondeo);
		cotizarlistadetalle.setEstadoExistencia(estadoExistencia);
		
		cotizarlistadetalle.setErrorCode(errorCode);
		cotizarlistadetalle.setErrorMessage(errorMessage);
		
	}
	
	

}
	

