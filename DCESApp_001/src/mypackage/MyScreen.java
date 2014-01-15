package mypackage;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.component.EmailAddressEditField;
import net.rim.device.api.ui.component.PasswordEditField;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import net.rim.device.api.ui.decor.BorderFactory;

import com.samples.toolkit.ui.component.BitmapButtonField;

import configurations.Strings;
import estilos.Estilos;

/**
 * A class extending the MainScreen class, which provides default standard
 * behavior for BlackBerry GUI applications.
 */
public final class MyScreen extends Estilos
{
	
	int tFuente;
	Font fLite;
	
	Bitmap bordes = Bitmap.getBitmapResource("bordes_txt.png");
	EmailAddressEditField txtCorreo;
	PasswordEditField txtPass;
	
	Bitmap btnInicioSesion;
	Bitmap btnInicioSesion1;
	Bitmap btnRegistro;
	Bitmap btnRegistro1;
	Bitmap btnSaltar;
	Bitmap btnSaltar1;
	Bitmap logoBm;
	//personalizacion
	int cinco	= 5;
	int diez	= 10;
	int veinte	= 20;
	int cincuenta	= 50;
    /**
     * Creates a new MyScreen object
     */
    public MyScreen()
    {        
        // Set the displayed title of the screen       
        //setTitle("MyTitle");
		if (Display.getWidth() == 320) {

			cinco 	= 0;
			diez 	= 5;
			veinte 	= 7;
			cincuenta = 20;
            btnInicioSesion 	= Bitmap.getBitmapResource("btnInicioSesion_320.png");
            btnInicioSesion1 	= Bitmap.getBitmapResource("btnInicioSesion1_320.png");	
            btnRegistro	    	= Bitmap.getBitmapResource("btnRegistro_320.png");
            btnRegistro1 		= Bitmap.getBitmapResource("btnRegistro1_320.png");
            btnSaltar			= Bitmap.getBitmapResource("btnSaltar_320.png");
            btnSaltar1 			= Bitmap.getBitmapResource("btnSaltar1_320.png");
			getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_320.png")));
			logoBm = Bitmap.getBitmapResource("logo_320.png");
			tFuente = 15;
		}
		if (Display.getWidth() == 360) {

			cinco 	= 0;
			diez 	= 5;
			veinte 	= 20;
			cincuenta = 20;
            btnInicioSesion 	= Bitmap.getBitmapResource("btnInicioSesion_360.png");
            btnInicioSesion1 	= Bitmap.getBitmapResource("btnInicioSesion1_360.png");
            btnRegistro	    	= Bitmap.getBitmapResource("btnRegistro_360.png");
            btnRegistro1 		= Bitmap.getBitmapResource("btnRegistro1_360.png");
            btnSaltar			= Bitmap.getBitmapResource("btnSaltar_360.png");
            btnSaltar1 			= Bitmap.getBitmapResource("btnSaltar1_360.png");
			getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_360.png")));
			logoBm = Bitmap.getBitmapResource("logo_360.png");
			tFuente = 20;
		}
		if (Display.getWidth() == 480) {
			cinco 	= 0;
			diez 	= 5;
			veinte 	= 10;
			cincuenta = 20;
            btnInicioSesion 	= Bitmap.getBitmapResource("btnInicioSesion_480.png");
            btnInicioSesion1 	= Bitmap.getBitmapResource("btnInicioSesion1_480.png");
            btnRegistro	    	= Bitmap.getBitmapResource("btnRegistro_480.png");
            btnRegistro1 		= Bitmap.getBitmapResource("btnRegistro1_480.png");
            btnSaltar			= Bitmap.getBitmapResource("btnSaltar_480.png");
            btnSaltar1 			= Bitmap.getBitmapResource("btnSaltar1_480.png");
			getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_480.png")));
			logoBm = Bitmap.getBitmapResource("logo_480.png");
			tFuente = 18;
		}
		if (Display.getWidth() == 640) {
            btnInicioSesion 	= Bitmap.getBitmapResource("btnInicioSesion.png");
            btnInicioSesion1 	= Bitmap.getBitmapResource("btnInicioSesion1.png");	
            btnRegistro	    	= Bitmap.getBitmapResource("btnRegistro.png");
            btnRegistro1 		= Bitmap.getBitmapResource("btnRegistro1.png");
            btnSaltar			= Bitmap.getBitmapResource("btnSaltar.png");
            btnSaltar1 			= Bitmap.getBitmapResource("btnSaltar1.png");
            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background.png")));
            logoBm = Bitmap.getBitmapResource("logo.png");
            tFuente = 30;
		}
    	    	
        
    	HorizontalFieldManager logoHfm = new HorizontalFieldManager(HorizontalFieldManager.FIELD_HCENTER);	    	
        BitmapField logoBmf = new BitmapField(logoBm);
        logoHfm.add(logoBmf);
        add(logoHfm);
        
        
        
        try{
	        FontFamily ffFont1 = FontFamily.forName("Arial");
		 	fLite = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente);
		 	
		 	VerticalFieldManager allContentInicio = new VerticalFieldManager();
		 	
		 	ColorRichText emailCrt = new ColorRichText(Strings.EMAIL,0x9cbe4f , RichTextField.FIELD_LEFT | RichTextField.TEXT_ALIGN_LEFT );
		 	emailCrt.setFont(fLite);
		 	emailCrt.setMargin(veinte, veinte, cinco, cincuenta);
		 	allContentInicio.add(emailCrt);
			
			txtCorreo = new EmailAddressEditField("", "", 200,BasicEditField.JUMP_FOCUS_AT_END){
				public void paint(Graphics g){      
	                g.setColor(0xFFF);
	                super.paint(g);
	            }};
			txtCorreo.setBorder(BorderFactory.createBitmapBorder(new XYEdges(5,13,5,13), bordes));
            txtCorreo.setMargin(cinco, cincuenta, cinco, cincuenta);
            txtCorreo.setPadding(cinco,cinco,cinco,cinco);
            allContentInicio.add(txtCorreo);
	        
	        ColorRichText pwCrt = new ColorRichText(Strings.PWD,0x9cbe4f , RichTextField.FIELD_LEFT | RichTextField.TEXT_ALIGN_LEFT );
	        pwCrt.setFont(fLite);
	        pwCrt.setMargin(veinte, veinte, cinco, cincuenta);
	        allContentInicio.add(pwCrt);
			
			txtPass = new PasswordEditField("", "", 200,BasicEditField.JUMP_FOCUS_AT_END){
				public void paint(Graphics g){      
	                g.setColor(0xFFF);
	                super.paint(g);
	            }};
	        txtPass.setBorder(BorderFactory.createBitmapBorder(new XYEdges(5,13,5,13), bordes));
			txtPass.setMargin(0, cincuenta, 0, cincuenta);
            txtPass.setPadding(cinco,cinco,cinco,cinco);
            allContentInicio.add(txtPass);
                        
            add(allContentInicio);
            
            HorizontalFieldManager botonesHfc = new HorizontalFieldManager(HorizontalFieldManager.FIELD_RIGHT);
            botonesHfc.setMargin(0, cincuenta, 0, 0);
            

            BitmapButtonField btnInicioSesionUser = new BitmapButtonField(btnInicioSesion,btnInicioSesion1,Field.FIELD_HCENTER);
            btnInicioSesionUser.setChangeListener( new FieldChangeListener( ) {
    			public void fieldChanged( Field field, int context ) {
    				UiApplication.getUiApplication().pushScreen(new MenuMain());
    			}
            });
            btnInicioSesionUser.setMargin(veinte, diez, 0, 0);
            

            BitmapButtonField btnRegistroUser = new BitmapButtonField(btnRegistro,btnRegistro1,Field.FIELD_HCENTER);
            btnRegistroUser.setChangeListener( new FieldChangeListener( ) {
    			public void fieldChanged( Field field, int context ) {
    				UiApplication.getUiApplication().pushScreen(new registroUser());
    			}
            });
            btnRegistroUser.setMargin(veinte, diez, 0, 0);
            
            botonesHfc.add(btnInicioSesionUser);
            botonesHfc.add(btnRegistroUser);
            add(botonesHfc);
            
            HorizontalFieldManager botonSaltarHfc = new HorizontalFieldManager(HorizontalFieldManager.FIELD_RIGHT);
            botonSaltarHfc.setMargin(0, cincuenta, 0, 0);
            

            BitmapButtonField btnSaltarUser = new BitmapButtonField(btnSaltar,btnSaltar1,Field.FIELD_HCENTER);
            btnSaltarUser.setChangeListener( new FieldChangeListener( ) {
    			public void fieldChanged( Field field, int context ) {
    				UiApplication.getUiApplication().pushScreen(new MenuMain());
    			}
            });
            btnSaltarUser.setMargin(diez, 0, 0, 0);
            botonSaltarHfc.add(btnSaltarUser);
            add(botonSaltarHfc);
            
            
		 	
        }catch (ClassNotFoundException e){
        	System.out.println(e.getMessage());
		}
    }
}
