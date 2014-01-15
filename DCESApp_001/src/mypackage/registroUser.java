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
import net.rim.device.api.ui.component.EmailAddressEditField;
import net.rim.device.api.ui.component.PasswordEditField;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import net.rim.device.api.ui.decor.BorderFactory;

import com.samples.toolkit.ui.component.BitmapButtonField;

import configurations.Strings;
import estilos.Estilos;

public class registroUser extends Estilos {

	int tFuente = 20;
	Font fLite;
	int tFuente2 = 30;
	Font fTitle;
	
//	Bitmap bordes = Bitmap.getBitmapResource("bordes_txt"+i+".png");
	Bitmap bordes = Bitmap.getBitmapResource("bordes_txt.png");
	BasicEditField txtName;
	EmailAddressEditField txtEmails;
	PasswordEditField txtPass;
	PasswordEditField txtRePass;
	
	Bitmap btnAceptarReg 	= Bitmap.getBitmapResource("btnAceptarReg.png");
	Bitmap btnAceptarReg1 	= Bitmap.getBitmapResource("btnAceptarReg1.png");
	
	//personalizacion
	int cinco	= 5;
	int diez	= 10;
	int veinte	= 20;
	int cincuenta	= 50;
	int heightScroll = 343;
	
	public registroUser() {
				
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

			txtName = new BasicEditField("", "", 200, BasicEditField.JUMP_FOCUS_AT_END) {
				public void paint(Graphics g) {
					g.setColor(0xFFF);
					super.paint(g);
				}
			};
			txtName.setBorder(BorderFactory.createBitmapBorder(new XYEdges(5,13, 5, 13), bordes));
			txtName.setMargin(0, cincuenta, 0, cincuenta);
			txtName.setPadding(cinco, cinco, cinco, cinco);
			contentForm.add(txtName);
			
			
			ColorRichText emailsCrt = new ColorRichText(Strings.EMAILS, 0x9cbe4f, RichTextField.FIELD_LEFT | RichTextField.TEXT_ALIGN_LEFT);
			emailsCrt.setFont(fLite);
			emailsCrt.setMargin(veinte, 20, cinco, cincuenta);
			contentForm.add(emailsCrt);

			txtEmails = new EmailAddressEditField("", "", 200, BasicEditField.JUMP_FOCUS_AT_END) {
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

			txtPass = new PasswordEditField("", "", 200, BasicEditField.JUMP_FOCUS_AT_END) {
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

			txtRePass = new PasswordEditField("", "", 200, BasicEditField.JUMP_FOCUS_AT_END) {
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
    				UiApplication.getUiApplication().pushScreen(new MyScreen());
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
