package pck_WS;

import pck_SG.LoginSG;
import net.rim.device.api.database.Cursor;
import net.rim.device.api.database.Database;
import net.rim.device.api.database.DatabaseFactory;
import net.rim.device.api.database.Row;
import net.rim.device.api.database.Statement;
import net.rim.device.api.io.URI;
import configurations.ConexionController;
import configurations.DbSql;

public class LoginPx {
	
	String tipoConexion = ConexionController.getConnectionString()[0];
	String getTipo = ConexionController.getConnectionString()[1];
		
	DbSql path = new DbSql();
	DbSql statement = new DbSql();
	
	public String nombre 	= new String();
	public String apellido  = new String();
	
	public String errorCode    = new String();
	public String errorMessage = new String();
	
	LoginSG loginsg = new LoginSG();
	
	public LoginPx(){
		
		try{
			URI uri = URI.create(path.Path());
			Database sqliteDB = DatabaseFactory.open(uri);						
			Statement sf = sqliteDB.createStatement(statement.SelectUser());
			sf.prepare();
			Cursor cf = sf.getCursor();
			Row rf;
			while(cf.next()){
				rf = cf.getRow();
				nombre 	= rf.getString(1);
				apellido = rf.getString(2);
				//incremento ++;
			}
			cf.close();
			sf.close();			
			sqliteDB.close();
			
						
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		loginsg.setNombre(nombre);
		loginsg.setApellido(apellido);
		
		loginsg.seterrorCode(errorCode);
		loginsg.seterrorMessage(errorMessage);
		
	}
	
	public void eliminarDatos(){
		
		try{
        	URI uri1 = URI.create(path.Path());
			Database sqliteDB1 = DatabaseFactory.open(uri1);
			Statement dt = sqliteDB1.createStatement(statement.DeleteUser());
			
			dt.prepare();
			dt.execute();
			dt.close(); 
			sqliteDB1.close();
    	}catch (Exception e){
 			//Dialog.alert("error elements habits "+e.getMessage());
 		}
		
	}
	
}
