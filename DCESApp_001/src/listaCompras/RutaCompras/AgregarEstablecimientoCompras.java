package listaCompras.RutaCompras;

import java.util.Vector;

import mypackage.MenuMain;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.DrawStyle;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.MenuItem;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import net.rim.device.api.ui.decor.BorderFactory;
import net.rim.device.api.ui.image.Image;
import net.rim.device.api.ui.image.ImageFactory;
import net.rim.device.api.util.StringProvider;
import pck_WS.AgregarEstablecimientoComprasCx;
import pck_WS.AgregarEstablecimientoComprasPx;

import com.samples.toolkit.ui.component.ListStyleButtonField;

import configurations.DbSql;
import configurations.Strings;
import estilos.Estilos;
import estilos.Estilos.VerticalField;

public class AgregarEstablecimientoCompras extends Estilos implements FieldChangeListener {
	
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
	Bitmap bgProducto = Bitmap.getBitmapResource("bgProduct.png");
	
	VerticalField contentListCategoria;
	//personalizacion
	int veinte = 20;
	int trecientoscuarentaysiete = 347;
	int seisientos = 600;
	int cientodiez = 110;
	int quince = 15;
	int noventa = 90;
	int cientocincuenta = 40;
	String apend = "";
	
	String IdLista;
	
	int topImageLogo = 7;
	int rightImageLogo = 5;
	int bottomImageLogo = 3;
	int leftImageLogo = 5;
	
	DbSql path = new DbSql();
	DbSql statement = new DbSql();
	
	AgregarEstablecimientoComprasCx agregarestablecimientocompras;
	
	AgregarEstablecimientoComprasPx agregarestablecimiento = new AgregarEstablecimientoComprasPx();
	
