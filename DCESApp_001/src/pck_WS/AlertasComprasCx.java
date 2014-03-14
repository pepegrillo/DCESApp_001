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

import pck_SG.AlertaComprasSG;
import configurations.ConexionController;
import configurations.DbSql;
import configurations.Metodo;
import configurations.Strings;

public class AlertasComprasCx {
	
	private String connectionURL;
	private HttpConnection conn;
	private InputStream is;
	private ByteArrayOutputStream bos;
	private String response;
	
	String tipoConexion = ConexionController.getConnectionString()[0];
	String getTipo = ConexionController.getConnectionString()[1];
	Metodo request = new Metodo();
	
	public Vector IdTipoNotificacion   = new Vector();
	public Vector Hora				   = new Vector();
	public Vector Dia				   = new Vector();
	public Vector IdListaN			   = new Vector();
	public Vector Notificacion		   = new Vector();
	
	public String errorCode    = new String();
	public String errorMessage = new String();
	
	public String idTipoN		= new String();
	public String HoraS			= new String();
	public String DiaS			= new String();
	public boolean Check;
	
	String hashKey;
	String TipoDeNotificacion;
	String AlertaActDesact;
	
	
	
	DbSql path = new DbSql();
	DbSql statement = new DbSql();
	
	AlertaComprasSG alertacompras = new AlertaComprasSG();
	
	public AlertasComprasCx(String IdLista){
		
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
      			hashKey = rc.getString(0);
      		}
      		selectR.close();
      		cursorR.close();
      		sqliteDB.close();
			
			connectionURL = Strings.HTTP_SW+"getEstadoAlertaLista/"+hashKey+"/"+IdLista+"/"+tipoConexion;
			
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
	            	
	            	JSONArray jsonMainArr = objeto2.getJSONArray("msg");
					
