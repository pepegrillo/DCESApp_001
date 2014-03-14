package listaCompras;

import java.util.Vector;

import listaCompras.cotizar.ProductosCotizarCompras;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.component.Status;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;

import com.samples.toolkit.ui.component.BitmapButtonField;

import configurations.ConexionController;
import configurations.Strings;
import estilos.Estilos;

public class ListaComprasChoice extends Estilos {
	
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
	Bitmap btnConsultaListaCompras  = Bitmap.getBitmapResource("btnConsultaListaCompras.png");
	Bitmap btnConsultaListaCompras1 = Bitmap.getBitmapResource("btnConsultaListaCompras1.png");
	Bitmap btnAjusteListaCompras  	= Bitmap.getBitmapResource("btnAjusteListaCompras.png");
	Bitmap btnAjusteListaCompras1 	= Bitmap.getBitmapResource("btnAjusteListaCompras1.png");
	
	HorizontalField contentListCategoria;
	//personalizacion
	int veinte = 20;
	int trecientoscuarentaysiete = 347;
	int seisientos = 600;
	int cientodiez = 110;
	int quince = 15;
	int noventa = 90;
	int cientocincuenta = 70;
	String apend = "";
	
	int topImageLogo = 7;
	int rightImageLogo = 5;
	int bottomImageLogo = 3;
	int leftImageLogo = 5;
	
	
	
