package pck_WS;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;

import net.rim.device.api.system.Display;
import net.rim.device.api.ui.component.Status;

import org.json.me.JSONArray;
import org.json.me.JSONObject;

import pck_SG.AgregarEstablecimientoComprasSG;
import configurations.ConexionController;
import configurations.Metodo;
import configurations.Strings;

public class AgregarEstablecimientoComprasCx {
	
	private String connectionURL;
	private HttpConnection conn;
	private InputStream is;
	private ByteArrayOutputStream bos;
	private String response;
	
	String tipoConexion = ConexionController.getConnectionString()[0];
	String getTipo = ConexionController.getConnectionString()[1];
	Metodo request = new Metodo();
	
	public Vector IdEstablecimiento			= new Vector();
	public Vector NombreEstablecimiento		= new Vector();
	public Vector DireccionEstablecimiento	= new Vector();
	
	public String errorCode    = new String();
	public String errorMessage = new String();
	
	AgregarEstablecimientoComprasSG agregarestablecimientocompras = new AgregarEstablecimientoComprasSG();
	
	public AgregarEstablecimientoComprasCx(String idMunicipioEst){
		
		
				if(getTipo.equals("wifi")){
					Status.show(Strings.MSG_DESCARGANDO);					
					descargarDatos(idMunicipioEst);
					
				}else if(getTipo.equals("BIBS")){
					Status.show(Strings.MSG_DESCARGANDO_SLOW);
					descargarDatos(idMunicipioEst);
					
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
		
		
	}
	
	
	public void descargarDatos(String idmunicipio){
		

		try{
			
			connectionURL = Strings.HTTP_SW+"getEstablecimientosPorMunicipio/"+idmunicipio+tipoConexion;
			
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
		            	
		            	IdEstablecimiento.addElement(childJSONObject.get("idEstablecimiento"));
		            	NombreEstablecimiento.addElement(childJSONObject.get("nombre"));
		            	DireccionEstablecimiento.addElement(childJSONObject.get("direccion"));
		            	
		            			            
	            	}
	            	
	            
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
			
			agregarestablecimientocompras.setIdEstablecimiento(IdEstablecimiento);
			agregarestablecimientocompras.setNombreEstablecimiento(NombreEstablecimiento);
			agregarestablecimientocompras.setDireccionEstablecimiento(DireccionEstablecimiento);
			agregarestablecimientocompras.seterrorCode(errorCode);
			agregarestablecimientocompras.seterrorMessage(errorMessage);
			
			
			
		
	}
	
	

}
	

