package configurations;

import mypackage.MenuMain;
import mypackage.MyScreen;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.component.Status;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import pck_WS.LoginPx;

import com.samples.toolkit.ui.component.BitmapButtonField;

import estilos.Estilos;

public class Ajustes extends Estilos {

	int tFuente;
	Font fLite;
	int tFuente2;
	Font fTitle;
	
	Bitmap logoList 		= Bitmap.getBitmapResource("vistaMapa.png");;
	Bitmap btnLogout		= Bitmap.getBitmapResource("btnLogout.png");
	Bitmap btnLogout1 		= Bitmap.getBitmapResource("btnLogout1.png");
	Bitmap btnPuntosMapa	= Bitmap.getBitmapResource("btnPuntosMapa.png");
	Bitmap btnPuntosMapa1 	= Bitmap.getBitmapResource("btnPuntosMapa1.png");
	Bitmap btnChangePw		= Bitmap.getBitmapResource("btnChangePw.png");
	Bitmap btnChangePw1 	= Bitmap.getBitmapResource("btnChangePw1.png");
	
	int veinticinco = 25;
	int veinte = 20;
	int sesenta = 60;
	int ocho = 8;
	int cuatrocuarenta = 440;
	int trecientoscuarentaysiete = 305;
	
	public Ajustes(){
		
		if (Display.getWidth() == 320) {
			
			getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_320.png")));
			tFuente = 17;
			tFuente2 = 20;
			veinticinco = 10;
			veinte = 10;
			sesenta = 30;
			ocho = 3;
			cuatrocuarenta = 200;
			trecientoscuarentaysiete = 155;
			logoList = Bitmap.getBitmapResource("vistaMapa_320.png");
			btnLogout	= Bitmap.getBitmapResource("btnLogout_320.png");
			btnLogout1 	= Bitmap.getBitmapResource("btnLogout1_320.png");
			btnPuntosMapa	= Bitmap.getBitmapResource("btnPuntosMapa_320.png");
			btnPuntosMapa1 	= Bitmap.getBitmapResource("btnPuntosMapa1_320.png");
			btnChangePw	= Bitmap.getBitmapResource("btnChangePw_320.png");
            btnChangePw1 	= Bitmap.getBitmapResource("btnChangePw1_320.png");
		}
		if (Display.getWidth() == 360) {
			
			getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_360.png")));
			tFuente = 17;
			tFuente2 = 20;
			veinticinco = 12;
			veinte = 10;
			sesenta = 45;
			ocho = 8;
			cuatrocuarenta = 210;
			trecientoscuarentaysiete = 385;
			logoList = Bitmap.getBitmapResource("vistaMapa.png");
			btnLogout	= Bitmap.getBitmapResource("btnLogout_320.png");
			btnLogout1 	= Bitmap.getBitmapResource("btnLogout1_320.png");
			btnPuntosMapa	= Bitmap.getBitmapResource("btnPuntosMapa_320.png");
			btnPuntosMapa1 	= Bitmap.getBitmapResource("btnPuntosMapa1_320.png");
			btnChangePw	= Bitmap.getBitmapResource("btnChangePw_320.png");
            btnChangePw1 	= Bitmap.getBitmapResource("btnChangePw1_320.png");
		}
		if (Display.getWidth() == 480) {
			
			getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_480.png")));
			tFuente = 17;
			tFuente2 = 20;
			veinticinco = 12;
			veinte = 10;
			sesenta = 45;
			ocho = 8;
			cuatrocuarenta = 350;
			trecientoscuarentaysiete = 249;
			logoList = Bitmap.getBitmapResource("vistaMapa.png");
			btnLogout	= Bitmap.getBitmapResource("btnLogout_320.png");
			btnLogout1 	= Bitmap.getBitmapResource("btnLogout1_320.png");
			btnPuntosMapa	= Bitmap.getBitmapResource("btnPuntosMapa_320.png");
			btnPuntosMapa1 	= Bitmap.getBitmapResource("btnPuntosMapa1_320.png");
			btnChangePw	= Bitmap.getBitmapResource("btnChangePw_320.png");
            btnChangePw1 	= Bitmap.getBitmapResource("btnChangePw1_320.png");
		}
		if (Display.getWidth() == 640) {
			
			getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background.png")));
			tFuente = 35;
			tFuente2 = 40;
			logoList = Bitmap.getBitmapResource("vistaMapa.png");
			btnLogout	= Bitmap.getBitmapResource("btnLogout.png");
			btnLogout1 	= Bitmap.getBitmapResource("btnLogout1.png");
			btnPuntosMapa	= Bitmap.getBitmapResource("btnPuntosMapa.png");
			btnPuntosMapa1 	= Bitmap.getBitmapResource("btnPuntosMapa1.png");
			btnChangePw	= Bitmap.getBitmapResource("btnChangePw.png");
            btnChangePw1 	= Bitmap.getBitmapResource("btnChangePw1.png");
		}
		
		try{
			
			FontFamily ffFont1 = FontFamily.forName("Arial");
			fLite = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente);
			fTitle = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente2);
			
			
			
