package mypackage;

import org.json.me.JSONObject;

import pck_WS.LoginCx;

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
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.EmailAddressEditField;
import net.rim.device.api.ui.component.PasswordEditField;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.component.Status;
import net.rim.device.api.ui.component.TextField;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import net.rim.device.api.ui.decor.BorderFactory;

import com.samples.toolkit.ui.component.BitmapButtonField;

import configurations.ConexionController;
import configurations.Encode;
import configurations.Metodo;
import configurations.Strings;
import configurations.ValidatorEmail;
import estilos.Estilos;
import estilos.JustifiedHorizontalFieldManager;
import estilos.LabeledSwitch;

public class registroUser extends Estilos {
	
	String tipoConexion = ConexionController.getConnectionString()[0];
	String getTipo = ConexionController.getConnectionString()[1];
	Metodo request = new Metodo(); 

	int tFuente = 20;
	Font fLite;
	int tFuente2 = 30;
	Font fTitle;
	
//	Bitmap bordes = Bitmap.getBitmapResource("bordes_txt"+i+".png");
	Bitmap bordes = Bitmap.getBitmapResource("bordes_txt.png");
	BasicEditField txtName;
	BasicEditField txtLastName;
	EmailAddressEditField txtEmails;
	String emailActivate;
	PasswordEditField txtPass;
	PasswordEditField txtRePass;
	
	Bitmap switchOn = Bitmap.getBitmapResource( "switch_left.png" );
	Bitmap switchOff = Bitmap.getBitmapResource( "switch_right.png" );
	Bitmap switchOnFocus = Bitmap.getBitmapResource( "switch_left_focus.png" );
	Bitmap switchOffFocus = Bitmap.getBitmapResource( "switch_right_focus.png" );
	
	Bitmap btnAceptarReg 	= Bitmap.getBitmapResource("btnAceptarReg.png");
	Bitmap btnAceptarReg1 	= Bitmap.getBitmapResource("btnAceptarReg1.png");
	
	private String genero;
	private LabeledSwitch generoSwitch;
	
	//personalizacion
	int cinco	= 5;
	int diez	= 10;
	int veinte	= 20;
	int cincuenta	= 50;
	int heightScroll = 343;
	
	ValidatorEmail validatoremail = new ValidatorEmail();
	
	public registroUser() {
				
		if (Display.getWidth() == 320) {

			cinco 	= 0;
			diez 	= 5;
			veinte 	= 10;
			cincuenta = 20;
			switchOn = Bitmap.getBitmapResource( "switch_left_320.png" );
			switchOff = Bitmap.getBitmapResource( "switch_right_320.png" );
			switchOnFocus = Bitmap.getBitmapResource( "switch_left_focus_320.png" );
			switchOffFocus = Bitmap.getBitmapResource( "switch_right_focus_320.png" );
			btnAceptarReg 	= Bitmap.getBitmapResource("btnAceptarReg_320.png");
			btnAceptarReg1 	= Bitmap.getBitmapResource("btnAceptarReg1_320.png");
			getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_320.png")));
			tFuente = 15;
			tFuente2 = 20;
			heightScroll = 175;
		}
		if (Display.getWidth() == 360) {

			cinco 	= 0;
			diez 	= 5;
			veinte 	= 20;
			cincuenta = 20;
			switchOn = Bitmap.getBitmapResource( "switch_left_320.png" );
			switchOff = Bitmap.getBitmapResource( "switch_right_320.png" );
			switchOnFocus = Bitmap.getBitmapResource( "switch_left_focus_320.png" );
			switchOffFocus = Bitmap.getBitmapResource( "switch_right_focus_320.png" );
			btnAceptarReg 	= Bitmap.getBitmapResource("btnAceptarReg_360.png");
			btnAceptarReg1 	= Bitmap.getBitmapResource("btnAceptarReg1_360.png");
			getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_360.png")));
			tFuente = 20;
			tFuente2 = 30;
			heightScroll = 366;
		}
		if (Display.getWidth() == 480) {

			cinco 	= 0;
			diez 	= 5;
			veinte 	= 15;
			cincuenta = 20;
			btnAceptarReg 	= Bitmap.getBitmapResource("btnAceptarReg_360.png");
			btnAceptarReg1 	= Bitmap.getBitmapResource("btnAceptarReg1_360.png");
			getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_480.png")));
			tFuente = 16;
			tFuente2 = 26;
			heightScroll = 267;
		}
		if (Display.getWidth() == 640) {

			getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background.png")));
			tFuente = 30;
			tFuente2 = 40;
			heightScroll = 355;
			btnAceptarReg 	= Bitmap.getBitmapResource("btnAceptarReg.png");
			btnAceptarReg1 	= Bitmap.getBitmapResource("btnAceptarReg1.png");
		}
		
		try {

			//tFuente = 30;
			//tFuente2 = 40;
			FontFamily ffFont1 = FontFamily.forName("Arial");
			fLite = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente);
			fTitle = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente2);
			
