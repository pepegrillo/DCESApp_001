package configurations;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;

import org.json.me.JSONObject;


/**
 * A class extending the MainScreen class, which provides default standard
 * behavior for BlackBerry GUI applications.
 */
public class Metodo extends Thread
{
	HttpConnection conn = null;
    InputStream is = null;
    ByteArrayOutputStream bos = null;
    String response = null;
    String connectionURL = null;
	String tipoConexion = ConexionController.getConnectionString()[0];
	String getTipo = ConexionController.getConnectionString()[1];
    
    /*String error;
   	String idUser;

   	String accessTocken;
       String name;
   	String email;
   	String gender;
   	int points;*/
   	
   	DbSql path = new DbSql();
	DbSql statement = new DbSql();
	/*String id_level;
	private int updates;
	private InputStream is2;
	private ByteArrayOutputStream bos2;*/

	
    
    public String POST(String url, String json)
    {   
    	connectionURL = url;
    	try{
    		JSONObject jsonObject =  new  JSONObject ("{"+ json +"}"); 
    		//Dialog.alert("JSON>"+jsonObject+"<");
            conn = (HttpConnection)Connector.open(connectionURL+tipoConexion);
            conn.setRequestMethod(HttpConnection.POST);
 
            conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Content-Length", Integer.toString(jsonObject.length()));      
            
            OutputStream os = conn.openOutputStream();
			os.write(jsonObject.toString().getBytes("UTF-8"));
			 
			bos = new ByteArrayOutputStream();
			is = conn.openInputStream();
			byte[] buffer = new byte[20000];
			int bytesRead = is.read(buffer);
			
			while(bytesRead > 0) {
			     bos.write(buffer, 0, bytesRead);
			     bytesRead = is.read(buffer);
			     }
			
			bos.close();
			conn.close();
			response = new String(bos.toByteArray(), "UTF-8");
         } catch (IOException ex) {
         } catch (Exception e) {
    	 }
    	return response;
    }
    
