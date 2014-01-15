package observatorioPrecio;

import pck_WS.Filtro2Cx;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.ObjectChoiceField;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;

import com.samples.toolkit.ui.component.BitmapButtonField;

import configurations.Strings;
import estilos.Estilos;
import estilos.FullWidthChoiceField;
import estilos.Estilos.ORichTextField;

public class FiltroBusqueda2 extends Estilos {

	int tFuente;
	Font fLite;
	int tFuente2;
	Font fTitle;
	
	Bitmap hr = Bitmap.getBitmapResource("hr_line.png");
	BitmapField hrBf;

	Bitmap btnConsultarFiltro;
	Bitmap btnConsultarFiltro1;
	
	Filtro2Cx filtro; 
	
	int selectedValue1, selectedValue2;
	String choiceIdEstablecimiento, choiceIdPresentacion, str;
	boolean Valor1Out, Valor2Out = false;

	
	int veinticinco = 25;
	int veinte = 20;
	int trecientoscuarentaysiete = 347;
	int setenta = 70;
	
	int leftHr = 25;
	
	public FiltroBusqueda2(String idCategoria, final String idProductoMain, final String idMunicipio) {
		
		filtro = new Filtro2Cx(idMunicipio);
		if (Display.getWidth() == 320) {

            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_320.png")));
			tFuente = 17;
			tFuente2 = 20;
			veinticinco = 10;
			veinte = 10;
			trecientoscuarentaysiete = 175;
			setenta = 35;
			hr = Bitmap.getBitmapResource("hr_line_3.png");
			leftHr = 10;
			btnConsultarFiltro	= Bitmap.getBitmapResource("btnConsultarFiltro_320.png");
			btnConsultarFiltro1 = Bitmap.getBitmapResource("btnConsultarFiltro1_320.png");	
		}
		if (Display.getWidth() == 360) {

            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_360.png")));
			tFuente = 20;
			tFuente2 = 23;
			veinticinco = 10;
			veinte = 10;
			trecientoscuarentaysiete = 403;
			setenta = 35;
			hr = Bitmap.getBitmapResource("hr_line_3.png");
			leftHr = 30;
			btnConsultarFiltro	= Bitmap.getBitmapResource("btnConsultarFiltro_360.png");
			btnConsultarFiltro1 = Bitmap.getBitmapResource("btnConsultarFiltro1_360.png");	
		}
		if (Display.getWidth() == 480) {

            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_480.png")));
			tFuente = 20;
			tFuente2 = 23;
			veinticinco = 10;
			veinte = 10;
			trecientoscuarentaysiete = 284;
			setenta = 35;
			//hr = Bitmap.getBitmapResource("hr_line.png");
			leftHr = 0;
			btnConsultarFiltro	= Bitmap.getBitmapResource("btnConsultarFiltro_360.png");
			btnConsultarFiltro1 = Bitmap.getBitmapResource("btnConsultarFiltro1_360.png");	
		}
		if (Display.getWidth() == 640) {

            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background.png")));
            
			tFuente = 35;
			tFuente2 = 40;
			btnConsultarFiltro	= Bitmap.getBitmapResource("btnConsultarFiltro.png");
			btnConsultarFiltro1 = Bitmap.getBitmapResource("btnConsultarFiltro1.png");	
		}
		try {


			FontFamily ffFont1 = FontFamily.forName("Arial");
			fLite = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente);
			fTitle = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente2);
			
			
			//hr = Bitmap.getBitmapResource("hr_line.png");
		

