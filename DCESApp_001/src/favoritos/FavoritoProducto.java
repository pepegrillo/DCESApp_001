package favoritos;

import java.util.Vector;

import pck_WS.FavoritoCx;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.DrawStyle;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import net.rim.device.api.ui.decor.BorderFactory;

import com.samples.toolkit.ui.component.BitmapButtonField;
import com.samples.toolkit.ui.component.ListStyleButtonField;

import configurations.Strings;
import estilos.Estilos;
import estilos.Estilos.ORichTextField;
import estilos.Estilos.VerticalField;

public class FavoritoProducto extends Estilos implements FieldChangeListener {
	
	int tFuente;
	Font fLite;
	int tFuente2;
	Font fTitle;
	
	Bitmap arrow = Bitmap.getBitmapResource( "arrow.png" );
	Bitmap bordes = Bitmap.getBitmapResource("bordes_txtsearch.png");
	Bitmap bgProducto = Bitmap.getBitmapResource("bgProduct.png");
	BasicEditField txtSearch;
	
	Bitmap btnSearch;
	Bitmap btnSearch1;
	
	Vector vLista   = new Vector();
	
	String hashkey;
	String idproducto;
	String producto;
	String marca;
	String presentacion;
	String establecimiento;
	String precioproducto;
	String preciopromocion;
	String latitud;
	String longitud;
	String fechasondeo;
	
	//personalizacion
	int veinticinco = 25;
	int sesenta = 20;
	int ocho = 8;
	int cinco = 5;
	int noventa = 90;
	int trecientos = 347;
	int seisientos = 600;
	int cientodiez = 110;
	int quince = 15;
	int diez = 10;
	int cuarenta = 40;
	int alturatxt = 25;
	int txtSearchWidth = 100;
	
	FavoritoCx favoritos = new FavoritoCx();
	