    /*public void LOGIN(String correo, String password) {
    	
    	
    		String idClient1 = "";  
    		int incremento=0; 
    	try{
    		
    			URI uri = URI.create(path.Path());
				Database sqliteDB1 = DatabaseFactory.open(uri); 				
    		try{
				Statement slc = sqliteDB1.createStatement("SELECT id_client FROM USER");
		        slc.prepare();
		        Cursor sc = slc.getCursor();               	
		        Row rc;                
		        int j = 0;
		        while(sc.next()){
		            rc = sc.getRow(); 
		            idClient1 	= rc.getString(0);		           
					j++;
		        }
		        slc.close(); 
		        sc.close(); 
		        sqliteDB1.close();
    		}catch(Exception e){   	
    			sqliteDB1.close();
    		}finally{
    			sqliteDB1.close();
    		}
    		Status.show("Descargando configuración, esto puede tomar un momento",1500);
	    	String connectionURL1 = "http://54.213.23.122/MeWe/service/user/v1/login/"+correo+"/"+password+"/3/"+idClient1+"/test_push_token/es.json"+tipoConexion;	        
	    	HttpConnection conn1 = (HttpConnection) Connector.open(connectionURL1);
	        conn1.setRequestProperty("Content-Type","application/json");	        
	        is = conn1.openInputStream();
	       
	        int ch=-1;
	        bos = new ByteArrayOutputStream();
	        
	        while((ch = is.read())!=-1)
	        {
	            bos.write(ch);	
	            incremento++;	                
	        }
	        
	        if(incremento!=0){
		        String connectionURL0 = "http://54.213.23.122/MeWe/service/user/v1/login/"+correo+"/"+password+"/3/"+idClient1+"/test_push_token/es.json"+tipoConexion;	        
		    	HttpConnection conn0 = (HttpConnection) Connector.open(connectionURL0);
		        conn0.setRequestProperty("Content-Type","application/json");	        
		        InputStream is0 = conn0.openInputStream();
		        int ch0=-1;
		        ByteArrayOutputStream bos0 = new ByteArrayOutputStream();
		        
		       Status.show("Ingresando...");
		        while((ch0 = is0.read())!=-1)
		        {
		            bos0.write(ch0);		                
		        }
			       String response1 = new String(bos0.toByteArray());	             
			       JSONObject objeto1 =  new  JSONObject ( response1 );
		           String resultado1 = objeto1.getString("response");		            
		
		           JSONObject objeto2 =  new  JSONObject ( resultado1 );
		           String resultado2 = objeto2.getString("modelUser");
		           JSONObject objeto3 =  new  JSONObject ( resultado2 );
			       
			       error = objeto2.getString("errorCode");            
		           if(error.equals("0")){	
		                     
		        	   String idUser1 		= objeto3.getString("idUser");
			           String idClient2 	= objeto3.getString("idClient");
			           String name1 		= objeto3.getString("name");
			           String email1 		= objeto3.getString("email");
			           String gender1 		= objeto3.getString("gender");
			           String accessToken1 	= objeto3.getString("accessToken");
			           int points1 			= objeto3.getInt("points");
			           int updates1 		= objeto3.getInt("hasPendingUpdates");
			           
			           Database sqliteDB = DatabaseFactory.open(uri); 	
			           try{      	           	  						
					      Statement update = sqliteDB.createStatement("UPDATE USER SET id_user='"+idUser1+"',id_client='"+idClient2+"',name='"+name1+"',email='"+email1+"',genero='"+gender1+"',accessTocken='"+accessToken1+"',points="+points1+"");
					      update.prepare();
					      update.execute();
					      update.close();   
					      sqliteDB.close(); 
				   		}catch(Exception e){   	
							sqliteDB.close();
						}finally{
							sqliteDB.close();
						}
			           
			           if(updates1 == 1){
							GetMaster rewards = new GetMaster();
							rewards.GETMASTER();	
			           }else{
							UiApplication.getUiApplication().pushScreen(new Home());
			           }
		           }else if(error.equals("104")){
			            Status.show(Strings.REGISTRO_ERROR_REGISTRO,2000);
			       }else{
			            Status.show(Strings.CONEXION_UNEXPECTED,2000);
			       } 
		           
		      }else{
		    	  Dialog.alert(Strings.CONEXION_UNEXPECTED);
		      }  
    	}catch(Exception e){   		
    		 Dialog.alert(Strings.CONEXION_UNEXPECTED);
    	}
    }*/
    
    
 /*   public String DELETE(String idHabito){
    	String idClient ="";
    	try {	
    	   	
	        URI uri = URI.create(path.Path());
				Database sqliteDB = DatabaseFactory.open(uri); 
				
				Statement slc = sqliteDB.createStatement(statement.SelectUser());
		        slc.prepare();
		        Cursor sc = slc.getCursor();               	
		        Row rc;                
		        int j = 0;
		        while(sc.next()){
		            rc = sc.getRow(); 
		            idUser 		= rc.getString(0);
		            idClient 	= rc.getString(1);
		            accessTocken = rc.getString(5);				
					j++;
		        }
		        slc.close(); 
		        sc.close();           
				
			connectionURL = Strings.SERVER_NAME+"habits/v1/delete/"+idUser+"/"+idClient+"/"+accessTocken+"/"+idHabito+".json"+tipoConexion;	          	
        	error = null;		        
	        conn = (HttpConnection) Connector.open(connectionURL);
	        conn.setRequestProperty("Content-Type","application/json");
	        conn.setRequestMethod("DELETE");
	        Status.show("Eliminando...");
	        	
	            is = conn.openInputStream();
	            int ch=-1;
	            bos = new ByteArrayOutputStream();
	            while((ch = is.read())!=-1)
	            {
	                bos.write(ch);
	            }
	            response = new String(bos.toByteArray());
	            
	            JSONObject objeto1 =  new  JSONObject ( response );
	            String resultado1 = objeto1.getString("response");		            

	            JSONObject objeto2 =  new  JSONObject ( resultado1 );			            
	            error = objeto2.getString("errorCode");
	            if(error.equals("0")){
	            	Statement delete = sqliteDB.createStatement("DELETE FROM USERHABITO WHERE idHabit = '"+idHabito+"';");
					delete.prepare();
					delete.execute();
					delete.close();
					
	            }
	            //127the habit user relation not exist
	        sqliteDB.close();
	    } catch (Exception e) {
	  // Dialog.alert(e.getMessage());
	    			    
	    }finally 
	    {
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
		return error;
}
    public String DELETE2(String idHabito,String idUser,String idClient,String accessTocken){ 
    	        
		try{	
			connectionURL = Strings.SERVER_NAME+"habits/v1/delete/"+idUser+"/"+idClient+"/"+accessTocken+"/"+idHabito+".json"+tipoConexion;	          	
        	error = null;		        
	        conn = (HttpConnection) Connector.open(connectionURL);
	        conn.setRequestProperty("Content-Type","application/json");
	        conn.setRequestMethod("DELETE");
	        //Status.show("Eliminando...");
	        	
	            is = conn.openInputStream();
	            int ch=-1;
	            bos = new ByteArrayOutputStream();
	            while((ch = is.read())!=-1)
	            {
	                bos.write(ch);
	            }
	            response = new String(bos.toByteArray());
	           // Dialog.alert(response);
	            JSONObject objeto1 =  new  JSONObject ( response );
	            String resultado1 = objeto1.getString("response");		            

	            JSONObject objeto2 =  new  JSONObject ( resultado1 );			            
	            error = objeto2.getString("errorCode");
	            if(error.equals("0")){
	            	Statement delete = sqliteDB.createStatement("DELETE FROM USERHABITO WHERE idHabit = '"+idHabito+"';");
					delete.prepare();
					delete.execute();
					delete.close();
					
	            }
	            //127the habit user relation not exist

	    } catch (Exception e) {
	    	//Dialog.alert(e.getMessage());
	    			    
	    }finally 
	    {
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
		return error;
}*/


public String PUT(String url, String json) {
	  	
    try {        			        
	        JSONObject jsonObject =  new  JSONObject ("{"+ json +"}");    	
            conn = (HttpConnection)Connector.open(url+tipoConexion);
            //conn.setRequestMethod(HttpConnection.);
            conn.setRequestMethod("PUT");
            
            conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Content-Length", Integer.toString(jsonObject.length()));      
            
            OutputStream os = conn.openOutputStream();
			os.write(jsonObject.toString().getBytes("UTF-8"));
			 
			bos = new ByteArrayOutputStream();
			is = conn.openInputStream();
			byte[] buffer = new byte[20000];
			int bytesRead = is.read(buffer);
			
			while(bytesRead > 0) {
			     bos.write(buffer, 0, bytesRead);
			     bytesRead = is.read(buffer);
			     }
			
			bos.close();
			conn.close();
			response = new String(bos.toByteArray(), "UTF-8");           
            //127the habit user relation not exist
        //add(new LabelField(response));
    } catch (Exception e) 
    {
    	// add(new LabelField("Response : "+e.toString()));
    }finally 
    {

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
	return response;
	}
}



