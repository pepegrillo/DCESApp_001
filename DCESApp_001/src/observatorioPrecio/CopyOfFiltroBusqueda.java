package observatorioPrecio;

import pck_WS.FiltroCx;

import com.samples.toolkit.ui.component.BitmapButtonField;

import mypackage.MyScreen;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.ObjectChoiceField;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import configurations.Strings;
import estilos.Estilos;
import estilos.FullWidthChoiceField;

public class CopyOfFiltroBusqueda extends Estilos {

	int tFuente;
	Font fLite;
	int tFuente2;
	Font fTitle;
	
	Bitmap hr;
	BitmapField hrBf;

	Bitmap btnConsultarFiltro;
	Bitmap btnConsultarFiltro1;
	
	public CopyOfFiltroBusqueda(String idCategoria) {

		FiltroCx filtro = new FiltroCx(idCategoria);
		
		try {

			tFuente = 35;
			tFuente2 = 40;
			FontFamily ffFont1 = FontFamily.forName("Arial");
			fLite = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente);
			fTitle = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente2);
			
			
			hr = Bitmap.getBitmapResource("hr_line.png");
			
			getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background.png")));

			VerticalFieldManager logoHfm = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER);
			logoHfm.setBackground(BackgroundFactory.createLinearGradientBackground(0xe68241, 0xe68241,0xd16f2f, 0xd16f2f));
			logoHfm.setMargin(0, 0, 0, 0);

			ColorRichText emailCrt = new ColorRichText(Strings.FILTRO, 0xffffff, RichTextField.FIELD_HCENTER | RichTextField.TEXT_ALIGN_HCENTER);
			emailCrt.setFont(fTitle);
			emailCrt.setMargin(25, 0, 25, 0);

			logoHfm.add(emailCrt);

			VerticalField footerLogoHfm = new VerticalField(Display.getWidth(),	20, VerticalFieldManager.FIELD_HCENTER);
			footerLogoHfm.setBackground(BackgroundFactory.createLinearGradientBackground(0x9cbe4f, 0x7a9b3c, 0x7a9b3c, 0x9cbe4f));
			logoHfm.add(footerLogoHfm);

			add(logoHfm);

			VerticalField allContentFiltro = new VerticalField(Display.getWidth(), 347, HorizontalField.FIELD_HCENTER | VerticalField.VERTICAL_SCROLL | VerticalField.VERTICAL_SCROLLBAR);
			
			/*
			 * String choices[] =
			 * {"Monday","Tuesday","Wednesday","Thursday","Friday"
			 * ,"Saturday","Sunday"}; int iSetTo = 0; ObjectChoiceField
			 * municipioOcf = new ObjectChoiceField("Municipio",choices,iSetTo);
			 * allContentFiltro.add(municipioOcf); add(allContentFiltro);
			 */

			Object[] municipioO = new Object[] { ""+filtro.Municipio.elementAt(0).toString(), "two", "three" };
			ObjectChoiceField municipioOcf = new FullWidthChoiceField();
			municipioOcf.setChoices(municipioO);
			municipioOcf.setMargin(0,70,0,70);

			VerticalFieldManager municipioVfm = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER | HorizontalFieldManager.FIELD_HCENTER);
			
			LabelField municipioLf = new LabelField("Municipio", LabelField.FIELD_HCENTER);
			municipioLf.setFont(fLite);
			municipioLf.setMargin(15,0,5,0);
			
			municipioVfm.add(municipioLf); // |/ DrawStyle.HCENTER));
			municipioVfm.add(municipioOcf);
			
			
	        hrBf = new BitmapField(hr);
	        hrBf.setMargin(20,0,0,25);
			municipioVfm.add(hrBf);
			
			allContentFiltro.add(municipioVfm);
			
			/**/
			Object[] establecimientoO = new Object[] { "one", "two", "three" };
			ObjectChoiceField establecimientoOcf = new FullWidthChoiceField();
			establecimientoOcf.setChoices(establecimientoO);
			establecimientoOcf.setMargin(0,70,0,70);
			
			VerticalFieldManager establecimientoVfm = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER | HorizontalFieldManager.FIELD_HCENTER);
			
			LabelField establecimientoLf = new LabelField("Establecimiento", LabelField.FIELD_HCENTER);
			establecimientoLf.setFont(fLite);
			establecimientoLf.setMargin(15,0,5,0);
			
			establecimientoVfm.add(establecimientoLf); // |/ DrawStyle.HCENTER));
			establecimientoVfm.add(establecimientoOcf);
			
			
	        hrBf = new BitmapField(hr);
	        hrBf.setMargin(20,0,0,25);
			establecimientoVfm.add(hrBf);			
			
			allContentFiltro.add(establecimientoVfm);
			
			
			/**/
			Object[] presentacionO = new Object[] { "one", "two", "three" };
			ObjectChoiceField presentacionOcf = new FullWidthChoiceField();
			presentacionOcf.setChoices(presentacionO);
			presentacionOcf.setMargin(0,70,0,70);
			
			VerticalFieldManager presentacionVfm = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER | HorizontalFieldManager.FIELD_HCENTER);
			
			LabelField presentacionLf = new LabelField("Presentación", LabelField.FIELD_HCENTER);
			presentacionLf.setFont(fLite);
			presentacionLf.setMargin(15,0,5,0);
			
			presentacionVfm.add(presentacionLf); // |/ DrawStyle.HCENTER));
			presentacionVfm.add(presentacionOcf);
			
			
	        hrBf = new BitmapField(hr);
	        hrBf.setMargin(20,0,0,25);
			presentacionVfm.add(hrBf);			
			
			allContentFiltro.add(presentacionVfm);
			
			
			//boton consultar
			btnConsultarFiltro	= Bitmap.getBitmapResource("btnConsultarFiltro.png");
			btnConsultarFiltro1 = Bitmap.getBitmapResource("btnConsultarFiltro1.png");	
            BitmapButtonField btnConsultarFiltroUser = new BitmapButtonField(btnConsultarFiltro,btnConsultarFiltro1,Field.FIELD_HCENTER);
            btnConsultarFiltroUser.setChangeListener( new FieldChangeListener( ) {
    			public void fieldChanged( Field field, int context ) {
    				//UiApplication.getUiApplication().pushScreen(new ProductoFiltro(selectedValue));
    			}
            });
            btnConsultarFiltroUser.setMargin(25, 0, 25, 0);
            
            allContentFiltro.add(btnConsultarFiltroUser);
			
			add(allContentFiltro);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			add(new RichTextField(e.getMessage()));
		}

	}

}