	public ListaComprasChoice(final String idlistan, String nombrelista) {
		if (Display.getWidth() == 320) {
			//Dialog.alert(""+Display.getWidth());
            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_320.png")));
			tFuente = 17;
			tFuente2 = 20;
			veinticinco = 12;
			veinte = 10;
			trecientoscuarentaysiete = 171;
			seisientos = 290;
			cientodiez = 55;
			quince = 7;
			btnConsultaListaCompras  = Bitmap.getBitmapResource("btnConsultaListaCompras_320.png");
			btnConsultaListaCompras1 = Bitmap.getBitmapResource("btnConsultaListaCompras1_320.png");
			btnAjusteListaCompras  	= Bitmap.getBitmapResource("btnAjusteListaCompras_320.png");
			btnAjusteListaCompras1 	= Bitmap.getBitmapResource("btnAjusteListaCompras1_320.png");
			arrow  = Bitmap.getBitmapResource( "arrow_320.png" );
			apend = "_320";
			noventa = 35;
			cientocincuenta = 60;
		}
		if (Display.getWidth() == 360) {
			//Dialog.alert(""+Display.getWidth());
            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_360.png")));
			tFuente = 19;
			tFuente2 = 22;
			veinticinco = 12;
			veinte = 10;
			trecientoscuarentaysiete = 403;
			seisientos = 330;
			cientodiez = 55;
			quince = 7;
			btnConsultaListaCompras  = Bitmap.getBitmapResource("btnConsultaListaCompras_320.png");
			btnConsultaListaCompras1 = Bitmap.getBitmapResource("btnConsultaListaCompras1_320.png");
			btnAjusteListaCompras  	= Bitmap.getBitmapResource("btnAjusteListaCompras_320.png");
			btnAjusteListaCompras1 	= Bitmap.getBitmapResource("btnAjusteListaCompras1_320.png");
			arrow  = Bitmap.getBitmapResource( "arrow_320.png" );
			apend = "_320";
			noventa = 35;
			cientocincuenta = 60;
			topImageLogo = 5;
			rightImageLogo = 5;
			bottomImageLogo = 3;
			leftImageLogo = 1;
		}
		if (Display.getWidth() == 480) {
			//Dialog.alert(""+Display.getWidth());
            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_480.png")));
			tFuente = 22;
			tFuente2 = 25;
			veinticinco = 12;
			veinte = 10;
			trecientoscuarentaysiete = 284;
			seisientos = 450;
			cientodiez = 55;
			quince = 7;
			btnConsultaListaCompras  = Bitmap.getBitmapResource("btnConsultaListaCompras_360.png");
			btnConsultaListaCompras1 = Bitmap.getBitmapResource("btnConsultaListaCompras1_360.png");
			btnAjusteListaCompras  	= Bitmap.getBitmapResource("btnAjusteListaCompras_360.png");
			btnAjusteListaCompras1 	= Bitmap.getBitmapResource("btnAjusteListaCompras1_360.png");
			arrow  = Bitmap.getBitmapResource( "arrow_320.png" );
			apend = "_320";
			noventa = 35;
			cientocincuenta = 60;
			topImageLogo = 5;
			rightImageLogo = 5;
			bottomImageLogo = 3;
			leftImageLogo = 1;
		}
		if (Display.getWidth() == 640) {
			//Dialog.alert(""+Display.getWidth());
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

			ColorRichText emailCrt = new ColorRichText(Strings.LCOMPRAS,0xffffff, RichTextField.FIELD_HCENTER | RichTextField.TEXT_ALIGN_HCENTER);
			emailCrt.setFont(fTitle);
			emailCrt.setMargin(veinticinco, 0, veinticinco, 0);

			logoHfm.add(emailCrt);
			
			VerticalField footerLogoHfm = new VerticalField(Display.getWidth(),veinte,VerticalFieldManager.FIELD_HCENTER);
			footerLogoHfm.setBackground(BackgroundFactory.createLinearGradientBackground(0x9cbe4f, 0x7a9b3c, 0x7a9b3c, 0x9cbe4f));
			logoHfm.add(footerLogoHfm);
			
			add(logoHfm);
			
			//Lista Categoria
			VerticalField allContentListaCategoria = new VerticalField(Display.getWidth(),trecientoscuarentaysiete,HorizontalField.FIELD_HCENTER | VerticalField.VERTICAL_SCROLL | VerticalField.VERTICAL_SCROLLBAR);
			
			RichTextField tituloCrt = new RichTextField("Lista seleccionada:", RichTextField.FIELD_HCENTER | RichTextField.TEXT_ALIGN_HCENTER){
				
	            public void paint(Graphics g)
				{      
					g.setColor(0xd16f2f);
					super.paint(g);
				}
			};
			tituloCrt.setFont(fTitle);
			tituloCrt.setMargin(10, 0, 0, 0);
			allContentListaCategoria.add(tituloCrt);
			
			RichTextField tituloListaCrt = new RichTextField(nombrelista, RichTextField.FIELD_HCENTER | RichTextField.TEXT_ALIGN_HCENTER){
				
	            public void paint(Graphics g)
				{      
					g.setColor(0xd16f2f);
					super.paint(g);
				}
			};
			tituloListaCrt.setFont(fLite);
			tituloListaCrt.setMargin(10, 0, 0, 0);
			allContentListaCategoria.add(tituloListaCrt);
			
			BitmapButtonField btnConsultar = new BitmapButtonField(btnConsultaListaCompras,btnConsultaListaCompras1,Field.FIELD_HCENTER);
			btnConsultar.setChangeListener( new FieldChangeListener( ) {
    			public void fieldChanged( Field field, int context ) {
    				if(getTipo.equals("wifi") || getTipo.equals("BIBS")){
    					UiApplication.getUiApplication().pushScreen(new ProductosCotizarCompras(idlistan));
    				} else {
    					Status.show(Strings.CONEXION_DESCONECTED);
    				}
    			}
            });
			btnConsultar.setMargin(15, 0, 0, 0);
			
            allContentListaCategoria.add(btnConsultar);
            
            BitmapButtonField btnAjustes = new BitmapButtonField(btnAjusteListaCompras,btnAjusteListaCompras1,Field.FIELD_HCENTER);
            btnAjustes.setChangeListener( new FieldChangeListener( ) {
    			public void fieldChanged( Field field, int context ) {
    				if(getTipo.equals("wifi") || getTipo.equals("BIBS")){
    					UiApplication.getUiApplication().pushScreen(new ConfigurarListaCompras(idlistan));
    				} else {
    					Status.show(Strings.CONEXION_DESCONECTED);
    				}
    			}
            });
            btnAjustes.setMargin(10, 0, 0, 0);
			
            allContentListaCategoria.add(btnAjustes);
	        
	        add(allContentListaCategoria);
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			add(new RichTextField(e.getMessage()));
			
		}
		
				
	}

	
}
