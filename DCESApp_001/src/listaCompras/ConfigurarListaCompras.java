package listaCompras;

import java.util.Vector;

import listaCompras.Alertas.AlertaListaCompras;
import listaCompras.Productos.ProductoCompras;
import listaCompras.RutaCompras.RutaCompras;
import mypackage.WebsiteDC;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.component.Status;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import pck_WS.ConfiguracionListaCx;
import pck_WS.ValidarRutaListaCompras;

import com.samples.toolkit.ui.component.BitmapButtonField;

import configurations.ConexionController;
import configurations.Strings;

import estilos.Estilos;

public class ConfigurarListaCompras extends Estilos {
	
	String tipoConexion = ConexionController.getConnectionString()[0];
	String getTipo = ConexionController.getConnectionString()[1];
	
	int tFuente;
	Font fLite;
	int tFuente2;
	Font fTitle;
	int veinticinco = 25;
	
	Vector vLista   = new Vector();
	//Vector vColores = new Vector();
	
	Bitmap arrow;
	Bitmap bordes;
	Bitmap logoList;
	BitmapField logoListaf;
	Bitmap btnRuta 	 	 = Bitmap.getBitmapResource("btnRuta.png");
	Bitmap btnRuta1 	 = Bitmap.getBitmapResource("btnRuta1.png");
	Bitmap btnProductos  = Bitmap.getBitmapResource("btnProductos.png");
	Bitmap btnProductos1 = Bitmap.getBitmapResource("btnProductos1.png");
	Bitmap btnAlertas 	 = Bitmap.getBitmapResource("btnAlertas.png");
	Bitmap btnAlertas1 	 = Bitmap.getBitmapResource("btnAlertas1.png");
	
	HorizontalField contentListCategoria;
	//personalizacion
	int veinte = 20;
	int trecientoscuarentaysiete = 347;
	int seisientos = 600;
	int cientodiez = 110;
	int quince = 15;
	int noventa = 90;
	int cientocincuenta = 40;
	String apend = "";
	
	int topImageLogo = 7;
	int rightImageLogo = 5;
	int bottomImageLogo = 3;
	int leftImageLogo = 5;
	
	ConfiguracionListaCx validarRuta;
	
