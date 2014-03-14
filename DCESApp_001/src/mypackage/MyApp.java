package mypackage;

import net.rim.device.api.database.Database;
import net.rim.device.api.database.DatabaseFactory;
import net.rim.device.api.database.Statement;
import net.rim.device.api.io.URI;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.container.MainScreen;
import configurations.DbSql;

/**
 * This class extends the UiApplication class, providing a
 * graphical user interface.
 */
public class MyApp extends UiApplication
{
    /**
     * Entry point for application
     * @param args Command line arguments (not used)
     */ 
	
	//Inicializando variable SplashScreen
	static MainScreen splashScreen = null, homeScreen = null;
	
	DbSql path = new DbSql();
	DbSql statement = new DbSql();
	
    public static void main(String[] args)
    {
        // Create a new instance of the application and make the currently
        // running thread the application's event dispatch thread.
        MyApp theApp = new MyApp();       
        theApp.enterEventDispatcher();
    }
    

    /**
     * Creates a new MyApp object
     */
    public MyApp()
    {        
    	try{
    		URI uri = URI.create(path.Path());
	     	Database sqliteDB = DatabaseFactory.create(uri);
	     	
		     	Statement cu = sqliteDB.createStatement(statement.CreateUser());				
		     	cu.prepare();
		     	cu.execute();
		     	cu.close();
				
				Statement cp = sqliteDB.createStatement(statement.CategoriaProducto());				
				cp.prepare();
				cp.execute();
				cp.close();
				
				Statement cpt = sqliteDB.createStatement(statement.TemporadaCategoriaProducto());				
				cpt.prepare();
				cpt.execute();
				cpt.close();
				
				Statement p = sqliteDB.createStatement(statement.Producto());				
				p.prepare();
				p.execute();
				p.close();
				
				Statement pt = sqliteDB.createStatement(statement.TemporadaProducto());				
				pt.prepare();
				pt.execute();
				pt.close();
				
				Statement cm = sqliteDB.createStatement(statement.Municipio());				
				cm.prepare();
				cm.execute();
				cm.close();
				
				Statement cmt = sqliteDB.createStatement(statement.TemporadaMunicipio());				
				cmt.prepare();
				cmt.execute();
				cmt.close();
				
				Statement ce = sqliteDB.createStatement(statement.Establecimiento());				
				ce.prepare();
				ce.execute();
				ce.close();
				
				Statement cet = sqliteDB.createStatement(statement.TemporadaEstablecimiento());				
				cet.prepare();
				cet.execute();
				cet.close();
				
				Statement cpr = sqliteDB.createStatement(statement.Presentacion());				
				cpr.prepare();
				cpr.execute();
				cpr.close();
				
				Statement cprt = sqliteDB.createStatement(statement.TemporadaPresentacion());				
				cprt.prepare();
				cprt.execute();
				cprt.close();
				
				Statement cpf = sqliteDB.createStatement(statement.ProductoFiltrado());				
				cpf.prepare();
				cpf.execute();
				cpf.close();
				
				Statement cpft = sqliteDB.createStatement(statement.TemporadaProductoFiltrado());				
				cpft.prepare();
				cpft.execute();
				cpft.close();
				
				Statement cb = sqliteDB.createStatement(statement.Busqueda());				
				cb.prepare();
				cb.execute();
				cb.close();
				
				Statement cbt = sqliteDB.createStatement(statement.TemporadaBusqueda());				
				cbt.prepare();
				cbt.execute();
				cbt.close();
				
				Statement cf = sqliteDB.createStatement(statement.Favorito());				
				cf.prepare();
				cf.execute();
				cf.close();
				
				Statement cftu = sqliteDB.createStatement(statement.TemporalUser());				
				cftu.prepare();
				cftu.execute();
				cftu.close();
				
				Statement clc = sqliteDB.createStatement(statement.ListaCompras());				
				clc.prepare();
				clc.execute();
				clc.close();
				
				Statement crc = sqliteDB.createStatement(statement.RutaCompras());				
				crc.prepare();
				crc.execute();
				crc.close();
				
				Statement cpc = sqliteDB.createStatement(statement.ProductoCompras());				
				cpc.prepare();
				cpc.execute();
				cpc.close();
				
			sqliteDB.close();
	     	
    	}catch (Exception e) {
			// TODO: handle exception
		}finally{
    	//Llamar SplashScreen
    	splashScreen = new SplashScreen();
    	
    	
    	
        // Push a screen onto the UI stack for rendering.
        //pushScreen(new MyScreen());
    	pushScreen(splashScreen);
		}
    }    
}