	            	for (int i = 0; i < jsonMainArr.length(); i++) {
		            	
		            	JSONObject childJSONObject = jsonMainArr.getJSONObject(i);
		            	
		            	idTipoN			= childJSONObject.getString("idTipoNotificacion");
		            	HoraS			= childJSONObject.getString("hora");
		            	DiaS			= childJSONObject.getString("dia");
		            	AlertaActDesact = childJSONObject.getString("notificacion");
		            	
		            	if (AlertaActDesact.equals("0")) {
		            		//check desactivado
		            		Check = false;
		            		//Status.show("desactivado");
		            	}else if (AlertaActDesact.equals("1")) {
		            		//check activado
		            		Check = true;
		            		//Status.show("activado");
		            	}
		            	
	            	}
	            } else if (errorCode.equals("1")) {
	            	Check = true;
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
		alertacompras.setIdTipoN(idTipoN);
		alertacompras.setHoraS(HoraS);
		alertacompras.setDiaS(DiaS);
		alertacompras.setCheck(Check);
		
	}
	
	
	//VALIDAR ALERTA
	public void validarAlertaCompras(String IdLista, String idTipoNotificacion, String notificacion, String hora){
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
      			hashKey = rc.getString(0);
      		}
      		selectR.close();
      		cursorR.close();
      		sqliteDB.close();
			
			connectionURL = Strings.HTTP_SW+"getEstadoAlertaLista/"+hashKey+"/"+IdLista+"/"+tipoConexion;
						
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
	            
	            	//PUT
	            	
	            	modificarAlertaCompras(IdLista, idTipoNotificacion, notificacion, hora);
	            	
	            }else if (errorCode.equals("1")){
		            
	            	//POST
	            	
	            	guardarAlertaCompras(IdLista, idTipoNotificacion, notificacion, hora);
	            	
	            }else{
	            	errorMessage = "En este momento no se pueden \n mostrar datos " +
		            		"inténtelo de nuevo.";
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
	
	
	//POST ALERTA
	public void guardarAlertaCompras(String idLista, String idTipoNotificacion, String notificacion, String hora){
		
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
	                           hashKey = rc.getString(0);
	                       }
	                       selectR.close();
	                       cursorR.close();
	                       sqliteDB.close();
	                       
	                       	String url = Strings.HTTP_SW+"postGuardarAlerta"+tipoConexion;
		   				 	String json = "'hashKey':'"+hashKey+"'," +
		   								"'idLista':'"+idLista+"'," +
		   								"'idTipoNotificacion':'"+idTipoNotificacion+"'," +
		   								"'notificacion':'"+notificacion+"'," +
		   								"'hora':'"+hora+"'";
		   					
		   					String response = request.POST(url,json);
		   					
		   					JSONObject objeto1 =  new  JSONObject ( response );
		   		            String resultado1 = objeto1.getString("response");		            
		   		            JSONObject objeto2 =  new  JSONObject ( resultado1 );    		           
		   		            int errorcode  = objeto2.getInt("errorCode");
		   		            
		   		            if(errorcode == 0){		   		            	
		   		            	Status.show("Alerta guardada satisfactoriamente.");
		   		            }else if(errorcode == 5){
		   		            	Status.show("Ya existen alertas para esta lista.");
		   		            }else if(errorcode == 10){
		   		            	Status.show("Ya existen alertas para esta lista.");
		   		            }else{
		   		            	Dialog.alert("Ha ocurrido algo inesperado, inténtelo de nuevo.");
		   		            }
	                      
			}catch(Exception e){
				Dialog.alert("Ha ocurrido algo inesperado, inténtelo de nuevo.");
			}finally{
			}
    	
    	}else{
    		Status.show(Strings.CONEXION_DESCONECTED);
    	}
	}
	
	
	//PUT ALERTA
		public void modificarAlertaCompras(String idLista, String idTipoNotificacion, String notificacion, String hora){
			
			if(getTipo.equals("wifi") || getTipo.equals("BIBS")){
	        	
	        	Status.show("Modificando...");
	        	
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
		                           hashKey = rc.getString(0);
		                       }
		                       selectR.close();
		                       cursorR.close();
		                       sqliteDB.close();
		                       
		                       	String url = "http://observatoriodeprecios.defensoria.gob.sv/v1/putCambiarAlerta/"+tipoConexion;
			   				 	String json = "'hashKey':'"+hashKey+"'," +
			   								"'idLista':'"+idLista+"'," +
			   								"'idTipoNotificacion':'"+idTipoNotificacion+"'," +
			   								"'notificacion':'"+notificacion+"'," +
			   								"'hora':'"+hora+"'";
			   					//Dialog.alert(url+"\n"+json);
			   					String response = request.PUT(url,json);
			   					
			   					JSONObject objeto1 =  new  JSONObject ( response );
			   		            String resultado1 = objeto1.getString("response");		            
			   		            JSONObject objeto2 =  new  JSONObject ( resultado1 );    		           
			   		            int errorcode  = objeto2.getInt("errorCode");
			   		            
			   		            if(errorcode == 0){		   		            	
			   		            	Status.show("Alerta guardada satisfactoriamente.");
			   		            }else if(errorcode == 5){
			   		            	Status.show("Ya existen alertas para esta lista.");
			   		            }else if(errorcode == 10){
			   		            	Status.show("Ya existen alertas para esta lista.");
			   		            }else{
			   		            	Dialog.alert("Ha ocurrido algo inesperado, inténtelo de nuevo.");
			   		            }
		                      
				}catch(Exception e){
					Dialog.alert("Ha ocurrido algo inesperado, inténtelo de nuevo.");
				}finally{
				}
	    	
	    	}else{
	    		Status.show(Strings.CONEXION_DESCONECTED);
	    	}
		}
		
		
		
		//PUT ALERTA
		public void modificarEstadoAlerta(String idLista, String notificacion){
			
			if(getTipo.equals("wifi") || getTipo.equals("BIBS")){
	        	
	        	Status.show("Esperando...");
	        	
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
		                           hashKey = rc.getString(0);
		                       }
		                       selectR.close();
		                       cursorR.close();
		                       sqliteDB.close();
		                       
		                       	String url = "http://observatoriodeprecios.defensoria.gob.sv/v1/putActivarDesactivarNotificacionLista/"+tipoConexion;
			   				 	String json = "'hashKey':'"+hashKey+"'," +
			   								"'idLista':'"+idLista+"'," +
			   								"'notificacion':'"+notificacion+"'";
			   					//Dialog.alert(url+"\n"+json);
			   					String response = request.PUT(url,json);
			   					
			   					JSONObject objeto1 =  new  JSONObject ( response );
			   		            String resultado1 = objeto1.getString("response");		            
			   		            JSONObject objeto2 =  new  JSONObject ( resultado1 );    		           
			   		            int errorcode  = objeto2.getInt("errorCode");
			   		            
			   		            if(errorcode == 0){		   		            	
			   		            	//Status.show("Alerta guardada satisfactoriamente.");
			   		            }else if(errorcode == 5){
			   		            	Status.show("Ya existen alertas para esta lista.");
			   		            }else if(errorcode == 10){
			   		            	Status.show("Ya existen alertas para esta lista.");
			   		            }else{
			   		            	Dialog.alert("Ha ocurrido algo inesperado, inténtelo de nuevo.");
			   		            }
		                      
				}catch(Exception e){
					Dialog.alert("Ha ocurrido algo inesperado, inténtelo de nuevo.");
				}finally{
				}
	    	
	    	}else{
	    		Status.show(Strings.CONEXION_DESCONECTED);
	    	}
		}

}
	

