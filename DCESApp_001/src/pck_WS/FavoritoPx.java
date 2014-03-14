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
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.Status;

import observatorioPrecio.CategoriaProducto;

import org.json.me.JSONObject;

import pck_SG.FavoritoSG;
import configurations.ConexionController;
import configurations.DbSql;
import configurations.Metodo;
import configurations.Strings;

public class FavoritoPx {
	
	private String connectionURL;
	private HttpConnection conn;
	private InputStream is;
	private ByteArrayOutputStream bos;
	private String response;
		
	String tipoConexion = ConexionController.getConnectionString()[0];
	String getTipo = ConexionController.getConnectionString()[1];
	Metodo request = new Metodo();
		
	DbSql path = new DbSql();
	DbSql statement = new DbSql();
	
	public String errorCode    = new String();
	public String errorMessage = new String();
	
	public String categoriasValidate = new String();
	
	String temporalUser;
	String HashKey;
	int incremento = 0;
	
	FavoritoSG favoritos = new FavoritoSG();
	
	public void guardarFavoritos(String idProducto, String idEstablecimiento, String Nombre){
		
		//verificarDatosBD();
		
		if(getTipo.equals("wifi") || getTipo.equals("BIBS")){
			
			try{
				
				URI uri = URI.create(path.Path());
				Database sqliteDB = DatabaseFactory.open(uri);

          		Statement selectR = sqliteDB.createStatement(statement.SelectTemporalUser());
          		selectR.prepare();
          		Cursor cursorR = selectR.getCursor();
          		Row rc;
          		//int i = 0;
          		while(cursorR.next()){
          			rc = cursorR.getRow();
          			temporalUser = rc.getString(0);
          			incremento ++;
          		}
          		selectR.close();
          		cursorR.close();
          		sqliteDB.close();
				
			}catch (Exception e) {
				// TODO: handle exception
			}
        	
			if (incremento == 0){
			
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
		                           HashKey = rc.getString(0);
		                       }
		                       selectR.close();
		                       cursorR.close();
		                       sqliteDB.close();
		                       
		                       	String url = Strings.HTTP_SW+"postElementosFavoritos"+tipoConexion;
			   					String json = "'hashKey':'"+HashKey+"'," +
			   								"'idArticulo':'"+idProducto+"'," +
			   								"'idEstablecimiento':'"+idEstablecimiento+"'";
			   					//Dialog.alert("Favoritos<"+json+">");
			   					String response = request.POST(url,json);
			   					//Dialog.alert("RESPONSE>"+response+"<");
			   					JSONObject objeto1 =  new  JSONObject ( response );
			   		            String resultado1 = objeto1.getString("response");		            
			   		            JSONObject objeto2 =  new  JSONObject ( resultado1 );    		           
			   		            int errorcode  = objeto2.getInt("errorCode");
			   		            //Dialog.alert("aqui se muestra el error "+errorcode);
			   		            if(errorcode == 0){
			   		            	//Dialog.alert(objeto2.getString("errorMessage"));
			   		            	Status.show(Nombre+" ha sido guardado satisfactoriamente.");
			   		            }else if(errorcode == 5){
			   		            	Status.show(Nombre+" ya ha sido guardado en Favoritos.",5000);
			   		            }else{
			   		            	Dialog.alert("ERROR CODE Ha ocurrido algo inesperado, inténtelo de nuevo.");
			   		            }
		                      
				}catch(Exception e){
					Dialog.alert(Strings.CONEXION_UNEXPECTED+" "+e.getMessage());
				}finally{
				}
	        	
			}else{
				Dialog.alert("Debes iniciar sesión o registrarte para acceder a ésta función.");
			}
    	
    	}else{
    		Status.show(Strings.CONEXION_DESCONECTED);
    	}
	}


	public void eliminarFavoritos(String hashKey, String idProducto, String idEstablecimiento){
		
		try{
			
			connectionURL = Strings.HTTP_SW+"deleteElementosFavoritos/"+hashKey+"/"+idProducto+"/"+idEstablecimiento+tipoConexion;
			
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
	            //Dialog.alert(response+"<<");
	            //JSONObject temporalError = new  JSONObject ( response );
	            
	            //errorCode    = temporalError.getString("errotCode");
	            //errorMessage = temporalError.getString("errorMessage");
	            
	            JSONObject objeto1 =  new  JSONObject ( response );
	            String resultado1  = objeto1.getString("response");
	            //Dialog.alert(resultado1+"<<");
	            JSONObject objeto2 =  new  JSONObject ( resultado1 );
	            errorCode    = objeto2.getString("errorCode");
	            errorMessage = objeto2.getString("errorMessage");
	            //Dialog.alert(errorCode+"<<"+errorMessage+">>");
	            
	            if(errorCode.equals("0")){
	            	
	            	errorMessage = "Favorito eliminado correctamente.";
	            	//Dialog.alert(errorMessage+">>");
	            }else if (errorCode.equals("1")){
		            errorMessage = "En este momento no se pueden \n mostrar datos " +
		            		"intentelo de nuevo más tarde";
	            	
	            }
	        }
	            
	        }catch (Exception e) {
	        	errorMessage = "En este momento no se pueden \n mostrar datos " +
	            		"intentelo de nuevo más tarde";
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
		
			favoritos.seterrorCode(errorCode);
			favoritos.seterrorMessage(errorMessage);
		
	}
	
	
	public void validacionUser(){
		
		try{
			URI uri1 = URI.create(path.Path());
    		Database sqliteDB1 = DatabaseFactory.open(uri1);
    		Statement in = sqliteDB1.createStatement(
    				statement.InsertTemporalUser("00","temporal"));
    		//Dialog.alert(in+"");
    		in.prepare();
			in.execute();
			in.close(); 
			sqliteDB1.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void eliminarTemporalUser(){
		
		try{
			URI uri1 = URI.create(path.Path());
    		Database sqliteDB1 = DatabaseFactory.open(uri1);
    		Statement in = sqliteDB1.createStatement(
    				statement.DeleteTemporalUser());
    		//Dialog.alert(in+"");
    		in.prepare();
			in.execute();
			in.close(); 
			sqliteDB1.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	/*public void verificarDatosBD() {
		
		try{
			
			URI uri = URI.create(path.Path());
			Database sqliteDB = DatabaseFactory.open(uri);

      		Statement selectR = sqliteDB.createStatement(statement.SelectCategoriaProducto());
      		selectR.prepare();
      		Cursor cursorR = selectR.getCursor();
      		Row rc;
      		//int i = 0;
      		while(cursorR.next()){
      			rc = cursorR.getRow();
      			incremento ++;
      		}
      		selectR.close();
      		cursorR.close();
      		sqliteDB.close();
			
      		if ((getTipo.equals("wifi") || getTipo.equals("BIBS")) && (incremento == 0)) {
      			//categoriasValidate = "1";
      			UiApplication.getUiApplication().pushScreen(new CategoriaProducto());
      		} else if ((getTipo.equals("wifi") || getTipo.equals("BIBS")) && (incremento > 0)) {
      			//categoriasValidate = "1";
      			UiApplication.getUiApplication().pushScreen(new CategoriaProducto());
      		} else if ((getTipo.equals("error")) && (incremento > 0)) {
      			//categoriasValidate = "1";
      			UiApplication.getUiApplication().pushScreen(new CategoriaProducto());
      		} else if ((getTipo.equals("error")) && (incremento == 0)) {
      			//categoriasValidate = "0";
      			Dialog.alert("NO PASAR");
      		}
		
		}catch (Exception e) {
			// TODO: handle exception
			categoriasValidate = "0";
			Dialog.alert("CATCH");
		}
		
		//favoritos.setCategoriasValidate(categoriasValidate);
		
	}*/
	
}
	

