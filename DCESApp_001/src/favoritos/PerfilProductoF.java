package favoritos;

import mypackage.MenuMain;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.MenuItem;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.component.Status;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import net.rim.device.api.ui.image.Image;
import net.rim.device.api.ui.image.ImageFactory;
import net.rim.device.api.util.StringProvider;
import observatorioPrecio.VerMapa;
import pck_WS.FavoritoPx;

import com.samples.toolkit.ui.component.BitmapButtonField;

import configurations.Strings;
import estilos.Estilos;
import estilos.Estilos.GRichTextField;

public class PerfilProductoF extends Estilos {

	int tFuente, tFuente2, tFuente3;
	Font fTituloMain, fDetalles, fDetalles2, fTitle;

	Bitmap btnMapa;
	Bitmap btnMapa1;

	int veinticinco = 25;
	int veinte = 20;
	int trecientoscuarentaysiete = 347;

	String hashKey, idProducto;
	
	FavoritoPx favoritos = new FavoritoPx();

	public PerfilProductoF(final String hashkey, final String idproducto, String producto,
			String marca, String presentacion, final String establecimiento,
			String precioproducto, String preciopromocion,
			final String latitud, final String longitud, String fechasondeo) {
		
		hashKey = hashkey;
		idProducto = idproducto;

		if (Display.getWidth() == 320) {

			getMainManager().setBackground(
					BackgroundFactory.createBitmapBackground(Bitmap
							.getBitmapResource("background_320.png")));
			tFuente = 25;
			tFuente2 = 20;
			tFuente3 = 17;
			veinticinco = 10;
			veinte = 10;
			trecientoscuarentaysiete = 179;
			btnMapa = Bitmap.getBitmapResource("btnMapa_320.png");
			btnMapa1 = Bitmap.getBitmapResource("btnMapa1_320.png");
		}
		if (Display.getWidth() == 360) {

			getMainManager().setBackground(
					BackgroundFactory.createBitmapBackground(Bitmap
							.getBitmapResource("background_360.png")));
			tFuente = 25;
			tFuente2 = 20;
			tFuente3 = 17;
			veinticinco = 10;
			veinte = 10;
			trecientoscuarentaysiete = 403;
			btnMapa = Bitmap.getBitmapResource("btnMapa_360.png");
			btnMapa1 = Bitmap.getBitmapResource("btnMapa1_360.png");
		}
		if (Display.getWidth() == 480) {

			getMainManager().setBackground(
					BackgroundFactory.createBitmapBackground(Bitmap
							.getBitmapResource("background_480.png")));
			tFuente = 25;
			tFuente2 = 20;
			tFuente3 = 17;
			veinticinco = 10;
			veinte = 10;
			trecientoscuarentaysiete = 291;
			btnMapa = Bitmap.getBitmapResource("btnMapa_360.png");
			btnMapa1 = Bitmap.getBitmapResource("btnMapa1_360.png");
		}
		if (Display.getWidth() == 640) {

			getMainManager().setBackground(
					BackgroundFactory.createBitmapBackground(Bitmap
							.getBitmapResource("background.png")));

			tFuente = 60;
			tFuente2 = 40;
			tFuente3 = 35;
			btnMapa = Bitmap.getBitmapResource("btnMapa.png");
			btnMapa1 = Bitmap.getBitmapResource("btnMapa1.png");

		}
		try {

			FontFamily ffFont1 = FontFamily.forName("Arial");
			fTituloMain = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente);
			fDetalles = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente2);
			fDetalles2 = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente2);
			fTitle = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente3);

			// getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background.png")));

			VerticalFieldManager logoHfm = new VerticalFieldManager(
					VerticalFieldManager.FIELD_HCENTER);
			logoHfm.setBackground(BackgroundFactory
					.createLinearGradientBackground(0xe68241, 0xe68241,
							0xd16f2f, 0xd16f2f));
			logoHfm.setMargin(0, 0, 0, 0);

			ColorRichText emailCrt = new ColorRichText(Strings.PERFIL,
					0xffffff, RichTextField.FIELD_HCENTER
							| RichTextField.TEXT_ALIGN_HCENTER);
			emailCrt.setFont(fTitle);
			emailCrt.setMargin(veinticinco, 0, veinticinco, 0);

			logoHfm.add(emailCrt);

			VerticalField footerLogoHfm = new VerticalField(Display.getWidth(),
					veinte, VerticalFieldManager.FIELD_HCENTER);
			footerLogoHfm.setBackground(BackgroundFactory
					.createLinearGradientBackground(0x9cbe4f, 0x7a9b3c,
							0x7a9b3c, 0x9cbe4f));
			logoHfm.add(footerLogoHfm);

			add(logoHfm);

			// detalle
			VerticalField allContentDetalle = new VerticalField(
					Display.getWidth(), trecientoscuarentaysiete,
					HorizontalField.FIELD_HCENTER
							| VerticalField.VERTICAL_SCROLL
							| VerticalField.VERTICAL_SCROLLBAR);

			ORichTextField tituloCrt = new ORichTextField(producto,
					RichTextField.FIELD_LEFT | RichTextField.TEXT_ALIGN_LEFT);
			tituloCrt.setFont(fTituloMain);
			tituloCrt.setMargin(20, 0, 5, 20);

			ORichTextField detalleCrt = new ORichTextField("Presentación: "
					+ presentacion, RichTextField.FIELD_LEFT
					| RichTextField.TEXT_ALIGN_LEFT);
			detalleCrt.setFont(fDetalles);
			detalleCrt.setMargin(20, 0, 5, 20);

			ORichTextField detalleCrt1 = new ORichTextField("Marca: " + marca,
					RichTextField.FIELD_LEFT | RichTextField.TEXT_ALIGN_LEFT);
			detalleCrt1.setFont(fDetalles);
			detalleCrt1.setMargin(20, 0, 5, 20);

			ORichTextField detalleCrt2 = new ORichTextField("Establecimiento: "
					+ establecimiento, RichTextField.FIELD_LEFT
					| RichTextField.TEXT_ALIGN_LEFT);
			detalleCrt2.setFont(fDetalles);
			detalleCrt2.setMargin(20, 0, 5, 20);

			ORichTextField detalleCrt3 = new ORichTextField("Sondeo: "
					+ fechasondeo, RichTextField.FIELD_LEFT
					| RichTextField.TEXT_ALIGN_LEFT);
			detalleCrt3.setFont(fDetalles);
			detalleCrt3.setMargin(20, 0, 5, 20);
			
			GRichTextField detalleGreenCrt = new GRichTextField("Normal $"+precioproducto+"        "+"Promedio $"+preciopromocion, RichTextField.FIELD_LEFT | RichTextField.TEXT_ALIGN_LEFT);
			detalleGreenCrt.setFont(fDetalles);
			detalleGreenCrt.setMargin(20, 0, 5, 20);


			allContentDetalle.add(tituloCrt);
			allContentDetalle.add(detalleCrt);
			allContentDetalle.add(detalleCrt1);
			allContentDetalle.add(detalleCrt2);
			allContentDetalle.add(detalleCrt3);
			allContentDetalle.add(detalleGreenCrt);

			BitmapButtonField btnAceptarRegUser = new BitmapButtonField(
					btnMapa, btnMapa1, Field.FIELD_HCENTER);
			btnAceptarRegUser.setChangeListener(new FieldChangeListener() {
				public void fieldChanged(Field field, int context) {
					// UiApplication.getUiApplication().pushScreen(new
					// VerMapa());
					UiApplication.getUiApplication().pushScreen(
							new VerMapa(latitud, longitud, establecimiento));
				}
			});
			btnAceptarRegUser.setMargin(25, 10, 25, 0);

			allContentDetalle.add(btnAceptarRegUser);

			add(allContentDetalle);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			add(new RichTextField(e.getMessage()));
		}

		// Menu Item
		MenuItem myItem = new MenuItem(new StringProvider("Eliminar de Favoritos"), 110, 0){
		    public void run(){
		    	int ans = Dialog.ask(Dialog.D_YES_NO,
						"¿Realmente deseas eliminarlo de favoritos?");
				if (ans == Dialog.NO) {
					// Do Nothing
				} else {
					Status.show("Eliminando...");
					favoritos.eliminarFavoritos(hashKey,idProducto,"2");
					Status.show(favoritos.errorMessage);
					UiApplication.getUiApplication().pushScreen(new MenuMain(1));
				}
		        
		    }
		};
		Image iconoHabito = ImageFactory.createImage(Bitmap.getBitmapResource("imgMewe2.png"));
		myItem.setIcon(iconoHabito);
		
		addMenuItem(myItem);
		

	}
	
	
	
	
	/*private MenuItem itemFavorito = new MenuItem("Eliminar de Favoritos", 110, 10) {
		public void run() {
			int ans = Dialog.ask(Dialog.D_YES_NO,
					"¿Realmente deseas eliminarlo de favoritos?");
			if (ans == Dialog.NO) {
				// Do Nothing
			} else {
				Status.show("Eliminando...");
				favoritos.eliminarFavoritos(hashKey,idProducto,"2");
				Status.show(favoritos.errorMessage);
				UiApplication.getUiApplication().pushScreen(new MenuMain(1));
			}

		}
	};*/

}
