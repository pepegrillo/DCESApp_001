package pck_WS;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;

import net.rim.device.api.database.Database;
import net.rim.device.api.database.DatabaseFactory;
import net.rim.device.api.database.Statement;
import net.rim.device.api.io.URI;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.component.Status;

import org.json.me.JSONObject;

import pck_SG.FiltroSG;
import configurations.ConexionController;
import configurations.DbSql;
import configurations.Strings;

public class LoginCx {

	
	private String connectionURL;
	private HttpConnection conn;
	private InputStream is;
	private ByteArrayOutputStream bos;
	private String response;
	
	String tipoConexion = ConexionController.getConnectionString()[0];
	String getTipo = ConexionController.getConnectionString()[1];
	
	public Vector IdMunicipio   = new Vector();
	public Vector Municipio     = new Vector();
	
	public String errorCode    = new String();
	public String errorMessage = new String();
	
	DbSql path = new DbSql();
	DbSql statement = new DbSql();
	//private int incremento;
	
	FiltroSG iniciosesion = new FiltroSG();
	
	public LoginCx(String emailC, String pwC){
		
		
		
		descargarDatos(emailC, pwC);
	}
	
	public void descargarDatos(String email, String pw){
		

		try{
			
			connectionURL = "http://observatoriodeprecios.defensoria.gob.sv/ApiREST.php/v1/getSesion/"+email+"/"+pw+tipoConexion;

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
	            errorCode    = objeto2.getString("errorCode");
	            errorMessage = objeto2.getString("errorMessage");
	            Status.show("Iniciando sesión...");
	            if(errorCode.equals("0")){
	            	
	            	String mensaje     = objeto2.getString("msg");
	            	
	            	JSONObject objeto3 = new JSONObject( mensaje );
	            	String datosuser   = objeto3.getString("miembro");
	            	
	            	JSONObject objeto4 = new JSONObject( datosuser );
	            	String idmiembro   = objeto4.getString("idMiembro");
	            	String nombre      = objeto4.getString("nombre");
	            	String apellido    = objeto4.getString("apellido");
	            	String sexo   	   = objeto4.getString("sexo");
	            	String correo      = objeto4.getString("correo");
	            	String hashkey     = objeto4.getString("hashKey");
	            	//Dialog.alert(idmiembro+nombre+apellido+sexo+correo+hashkey);
	            	
	            	try{
	            		URI uri1 = URI.create(path.Path());
	            		Database sqliteDB1 = DatabaseFactory.open(uri1);
	            		//Aqui tiene que ir un update Viernes 17 enero 2014
	            		Statement in = sqliteDB1.createStatement(
	            				statement.InsertUser(idmiembro, nombre, apellido, sexo, correo, hashkey));
	            		in.prepare();
						in.execute();
						in.close(); 
						sqliteDB1.close();
	            	}catch (Exception e) {
						// TODO: handle exception
	            		errorMessage = "Usuario y/o Contraseña incorrecto.";
					}
	            	
		            /*JSONArray jsonMainArr = objeto2.getJSONArray("msg");
				
	            	for (int i = 0; i < jsonMainArr.length(); i++) {
		            	
		            	JSONObject childJSONObject = jsonMainArr.getJSONObject(i);
		            	
		            	try{
		            		URI uri1 = URI.create(path.Path());
		            		Database sqliteDB1 = DatabaseFactory.open(uri1);
		            		Statement in = sqliteDB1.createStatement(
		            				statement.InsertMunicipio(idcategoria,
		            						childJSONObject.getString("idMunicipio"),
		            						childJSONObject.getString("municipio")));
		            		in.prepare();
							in.execute();
							in.close(); 
							sqliteDB1.close();
		            	}catch (Exception e) {
							// TODO: handle exception
		            		errorMessage = "En este momento no se pueden \n mostrar datos " +
				            		"intentelo de nuevo más tarde";
						}
		            	
		            
	            	}*/
	            	
	            	//cargarDatos(idcategoria);
	            	
	            }else if (errorCode.equals("1")){
		            errorMessage = "Usuario y/o Contraseña incorrecto.";
	            	
	            }else{
	            	errorMessage = "Usuario y/o Contraseña incorrecto.";
	            }
	        }
	            
	        }catch (Exception e) {
				// TODO: handle exception
	        	//Dialog.alert("descargar datos "+e.getMessage());
	        	errorMessage = "Algo inesperado ha sucedido!.";
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
		
		iniciosesion.seterrorCode(errorCode);
		iniciosesion.seterrorMessage(errorMessage);
		
	}
	
	
	
	
	
}
