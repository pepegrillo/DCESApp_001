package mypackage;

import configurations.DbSql;
import net.rim.device.api.database.Cursor;
import net.rim.device.api.database.Database;
import net.rim.device.api.database.DatabaseFactory;
import net.rim.device.api.database.Row;
import net.rim.device.api.database.Statement;
import net.rim.device.api.io.URI;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.MainScreen;
import estilos.Utils;

public class SplashScreen extends MainScreen {
	BitmapField bmp;
	DbSql path = new DbSql();
	
    public SplashScreen() {
    	
        super(SplashScreen.USE_ALL_HEIGHT | SplashScreen.NO_VERTICAL_SCROLL);
        
        try{
        	
        //setTitle((LabelField)null) ; // hide screen title  
    	if (Display.getWidth() > Display.getHeight())
		{	
    		bmp = new BitmapField(Utils.getFitBitmapImage("splash.png",Display.getWidth(), Display.getHeight()),BitmapField.FIELD_HCENTER | BitmapField.FIELD_VCENTER);  
        }else if (Display.getWidth() == 360){
        	bmp = new BitmapField(Utils.getFitBitmapImage("splash_360.png",Display.getWidth(), Display.getHeight()),BitmapField.FIELD_HCENTER | BitmapField.FIELD_VCENTER);
        }else if (Display.getWidth() == 360){
        	bmp = new BitmapField(Utils.getFitBitmapImage("splash_480.png",Display.getWidth(), Display.getHeight()),BitmapField.FIELD_HCENTER | BitmapField.FIELD_VCENTER);
        } 
        HorizontalFieldManager rowHolder = new HorizontalFieldManager(NO_HORIZONTAL_SCROLL | NO_VERTICAL_SCROLL| Field.FIELD_HCENTER | USE_ALL_HEIGHT );
        rowHolder.add(bmp);
        add(rowHolder);              
        }catch (Exception e){
        e.printStackTrace();

        }finally{
        	
        	try{  
    			/*URI uri = URI.create(path.Path());
    			Database sqliteDB = DatabaseFactory.create(uri); 
    			
    			Statement slc = sqliteDB.createStatement("CREATE TABLE IF NOT EXISTS USER(id_user TEXT, email TEXT, pw TEXT)");
                slc.prepare();
                Cursor sc = slc.getCursor();               	
                Row rc;                
                int j = 0;
                while(sc.next()){
                    rc = sc.getRow(); 
                    idUser 	= rc.getString(0);				
    				j++;
                }
                slc.close();
                sc.close();
    			sqliteDB.close();*/
            }catch (Exception e){
            	//Dialog.alert("error al entrar a la base "+e.getMessage());
            }
        	
        	MyApp.homeScreen = new MyScreen();
        	//MyApp.homeScreen = new Ajustes();
        	  
            UiApplication.getUiApplication().invokeLater(new Runnable() {			        	
				public void run() {
					
					UiApplication.getUiApplication().pushScreen(MyApp.homeScreen);
				    UiApplication.getUiApplication().popScreen(MyApp.splashScreen);					    
				}  
		            
		        }, 2000, false);
        }
    }
}