	public ConfigurarListaCompras(final String IdLista) {
		
		validarRuta = new ConfiguracionListaCx(IdLista);
		
		if (Display.getWidth() == 320) {

            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_320.png")));
			tFuente = 17;
			tFuente2 = 20;
			veinticinco = 12;
			veinte = 10;
			trecientoscuarentaysiete = 171;
			seisientos = 290;
			cientodiez = 55;
			quince = 7;
			btnRuta  	  = Bitmap.getBitmapResource("btnRuta_320.png");
			btnRuta1 	  = Bitmap.getBitmapResource("btnRuta1_320.png");
			btnProductos  = Bitmap.getBitmapResource("btnProductos_320.png");
			btnProductos1 = Bitmap.getBitmapResource("btnProductos1_320.png");
			btnAlertas 	  = Bitmap.getBitmapResource("btnAlertas_320.png");
			btnAlertas1   = Bitmap.getBitmapResource("btnAlertas1_320.png");
			arrow  		  = Bitmap.getBitmapResource( "arrow_320.png" );
			apend = "_320";
			noventa = 35;
			cientocincuenta = 30;
		}
		if (Display.getWidth() == 360) {

            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_360.png")));
			tFuente = 17;
			tFuente2 = 20;
			veinticinco = 12;
			veinte = 10;
			trecientoscuarentaysiete = 403;
			seisientos = 330;
			cientodiez = 55;
			quince = 7;
			btnRuta  	  = Bitmap.getBitmapResource("btnRuta_360.png");
			btnRuta1 	  = Bitmap.getBitmapResource("btnRuta1_360.png");
			btnProductos  = Bitmap.getBitmapResource("btnProductos_360.png");
			btnProductos1 = Bitmap.getBitmapResource("btnProductos1_360.png");
			btnAlertas 	  = Bitmap.getBitmapResource("btnAlertas_360.png");
			btnAlertas1   = Bitmap.getBitmapResource("btnAlertas1_360.png");
			arrow  		  = Bitmap.getBitmapResource( "arrow_320.png" );
			apend = "_320";
			noventa = 35;
			cientocincuenta = 30;
			topImageLogo = 5;
			rightImageLogo = 5;
			bottomImageLogo = 3;
			leftImageLogo = 1;
		}
		if (Display.getWidth() == 480) {

            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_480.png")));
			tFuente = 17;
			tFuente2 = 20;
			veinticinco = 12;
			veinte = 10;
			trecientoscuarentaysiete = 284;
			seisientos = 450;
			cientodiez = 55;
			quince = 7;
			btnRuta  	  = Bitmap.getBitmapResource("btnRuta_480.png");
			btnRuta1 	  = Bitmap.getBitmapResource("btnRuta1_480.png");
			btnProductos  = Bitmap.getBitmapResource("btnProductos_480.png");
			btnProductos1 = Bitmap.getBitmapResource("btnProductos1_480.png");
			btnAlertas 	  = Bitmap.getBitmapResource("btnAlertas_480.png");
			btnAlertas1   = Bitmap.getBitmapResource("btnAlertas1_480.png");
			arrow  		  = Bitmap.getBitmapResource( "arrow_320.png" );
			apend = "_320";
			noventa = 35;
			cientocincuenta = 30;
			topImageLogo = 5;
			rightImageLogo = 5;
			bottomImageLogo = 3;
			leftImageLogo = 1;
		}
		if (Display.getWidth() == 640) {

            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background.png")));
            
			tFuente = 35;
			tFuente2 = 40;
			arrow  = Bitmap.getBitmapResource( "arrow.png" );
		}
		try {
			

			FontFamily ffFont1 = FontFamily.forName("Arial");
			fLite = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente);
			fTitle = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente2);
			
						
			VerticalFieldManager logoHfm = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER);
			logoHfm.setBackground(BackgroundFactory.createLinearGradientBackground(0xe68241, 0xe68241,0xd16f2f, 0xd16f2f));
			logoHfm.setMargin(0, 0, 0, 0);

			ColorRichText emailCrt = new ColorRichText("Configure su lista ",0xffffff, RichTextField.FIELD_HCENTER | RichTextField.TEXT_ALIGN_HCENTER);
			emailCrt.setFont(fTitle);
			emailCrt.setMargin(veinticinco, 0, veinticinco, 0);

			logoHfm.add(emailCrt);
			
			VerticalField footerLogoHfm = new VerticalField(Display.getWidth(),veinte,VerticalFieldManager.FIELD_HCENTER);
			footerLogoHfm.setBackground(BackgroundFactory.createLinearGradientBackground(0x9cbe4f, 0x7a9b3c, 0x7a9b3c, 0x9cbe4f));
			logoHfm.add(footerLogoHfm);
			
			add(logoHfm);
			
			//Lista Categoria
			VerticalField allContentListaCategoria = new VerticalField(Display.getWidth(),trecientoscuarentaysiete,HorizontalField.FIELD_HCENTER | VerticalField.VERTICAL_SCROLL | VerticalField.VERTICAL_SCROLLBAR);
			
			
			BitmapButtonField btnRutaCompra = new BitmapButtonField(btnRuta, btnRuta1, Field.FIELD_HCENTER);
			btnRutaCompra.setChangeListener(new FieldChangeListener() {
				public void fieldChanged(Field field, int context) {					
					if(getTipo.equals("wifi") || getTipo.equals("BIBS")){
						UiApplication.getUiApplication().pushScreen(new RutaCompras(IdLista));
					}else {
						Status.show(Strings.CONEXION_DESCONECTED);
					}
				}
			});
			btnRutaCompra.setMargin(7, 10, 7, 10);

			allContentListaCategoria.add(btnRutaCompra);
			
			
			BitmapButtonField btnProducto = new BitmapButtonField(btnProductos, btnProductos1, Field.FIELD_HCENTER);
			btnProducto.setChangeListener(new FieldChangeListener() {
				public void fieldChanged(Field field, int context) {
					if(getTipo.equals("wifi") || getTipo.equals("BIBS")){					
						if (validarRuta.errorCode.equals("0")) {
							if (validarRuta.rutas.equals("1")) {
								UiApplication.getUiApplication().pushScreen(new ProductoCompras(IdLista));
							} else if (validarRuta.rutas.equals("0")) {
								Dialog.alert("Debes agregar establecimientos a ruta de compras.");						
							}
						} else if (validarRuta.errorCode.equals("1")) {
								Dialog.alert("Debes agregar establecimientos a ruta de compras.");						
						}
					}else {
						Status.show(Strings.CONEXION_DESCONECTED);
					}
				}
			});
			btnProducto.setMargin(7, 10, 7, 10);

			allContentListaCategoria.add(btnProducto);
			
			
			BitmapButtonField btnAlerta = new BitmapButtonField(btnAlertas, btnAlertas1, Field.FIELD_HCENTER);
			btnAlerta.setChangeListener(new FieldChangeListener() {
				public void fieldChanged(Field field, int context) {
					if(getTipo.equals("wifi") || getTipo.equals("BIBS")){
						if (validarRuta.errorCode.equals("0")) {
							if (validarRuta.productos.equals("1")) {
								UiApplication.getUiApplication().pushScreen(new AlertaListaCompras(IdLista));
							} else if (validarRuta.productos.equals("0")) {
								Dialog.alert("Debes agregar productos antes de configurar alertas.");
							}
						} else if (validarRuta.errorCode.equals("1")) {
								Dialog.alert("Debes agregar productos antes de configurar alertas.");
						}
					}else {
						Status.show(Strings.CONEXION_DESCONECTED);
					}
				}
			});
			btnAlerta.setMargin(7, 10, 7, 10);

			allContentListaCategoria.add(btnAlerta);

			add(allContentListaCategoria);
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			add(new RichTextField(e.getMessage()));
			
		}
		
		
	}

	public void close() {
		UiApplication.getUiApplication().pushScreen(new ListaCompras());
    }
	

}
