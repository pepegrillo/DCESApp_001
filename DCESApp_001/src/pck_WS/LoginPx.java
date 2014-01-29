package pck_WS;

import net.rim.device.api.database.Database;
import net.rim.device.api.database.DatabaseFactory;
import net.rim.device.api.database.Statement;
import net.rim.device.api.io.URI;
import configurations.ConexionController;
import configurations.DbSql;

public class LoginPx {

	
	
	String tipoConexion = ConexionController.getConnectionString()[0];
	String getTipo = ConexionController.getConnectionString()[1];
	
	
	DbSql path = new DbSql();
	DbSql statement = new DbSql();
	
	public LoginPx(){
		
		eliminarDatos();
		
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
