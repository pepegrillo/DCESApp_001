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
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.EmailAddressEditField;
import net.rim.device.api.ui.component.PasswordEditField;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.component.Status;
import net.rim.device.api.ui.component.TextField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import net.rim.device.api.ui.decor.BorderFactory;
import pck_WS.LoginCx;

import com.samples.toolkit.ui.component.BitmapButtonField;

import configurations.ConexionController;
import configurations.Encode;
import configurations.Strings;
import estilos.Estilos;
import estilos.Estilos.HorizontalField;
import estilos.Estilos.VerticalField;

/**
 * A class extending the MainScreen class, which provides default standard
 * behavior for BlackBerry GUI applications.
 */
public final class MyScreen extends Estilos
{
	
	String tipoConexion = ConexionController.getConnectionString()[0];
	String getTipo = ConexionController.getConnectionString()[1];
	
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
	Bitmap logoDCBm;
	Bitmap logoDC1Bm;
	//personalizacion
	int cinco	= 5;
	int diez	= 10;
	int veinte	= 20;
	int trecientoscuarentaysiete = 457; //347
	int cincuenta	= 50;
    /**
     * Creates a new MyScreen object
     */
	
	LoginCx iniciosesion;
	
    public MyScreen()
    {        
        // Set the displayed title of the screen       
        //setTitle("MyTitle");
		if (Display.getWidth() == 320) {

			cinco 	= 0;
			diez 	= 5;
			veinte 	= 7;
			trecientoscuarentaysiete = 225;
			cincuenta = 20;
            btnInicioSesion 	= Bitmap.getBitmapResource("btnInicioSesion_320.png");
            btnInicioSesion1 	= Bitmap.getBitmapResource("btnInicioSesion1_320.png");	
            btnRegistro	    	= Bitmap.getBitmapResource("btnRegistro_320.png");
            btnRegistro1 		= Bitmap.getBitmapResource("btnRegistro1_320.png");
            btnSaltar			= Bitmap.getBitmapResource("btnSaltar_320.png");
            btnSaltar1 			= Bitmap.getBitmapResource("btnSaltar1_320.png");
            logoDCBm			= Bitmap.getBitmapResource("logoDC_320.png");
            logoDC1Bm			= Bitmap.getBitmapResource("logoDC1_320.png");
			getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_320.png")));
			logoBm = Bitmap.getBitmapResource("logo_320.png");
			tFuente = 15;
		}
		if (Display.getWidth() == 360) {

			cinco 	= 0;
			diez 	= 5;
			veinte 	= 20;
			trecientoscuarentaysiete = 480;
			cincuenta = 20;
            btnInicioSesion 	= Bitmap.getBitmapResource("btnInicioSesion_360.png");
            btnInicioSesion1 	= Bitmap.getBitmapResource("btnInicioSesion1_360.png");
            btnRegistro	    	= Bitmap.getBitmapResource("btnRegistro_360.png");
            btnRegistro1 		= Bitmap.getBitmapResource("btnRegistro1_360.png");
            btnSaltar			= Bitmap.getBitmapResource("btnSaltar_360.png");
            btnSaltar1 			= Bitmap.getBitmapResource("btnSaltar1_360.png");
            logoDCBm			= Bitmap.getBitmapResource("logoDC_360.png");
            logoDC1Bm			= Bitmap.getBitmapResource("logoDC1_360.png");
			getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_360.png")));
			logoBm = Bitmap.getBitmapResource("logo_360.png");
			tFuente = 20;
		}
		if (Display.getWidth() == 480) {
			cinco 	= 0;
			diez 	= 5;
			veinte 	= 10;
			trecientoscuarentaysiete = 338; //285
			cincuenta = 20;
            btnInicioSesion 	= Bitmap.getBitmapResource("btnInicioSesion_480.png");
            btnInicioSesion1 	= Bitmap.getBitmapResource("btnInicioSesion1_480.png");
            btnRegistro	    	= Bitmap.getBitmapResource("btnRegistro_480.png");
            btnRegistro1 		= Bitmap.getBitmapResource("btnRegistro1_480.png");
            btnSaltar			= Bitmap.getBitmapResource("btnSaltar_480.png");
            btnSaltar1 			= Bitmap.getBitmapResource("btnSaltar1_480.png");
            logoDCBm			= Bitmap.getBitmapResource("logoDC_480.png");
            logoDC1Bm			= Bitmap.getBitmapResource("logoDC1_480.png");
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
            logoDCBm			= Bitmap.getBitmapResource("logoDC.png");
            logoDC1Bm			= Bitmap.getBitmapResource("logoDC1.png");
            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background.png")));
            logoBm = Bitmap.getBitmapResource("logo.png");
            tFuente = 30;
		}
    	
		VerticalField allContentMap = new VerticalField(Display.getWidth(),trecientoscuarentaysiete,HorizontalField.FIELD_HCENTER | VerticalField.VERTICAL_SCROLL | VerticalField.VERTICAL_SCROLLBAR);
    	
		VerticalFieldManager logoHfm = new VerticalFieldManager(HorizontalFieldManager.FIELD_HCENTER);	    	
        
    	BitmapField logoBmf = new BitmapField(logoBm);
        logoHfm.add(logoBmf);
        
        BitmapButtonField btnLogoDC = new BitmapButtonField(logoDCBm,logoDC1Bm,Field.FIELD_HCENTER);
        btnLogoDC.setMargin(10,0,0,0);
        btnLogoDC.setChangeListener( new FieldChangeListener( ) {
			public void fieldChanged( Field field, int context ) {
				if(getTipo.equals("wifi") || getTipo.equals("BIBS")){
					UiApplication.getUiApplication().pushScreen(new WebsiteDC());
				}else {
					Status.show(Strings.CONEXION_DESCONECTED);
				}
			}
        });
        logoHfm.add(btnLogoDC);
        
        allContentMap.add(logoHfm);
        
        
        try{
	        FontFamily ffFont1 = FontFamily.forName("Arial");
		 	fLite = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente);
		 	
		 	VerticalFieldManager allContentInicio = new VerticalFieldManager();
		 	
		 	ColorRichText emailCrt = new ColorRichText(Strings.EMAIL,0x9cbe4f , RichTextField.FIELD_LEFT | RichTextField.TEXT_ALIGN_LEFT );
		 	emailCrt.setFont(fLite);
		 	emailCrt.setMargin(veinte, veinte, cinco, cincuenta);
		 	allContentInicio.add(emailCrt);
		 	
			
			txtCorreo = new EmailAddressEditField("", "", 50,BasicEditField.JUMP_FOCUS_AT_END | TextField.NO_NEWLINE){
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
			
			txtPass = new PasswordEditField("", "", 50,BasicEditField.JUMP_FOCUS_AT_END | TextField.NO_NEWLINE){
				public void paint(Graphics g){      
	                g.setColor(0xFFF);
	                super.paint(g);
	            }};
	        txtPass.setBorder(BorderFactory.createBitmapBorder(new XYEdges(5,13,5,13), bordes));
			txtPass.setMargin(0, cincuenta, 0, cincuenta);
            txtPass.setPadding(cinco,cinco,cinco,cinco);
            allContentInicio.add(txtPass);
                      
            allContentMap.add(allContentInicio);
            //add(allContentMap);
            
            HorizontalFieldManager botonesHfc = new HorizontalFieldManager(HorizontalFieldManager.FIELD_RIGHT);
            botonesHfc.setMargin(0, cincuenta, 0, 0);
            

            BitmapButtonField btnInicioSesionUser = new BitmapButtonField(btnInicioSesion,btnInicioSesion1,Field.FIELD_HCENTER);
            btnInicioSesionUser.setChangeListener( new FieldChangeListener( ) {
    			public void fieldChanged( Field field, int context ) {
    				if(getTipo.equals("wifi") || getTipo.equals("BIBS")){
	    				//if(iniciosesion.errorCode.equals("0")){
    					if (txtCorreo.getText().length()>5 && txtPass.getText().length()>3) {
		    				Encode sha = new Encode();
		    	            String pw = sha.SHA1(txtPass.getText().toString());
		    				//Dialog.alert(pw+txtPass.getText());
		    				iniciosesion = new LoginCx(txtCorreo.getText().toString(), pw);
		    				if(iniciosesion.errorCode.equals("0")){
		    					UiApplication.getUiApplication().pushScreen(new MenuMain(1));
		    					Status.show("¡Bienvenido!");
		    				}else{
		    					Dialog.alert(iniciosesion.errorMessage);
		    				}
    					} else {
    						Status.show("Por favor digita tu correo y contraseña válidos.");
    					}
	    				/*}else{
	    					Dialog.alert(iniciosesion.errorMessage);
	    				}*/
    				}else{
    					Status.show(Strings.CONEXION_DESCONECTED);
    				}
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
            
            allContentMap.add(botonesHfc);
            
            
            HorizontalFieldManager botonSaltarHfc = new HorizontalFieldManager(HorizontalFieldManager.FIELD_RIGHT);
            botonSaltarHfc.setMargin(0, cincuenta, 0, 0);
            

            BitmapButtonField btnSaltarUser = new BitmapButtonField(btnSaltar,btnSaltar1,Field.FIELD_HCENTER);
            btnSaltarUser.setChangeListener( new FieldChangeListener( ) {
    			public void fieldChanged( Field field, int context ) {
    				UiApplication.getUiApplication().pushScreen(new MenuMain(3));
    			}
            });
            btnSaltarUser.setMargin(diez, 0, 0, 0);
            botonSaltarHfc.add(btnSaltarUser);
            
            allContentMap.add(botonSaltarHfc);
            add(allContentMap);
            
            
		 	
        }catch (ClassNotFoundException e){
        	System.out.println(e.getMessage());
		}
    }
    
    public void close() {
		System.exit(0);
        super.close();
    }
    
}
