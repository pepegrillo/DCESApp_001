package observatorioPrecio;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Vector;

import javax.microedition.io.HttpConnection;

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
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import net.rim.device.api.ui.decor.BorderFactory;
import pck_WS.FiltroCx;

import com.samples.toolkit.ui.component.ListStyleButtonField;

import configurations.ConexionController;
import estilos.Estilos;
import estilos.Estilos.ORichTextField;

public class FiltroBusqueda extends Estilos implements FieldChangeListener {
	
	int tFuente;
	Font fLite;
	int tFuente2;
	Font fTitle;
	
	Vector vLista   = new Vector();
	//Vector vColores = new Vector();
	
	Bitmap arrow;
	Bitmap bordes;
	Bitmap logoList;
	BitmapField logoListaf;
	HorizontalField contentListCategoria;
	
	private String connectionURL;
	private HttpConnection conn;
	private InputStream is;
	private ByteArrayOutputStream bos;
	private String response;
	
	String tipoConexion = ConexionController.getConnectionString()[0];
	String getTipo = ConexionController.getConnectionString()[1];
	
	FiltroCx filtro;
	String idCategoria;
	String idProductoMain;
	String idMunicipio;
	
	int veinticinco = 25;
	int veinte = 20;
	int trecientoscuarentaysiete = 347;
	Bitmap bgProducto = Bitmap.getBitmapResource("bgProduct.png");
	int seisientos = 600;
	int cientodiez = 110;
	int quince = 15;
	int cuarenta = 40;
	int noventa = 90;
	int diez = 10;
	public FiltroBusqueda(String IdCategoria, String IdProductoMain) {
		filtro = new FiltroCx(IdCategoria);
		idCategoria    = IdCategoria;
		idProductoMain = IdProductoMain;
		if (Display.getWidth() == 320) {

            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_320.png")));
			tFuente = 17;
			tFuente2 = 20;
			veinticinco = 10;
			veinte = 10;
			trecientoscuarentaysiete = 171;
			arrow  = Bitmap.getBitmapResource( "arrow_320.png" );
			bgProducto = Bitmap.getBitmapResource("bgProduct_320.png");
			noventa = 45;
			seisientos = 290;
			cientodiez = 55;
			quince = 7;
			diez = 5;
			cuarenta = 30;
		}
		if (Display.getWidth() == 360) {

            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_360.png")));
			tFuente = 17;
			tFuente2 = 20;
			veinticinco = 12;
			veinte = 10;
			trecientoscuarentaysiete = 403;
			arrow  = Bitmap.getBitmapResource( "arrow_320.png" );
			bgProducto = Bitmap.getBitmapResource("bgProduct_320.png");
			noventa = 45;
			seisientos = 330;
			cientodiez = 55;
			quince = 7;
			diez = 5;
			cuarenta = 30;
		}
		if (Display.getWidth() == 480) {

            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_480.png")));
			tFuente = 17;
			tFuente2 = 20;
			veinticinco = 12;
			veinte = 10;
			trecientoscuarentaysiete = 284;
			arrow  = Bitmap.getBitmapResource( "arrow_320.png" );
			bgProducto = Bitmap.getBitmapResource("bgProduct_320.png");
			noventa = 45;
			seisientos = 450;
			cientodiez = 55;
			quince = 7;
			diez = 5;
			cuarenta = 30;
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

			ColorRichText emailCrt = new ColorRichText("Filtro búsqueda ",0xffffff, RichTextField.FIELD_HCENTER | RichTextField.TEXT_ALIGN_HCENTER);
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
			
			if (filtro.errorCode.equals("0")){
			
				for (int i = 0; i < filtro.IdMunicipio.size(); i++){
	
					
					contentListCategoria = new HorizontalField(seisientos, cientodiez, HorizontalField.FIELD_HCENTER);
					//contentListCategoria.setBackground((Background) vColores.elementAt(i));
					
					contentListCategoria.setBorder(BorderFactory.createBitmapBorder(new XYEdges(0,8,0,8), bgProducto));
					contentListCategoria.setMargin(quince,0,quince,quince);
					contentListCategoria.setPadding(0,0,0,0);
					//contentListCategoria.setBorder(BorderFactory.createRoundedBorder(new XYEdges(5,5,5,5)));
					
					 
			        vLista.addElement(new ListStyleButtonField(null,filtro.Municipio.elementAt(i).toString().toUpperCase() , arrow,DrawStyle.ELLIPSIS){
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
		    	    
		    	    contentListCategoria.add(((Field) vLista.elementAt(i)));
		    	    allContentListaCategoria.add(contentListCategoria);
				}
			}else{
				ORichTextField errorM = new ORichTextField(filtro.errorMessage, RichTextField.FIELD_HCENTER | RichTextField.FIELD_VCENTER | RichTextField.TEXT_ALIGN_LEFT);
				errorM.setFont(fTitle);
				//errorM.setMargin(20, 0, 5, 20);
				allContentListaCategoria.add(errorM);
			}
	        
	        add(allContentListaCategoria);
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			add(new RichTextField(e.getMessage()));
			
		}
		
	}
	
	/*public void descargarDatos(){
		
		try {

	        connectionURL = "http://190.5.140.249/odp/ApiREST.php/v1/getCategorias"+tipoConexion;

	        conn = (HttpConnection) Connector.open(connectionURL);
	        conn.setRequestProperty("Content-Type","application/json");
	       // System.out.println("Response code : "+conn.getResponseCode());

	        if(conn.getResponseCode() == HttpConnection.HTTP_OK)
	        {

	            is = conn.openInputStream();
	            int ch=-1;
	            bos = new ByteArrayOutputStream();
	            while((ch = is.read())!=-1)
	            {
	                bos.write(ch);
	            }
	            response = new String(bos.toByteArray(),"UTF-8");
	            //add(new RichTextField(response));
	            
	            JSONObject objeto1 =  new  JSONObject ( response );
	            String resultado1 = objeto1.getString("msg");	
	            //add(new RichTextField(resultado1));
	            
	            JSONObject objeto2 =  new  JSONObject ( resultado1 );
	            //String resultado2 = objeto2.getString("ListaCategorias");
	            //add(new RichTextField(resultado2));
	            
	            JSONArray jsonMainArr = objeto2.getJSONArray("ListaCategorias");
	            
	          //Lista Categoria
				VerticalField allContentListaCategoria = new VerticalField(Display.getWidth(),347,HorizontalField.FIELD_HCENTER | VerticalField.VERTICAL_SCROLL | VerticalField.VERTICAL_SCROLLBAR);
				
	            
	            for (int i = 0; i < jsonMainArr.length(); i++) {
	            	
	            	JSONObject childJSONObject = jsonMainArr.getJSONObject(i);
	            	
//	            	add(new RichTextField(childJSONObject.getString("Categoria")));
	            	
	            	HorizontalField contentListCategoria = new HorizontalField(600, 110, HorizontalField.FIELD_HCENTER);
					//contentListCategoria.setBackground((Background) vColores.elementAt(i));
					
					contentListCategoria.setBorder(BorderFactory.createBitmapBorder(new XYEdges(0,8,0,8), Bitmap.getBitmapResource("bgList"+i+".png")));
					contentListCategoria.setMargin(15,0,15,13);
					contentListCategoria.setPadding(0,0,0,0);
					//contentListCategoria.setBorder(BorderFactory.createRoundedBorder(new XYEdges(5,5,5,5)));

					Bitmap logoList = Bitmap.getBitmapResource("listImagen.png");
			        BitmapField logoListaf = new BitmapField(logoList);
			        //logoListaf.setMargin(7,7,7,7);
			        logoListaf.setPadding(7, 5, 3, 5);	        
			        contentListCategoria.add(logoListaf);
			        
			        vLista.addElement(new ListStyleButtonField(null,childJSONObject.getString("Categoria").toUpperCase() , arrow,DrawStyle.ELLIPSIS){
			            public int getPreferredWidth(){return Display.getWidth()-150;}
			            public int getPreferredHeight(){return 90;}
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
		        
		        add(allContentListaCategoria);
	            
	            
	        }
		} catch (Exception e) 
	    {
			add(new RichTextField(e.getMessage()));

	    }finally 
	    {

	            if(conn != null)
					try {
						conn.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            if(is != null)
					try {
						is.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            if(bos != null)
					try {
						bos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    }
		
	}*/

	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		
		for(int j=0;j<=vLista.size()-1;j++){
			if( vLista.elementAt(j)== field ){
				idMunicipio = filtro.IdMunicipio.elementAt(j).toString();
				//pushScreen(new MenuMain());
				UiApplication.getUiApplication().pushScreen(new FiltroBusqueda2(idCategoria, idProductoMain, idMunicipio));
			}
		}
	}

}