	public AgregarEstablecimientoCompras(String idLista, String idMunicipioEst) {
		
		IdLista = idLista;
		
		agregarestablecimientocompras = new AgregarEstablecimientoComprasCx(idMunicipioEst);
		
		if (Display.getWidth() == 320) {

            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_320.png")));
			tFuente = 15;
			tFuente2 = 20;
			veinticinco = 12;
			veinte = 10;
			trecientoscuarentaysiete = 171;
			seisientos = 290;
			cientodiez = 55;
			quince = 7;
			bgProducto = Bitmap.getBitmapResource("bgProduct_320.png");
			arrow  = Bitmap.getBitmapResource( "mas_320.png" );
			apend = "_320";
			noventa = 30;
			cientocincuenta = 30;
		}
		if (Display.getWidth() == 360) {

            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_360.png")));
			tFuente = 15;
			tFuente2 = 20;
			veinticinco = 12;
			veinte = 10;
			trecientoscuarentaysiete = 403;
			seisientos = 330;
			cientodiez = 55;
			quince = 7;
			bgProducto = Bitmap.getBitmapResource("bgProduct_320.png");
			arrow  = Bitmap.getBitmapResource( "mas_320.png" );
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
			tFuente = 15;
			tFuente2 = 20;
			veinticinco = 12;
			veinte = 10;
			trecientoscuarentaysiete = 284;
			seisientos = 450;
			cientodiez = 55;
			quince = 7;
			bgProducto = Bitmap.getBitmapResource("bgProduct_320.png");
			arrow  = Bitmap.getBitmapResource( "mas_320.png" );
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
            
			tFuente = 33;
			tFuente2 = 40;
			arrow  = Bitmap.getBitmapResource( "mas.png" );
			noventa = 70;
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
			
			if (agregarestablecimientocompras.errorCode.equals("0")){
			//Lista Categoria
			VerticalField allContentListaCategoria = new VerticalField(Display.getWidth(),trecientoscuarentaysiete,HorizontalField.FIELD_HCENTER | VerticalField.VERTICAL_SCROLL | VerticalField.VERTICAL_SCROLLBAR);
			
				for (int i = 0; i < agregarestablecimientocompras.IdEstablecimiento.size(); i++){
	
					
					contentListCategoria = new VerticalField(seisientos, cientodiez, HorizontalField.FIELD_HCENTER);
					//contentListCategoria.setBackground((Background) vColores.elementAt(i));
					
					contentListCategoria.setBorder(BorderFactory.createBitmapBorder(new XYEdges(0,8,0,8), bgProducto));
					contentListCategoria.setMargin(quince,0,quince,quince);
					contentListCategoria.setPadding(0,0,0,0);
					//contentListCategoria.setBorder(BorderFactory.createRoundedBorder(new XYEdges(5,5,5,5)));
					
					
					vLista.addElement(new ListStyleButtonField(arrow,""+agregarestablecimientocompras.NombreEstablecimiento.elementAt(i) , null,DrawStyle.ELLIPSIS){
			            public int getPreferredWidth(){return Display.getWidth()-cientocincuenta;}
			            public int getPreferredHeight(){return noventa;}
			            public void layout( int maxWidth, int maxHeight )
			            {
			                super.layout(getPreferredWidth(),getPreferredHeight());
			                setExtent(getPreferredWidth(), getPreferredHeight());
			            }
			            public void paint(Graphics g)
						{      
							g.setColor(0xffffff);
							super.paint(g);
						}
		            });
		            
					//vLista.addElement(new LabelField(" - "+agregarestablecimientocompras.DireccionEstablecimiento.elementAt(i).toString(),DrawStyle.ELLIPSIS | LabelField.FIELD_LEFT));
					
		    	    ((Field) vLista.elementAt(i)).setChangeListener(this);
		    	    ((Field) vLista.elementAt(i)).setMargin(5,0,0,0);
		    	    
		    	    contentListCategoria.add(((Field) vLista.elementAt(i)));
		    	    
		    	    LabelField datoextra = new LabelField(" - "+agregarestablecimientocompras.DireccionEstablecimiento.elementAt(i).toString(),DrawStyle.ELLIPSIS | LabelField.FIELD_LEFT){
		    	    	public void paint(Graphics g)
						{      
							g.setColor(0x1c6dae);
							super.paint(g);
						}
		    	    }; 
		    	    datoextra.setFont(fLite);
		    	    
		    	    contentListCategoria.add(datoextra);
		    	    
		    	    allContentListaCategoria.add(contentListCategoria);
		    	    //allContentListaCategoria.add(datoextra);
				}
				add(allContentListaCategoria);
			}else{
				VerticalField errorHfm = new VerticalField(Display.getWidth(),trecientoscuarentaysiete,HorizontalFieldManager.FIELD_HCENTER | DrawStyle.HCENTER | VerticalFieldManager.FIELD_HCENTER);
				errorHfm.setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource(agregarestablecimientocompras.errorMessage)));
				
				add(errorHfm);
			}
			//Descargar datos despues de consumidos
			//descargarDatos();
	        
	        
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			add(new RichTextField(e.getMessage()));
			
		}
		
		
		
	}

	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		
		for(int j=0;j<=vLista.size()-1;j++){
			if( vLista.elementAt(j)== field ){
				options(IdLista,agregarestablecimientocompras.IdEstablecimiento.elementAt(j).toString());
				
			}
		}
	}
	
	public void options(final String idLista, final String idEstablecimiento){
    	UiApplication.getUiApplication().invokeLater(new Runnable(){
			
    		public void run(){
				Object[] choices = new Object[] {"Agregar"};
				int result = Dialog.ask("Agregar Establecimiento ", choices, 0);
				switch (result) {
				case 0:
					agregarestablecimiento.postEstablecimientosCompras(idLista,idEstablecimiento);
					//UiApplication.getUiApplication().pushScreen(new ListaComprasChoice(idLista,nombreLista));
					break;
				case 1:
					
					break;
				}
    		}
    	});
	}
    	
}