	public FavoritoProducto(){
		
		
		if (Display.getWidth() == 320) {

            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_320.png")));
			tFuente = 17;
			tFuente2 = 20;
			veinticinco = 10;
			sesenta = 10;
			arrow  = Bitmap.getBitmapResource( "arrow_320.png" );
			ocho = 3;
			bgProducto = Bitmap.getBitmapResource("bgProduct_320.png");
			cinco = 0;
			noventa = 45;
			trecientos = 171;
			seisientos = 290;
			cientodiez = 55;
			quince = 7;
			diez = 5;
			cuarenta = 30;
			alturatxt = 20;
			txtSearchWidth = 73;
			btnSearch	= Bitmap.getBitmapResource("btnSearch_320.png");
			btnSearch1 	= Bitmap.getBitmapResource("btnSearch1_320.png");
		}
		if (Display.getWidth() == 360) {

            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_360.png")));
			tFuente = 20;
			tFuente2 = 23;
			veinticinco = 10;
			sesenta = 10;
			arrow  = Bitmap.getBitmapResource( "arrow_320.png" );
			ocho = 3;
			bgProducto = Bitmap.getBitmapResource("bgProduct_320.png");
			cinco = 0;
			noventa = 45;
			trecientos = 403;
			seisientos = 330;
			cientodiez = 55;
			quince = 7;
			diez = 5;
			cuarenta = 30;
			alturatxt = 20;
			txtSearchWidth = 70;
			btnSearch	= Bitmap.getBitmapResource("btnSearch_320.png");
			btnSearch1 	= Bitmap.getBitmapResource("btnSearch1_320.png");
		}
		if (Display.getWidth() == 480) {

            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_480.png")));
			tFuente = 20;
			tFuente2 = 23;
			veinticinco = 10;
			sesenta = 10;
			arrow  = Bitmap.getBitmapResource( "arrow_320.png" );
			ocho = 3;
			bgProducto = Bitmap.getBitmapResource("bgProduct_320.png");
			cinco = 0;
			noventa = 45;
			trecientos = 284;
			seisientos = 450;
			cientodiez = 55;
			quince = 7;
			diez = 5;
			cuarenta = 30;
			alturatxt = 20;
			txtSearchWidth = 70;
			btnSearch	= Bitmap.getBitmapResource("btnSearch_320.png");
			btnSearch1 	= Bitmap.getBitmapResource("btnSearch1_320.png");
		}
		if (Display.getWidth() == 640) {

            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background.png")));
            
			tFuente = 30;
			tFuente2 = 40;
			arrow  = Bitmap.getBitmapResource( "arrow.png" );
			btnSearch	= Bitmap.getBitmapResource("btnSearch.png");
			btnSearch1 	= Bitmap.getBitmapResource("btnSearch1.png");
		}
		
		try{
			
			FontFamily ffFont1 = FontFamily.forName("Arial");
			fLite = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente);
			fTitle = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente2);
			
			
			//getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background.png")));
			
			
			VerticalFieldManager logoHfm = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER);
			logoHfm.setBackground(BackgroundFactory.createLinearGradientBackground(0xe68241, 0xe68241,0xd16f2f, 0xd16f2f));
			logoHfm.setMargin(0, 0, 0, 0);

			ColorRichText emailCrt = new ColorRichText(Strings.FAVORITOS,0xffffff, RichTextField.FIELD_HCENTER | RichTextField.TEXT_ALIGN_HCENTER);
			emailCrt.setFont(fTitle);
			emailCrt.setMargin(veinticinco, 0, veinticinco, 0);

			logoHfm.add(emailCrt);
			
			HorizontalField footerLogoHfm = new HorizontalField(Display.getWidth(),sesenta,HorizontalFieldManager.FIELD_HCENTER | VerticalFieldManager.FIELD_HCENTER);
			footerLogoHfm.setBackground(BackgroundFactory.createLinearGradientBackground(0x9cbe4f, 0x7a9b3c, 0x7a9b3c, 0x9cbe4f));
			
			/*txtSearch = new BasicEditField("Buscar: ", "", 200, BasicEditField.JUMP_FOCUS_AT_END){
	            public int getPreferredWidth(){return Display.getWidth()-txtSearchWidth;}
	            public int getPreferredHeight(){return alturatxt;}
	            public void layout( int maxWidth, int maxHeight )
	            {
	                super.layout(getPreferredWidth(),getPreferredHeight());
	                setExtent(getPreferredWidth(), getPreferredHeight());
	            }
	            public void paint(Graphics g)
				{      
					g.setColor(0xFFF);
					super.paint(g);
				}
            };
			txtSearch.setBorder(BorderFactory.createBitmapBorder(new XYEdges(5,13, 5, 13), bordes));
			txtSearch.setMargin(ocho, 0, 0, ocho);
			txtSearch.setPadding(cinco, cinco, cinco, cinco);
			txtSearch.setFont(fLite);
			footerLogoHfm.add(txtSearch);
			
            BitmapButtonField btnSearchUser = new BitmapButtonField(btnSearch,btnSearch1,Field.FIELD_HCENTER);
            btnSearchUser.setChangeListener( new FieldChangeListener( ) {
    			public void fieldChanged( Field field, int context ) {
    				if (txtSearch.getText().equals("")){
    					Dialog.alert("Ingresa una palabra de b�squeda.");
    				}else{
    					//UiApplication.getUiApplication().pushScreen(new SearchProducto(idCategoria, txtSearch.getText()));
    				}
    			}
            });     
            btnSearchUser.setMargin(ocho, 0, 0, 5);
            
            footerLogoHfm.add(btnSearchUser);*/
            
			
			logoHfm.add(footerLogoHfm);
			
			add(logoHfm);
			
			if (favoritos.errorCode.equals("0")) {
			//Lista Producto
			VerticalField allContentListaProducto = new VerticalField(Display.getWidth(),trecientos,HorizontalField.FIELD_HCENTER | VerticalField.VERTICAL_SCROLL | VerticalField.VERTICAL_SCROLLBAR);
			
				for (int i = 0; i < favoritos.IdProducto.size(); i++){
										
					HorizontalField contentListProducto = new HorizontalField(seisientos, cientodiez, HorizontalField.FIELD_HCENTER);
					//contentListProducto.setBackground((Background) vColores.elementAt(i));
					
					contentListProducto.setBorder(BorderFactory.createBitmapBorder(new XYEdges(0,8,0,8), bgProducto));
					contentListProducto.setMargin(quince,0,quince,quince);
					contentListProducto.setPadding(0,0,0,0);
					//contentListProducto.setBorder(BorderFactory.createRoundedBorder(new XYEdges(5,5,5,5)));
	
			        
			        vLista.addElement(new ListStyleButtonField(null,""+favoritos.Nombre.elementAt(i) , arrow,DrawStyle.ELLIPSIS){
			            public int getPreferredWidth(){return Display.getWidth()-cuarenta;}
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
		            
		    	    ((Field) vLista.elementAt(i)).setChangeListener(this);
		    	    ((Field) vLista.elementAt(i)).setMargin(diez,0,0,0);
		    	    
		    	    contentListProducto.add(((Field) vLista.elementAt(i)));
		    	    allContentListaProducto.add(contentListProducto);
				}
				add(allContentListaProducto);
			}else{
				VerticalField errorHfm = new VerticalField(Display.getWidth(),trecientos,HorizontalFieldManager.FIELD_HCENTER | DrawStyle.HCENTER | VerticalFieldManager.FIELD_HCENTER);
				errorHfm.setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource(favoritos.errorMessage)));
				
				add(errorHfm);
			}
	        
			
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			add(new RichTextField(e.getMessage()));
		}
		
	}

	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		
		for(int j=0;j<=vLista.size()-1;j++){
			if( vLista.elementAt(j)== field ){
				//pushScreen(new MenuMain());
				hashkey				= favoritos.hashKey;
				idproducto			= favoritos.IdProducto.elementAt(j).toString();
				producto			= favoritos.Producto.elementAt(j).toString();
				marca				= favoritos.Marca.elementAt(j).toString();
				presentacion		= favoritos.Presentacion.elementAt(j).toString();
				establecimiento		= favoritos.Nombre.elementAt(j).toString();
				precioproducto		= favoritos.Precio.elementAt(j).toString();
				preciopromocion		= favoritos.PrecioPromo.elementAt(j).toString();
				latitud				= favoritos.Latitud.elementAt(j).toString();
				longitud			= favoritos.Longitud.elementAt(j).toString();
				fechasondeo			= favoritos.Fecha.elementAt(j).toString();
				UiApplication.getUiApplication().pushScreen(new PerfilProductoF(hashkey, idproducto, producto, marca, presentacion, establecimiento, precioproducto, preciopromocion, latitud, longitud, fechasondeo));
			}
		}
		
	}

}
