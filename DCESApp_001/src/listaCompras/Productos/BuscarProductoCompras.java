package listaCompras.Productos;

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
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.component.Status;
import net.rim.device.api.ui.component.TextField;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import net.rim.device.api.ui.decor.BorderFactory;
import pck_WS.FavoritoPx;
import pck_WS.ListaComprasPx;

import com.samples.toolkit.ui.component.BitmapButtonField;

import configurations.ConexionController;
import configurations.DbSql;
import configurations.Metodo;
import configurations.Strings;
import estilos.Estilos;

public class BuscarProductoCompras extends Estilos {
	
	String tipoConexion = ConexionController.getConnectionString()[0];
	String getTipo = ConexionController.getConnectionString()[1];
	Metodo request = new Metodo();
	
	DbSql path = new DbSql();
	DbSql statement = new DbSql();
	
	int tFuente = 20;
	Font fLite;
	int tFuente2 = 30;
	Font fTitle;
	
	
	Bitmap btnAceptarReg 	= Bitmap.getBitmapResource("btnAceptarReg.png");
	Bitmap btnAceptarReg1 	= Bitmap.getBitmapResource("btnAceptarReg1.png");
	Bitmap bordes = Bitmap.getBitmapResource("bordes_txt.png");
	BasicEditField txtProductoName;
	
	String IdLista;
	
	int veinticinco = 25;
	int veinte = 20;
	int trecientoscuarentaysiete = 347;
	
	//personalizacion
	int cinco	= 5;
	int diez	= 10;
	//int veinte	= 20;
	int cincuenta	= 50;
	
	ListaComprasPx crearlistacompras = new ListaComprasPx();
	
	public BuscarProductoCompras(final String idLista) {
		
		IdLista = idLista;
		
		if (Display.getWidth() == 320) {

            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_320.png")));
            tFuente = 15;
			tFuente2 = 20;
			veinticinco = 10;
			cinco 	= 0;
			diez 	= 5;
			veinte 	= 10;
			cincuenta = 20;
			trecientoscuarentaysiete = 179;
			btnAceptarReg 	= Bitmap.getBitmapResource("btnAceptarReg_320.png");
			btnAceptarReg1 	= Bitmap.getBitmapResource("btnAceptarReg1_320.png");
		}
		if (Display.getWidth() == 360) {

            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_360.png")));
            tFuente = 20;
			tFuente2 = 30;
			veinticinco = 10;
			cinco 	= 0;
			diez 	= 5;
			veinte 	= 20;
			cincuenta = 20;
			trecientoscuarentaysiete = 403;
			btnAceptarReg 	= Bitmap.getBitmapResource("btnAceptarReg_360.png");
			btnAceptarReg1 	= Bitmap.getBitmapResource("btnAceptarReg1_360.png");
		}
		if (Display.getWidth() == 480) {

            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_480.png")));
            tFuente = 16;
			tFuente2 = 26;
			veinticinco = 10;
			cinco 	= 0;
			diez 	= 5;
			veinte 	= 15;
			cincuenta = 20;
			trecientoscuarentaysiete = 291;
			btnAceptarReg 	= Bitmap.getBitmapResource("btnAceptarReg_360.png");
			btnAceptarReg1 	= Bitmap.getBitmapResource("btnAceptarReg1_360.png");
		}
		if (Display.getWidth() == 640) {

            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background.png")));
            
            tFuente = 30;
			tFuente2 = 40;
			btnAceptarReg 	= Bitmap.getBitmapResource("btnAceptarReg.png");
			btnAceptarReg1 	= Bitmap.getBitmapResource("btnAceptarReg1.png");
			
		}
		try {
			

			FontFamily ffFont1 = FontFamily.forName("Arial");
			fLite = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente);
			fTitle = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente2);
					
					
			VerticalFieldManager logoHfm = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER);
			logoHfm.setBackground(BackgroundFactory.createLinearGradientBackground(0xe68241, 0xe68241,0xd16f2f, 0xd16f2f));
			logoHfm.setMargin(0, 0, 0, 0);

			ColorRichText emailCrt = new ColorRichText("Búsqueda de productos",0xffffff, RichTextField.FIELD_HCENTER | RichTextField.TEXT_ALIGN_HCENTER);
			emailCrt.setFont(fTitle);
			emailCrt.setMargin(veinticinco, 0, veinticinco, 0);

			logoHfm.add(emailCrt);
			
			VerticalField footerLogoHfm = new VerticalField(Display.getWidth(),veinte,VerticalFieldManager.FIELD_HCENTER);
			footerLogoHfm.setBackground(BackgroundFactory.createLinearGradientBackground(0x9cbe4f, 0x7a9b3c, 0x7a9b3c, 0x9cbe4f));
			logoHfm.add(footerLogoHfm);
			
			add(logoHfm);
			
			
			//detalle
			VerticalField allContentDetalle = new VerticalField(Display.getWidth(),trecientoscuarentaysiete,HorizontalField.FIELD_HCENTER | VerticalField.VERTICAL_SCROLL | VerticalField.VERTICAL_SCROLLBAR);
			
			ColorRichText lastnameCrt = new ColorRichText("BUSCAR PRODUCTO:", 0x9cbe4f, RichTextField.FIELD_LEFT | RichTextField.TEXT_ALIGN_LEFT);
			lastnameCrt.setFont(fLite);
			lastnameCrt.setMargin(veinte, 20, cinco, cincuenta);
			allContentDetalle.add(lastnameCrt);

			txtProductoName = new BasicEditField("", "", 70, BasicEditField.JUMP_FOCUS_AT_END | TextField.NO_NEWLINE) {
				public void paint(Graphics g) {
					g.setColor(0xFFF);
					super.paint(g);
				}
			};
			txtProductoName.setBorder(BorderFactory.createBitmapBorder(new XYEdges(5,13, 5, 13), bordes));
			txtProductoName.setMargin(0, cincuenta, 0, cincuenta);
			txtProductoName.setPadding(cinco, cinco, cinco, cinco);
			allContentDetalle.add(txtProductoName);

			

			BitmapButtonField btnAceptarRegUser = new BitmapButtonField(btnAceptarReg, btnAceptarReg1, Field.FIELD_HCENTER);
			btnAceptarRegUser.setChangeListener(new FieldChangeListener() {
				public void fieldChanged(Field field, int context) {
					if (!txtProductoName.getText().toString().equals("")){
						UiApplication.getUiApplication().pushScreen(new ResultadoBusquedaProductoCompras(idLista, txtProductoName.getText().toString()));
					}else{
						Status.show("El campo esta vacío.",Bitmap.getPredefinedBitmap(Bitmap.INFORMATION),3000);
					}
					//UiApplication.getUiApplication().pushScreen(new VerMapa(latitud, longitud, establecimiento));
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
	
	public void close() {
		UiApplication.getUiApplication().pushScreen(new ProductoCompras(IdLista));
    }
	

}