			VerticalFieldManager logoHfm = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER);
			logoHfm.setBackground(BackgroundFactory.createLinearGradientBackground(0xe68241, 0xe68241,0xd16f2f, 0xd16f2f));
			logoHfm.setMargin(0, 0, 0, 0);

			ColorRichText emailCrt = new ColorRichText(Strings.FILTRO+idCategoria, 0xffffff, RichTextField.FIELD_HCENTER | RichTextField.TEXT_ALIGN_HCENTER);
			emailCrt.setFont(fTitle);
			emailCrt.setMargin(veinticinco, 0, veinticinco, 0);

			logoHfm.add(emailCrt);

			VerticalField footerLogoHfm = new VerticalField(Display.getWidth(),	veinte, VerticalFieldManager.FIELD_HCENTER);
			footerLogoHfm.setBackground(BackgroundFactory.createLinearGradientBackground(0x9cbe4f, 0x7a9b3c, 0x7a9b3c, 0x9cbe4f));
			logoHfm.add(footerLogoHfm);

			add(logoHfm);
			
			VerticalField allContentFiltro = new VerticalField(Display.getWidth(), trecientoscuarentaysiete, HorizontalField.FIELD_HCENTER | VerticalField.VERTICAL_SCROLL | VerticalField.VERTICAL_SCROLLBAR);
			
			/*
			 * String choices[] =
			 * {"Monday","Tuesday","Wednesday","Thursday","Friday"
			 * ,"Saturday","Sunday"}; int iSetTo = 0; ObjectChoiceField
			 * municipioOcf = new ObjectChoiceField("Municipio",choices,iSetTo);
			 * allContentFiltro.add(municipioOcf); add(allContentFiltro);
			 */

			
			/**/
			
			if (filtro.errorCode.equals("0")){
			
				final String[] choiceTipoSondeo = new String[filtro.IdTipoSondeo.size()] ;
	            for(int i=0;i<filtro.IdTipoSondeo.size();i++)
	            {
	            	choiceTipoSondeo[i]=(String) filtro.TipoSondeo.elementAt(i);
	            }
				
				//Object[] establecimientoO = new Object[] { "one", "two", "three" };
				final ObjectChoiceField establecimientoOcf = new FullWidthChoiceField();
				establecimientoOcf.setChoices(choiceTipoSondeo);
				establecimientoOcf.setMargin(0,setenta,0,setenta);
				if(establecimientoOcf.getSize() == 0){
					establecimientoOcf.setChoices(new Object[] {"No hay datos"});
					Valor1Out = true;
				}
				
				/*Object ob = establecimientoOcf.getChoice(establecimientoOcf.getSelectedIndex());
				str = ob.toString();*/
				
				
				VerticalFieldManager establecimientoVfm = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER | HorizontalFieldManager.FIELD_HCENTER);
				
				LabelField establecimientoLf = new LabelField("Establecimiento", LabelField.FIELD_HCENTER);
				establecimientoLf.setFont(fLite);
				establecimientoLf.setMargin(15,0,5,0);
				
				establecimientoVfm.add(establecimientoLf); // |/ DrawStyle.HCENTER));
				establecimientoVfm.add(establecimientoOcf);
				
				
		        hrBf = new BitmapField(hr);
		        hrBf.setMargin(20,0,0,leftHr);
				establecimientoVfm.add(hrBf);			
				
				allContentFiltro.add(establecimientoVfm);
				
				
				/**/
				final String[] choicePresentacion = new String[filtro.IdArticulo.size()] ;
	            for(int i=0;i<filtro.IdArticulo.size();i++)
	            {
	            	choicePresentacion[i]=(String) filtro.Presentacion.elementAt(i);
	            }
				
				final ObjectChoiceField presentacionOcf = new FullWidthChoiceField();
				presentacionOcf.setChoices(choicePresentacion);
				presentacionOcf.setMargin(0,setenta,0,setenta);
				if(presentacionOcf.getSize() == 0){
					presentacionOcf.setChoices(new Object[] {"No hay datos"});
					Valor2Out = true;
				}
				
				
				/*Object ob2 = presentacionOcf.getChoice(presentacionOcf.getSelectedIndex());
				String str2 = ob2.toString();
				add(new RichTextField(str2));*/
				
				VerticalFieldManager presentacionVfm = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER | HorizontalFieldManager.FIELD_HCENTER);
				
				LabelField presentacionLf = new LabelField("Presentación", LabelField.FIELD_HCENTER);
				presentacionLf.setFont(fLite);
				presentacionLf.setMargin(15,0,5,0);
				
				presentacionVfm.add(presentacionLf); // |/ DrawStyle.HCENTER));
				presentacionVfm.add(presentacionOcf);
				
				
		        hrBf = new BitmapField(hr);
		        hrBf.setMargin(20,0,0,leftHr);
				presentacionVfm.add(hrBf);			
				
				allContentFiltro.add(presentacionVfm);
			
			
			
				//boton consultar
	
	            BitmapButtonField btnConsultarFiltroUser = new BitmapButtonField(btnConsultarFiltro,btnConsultarFiltro1,Field.FIELD_HCENTER);
	            btnConsultarFiltroUser.setChangeListener( new FieldChangeListener( ) {
	    			public void fieldChanged( Field field, int context ) {
	    				
	    				
	    				if((Valor1Out == true) && (Valor2Out == true)){
	    					Dialog.alert("No hay datos para poder filtrar.");
	    				}else{
	    					selectedValue1 = establecimientoOcf.getSelectedIndex();
	    					choiceIdEstablecimiento = filtro.IdTipoSondeo.elementAt(selectedValue1).toString();
	    					
	    					selectedValue2 = presentacionOcf.getSelectedIndex();
	    					choiceIdPresentacion = filtro.IdArticulo.elementAt(selectedValue2).toString();
	    					
	    					UiApplication.getUiApplication().pushScreen(new ProductoFiltro(idMunicipio, idProductoMain, choiceIdEstablecimiento, choiceIdPresentacion));
	    				
	    				}
	    				/*selectedValue2 = presentacionOcf.getSelectedIndex();    				
	    				choiceIdPresentacion = filtro.IdArticulo.elementAt(selectedValue2).toString();*/
	    				
	    				
	    			}
	            });
	            btnConsultarFiltroUser.setMargin(25, 0, 25, 0);
	            
	            allContentFiltro.add(btnConsultarFiltroUser);
            
			}else{
				ORichTextField errorM = new ORichTextField(filtro.errorMessage, RichTextField.FIELD_HCENTER | RichTextField.FIELD_VCENTER | RichTextField.TEXT_ALIGN_LEFT);
				errorM.setFont(fTitle);
				//errorM.setMargin(20, 0, 5, 20);
				allContentFiltro.add(errorM);
			}
            
			add(allContentFiltro);
			
			
			

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			add(new RichTextField(e.getMessage()));
		}

	}
}
