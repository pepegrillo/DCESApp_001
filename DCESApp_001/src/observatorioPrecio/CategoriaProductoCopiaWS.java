package observatorioPrecio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;

import org.json.me.JSONArray;
import org.json.me.JSONObject;

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

import com.samples.toolkit.ui.component.ListStyleButtonField;

import configurations.ConexionController;
import configurations.Strings;
import estilos.Estilos;

public class CategoriaProductoCopiaWS extends Estilos implements FieldChangeListener {
	
	int tFuente;
	Font fLite;
	int tFuente2;
	Font fTitle;
	
	Vector vLista   = new Vector();
	//Vector vColores = new Vector();
	
	Bitmap arrow;
	Bitmap bordes;
	
	private String connectionURL;
	private HttpConnection conn;
	private InputStream is;
	private ByteArrayOutputStream bos;
	private String response;
	
	String tipoConexion = ConexionController.getConnectionString()[0];
	String getTipo = ConexionController.getConnectionString()[1];
	
	public CategoriaProductoCopiaWS() {
		
		try {
			
			tFuente = 35;
			tFuente2 = 40;
			FontFamily ffFont1 = FontFamily.forName("Arial");
			fLite = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente);
			fTitle = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente2);
			
			arrow  = Bitmap.getBitmapResource( "arrow.png" );
			
			/*vColores.addElement(BackgroundFactory.createLinearGradientBackground(0x903d3c, 0x903d3c, 0x87413f, 0x87413f));
			vColores.addElement(BackgroundFactory.createLinearGradientBackground(0x709fd3, 0x709fd3, 0x668ab1, 0x668ab1));
			vColores.addElement(BackgroundFactory.createLinearGradientBackground(0xe3ae34, 0xe3ae34, 0xd98e3b, 0xd98e3b));
			vColores.addElement(BackgroundFactory.createLinearGradientBackground(0x92b955, 0x92b955, 0x76924a, 0x76924a));
			vColores.addElement(BackgroundFactory.createLinearGradientBackground(0xd27131, 0xd27131, 0xd3763a, 0xd3763a));
			vColores.addElement(BackgroundFactory.createLinearGradientBackground(0x7a6142, 0x7a6142, 0x705b41, 0x705b41));*/
						
			getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background.png")));
			
						
			VerticalFieldManager logoHfm = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER);
			logoHfm.setBackground(BackgroundFactory.createLinearGradientBackground(0xe68241, 0xe68241,0xd16f2f, 0xd16f2f));
			logoHfm.setMargin(0, 0, 0, 0);

			ColorRichText emailCrt = new ColorRichText(Strings.CATEGORIA,0xffffff, RichTextField.FIELD_HCENTER | RichTextField.TEXT_ALIGN_HCENTER);
			emailCrt.setFont(fTitle);
			emailCrt.setMargin(25, 0, 25, 0);

			logoHfm.add(emailCrt);
			
			VerticalField footerLogoHfm = new VerticalField(Display.getWidth(),20,VerticalFieldManager.FIELD_HCENTER);
			footerLogoHfm.setBackground(BackgroundFactory.createLinearGradientBackground(0x9cbe4f, 0x7a9b3c, 0x7a9b3c, 0x9cbe4f));
			logoHfm.add(footerLogoHfm);
			
			add(logoHfm);
			
			descargarDatos();
			
			/*//Lista Categoria
			VerticalField allContentListaCategoria = new VerticalField(Display.getWidth(),347,HorizontalField.FIELD_HCENTER | VerticalField.VERTICAL_SCROLL | VerticalField.VERTICAL_SCROLLBAR);
			
			for (int i = 0; i < 5; i++){

				
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
		        
		        vLista.addElement(new ListStyleButtonField(null,"HUEVOS Y CARNE" , arrow,DrawStyle.ELLIPSIS){
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
	        
	        add(allContentListaCategoria);*/
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			add(new RichTextField(e.getMessage()));
		}
		
	}
	
	public void descargarDatos(){
		
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
		
	}

	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		
		for(int j=0;j<=vLista.size()-1;j++){
			if( vLista.elementAt(j)== field ){
				//pushScreen(new MenuMain());
				//UiApplication.getUiApplication().pushScreen(new Producto(j+1));
			}
		}
	}

}
