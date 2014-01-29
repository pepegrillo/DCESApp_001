package temporadaProducto;

import java.util.Vector;

import net.rim.device.api.database.Database;
import net.rim.device.api.database.DatabaseFactory;
import net.rim.device.api.database.Statement;
import net.rim.device.api.io.URI;
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
import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import net.rim.device.api.ui.decor.BorderFactory;
import pck_WS.CategoriaProductoCx;
import pck_WS.TemporadaCategoriaProductoCx;

import com.samples.toolkit.ui.component.ListStyleButtonField;

import configurations.DbSql;
import configurations.Strings;
import estilos.Estilos;
import estilos.Estilos.ORichTextField;

public class CategoriaProductoT extends Estilos implements FieldChangeListener {
	
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
	HorizontalField contentListCategoria;
	//personalizacion
	int veinte = 20;
	int trecientoscuarentaysiete = 347;
	int seisientos = 600;
	int cientodiez = 110;
	int quince = 15;
	int noventa = 90;
	int cientocincuenta = 150;
	String apend = "";
	
	int topImageLogo = 7;
	int rightImageLogo = 5;
	int bottomImageLogo = 3;
	int leftImageLogo = 5;
	
	DbSql path = new DbSql();
	DbSql statement = new DbSql();
	
	TemporadaCategoriaProductoCx categoria = new TemporadaCategoriaProductoCx();
	
	public CategoriaProductoT() {
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
			arrow  = Bitmap.getBitmapResource( "arrow_320.png" );
			apend = "_320";
			noventa = 35;
			cientocincuenta = 85;
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
			arrow  = Bitmap.getBitmapResource( "arrow_320.png" );
			apend = "_320";
			noventa = 35;
			cientocincuenta = 85;
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
			arrow  = Bitmap.getBitmapResource( "arrow_320.png" );
			apend = "_320";
			noventa = 35;
			cientocincuenta = 85;
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
			
			
			
			/*vColores.addElement(BackgroundFactory.createLinearGradientBackground(0x903d3c, 0x903d3c, 0x87413f, 0x87413f));
			vColores.addElement(BackgroundFactory.createLinearGradientBackground(0x709fd3, 0x709fd3, 0x668ab1, 0x668ab1));
			vColores.addElement(BackgroundFactory.createLinearGradientBackground(0xe3ae34, 0xe3ae34, 0xd98e3b, 0xd98e3b));
			vColores.addElement(BackgroundFactory.createLinearGradientBackground(0x92b955, 0x92b955, 0x76924a, 0x76924a));
			vColores.addElement(BackgroundFactory.createLinearGradientBackground(0xd27131, 0xd27131, 0xd3763a, 0xd3763a));
			vColores.addElement(BackgroundFactory.createLinearGradientBackground(0x7a6142, 0x7a6142, 0x705b41, 0x705b41));*/
						
			//getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background.png")));
			
						
			VerticalFieldManager logoHfm = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER);
			logoHfm.setBackground(BackgroundFactory.createLinearGradientBackground(0xe68241, 0xe68241,0xd16f2f, 0xd16f2f));
			logoHfm.setMargin(0, 0, 0, 0);

			ColorRichText emailCrt = new ColorRichText(Strings.CATEGORIA,0xffffff, RichTextField.FIELD_HCENTER | RichTextField.TEXT_ALIGN_HCENTER);
			emailCrt.setFont(fTitle);
			emailCrt.setMargin(veinticinco, 0, veinticinco, 0);

			logoHfm.add(emailCrt);
			
			VerticalField footerLogoHfm = new VerticalField(Display.getWidth(),veinte,VerticalFieldManager.FIELD_HCENTER);
			footerLogoHfm.setBackground(BackgroundFactory.createLinearGradientBackground(0x9cbe4f, 0x7a9b3c, 0x7a9b3c, 0x9cbe4f));
			logoHfm.add(footerLogoHfm);
			
			add(logoHfm);
			
			//descargarDatos();
			
			
			
			//Lista Categoria
			VerticalField allContentListaCategoria = new VerticalField(Display.getWidth(),trecientoscuarentaysiete,HorizontalField.FIELD_HCENTER | VerticalField.VERTICAL_SCROLL | VerticalField.VERTICAL_SCROLLBAR);
			
			if (categoria.errorCode.equals("0")){
			
				for (int i = 0; i < categoria.IdCategoria.size(); i++){
	
					
					contentListCategoria = new HorizontalField(seisientos, cientodiez, HorizontalField.FIELD_HCENTER);
					//contentListCategoria.setBackground((Background) vColores.elementAt(i));
					
					contentListCategoria.setBorder(BorderFactory.createBitmapBorder(new XYEdges(0,8,0,8), Bitmap.getBitmapResource("bgList"+i+""+apend+".png")));
					contentListCategoria.setMargin(quince,0,quince,quince);
					contentListCategoria.setPadding(0,0,0,0);
					//contentListCategoria.setBorder(BorderFactory.createRoundedBorder(new XYEdges(5,5,5,5)));
					
					try{
						logoList = Bitmap.getBitmapResource("imgCat_"+ i +""+apend+".png");
						
				        logoListaf = new BitmapField(logoList);
				        //logoListaf.setMargin(7,7,7,7);
				        logoListaf.setPadding(topImageLogo, rightImageLogo, bottomImageLogo, leftImageLogo);	        
				        contentListCategoria.add(logoListaf);
					}catch (Exception e) {
						// TODO: handle exception
						logoList = Bitmap.getBitmapResource("imgCat_Default.png");
				        logoListaf = new BitmapField(logoList);
				        //logoListaf.setMargin(7,7,7,7);
				        logoListaf.setPadding(7, 5, 3, 5);	        
				        contentListCategoria.add(logoListaf);
					}  
			        vLista.addElement(new ListStyleButtonField(null,categoria.Categoria.elementAt(i).toString().toUpperCase() , arrow,DrawStyle.ELLIPSIS){
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
		            
		    	    ((Field) vLista.elementAt(i)).setChangeListener(this);
		    	    ((Field) vLista.elementAt(i)).setMargin(10,0,0,0);
		    	    
		    	    contentListCategoria.add(((Field) vLista.elementAt(i)));
		    	    allContentListaCategoria.add(contentListCategoria);
				}
				
			}else{
				ORichTextField errorM = new ORichTextField(categoria.errorMessage, RichTextField.FIELD_HCENTER | RichTextField.FIELD_VCENTER | RichTextField.TEXT_ALIGN_LEFT);
				errorM.setFont(fTitle);
				//errorM.setMargin(20, 0, 5, 20);
				allContentListaCategoria.add(errorM);
			}
			//Descargar datos despues de consumidos
			//descargarDatos();
	        
	        add(allContentListaCategoria);
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			add(new RichTextField(e.getMessage()));
			
		}
		
	}

	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		
		for(int j=0;j<=vLista.size()-1;j++){
			if( vLista.elementAt(j)== field ){
				//pushScreen(new MenuMain());
				UiApplication.getUiApplication().pushScreen(new ProductoT(categoria.IdCategoria.elementAt(j).toString()));
			}
		}
	}
	

}
