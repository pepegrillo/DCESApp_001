package listaCompras.cotizar;

import java.util.Vector;

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
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import net.rim.device.api.ui.decor.BorderFactory;
import net.rim.device.api.ui.image.Image;
import net.rim.device.api.ui.image.ImageFactory;
import net.rim.device.api.util.StringProvider;
import pck_WS.CotizarListaCx;

import com.samples.toolkit.ui.component.ListStyleButtonField;

import configurations.DbSql;
import estilos.Estilos;

public class CotizarLista extends Estilos implements FieldChangeListener {
	
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
	Bitmap bgProducto = Bitmap.getBitmapResource("bgListaBlanca.png");
	Bitmap bgProducto2 = Bitmap.getBitmapResource("bgListaRoja.png");
	Bitmap btnConsultaListaCompras  = Bitmap.getBitmapResource("btnConsultaListaCompras.png");
	Bitmap btnConsultaListaCompras1 = Bitmap.getBitmapResource("btnConsultaListaCompras1.png");
	
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
	
	CotizarListaCx cotizarlista;
	
	
	public CotizarLista(String idLista) {
		
		IdLista = idLista;
		
		cotizarlista = new CotizarListaCx(IdLista);
		
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
			bgProducto = Bitmap.getBitmapResource("bgListaBlanca_320.png");
			bgProducto2 = Bitmap.getBitmapResource("bgListaRoja_320.png");
			arrow  = Bitmap.getBitmapResource( "arrow_320.png" );
			btnConsultaListaCompras  = Bitmap.getBitmapResource("btnConsultaListaCompras_320.png");
			btnConsultaListaCompras1 = Bitmap.getBitmapResource("btnConsultaListaCompras1_320.png");
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
			bgProducto = Bitmap.getBitmapResource("bgListaBlanca_320.png");
			bgProducto2 = Bitmap.getBitmapResource("bgListaRoja_320.png");
			arrow  = Bitmap.getBitmapResource( "arrow_320.png" );
			btnConsultaListaCompras  = Bitmap.getBitmapResource("btnConsultaListaCompras_320.png");
			btnConsultaListaCompras1 = Bitmap.getBitmapResource("btnConsultaListaCompras1_320.png");
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
			bgProducto = Bitmap.getBitmapResource("bgListaBlanca_320.png");
			bgProducto2 = Bitmap.getBitmapResource("bgListaRoja_320.png");
			arrow  = Bitmap.getBitmapResource( "arrow_320.png" );
			btnConsultaListaCompras  = Bitmap.getBitmapResource("btnConsultaListaCompras_320.png");
			btnConsultaListaCompras1 = Bitmap.getBitmapResource("btnConsultaListaCompras1_320.png");
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
			arrow  = Bitmap.getBitmapResource( "arrow.png" );
			noventa = 70;
		}
		try {
			

			FontFamily ffFont1 = FontFamily.forName("Arial");
			fLite = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente);
			fTitle = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente2);
			
						
			VerticalFieldManager logoHfm = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER);
			logoHfm.setBackground(BackgroundFactory.createLinearGradientBackground(0xe68241, 0xe68241,0xd16f2f, 0xd16f2f));
			logoHfm.setMargin(0, 0, 0, 0);

			ColorRichText emailCrt = new ColorRichText("Establecimientos de la lista",0xffffff, RichTextField.FIELD_HCENTER | RichTextField.TEXT_ALIGN_HCENTER);
			emailCrt.setFont(fTitle);
			emailCrt.setMargin(veinticinco, 0, veinticinco, 0);

			logoHfm.add(emailCrt);
			
			VerticalField footerLogoHfm = new VerticalField(Display.getWidth(),veinte,VerticalFieldManager.FIELD_HCENTER | VerticalField.FIELD_HCENTER | DrawStyle.HCENTER);
			footerLogoHfm.setBackground(BackgroundFactory.createLinearGradientBackground(0x9cbe4f, 0x7a9b3c, 0x7a9b3c, 0x9cbe4f));
						
			logoHfm.add(footerLogoHfm);
			
			add(logoHfm);
			
			if (cotizarlista.errorCode.equals("0")){
			//Lista Categoria
			VerticalField allContentListaCategoria = new VerticalField(Display.getWidth(),trecientoscuarentaysiete,HorizontalField.FIELD_HCENTER | VerticalField.VERTICAL_SCROLL | VerticalField.VERTICAL_SCROLLBAR);
			
				for (int i = 0; i < cotizarlista.idEstablecimiento.size(); i++){
	
					
					contentListCategoria = new VerticalField(seisientos, cientodiez, HorizontalField.FIELD_HCENTER);
					//contentListCategoria.setBackground((Background) vColores.elementAt(i));
					if (cotizarlista.estadoCompleto.elementAt(i).toString().equals("0")) {
						//Rojo
						contentListCategoria.setBorder(BorderFactory.createBitmapBorder(new XYEdges(0,8,0,8), bgProducto2));
					}else if (cotizarlista.estadoCompleto.elementAt(i).toString().equals("1")) {
						contentListCategoria.setBorder(BorderFactory.createBitmapBorder(new XYEdges(0,8,0,8), bgProducto));
					}
					
					contentListCategoria.setMargin(quince,0,quince,quince);
					contentListCategoria.setPadding(0,0,0,0);
					//contentListCategoria.setBorder(BorderFactory.createRoundedBorder(new XYEdges(5,5,5,5)));
					
					if (cotizarlista.estadoCompleto.elementAt(i).toString().equals("1")) {
						vLista.addElement(new ListStyleButtonField(null,""+cotizarlista.nombre.elementAt(i) , arrow,DrawStyle.ELLIPSIS){
				            public int getPreferredWidth(){return Display.getWidth()-cientocincuenta;}
				            public int getPreferredHeight(){return noventa;}
				            public void layout( int maxWidth, int maxHeight )
				            {
				                super.layout(getPreferredWidth(),getPreferredHeight());
				                setExtent(getPreferredWidth(), getPreferredHeight());
				            }
				            public void paint(Graphics g)
							{      
								g.setColor(0x000000);
								super.paint(g);
							}
			            });
			            
						//vLista.addElement(new LabelField(" - "+agregarestablecimientocompras.DireccionEstablecimiento.elementAt(i).toString(),DrawStyle.ELLIPSIS | LabelField.FIELD_LEFT));
						
			    	    ((Field) vLista.elementAt(i)).setChangeListener(this);
			    	    ((Field) vLista.elementAt(i)).setMargin(5,0,0,0);
			    	    
			    	    contentListCategoria.add(((Field) vLista.elementAt(i)));
			    	    
			    	    if (cotizarlista.montoTotal.elementAt(i).toString().length() == 0) {
				    	    LabelField datoextra = new LabelField("Total N/A",DrawStyle.ELLIPSIS | LabelField.FIELD_LEFT){
				    	    	public void paint(Graphics g)
								{      
									g.setColor(0x1c6dae);
									super.paint(g);
								}
				    	    };
				    	    datoextra.setFont(fLite);		    	    
				    	    contentListCategoria.add(datoextra);
			    	    } else {
			    	    	LabelField datoextra = new LabelField("Total $ "+cotizarlista.montoTotal.elementAt(i).toString(),DrawStyle.ELLIPSIS | LabelField.FIELD_LEFT){
				    	    	public void paint(Graphics g)
								{      
									g.setColor(0x1c6dae);
									super.paint(g);
								}
				    	    };
				    	    datoextra.setFont(fLite);		    	    
				    	    contentListCategoria.add(datoextra);
			    	    }
			    	    
			    	
					}else if (cotizarlista.estadoCompleto.elementAt(i).toString().equals("0")) {
						vLista.addElement(new ListStyleButtonField(null,""+cotizarlista.nombre.elementAt(i) , arrow,DrawStyle.ELLIPSIS){
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
			    	    
			    	    if (cotizarlista.montoTotal.elementAt(i).toString().length() == 0) {
				    	    LabelField datoextra = new LabelField("Total N/A",DrawStyle.ELLIPSIS | LabelField.FIELD_LEFT){
				    	    	public void paint(Graphics g)
								{      
									g.setColor(0x1c6dae);
									super.paint(g);
								}
				    	    };
				    	    datoextra.setFont(fLite);		    	    
				    	    contentListCategoria.add(datoextra);
			    	    } else {
			    	    	LabelField datoextra = new LabelField("Total $ "+cotizarlista.montoTotal.elementAt(i).toString(),DrawStyle.ELLIPSIS | LabelField.FIELD_LEFT){
				    	    	public void paint(Graphics g)
								{      
									g.setColor(0x1c6dae);
									super.paint(g);
								}
				    	    };
				    	    datoextra.setFont(fLite);		    	    
				    	    contentListCategoria.add(datoextra);
			    	    }
					}
		    	    
		    	    allContentListaCategoria.add(contentListCategoria);
		    	    //allContentListaCategoria.add(datoextra);
				}
				add(allContentListaCategoria);
			}else{
				VerticalField errorHfm = new VerticalField(Display.getWidth(),trecientoscuarentaysiete,HorizontalFieldManager.FIELD_HCENTER | DrawStyle.HCENTER | VerticalFieldManager.FIELD_HCENTER);
				errorHfm.setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource(cotizarlista.errorMessage)));
				
				add(errorHfm);
			}
			//Descargar datos despues de consumidos
			//descargarDatos();
	        
	       
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			add(new RichTextField(e.getMessage()));
			
		}
		
		// Menu Item
		MenuItem myItem = new MenuItem(new StringProvider("Ver Mapa"), 110, 0){
		    public void run(){
		    	
		    	String url = "http://maps.google.com/maps/api/staticmap?zoom=12&size=500x500&ma...%20";            	
		    	String datos = "";
            	
            	for (int k = 0; k < cotizarlista.idEstablecimiento.size(); k++) {
                	
                	datos = datos + "&markers=color:red|color:red|label:A|"+cotizarlista.altitud.elementAt(k).toString()+","+cotizarlista.longitud.elementAt(k).toString();
                	
                }
		    	
            	String urlComplete = url+datos+"&sensor=false";
            	//Dialog.alert(">"+urlComplete);
		    	UiApplication.getUiApplication().pushScreen(new VerMapa(urlComplete));
		        
		    }
		};
		Image iconoHabito = ImageFactory.createImage(Bitmap.getBitmapResource("imgMewe2.png"));
		myItem.setIcon(iconoHabito);
		
		addMenuItem(myItem);
		
		
	}

	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		
		for(int j=0;j<=vLista.size()-1;j++){
			if( vLista.elementAt(j)== field ){
				UiApplication.getUiApplication().pushScreen(new CotizarListaDetalle(IdLista,cotizarlista.idEstablecimiento.elementAt(j).toString()));				
			}
		}
	}
	
	
	
	/*public void close() {
		UiApplication.getUiApplication().pushScreen(new ConfigurarListaCompras(IdLista));
    }*/
    	
}