			//getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background.png")));
			
			VerticalFieldManager logoHfm = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER);
			logoHfm.setBackground(BackgroundFactory.createLinearGradientBackground(0xe2ab32, 0xe2ab32,0xdc9730, 0xdc9730));
			logoHfm.setMargin(veinte, 0, 0, 0);

			ColorRichText emailCrt = new ColorRichText(Strings.REGISTRO,0xffffff, RichTextField.FIELD_HCENTER | RichTextField.TEXT_ALIGN_HCENTER);
			emailCrt.setFont(fTitle);
			emailCrt.setMargin(veinte, 0, veinte, 0);

			logoHfm.add(emailCrt);
			add(logoHfm);
			
			VerticalField allContentInicio = new VerticalField(Display.getWidth(),heightScroll,VerticalField.VERTICAL_SCROLL | VerticalField.VERTICAL_SCROLLBAR);
						

			// Formulario
			VerticalFieldManager contentForm = new VerticalFieldManager();

			ColorRichText nameCrt = new ColorRichText(Strings.NAME, 0x9cbe4f, RichTextField.FIELD_LEFT | RichTextField.TEXT_ALIGN_LEFT);
			nameCrt.setFont(fLite);
			nameCrt.setMargin(veinte, 20, cinco, cincuenta);
			contentForm.add(nameCrt);
			

			txtName = new BasicEditField("", "", 25, BasicEditField.JUMP_FOCUS_AT_END | TextField.NO_NEWLINE) {
				public void paint(Graphics g) {
					g.setColor(0xFFF);
					super.paint(g);
				}
			};
			txtName.setBorder(BorderFactory.createBitmapBorder(new XYEdges(5,13, 5, 13), bordes));
			txtName.setMargin(0, cincuenta, 0, cincuenta);
			txtName.setPadding(cinco, cinco, cinco, cinco);
			contentForm.add(txtName);
			
			
			
			ColorRichText lastnameCrt = new ColorRichText(Strings.LASTNAME, 0x9cbe4f, RichTextField.FIELD_LEFT | RichTextField.TEXT_ALIGN_LEFT);
			lastnameCrt.setFont(fLite);
			lastnameCrt.setMargin(veinte, 20, cinco, cincuenta);
			contentForm.add(lastnameCrt);

			txtLastName = new BasicEditField("", "", 30, BasicEditField.JUMP_FOCUS_AT_END | TextField.NO_NEWLINE) {
				public void paint(Graphics g) {
					g.setColor(0xFFF);
					super.paint(g);
				}
			};
			txtLastName.setBorder(BorderFactory.createBitmapBorder(new XYEdges(5,13, 5, 13), bordes));
			txtLastName.setMargin(0, cincuenta, 0, cincuenta);
			txtLastName.setPadding(cinco, cinco, cinco, cinco);
			contentForm.add(txtLastName);
			
			
			
			ColorRichText generoCrt = new ColorRichText(Strings.GENERO, 0x9cbe4f, RichTextField.FIELD_LEFT | RichTextField.TEXT_ALIGN_LEFT);
			generoCrt.setFont(fLite);
			generoCrt.setMargin(veinte, 20, cinco, cincuenta);
			generoSwitch = new LabeledSwitch( switchOff, switchOn, switchOffFocus, switchOnFocus, "Femenino", "Masculino", true );
			generoSwitch.setFont(fLite);
			generoSwitch.setMargin(veinte, cincuenta, cinco, cincuenta);
			
			JustifiedHorizontalFieldManager campoGeneroJhm = new JustifiedHorizontalFieldManager(generoCrt, generoSwitch, false, USE_ALL_WIDTH );
			contentForm.add(campoGeneroJhm);
			
			
			ColorRichText emailsCrt = new ColorRichText(Strings.EMAILS, 0x9cbe4f, RichTextField.FIELD_LEFT | RichTextField.TEXT_ALIGN_LEFT);
			emailsCrt.setFont(fLite);
			emailsCrt.setMargin(veinte, 20, cinco, cincuenta);
			contentForm.add(emailsCrt);

			txtEmails = new EmailAddressEditField("", "", 70, BasicEditField.JUMP_FOCUS_AT_END | TextField.NO_NEWLINE) {
				public void paint(Graphics g) {
					g.setColor(0xFFF);
					super.paint(g);
				}
			};
			txtEmails.setBorder(BorderFactory.createBitmapBorder(new XYEdges(5,13, 5, 13), bordes));
			txtEmails.setMargin(0, cincuenta, 0, cincuenta);
			txtEmails.setPadding(cinco, cinco, cinco, cinco);
			contentForm.add(txtEmails);
			
			
			ColorRichText pwCrt = new ColorRichText(Strings.PWDS, 0x9cbe4f, RichTextField.FIELD_LEFT | RichTextField.TEXT_ALIGN_LEFT);
			pwCrt.setFont(fLite);
			pwCrt.setMargin(veinte, 20, cinco, cincuenta);
			contentForm.add(pwCrt);

			txtPass = new PasswordEditField("", "", 50, BasicEditField.JUMP_FOCUS_AT_END | TextField.NO_NEWLINE) {
				public void paint(Graphics g) {
					g.setColor(0xFFF);
					super.paint(g);
				}
			};
			txtPass.setBorder(BorderFactory.createBitmapBorder(new XYEdges(5,13, 5, 13), bordes));
			txtPass.setMargin(0, cincuenta, 0, cincuenta);
			txtPass.setPadding(cinco, cinco, cinco, cinco);
			contentForm.add(txtPass);
			
			
			ColorRichText rePwCrt = new ColorRichText(Strings.RPWDS, 0x9cbe4f, RichTextField.FIELD_LEFT | RichTextField.TEXT_ALIGN_LEFT);
			rePwCrt.setFont(fLite);
			rePwCrt.setMargin(veinte, 20, cinco, cincuenta);
			contentForm.add(rePwCrt);

			txtRePass = new PasswordEditField("", "", 50, BasicEditField.JUMP_FOCUS_AT_END | TextField.NO_NEWLINE) {
				public void paint(Graphics g) {
					g.setColor(0xFFF);
					super.paint(g);
				}
			};
			txtRePass.setBorder(BorderFactory.createBitmapBorder(new XYEdges(5,13, 5, 13), bordes));
			txtRePass.setMargin(0, cincuenta, 0, cincuenta);
			txtRePass.setPadding(cinco, cinco, cinco, cinco);
			contentForm.add(txtRePass);
			
            BitmapButtonField btnAceptarRegUser = new BitmapButtonField(btnAceptarReg,btnAceptarReg1,Field.FIELD_HCENTER);
            btnAceptarRegUser.setChangeListener( new FieldChangeListener( ) {
    			public void fieldChanged( Field field, int context ) {
    				if(getTipo.equals("wifi") || getTipo.equals("BIBS")){
    					if (generoSwitch.getOnState() == true){
	    					//Femenino
	            			genero = "F";
	            			//Status.show("femenino "+genero,1500);
	            		}else{
	            			//Masculino
	            			genero = "M";
	            		}
    					
						//Dialog.alert(""+validatoremail.validateEmailID(txtEmails.getText().toString()));
						if (validatoremail.validateEmailID(txtEmails.getText().toString()) == true) {
							emailActivate = txtEmails.getText().toString();
							//Dialog.alert(emailActivate+" / "+validatoremail.validateEmailID(txtEmails.getText().toString()));
						}/* else {
							Status.show(Strings.VT_CAMPODIEZ);
						}*/
    					
	    				if((txtName.getTextLength()>=3) && (txtLastName.getTextLength()>=3) && (validatoremail.validateEmailID(txtEmails.getText().toString()) == true) && (txtPass.getTextLength()>=6) && ((txtPass.getText().equals(txtRePass.getText())))){
	    					//UiApplication.getUiApplication().pushScreen(new MyScreen());
	    					//emailActivate = txtEmails.getText().toString();
	    					Status.show("CAMPOS COMPLETADOS CORRECTAMENTE");
	    					try{
		    					Encode sha = new Encode();
		    					String Pw = sha.SHA1(txtPass.getText().toString());
		    					//String Pw = txtPass.getText().toString();
		    					String url = Strings.HTTP_SW+"postMiembro"+tipoConexion;
		    					String json = "'nombre'		: '"+txtName.getText().toString()+"'," +
		    								"'apellido'		: '"+txtLastName.getText().toString()+"'," +
											"'sexo'			: '"+genero.toString()+"'," +
											"'correo'		: '"+emailActivate+"'," +
											"'clave'		: '"+Pw+"'";
		    					Dialog.alert(json);
		    					String response = request.POST(url,json);
		    					
		    					JSONObject objeto1 =  new  JSONObject ( response );
		    		            String resultado1 = objeto1.getString("response");		            
		    		            JSONObject objeto2 =  new  JSONObject ( resultado1 );    		           
		    		            response  = objeto2.getString("errorCode");
		    		            
		    		            String datosUser = objeto2.getString("msg");
		    		            JSONObject objeto3 = new JSONObject( datosUser );
		    		            String email = objeto3.getString("correo");
		    		            
		    		            if(response.equals("0")){
		    		            	Dialog.alert(objeto2.getString("errorMessage"));
		    		            	new LoginCx(email, Pw);
		    		            	UiApplication.getUiApplication().pushScreen(new MenuMain(2));
		    		            }else{
		    		            	Dialog.alert("Ha ocurrido algo inesperado, inténtelo de nuevo.");
		    		            }
		    					
		    				}catch (Exception e) {
								// TODO: handle exception
		    					Dialog.alert("Ha ocurrido algo inesperado, inténtelo de nuevo.");
							}
	    				}else if (((txtName.getTextLength()<3) && (txtLastName.getTextLength()<3)) || ((txtName.getTextLength()<3) || (txtLastName.getTextLength()<3))){
	    					Status.show(Strings.VT_CAMPOTRES);
	    				}else if ((validatoremail.validateEmailID(txtEmails.getText().toString()) == false)){
	    					Status.show(Strings.VT_CAMPODIEZ);
	    				}else if ((txtPass.getTextLength()<6) && (txtRePass.getTextLength()<6)){
	    					Status.show(Strings.VT_CAMPOPW);
	    				}else if ((txtPass.getText() != txtRePass.getText())){
	    					Status.show(Strings.VT_CAMPORPW,1500);
	    				}else{
	    					Status.show(Strings.VT_GENERAL);
	    				}
	    				
	    				
	    				
    				}else{
                		Status.show(Strings.CONEXION_DESCONECTED);
                	}
    			}
            });
            btnAceptarRegUser.setMargin(cincuenta, 10, 25, 0);
            contentForm.add(btnAceptarRegUser);
			
			
			allContentInicio.add(contentForm);
			add(allContentInicio);
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
