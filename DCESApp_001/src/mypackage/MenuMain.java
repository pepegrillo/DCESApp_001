package mypackage;

import listaProductos.ListaProductos;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import observatorioPrecio.CategoriaProducto;
import pck_WS.FavoritoPx;
import temporadaProducto.CategoriaProductoT;

import com.samples.toolkit.ui.component.BitmapButtonField;

import configurations.Ajustes;
import estilos.Estilos;
import favoritos.FavoritoProducto;

public class MenuMain extends Estilos {
	
	Bitmap btnObservatorioPrecio;
	Bitmap btnObservatorioPrecio1;
	Bitmap btnListaCompra;
	Bitmap btnListaCompra1;
	Bitmap btnTemporada;
	Bitmap btnTemporada1;
	Bitmap btnFavoritos;
	Bitmap btnFavoritos1;
	Bitmap btnAjustes;
	Bitmap btnAjustes1;
	
	//personalizacion
	int cientocinco 	= 105;
	int cuatrocientos 	= 434;
	int diecisiete 		= 17;
	int veintitres 		= 23;
	
	int cerrarscreen = 0;
	
	FavoritoPx favoritos = new FavoritoPx();
	
	public MenuMain(int cerrarScreen) {
		
		cerrarscreen = cerrarScreen;
		
		
		
		if (Display.getWidth() == 320) {
			btnObservatorioPrecio	= Bitmap.getBitmapResource("btnObservatorioPrecio_320.png");
			btnObservatorioPrecio1 	= Bitmap.getBitmapResource("btnObservatorioPrecio1_320.png");
            btnListaCompra			= Bitmap.getBitmapResource("btnListaCompra_320.png");
            btnListaCompra1 		= Bitmap.getBitmapResource("btnListaCompra1_320.png");
            btnTemporada			= Bitmap.getBitmapResource("btnTemporada_320.png");
            btnTemporada1 			= Bitmap.getBitmapResource("btnTemporada1_320.png");
            btnFavoritos			= Bitmap.getBitmapResource("btnFavoritos_320.png");
            btnFavoritos1 			= Bitmap.getBitmapResource("btnFavoritos1_320.png");
            btnAjustes				= Bitmap.getBitmapResource("btnAjustes_320.png");
            btnAjustes1 			= Bitmap.getBitmapResource("btnAjustes1_320.png");
            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_menu_320.png")));
            cientocinco 	= 52;
            cuatrocientos 	= 216;
            diecisiete 		= 8;
            veintitres 		= 12;
		}
		if (Display.getWidth() == 360) {
			btnObservatorioPrecio	= Bitmap.getBitmapResource("btnObservatorioPrecio_360.png");
			btnObservatorioPrecio1 	= Bitmap.getBitmapResource("btnObservatorioPrecio1_360.png");
            btnListaCompra			= Bitmap.getBitmapResource("btnListaCompra_360.png");
            btnListaCompra1 		= Bitmap.getBitmapResource("btnListaCompra1_360.png");
            btnTemporada			= Bitmap.getBitmapResource("btnTemporada_360.png");
            btnTemporada1 			= Bitmap.getBitmapResource("btnTemporada1_360.png");
            btnFavoritos			= Bitmap.getBitmapResource("btnFavoritos_360.png");
            btnFavoritos1 			= Bitmap.getBitmapResource("btnFavoritos1_360.png");
            btnAjustes				= Bitmap.getBitmapResource("btnAjustes_360.png");
            btnAjustes1 			= Bitmap.getBitmapResource("btnAjustes1_360.png");
            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_menu_360.png")));
            cientocinco 	= 52;
            cuatrocientos 	= 440;
            diecisiete 		= 8;
            veintitres 		= 20;
		}
		if (Display.getWidth() == 480) {
			btnObservatorioPrecio	= Bitmap.getBitmapResource("btnObservatorioPrecio_480.png");
			btnObservatorioPrecio1 	= Bitmap.getBitmapResource("btnObservatorioPrecio1_480.png");
            btnListaCompra			= Bitmap.getBitmapResource("btnListaCompra_480.png");
            btnListaCompra1 		= Bitmap.getBitmapResource("btnListaCompra1_480.png");
            btnTemporada			= Bitmap.getBitmapResource("btnTemporada_480.png");
            btnTemporada1 			= Bitmap.getBitmapResource("btnTemporada1_480.png");
            btnFavoritos			= Bitmap.getBitmapResource("btnFavoritos_480.png");
            btnFavoritos1 			= Bitmap.getBitmapResource("btnFavoritos1_480.png");
            btnAjustes				= Bitmap.getBitmapResource("btnAjustes_480.png");
            btnAjustes1 			= Bitmap.getBitmapResource("btnAjustes1_480.png");
            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_menu_480.png")));
            cientocinco 	= 80;
            cuatrocientos 	= 314;
            diecisiete 		= 8;
            veintitres 		= 23;
		}
		if (Display.getWidth() == 640) {
			btnObservatorioPrecio	= Bitmap.getBitmapResource("btnObservatorioPrecio.png");
			btnObservatorioPrecio1 	= Bitmap.getBitmapResource("btnObservatorioPrecio1.png");
            btnListaCompra			= Bitmap.getBitmapResource("btnListaCompra.png");
            btnListaCompra1 		= Bitmap.getBitmapResource("btnListaCompra1.png");
            btnTemporada			= Bitmap.getBitmapResource("btnTemporada.png");
            btnTemporada1 			= Bitmap.getBitmapResource("btnTemporada1.png");
            btnFavoritos			= Bitmap.getBitmapResource("btnFavoritos.png");
            btnFavoritos1 			= Bitmap.getBitmapResource("btnFavoritos1.png");
            btnAjustes				= Bitmap.getBitmapResource("btnAjustes.png");
            btnAjustes1 			= Bitmap.getBitmapResource("btnAjustes1.png");
            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_menu.png")));
		}
		try {
			
			
			
			VerticalField allContentInicio = new VerticalField(Display.getWidth(),cuatrocientos,VerticalField.VERTICAL_SCROLL | VerticalField.VERTICAL_SCROLLBAR);
			allContentInicio.setMargin(veintitres, 0, 0, 0);
			
			//Menu Options
			VerticalFieldManager contentMenuMain = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER | VerticalFieldManager.FIELD_VCENTER);
			contentMenuMain.setMargin(diecisiete, 0, 10, cientocinco);
			
			if((cerrarscreen == 1) || (cerrarscreen == 2)){
				
				BitmapButtonField btnObservatorioPrecioUser = new BitmapButtonField(btnObservatorioPrecio,btnObservatorioPrecio1);
	            btnObservatorioPrecioUser.setChangeListener( new FieldChangeListener( ) {
	    			public void fieldChanged( Field field, int context ) {
	    				UiApplication.getUiApplication().pushScreen(new CategoriaProducto());
	    			}
	            });            
	            contentMenuMain.add(btnObservatorioPrecioUser);
	            
		
	            BitmapButtonField btnListaCompraUser = new BitmapButtonField(btnListaCompra,btnListaCompra1);
	            btnListaCompraUser.setChangeListener( new FieldChangeListener( ) {
	    			public void fieldChanged( Field field, int context ) {
	    				UiApplication.getUiApplication().pushScreen(new ListaProductos());
	    			}
	            });            
	            contentMenuMain.add(btnListaCompraUser);
	            
		
	            BitmapButtonField btnTemporadaUser = new BitmapButtonField(btnTemporada,btnTemporada1);
	            btnTemporadaUser.setChangeListener( new FieldChangeListener( ) {
	    			public void fieldChanged( Field field, int context ) {
	    				UiApplication.getUiApplication().pushScreen(new CategoriaProductoT());
	    			}
	            });            
	            contentMenuMain.add(btnTemporadaUser);
	            
		
	            BitmapButtonField btnFavoritosUser = new BitmapButtonField(btnFavoritos,btnFavoritos1);
	            btnFavoritosUser.setChangeListener( new FieldChangeListener( ) {
	    			public void fieldChanged( Field field, int context ) {
	    				UiApplication.getUiApplication().pushScreen(new FavoritoProducto());
	    			}
	            });            
	            contentMenuMain.add(btnFavoritosUser);
	            
		
	            BitmapButtonField btnAjustesUser = new BitmapButtonField(btnAjustes,btnAjustes1);
	            btnAjustesUser.setChangeListener( new FieldChangeListener( ) {
	    			public void fieldChanged( Field field, int context ) {
	    				UiApplication.getUiApplication().pushScreen(new Ajustes());
	    			}
	            });
	            contentMenuMain.add(btnAjustesUser);
				
			}else if(cerrarscreen == 3){
				
				favoritos.validacionUser();
				
				BitmapButtonField btnObservatorioPrecioUser = new BitmapButtonField(btnObservatorioPrecio,btnObservatorioPrecio1);
	            btnObservatorioPrecioUser.setChangeListener( new FieldChangeListener( ) {
	    			public void fieldChanged( Field field, int context ) {	    				
	    				UiApplication.getUiApplication().pushScreen(new CategoriaProducto());
	    			}
	            });            
	            contentMenuMain.add(btnObservatorioPrecioUser);
	            
		
	            BitmapButtonField btnListaCompraUser = new BitmapButtonField(btnListaCompra,btnListaCompra1);
	            btnListaCompraUser.setChangeListener( new FieldChangeListener( ) {
	    			public void fieldChanged( Field field, int context ) {
	    				Dialog.alert("Debes iniciar sesión o registrarte para acceder a ésta función.");
	    			}
	            });            
	            contentMenuMain.add(btnListaCompraUser);
	            
		
	            BitmapButtonField btnTemporadaUser = new BitmapButtonField(btnTemporada,btnTemporada1);
	            btnTemporadaUser.setChangeListener( new FieldChangeListener( ) {
	    			public void fieldChanged( Field field, int context ) {
	    				UiApplication.getUiApplication().pushScreen(new CategoriaProductoT());
	    			}
	            });            
	            contentMenuMain.add(btnTemporadaUser);
	            
		
	            BitmapButtonField btnFavoritosUser = new BitmapButtonField(btnFavoritos,btnFavoritos1);
	            btnFavoritosUser.setChangeListener( new FieldChangeListener( ) {
	    			public void fieldChanged( Field field, int context ) {
	    				Dialog.alert("Debes iniciar sesión o registrarte para acceder a ésta función.");
	    			}
	            });            
	            contentMenuMain.add(btnFavoritosUser);
	            
		
	            BitmapButtonField btnAjustesUser = new BitmapButtonField(btnAjustes,btnAjustes1);
	            btnAjustesUser.setChangeListener( new FieldChangeListener( ) {
	    			public void fieldChanged( Field field, int context ) {
	    				Dialog.alert("Debes iniciar sesión o registrarte para acceder a ésta función.");
	    			}
	            });
	            contentMenuMain.add(btnAjustesUser);
			}
				
            
            
            allContentInicio.add(contentMenuMain);
            add(allContentInicio);
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void close() {
    	
		if((cerrarscreen == 1) || (cerrarscreen == 2)){
			//UiApplication.getUiApplication().popScreen();
			int ans = Dialog.ask(Dialog.D_YES_NO,"¿Realmente desea salir de la aplicación Observatorio de Precios?");
		    if (ans == Dialog.NO) {
		        // Do Nothing
		    } else {
				System.exit(0);
		        super.close();
		    }
		}else if(cerrarscreen == 3){
			favoritos.eliminarTemporalUser();
			UiApplication.getUiApplication().popScreen();
		}
		
    }
	
}
