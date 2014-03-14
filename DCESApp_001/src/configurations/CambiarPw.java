package configurations;

import mypackage.MyScreen;
import net.rim.device.api.database.Cursor;
import net.rim.device.api.database.Database;
import net.rim.device.api.database.DatabaseFactory;
import net.rim.device.api.database.Row;
import net.rim.device.api.database.Statement;
import net.rim.device.api.io.URI;
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

import org.json.me.JSONObject;

import pck_WS.LoginPx;

import com.samples.toolkit.ui.component.BitmapButtonField;

import estilos.Estilos;
import estilos.LabeledSwitch;

public class CambiarPw extends Estilos {
	
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
	PasswordEditField txtPass;
	PasswordEditField txtRePass;
	PasswordEditField txtPassOld;
	
	Bitmap btnAceptarReg 	= Bitmap.getBitmapResource("btnAceptarReg.png");
	Bitmap btnAceptarReg1 	= Bitmap.getBitmapResource("btnAceptarReg1.png");
	
	//private String genero;
	//private LabeledSwitch generoSwitch;
	
	public String hashKey    = new String();
	
	DbSql path = new DbSql();
	DbSql statement = new DbSql();
	
	
	
	//personalizacion
	int cinco	= 5;
	int diez	= 10;
	int veinte	= 20;
	int cincuenta	= 50;
	int heightScroll = 343;
	
	public CambiarPw() {
				
		if (Display.getWidth() == 320) {

			cinco 	= 0;
			diez 	= 5;
			veinte 	= 10;
			cincuenta = 20;
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

			ColorRichText emailCrt = new ColorRichText(Strings.CHANGEPW,0xffffff, RichTextField.FIELD_HCENTER | RichTextField.TEXT_ALIGN_HCENTER);
			emailCrt.setFont(fTitle);
			emailCrt.setMargin(veinte, 0, veinte, 0);

			logoHfm.add(emailCrt);
			add(logoHfm);
			
			VerticalField allContentInicio = new VerticalField(Display.getWidth(),heightScroll,VerticalField.VERTICAL_SCROLL | VerticalField.VERTICAL_SCROLLBAR);
						

			// Formulario
			VerticalFieldManager contentForm = new VerticalFieldManager();
			
			/*ColorRichText pwCrtOld = new ColorRichText(Strings.PWACTUAL, 0x9cbe4f, RichTextField.FIELD_LEFT | RichTextField.TEXT_ALIGN_LEFT);
			pwCrtOld.setFont(fLite);
			pwCrtOld.setMargin(veinte, 20, cinco, cincuenta);
			contentForm.add(pwCrtOld);

			txtPassOld = new PasswordEditField("", "", 200, BasicEditField.JUMP_FOCUS_AT_END) {
				public void paint(Graphics g) {
					g.setColor(0xFFF);
					super.paint(g);
				}
			};
			txtPassOld.setBorder(BorderFactory.createBitmapBorder(new XYEdges(5,13, 5, 13), bordes));
			txtPassOld.setMargin(0, cincuenta, 0, cincuenta);
			txtPassOld.setPadding(cinco, cinco, cinco, cinco);
			contentForm.add(txtPassOld);*/
			
			
			ColorRichText pwCrt = new ColorRichText(Strings.PWNEW, 0x9cbe4f, RichTextField.FIELD_LEFT | RichTextField.TEXT_ALIGN_LEFT);
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
			
			
			ColorRichText rePwCrt = new ColorRichText(Strings.REPWNEW, 0x9cbe4f, RichTextField.FIELD_LEFT | RichTextField.TEXT_ALIGN_LEFT);
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
    					
	    				if(/*(txtPassOld.getTextLength()>0) &&*/ (txtPass.getTextLength()>=6) && ((txtPass.getText().equals(txtRePass.getText())))){
	    					//UiApplication.getUiApplication().pushScreen(new MyScreen());
	    					Status.show("CAMPOS COMPLETADOS CORRECTAMENTE");
	    					try{
	    						
	    						URI uri = URI.create(path.Path());
	    						Database sqliteDB = DatabaseFactory.open(uri);
	    							    						
	    						Statement sf = sqliteDB.createStatement(statement.SelectHashKey());
	    						sf.prepare();
	    						Cursor cf = sf.getCursor();
	    						Row rf;
	    						while(cf.next()){
	    							rf = cf.getRow();
	    							hashKey = rf.getString(0);
	    							//incremento ++;
	    						}
	    						cf.close();
	    						sf.close();	    						
	    						sqliteDB.close();
	    						
		    					Encode sha = new Encode();
		    					String Pw2 = sha.SHA1(txtPass.getText().toString());
		    					//String Pw2 = txtPass.getText().toString();
		    					
		    					String url = "http://observatoriodeprecios.defensoria.gob.sv/ApiREST.php//v1/putCambiarClave/"+tipoConexion;
		    					String json = "'hashKey'		: '"+hashKey+"'," +
											"'clave'		: '"+Pw2+"'";
		    					//Dialog.alert(json);
		    					String response = request.PUT(url,json);
		    					
		    					JSONObject objeto1 =  new  JSONObject ( response );
		    		            String resultado1 = objeto1.getString("response");		            
		    		            JSONObject objeto2 =  new  JSONObject ( resultado1 );    		           
		    		            response  = objeto2.getString("errorCode");
		    		            
		    		            if(response.equals("0")){
		    		            	//Dialog.alert(objeto2.getString("errorMessage"));
		    		            	new LoginPx();
		    		            	UiApplication.getUiApplication().pushScreen(new MyScreen());
		    		            }else{
		    		            	Dialog.alert("Ha ocurrido algo inesperado, inténtelo de nuevo.");
		    		            }
		    					
		    				}catch (Exception e) {
								// TODO: handle exception
		    					Dialog.alert("Ha ocurrido algo inesperado, inténtelo de nuevo 404.");
							}
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