			VerticalFieldManager logoHfm = new VerticalFieldManager(VerticalFieldManager.FIELD_RIGHT | HorizontalFieldManager.FIELD_RIGHT);
			logoHfm.setBackground(BackgroundFactory.createLinearGradientBackground(0xe68241, 0xe68241,0xd16f2f, 0xd16f2f));
			logoHfm.setMargin(0, 0, 0, 0);

			ColorRichText emailCrt = new ColorRichText("Ajustes",0xffffff, RichTextField.FIELD_HCENTER | RichTextField.TEXT_ALIGN_HCENTER);
			emailCrt.setFont(fTitle);
			emailCrt.setMargin(veinticinco, 0, veinticinco, 0);

			logoHfm.add(emailCrt);
			
			HorizontalField footerLogoHfm = new HorizontalField(Display.getWidth(),sesenta,HorizontalFieldManager.FIELD_RIGHT);
			footerLogoHfm.setBackground(BackgroundFactory.createLinearGradientBackground(0x9cbe4f, 0x7a9b3c, 0x7a9b3c, 0x9cbe4f));
			
			HorizontalFieldManager logoutHfm = new HorizontalFieldManager(HorizontalFieldManager.FIELD_RIGHT);			
			
            BitmapButtonField btnSearchUser = new BitmapButtonField(btnLogout,btnLogout1,Field.FIELD_RIGHT);
            btnSearchUser.setChangeListener( new FieldChangeListener( ) {
    			public void fieldChanged( Field field, int context ) {
    				int ans = Dialog.ask(Dialog.D_YES_NO,
    						"¿Realmente deseas cerrar sesión?");
    				if (ans == Dialog.NO) {
    					// Do Nothing
    				} else {
    					Status.show("Cerrando Sesión...");
    					new LoginPx();
        				UiApplication.getUiApplication().pushScreen(new MyScreen());
    				}
    				
    			}
            });     
            btnSearchUser.setMargin(ocho, 0, 0, cuatrocuarenta);
            logoutHfm.add(btnSearchUser);
            footerLogoHfm.add(logoutHfm);
            
            //logoHfm.add(logoutHfm);
			logoHfm.add(footerLogoHfm);
			
			add(logoHfm);
			
			
			//Lista Categoria
			VerticalFieldManager allContentAjustes = new VerticalFieldManager(HorizontalFieldManager.FIELD_HCENTER);
			//VerticalField allContentAjustes = new VerticalField(Display.getWidth(),trecientoscuarentaysiete,HorizontalFieldManager.FIELD_HCENTER | VerticalFieldManager.FIELD_HCENTER  | VerticalField.VERTICAL_SCROLL | VerticalField.VERTICAL_SCROLLBAR);
			
			/*BitmapField logoListaf = new BitmapField(logoList);   
	        allContentAjustes.add(logoListaf);*/
	        
	        
            BitmapButtonField btnPuntosMapaUser = new BitmapButtonField(btnPuntosMapa,btnPuntosMapa1,Field.FIELD_HCENTER);
            btnPuntosMapaUser.setChangeListener( new FieldChangeListener( ) {
    			public void fieldChanged( Field field, int context ) {
    				UiApplication.getUiApplication().pushScreen(new CambiarPuntosMap());
    			}
            });
            btnPuntosMapaUser.setMargin(30,0,0,0);
            allContentAjustes.add(btnPuntosMapaUser);
            
              
            BitmapButtonField btnChangePwUser = new BitmapButtonField(btnChangePw,btnChangePw1,Field.FIELD_HCENTER);
            btnChangePwUser.setChangeListener( new FieldChangeListener( ) {
    			public void fieldChanged( Field field, int context ) {
    				UiApplication.getUiApplication().pushScreen(new CambiarPw());
    			}
            });
            btnChangePwUser.setMargin(20,0,20,0);
            allContentAjustes.add(btnChangePwUser);
			
            add(allContentAjustes);
			
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			add(new RichTextField("Control de Error "+e.getMessage()));
		}
		
	}
	
}
