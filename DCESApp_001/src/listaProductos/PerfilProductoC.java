package listaProductos;

import observatorioPrecio.VerMapa;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;

import com.samples.toolkit.ui.component.BitmapButtonField;

import configurations.Strings;
import estilos.Estilos;

public class PerfilProductoC extends Estilos {
	
	
	int tFuente, tFuente2, tFuente3;
	Font fTituloMain, fDetalles, fDetalles2, fTitle;
	
	Bitmap btnMapa;
	Bitmap btnMapa1;
	
	int veinticinco = 25;
	int veinte = 20;
	int trecientoscuarentaysiete = 347;
	
	public PerfilProductoC() {

		
		if (Display.getWidth() == 320) {

            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_320.png")));
			tFuente = 25;
			tFuente2 = 20;
			tFuente3 = 17;
			veinticinco = 10;
			veinte = 10;
			trecientoscuarentaysiete = 178;
			btnMapa	= Bitmap.getBitmapResource("btnMapa_320.png");
			btnMapa1 	= Bitmap.getBitmapResource("btnMapa1_320.png");	
		}
		if (Display.getWidth() == 360) {

            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_360.png")));
			tFuente = 25;
			tFuente2 = 20;
			tFuente3 = 17;
			veinticinco = 10;
			veinte = 10;
			trecientoscuarentaysiete = 403;
			btnMapa	= Bitmap.getBitmapResource("btnMapa_360.png");
			btnMapa1 	= Bitmap.getBitmapResource("btnMapa1_360.png");	
		}
		if (Display.getWidth() == 480) {

            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_480.png")));
			tFuente = 25;
			tFuente2 = 20;
			tFuente3 = 17;
			veinticinco = 10;
			veinte = 10;
			trecientoscuarentaysiete = 284;
			btnMapa	= Bitmap.getBitmapResource("btnMapa_360.png");
			btnMapa1 	= Bitmap.getBitmapResource("btnMapa1_360.png");	
		}
		if (Display.getWidth() == 640) {

            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background.png")));
            
			tFuente = 60;
			tFuente2 = 40;
			tFuente3 = 35;
			btnMapa	= Bitmap.getBitmapResource("btnMapa.png");
			btnMapa1 	= Bitmap.getBitmapResource("btnMapa1.png");	
			
		}
		
		try {
			
			FontFamily ffFont1 = FontFamily.forName("Arial");
			fTituloMain = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente);
			fDetalles   = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente2);
			fDetalles2  = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente2);
			fTitle      = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente3);
					
			//getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background.png")));
			
						
			VerticalFieldManager logoHfm = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER);
			logoHfm.setBackground(BackgroundFactory.createLinearGradientBackground(0xe68241, 0xe68241,0xd16f2f, 0xd16f2f));
			logoHfm.setMargin(0, 0, 0, 0);

			ColorRichText emailCrt = new ColorRichText(Strings.PERFIL,0xffffff, RichTextField.FIELD_HCENTER | RichTextField.TEXT_ALIGN_HCENTER);
			emailCrt.setFont(fTitle);
			emailCrt.setMargin(veinticinco, 0, veinticinco, 0);

			logoHfm.add(emailCrt);
			
			VerticalField footerLogoHfm = new VerticalField(Display.getWidth(),veinte,VerticalFieldManager.FIELD_HCENTER);
			footerLogoHfm.setBackground(BackgroundFactory.createLinearGradientBackground(0x9cbe4f, 0x7a9b3c, 0x7a9b3c, 0x9cbe4f));
			logoHfm.add(footerLogoHfm);
			
			add(logoHfm);
			
			
			//detalle
			VerticalField allContentDetalle = new VerticalField(Display.getWidth(),trecientoscuarentaysiete,HorizontalField.FIELD_HCENTER | VerticalField.VERTICAL_SCROLL | VerticalField.VERTICAL_SCROLLBAR);
			
			ORichTextField tituloCrt = new ORichTextField("Frijol Rojo", RichTextField.FIELD_LEFT | RichTextField.TEXT_ALIGN_LEFT);
			tituloCrt.setFont(fTituloMain);
			tituloCrt.setMargin(20, 0, 5, 20);
			
			ORichTextField detalleCrt = new ORichTextField("Presentación: 1 Libra", RichTextField.FIELD_LEFT | RichTextField.TEXT_ALIGN_LEFT);
			detalleCrt.setFont(fDetalles);
			detalleCrt.setMargin(20, 0, 5, 20);
			
			ORichTextField detalleCrt1 = new ORichTextField("Marca: Don Frijol", RichTextField.FIELD_LEFT | RichTextField.TEXT_ALIGN_LEFT);
			detalleCrt1.setFont(fDetalles);
			detalleCrt1.setMargin(20, 0, 5, 20);
			
			ORichTextField detalleCrt2 = new ORichTextField("Establecimiento: Super Selectos, Zacamil", RichTextField.FIELD_LEFT | RichTextField.TEXT_ALIGN_LEFT);
			detalleCrt2.setFont(fDetalles);
			detalleCrt2.setMargin(20, 0, 5, 20);
			
			ORichTextField detalleCrt3 = new ORichTextField("Sondeo: 11/12/13", RichTextField.FIELD_LEFT | RichTextField.TEXT_ALIGN_LEFT);
			detalleCrt3.setFont(fDetalles);
			detalleCrt3.setMargin(20, 0, 5, 20);
			
			GRichTextField detalleGreenCrt = new GRichTextField("Normal $1.35", RichTextField.FIELD_LEFT | RichTextField.TEXT_ALIGN_LEFT);
			detalleGreenCrt.setFont(fDetalles);
			detalleGreenCrt.setMargin(20, 0, 5, 20);
			
			GRichTextField detalleGreenCrt2 = new GRichTextField("Promedio $1.35",  RichTextField.FIELD_LEFT | RichTextField.TEXT_ALIGN_LEFT);
			detalleGreenCrt2.setFont(fDetalles);
			detalleGreenCrt2.setMargin(20, 0, 5, 20);
			
			allContentDetalle.add(tituloCrt);
			allContentDetalle.add(detalleCrt);
			allContentDetalle.add(detalleCrt1);
			allContentDetalle.add(detalleCrt2);
			allContentDetalle.add(detalleCrt3);
			allContentDetalle.add(detalleGreenCrt);
			allContentDetalle.add(detalleGreenCrt2);
	        
            BitmapButtonField btnAceptarRegUser = new BitmapButtonField(btnMapa,btnMapa1,Field.FIELD_HCENTER);
            btnAceptarRegUser.setChangeListener( new FieldChangeListener( ) {
    			public void fieldChanged( Field field, int context ) {
    				//UiApplication.getUiApplication().pushScreen(new VerMapa());
    				//UiApplication.getUiApplication().pushScreen(new VerMapaC());
    			}
            });
            btnAceptarRegUser.setMargin(25, 10, 25, 0);
			
            allContentDetalle.add(btnAceptarRegUser);
			
	        add(allContentDetalle);
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			add(new RichTextField(e.getMessage()));
		}
		
	}

	

}
