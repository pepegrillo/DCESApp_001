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

import org.json.me.JSONObject;

import pck_SG.ListaComprasSG;
import configurations.ConexionController;
import configurations.DbSql;
import configurations.Metodo;
import configurations.Strings;

public class ListaComprasPx {
	
	private String connectionURL;
	private HttpConnection conn;
	private InputStream is;
	private ByteArrayOutputStream bos;
	private String response;
	
	String tipoConexion = ConexionController.getConnectionString()[0];
	String getTipo = ConexionController.getConnectionString()[1];
	Metodo request = new Metodo();
	
	public Vector IdLista		= new Vector();
	public Vector NombreLista	= new Vector();
	
	public String IdListaReturn = new String();
	public String errorCode    	= new String();
	public String errorMessage 	= new String();
	
	public String hashKey    = new String();
	
	DbSql path = new DbSql();
	DbSql statement = new DbSql();
	
	//String hashKey;
	
	ListaComprasSG listacompras = new ListaComprasSG();
	
	public void postListaCompras(String txtListName){
		
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
			
			String url = Strings.HTTP_SW+"postListaDeCompras"+tipoConexion;
			String json = "'hashKey'		: '"+hashKey.toString()+"'," +
						"'nombreLista'		: '"+txtListName+"'";
			//Dialog.alert(json);
			String response = request.POST(url,json);
			
			JSONObject objeto1 =  new  JSONObject ( response );
            String resultado1 = objeto1.getString("response");		            
            JSONObject objeto2 =  new  JSONObject ( resultado1 );    		           
            response  = objeto2.getString("errorCode");
            
            //String datosUser = objeto2.getString("msg");
            
            if(response.equals("0")){
            	//Dialog.alert(objeto2.getString("errorMessage"));
            	
            	String datosUser = objeto2.getString("msg");
            	JSONObject objeto3 =  new  JSONObject ( datosUser );
            	
            	IdListaReturn = objeto3.getString("idLista");
            	
            	//UiApplication.getUiApplication().pushScreen(new MenuMain(2));
            }else{
            	Dialog.alert("Ha ocurrido algo inesperado, inténtelo de nuevo.");
            }
			
		}catch (Exception e) {
			// TODO: handle exception
			Dialog.alert("Ha ocurrido algo inesperado, inténtelo de nuevo.");
		}finally{
			listacompras.setIdListaReturn(IdListaReturn);
			//listacompras.seterrorCode(errorCode);
			//listacompras.seterrorMessage(errorMessage);
		}
		
	}
	
	
	public void eliminarListaCompras(String idLista){
		
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
			
			connectionURL = Strings.HTTP_SW+"deleteListaCompras/"+hashKey+"/"+idLista+tipoConexion;
			
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
	            //Dialog.alert(resultado1+"<<");
	            JSONObject objeto2 =  new  JSONObject ( resultado1 );
	            errorCode    = objeto2.getString("errorCode");
	            errorMessage = objeto2.getString("errorMessage");
	            
	            if(errorCode.equals("0")){
	            	
	            	
	            	Status.show("Lista de compras eliminada correctamente.");
	            	//new ListaComprasCx(); 
	            	//Dialog.alert(errorMessage+">>");
	            }else if (errorCode.equals("1")){
	            	Status.show("En este momento no se pueden \n mostrar datos " +
		            		"intentelo de nuevo más tarde");
		            
	            	
	            }
	        }
	            
	        }catch (Exception e) {
	        	Status.show("En este momento no se pueden \n mostrar datos " +
	            		"intentelo de nuevo más tarde");
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
		
		
	}
	

}
	

