package listaCompras.Alertas;

import java.util.Calendar;

import net.rim.device.api.i18n.SimpleDateFormat;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.DrawStyle;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.component.CheckboxField;
import net.rim.device.api.ui.component.DateField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.component.Status;
import net.rim.device.api.ui.container.FlowFieldManager;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import pck_WS.AlertasComprasCx;

import com.samples.toolkit.ui.component.BitmapButtonField;
import com.samples.toolkit.ui.component.PillButtonField;
import com.samples.toolkit.ui.container.NegativeMarginHorizontalFieldManager;
import com.samples.toolkit.ui.container.NegativeMarginVerticalFieldManager;
import com.samples.toolkit.ui.container.PillButtonSet;

import configurations.ConexionController;
import configurations.DbSql;
import configurations.Metodo;
import estilos.Estilos;

public class AlertaListaCompras extends Estilos {
	
	String tipoConexion = ConexionController.getConnectionString()[0];
	String getTipo = ConexionController.getConnectionString()[1];
	Metodo request = new Metodo();
	
	DbSql path = new DbSql();
	DbSql statement = new DbSql();
	
	int tFuente = 20;
	Font fLite;
	int tFuente2 = 30;
	Font fTitle;
	
	BitmapButtonField btnAceptarRegUser;
	Bitmap btnAceptarReg 	= Bitmap.getBitmapResource("btnAceptarReg.png");
	Bitmap btnAceptarReg1 	= Bitmap.getBitmapResource("btnAceptarReg1.png");
	Bitmap bordes = Bitmap.getBitmapResource("bordes_txt.png");
	
	Manager _contentOne;
	Manager _contentTwo;
	Manager _contentThree;

	Manager _bodyWrapper;
	Manager _currentBody;
	
	DateField dateField;
	DateField datetimeField;
	DateField ndatetimeField;
	
	String idLista;
	
	String ampm;
	String tiempo2;
	String tiempoHora;
	int tiempoN = 0;
	
	int veinticinco = 25;
	int veinte = 20;
	int trecientoscuarentaysiete = 347;
	
	//personalizacion
	int cinco	= 5;
	int diez	= 10;
	//int veinte	= 20;
	int cincuenta	= 50;
	
	AlertasComprasCx alertacompras;
	
	public AlertaListaCompras(String IdLista) {
		
		idLista = IdLista;
		
		alertacompras = new AlertasComprasCx(idLista);
		
		if (Display.getWidth() == 320) {

            getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_320.png")));
            tFuente = 15;
			tFuente2 = 20;
			veinticinco = 10;
			cinco 	= 0;
			diez 	= 5;
			veinte 	= 10;
			cincuenta = 20;
			trecientoscuarentaysiete = 176;
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
            tFuente = 20;
			tFuente2 = 30;
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

			ColorRichText emailCrt = new ColorRichText("Configuración de alertas",0xffffff, RichTextField.FIELD_HCENTER | RichTextField.TEXT_ALIGN_HCENTER);
			emailCrt.setFont(fTitle);
			emailCrt.setMargin(veinticinco, 0, veinticinco, 0);

			logoHfm.add(emailCrt);
			
			VerticalField footerLogoHfm = new VerticalField(Display.getWidth(),veinte,VerticalFieldManager.FIELD_HCENTER);
			footerLogoHfm.setBackground(BackgroundFactory.createLinearGradientBackground(0x9cbe4f, 0x7a9b3c, 0x7a9b3c, 0x9cbe4f));
			logoHfm.add(footerLogoHfm);
			
			add(logoHfm);
			
			
			//detalle
			VerticalField allContentDetalle = new VerticalField(Display.getWidth(),trecientoscuarentaysiete,HorizontalField.FIELD_HCENTER | VerticalField.VERTICAL_SCROLL | VerticalField.VERTICAL_SCROLLBAR);
			
			HorizontalFieldManager hfmTerminos = new HorizontalFieldManager();
			
			final CheckboxField cbTerminos = new CheckboxField("Deseo recibir notificaciones por correo electrónico sobre esta lista.", alertacompras.Check){
				
				protected void paint(Graphics g) {
					g.setColor(0xd16f2f);
				    g.setBackgroundColor(isFocus() ? 0x9cbe4f : 0xFFFFFF);
				    g.getFont();
				    g.clear();
				    super.paint(g);
				  }
				  protected void onFocus(int direction) {
				    invalidate();
				    super.onFocus(direction);
				  }
				  protected void onUnfocus() {
				    invalidate();
				    super.onUnfocus();
				  }
			};
			
			cbTerminos.setFont(fLite);
			cbTerminos.setMargin(veinte, 10, cinco, 10);
			
			cbTerminos.setChangeListener(new FieldChangeListener() {
				public void fieldChanged(Field field, int context) {
					if (cbTerminos.getChecked() == false) {
						alertacompras.modificarEstadoAlerta(idLista, "0");
						Status.show("Alerta desactivada.");
					}else if (cbTerminos.getChecked() == true) {
						alertacompras.modificarEstadoAlerta(idLista, "1");
						Status.show("Alerta activada.");
					}
				}
			});
			
			
			hfmTerminos.add(cbTerminos);
			
			allContentDetalle.add(hfmTerminos);
			
			VerticalFieldManager vfmPillButton = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER | HorizontalFieldManager.FIELD_HCENTER);
			
			PillButtonSet pills = new PillButtonSet();
			final PillButtonField pillOne = new PillButtonField( "Diario" );
			final PillButtonField pillTwo = new PillButtonField( "Semanal" );
			final PillButtonField pillThree = new PillButtonField( "Mensual" );
			pills.setMargin(10, 10, 10, 10);
			pills.add( pillOne );
	        pills.add( pillTwo );
	        pills.add( pillThree );
	        vfmPillButton.add( pills );
	        
	        allContentDetalle.add(vfmPillButton);
	        
	        _bodyWrapper = new NegativeMarginVerticalFieldManager( NegativeMarginVerticalFieldManager.FIELD_HCENTER | NegativeMarginHorizontalFieldManager.FIELD_HCENTER );
	        
	        _contentOne = new FlowFieldManager(FlowFieldManager.FIELD_HCENTER);
	        
	        RichTextField rtfTimeFormat = new RichTextField("Seleccionar hora:", RichTextField.TEXT_ALIGN_HCENTER);
	        rtfTimeFormat.setMargin(5,0,10,0);
	        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm aa");
	        //SimpleDateFormat timeFormat2 = new SimpleDateFormat("HH:mm");
	        //long date = System.currentTimeMillis();
	        if (alertacompras.errorCode.equals("0")) {
	        	int puntos = alertacompras.HoraS.indexOf(":");
		        int HoraSL		= Integer.parseInt(alertacompras.HoraS.substring(0,puntos));
		        int MinutoSL	= Integer.parseInt(alertacompras.HoraS.substring(3,5));
		        
		        Calendar c = Calendar.getInstance();
		        	if (HoraSL > 12) {
		        		HoraSL = HoraSL - 12;
		        		c.set(Calendar.HOUR, HoraSL);
		        		c.set(Calendar.MINUTE, MinutoSL);
		        		c.set(Calendar.AM_PM, 1);
		        	}else{
		        		c.set(Calendar.HOUR, HoraSL);
		        		c.set(Calendar.MINUTE, MinutoSL);
		        		c.set(Calendar.AM_PM, 0);
		        	}
			        
		        dateField = new DateField("", c.getTime().getTime(), timeFormat, DateField.FIELD_HCENTER | DrawStyle.HCENTER);
		        dateField.setMargin(10, 10, 10, 10);
	        } else if (alertacompras.errorCode.equals("1")) {
	        	long date = System.currentTimeMillis();
	        	dateField = new DateField("", date, timeFormat, DateField.FIELD_HCENTER | DrawStyle.HCENTER);
		        dateField.setMargin(10, 10, 10, 10);
	        }
	        
	        
	        btnAceptarRegUser = new BitmapButtonField(btnAceptarReg, btnAceptarReg1);
			btnAceptarRegUser.setChangeListener(new FieldChangeListener() {
				public void fieldChanged(Field field, int context) {
					if (cbTerminos.getChecked() == true) {
						String ampm = dateField.toString().substring(6, 8);
						//tiempo 11:50 - consubstring 3,5 obtiene :50
						String tiempo = dateField.toString().substring(0, 5);
						String tiempo2 = dateField.toString().substring(2, 5);
						//tiempoHora primero digitos 11
						String tiempoHora = dateField.toString().substring(0, 2);
						//tiempoN convertir el string a int de tiempoHora
						int tiempoN = 0;
						if (ampm.equals("PM")) {
							
							tiempoN = Integer.parseInt(tiempoHora);
							tiempoN = tiempoN + 12;
							if (tiempoN == 24) {
								//Dialog.alert("Aqui vacilando con el 24");
								alertacompras.validarAlertaCompras(idLista,"1","0","12"+tiempo2);
							}else{
								alertacompras.validarAlertaCompras(idLista,"1","0",Integer.toString(tiempoN)+tiempo2);
							}
							//Dialog.alert("HORA: "+idLista+"1"+"0"+Integer.toString(tiempoN)+tiempo2);
							
							//Dialog.alert(tiempo);
							//Dialog.alert(dateField.toString().substring(5, 8));
						}else if (ampm.equals("AM")) {
							//Dialog.alert("HORA: "+idLista+"1"+"0"+tiempo);
							tiempoN = Integer.parseInt(tiempoHora);
							if (tiempoN == 12) {
								//Dialog.alert("Aqui vacilando con el 24");
								alertacompras.validarAlertaCompras(idLista,"1","0","00"+tiempo2);
							}else{
								alertacompras.validarAlertaCompras(idLista,"1","0",Integer.toString(tiempoN)+tiempo2);
							}
							//alertacompras.validarAlertaCompras(idLista,"1","0",tiempo);
						}
					} else if (cbTerminos.getChecked() == false) {
						Dialog.alert("Para modificar esta alerta debe marcar la opción 'recibir notificaciones' en la parte de arriba");
					}
				}
			});
			//btnAceptarRegUser.setMargin(0, 10, 15, 0);
			//btnAceptarRegUser.setPadding(0,50,0,61);
			
	        
	        _contentOne.add(rtfTimeFormat);
	        _contentOne.add(dateField);
	        _contentOne.add(btnAceptarRegUser);
	        
	        //final String choiceTipoSondeo[] = {"Lunes", "Martes"};
	        //_contentOne.add(new ObjectChoiceField("Day of the week",choiceTipoSondeo));
	        
			
	        _contentTwo = new FlowFieldManager(FlowFieldManager.FIELD_HCENTER);
	        
	        RichTextField rtfDateTimeFormat = new RichTextField("Seleccionar día y hora:", RichTextField.TEXT_ALIGN_HCENTER);
	        rtfDateTimeFormat.setMargin(5,0,10,0);
	        SimpleDateFormat datetimeFormat = new SimpleDateFormat("EEEE hh:mm aa");
	        
	        if (alertacompras.errorCode.equals("0")) {
		        int puntos2 = alertacompras.HoraS.indexOf(":");
		        int HoraSL2		= Integer.parseInt(alertacompras.HoraS.substring(0,puntos2));
		        int MinutoSL2	= Integer.parseInt(alertacompras.HoraS.substring(3,5));
		        //int hola = alertacompras.HoraS.indexOf(":");
		        //Dialog.alert(">"+HoraSL+MinutoSL+"\n c"+alertacompras.HoraS.toString());
		        
		        Calendar c2 = Calendar.getInstance();
		        
		        	if (alertacompras.DiaS.equals("LU")) {
		        		c2.set(Calendar.DAY_OF_WEEK, 2);
		        	}else if (alertacompras.DiaS.equals("MA")) {
		        		c2.set(Calendar.DAY_OF_WEEK, 3);
		        	}else if (alertacompras.DiaS.equals("MI")) {
		        		c2.set(Calendar.DAY_OF_WEEK, 4);
		        	}else if (alertacompras.DiaS.equals("JU")) {
		        		c2.set(Calendar.DAY_OF_WEEK, 5);
		        	}else if (alertacompras.DiaS.equals("VI")) {
		        		c2.set(Calendar.DAY_OF_WEEK, 6);
		        	}else if (alertacompras.DiaS.equals("SA")) {
		        		c2.set(Calendar.DAY_OF_WEEK, 7);
		        	}else if (alertacompras.DiaS.equals("DO")) {
		        		c2.set(Calendar.DAY_OF_WEEK, 1);
		        	}
		        
		        	if (HoraSL2 > 12) {
		        		HoraSL2 = HoraSL2 - 12;
		        		c2.set(Calendar.HOUR, HoraSL2);
		        		c2.set(Calendar.MINUTE, MinutoSL2);
		        		c2.set(Calendar.AM_PM, 1);
		        		//Dialog.alert(">"+HoraSL);
		        	}else{
		        		c2.set(Calendar.HOUR, HoraSL2);
		        		c2.set(Calendar.MINUTE, MinutoSL2);
		        		c2.set(Calendar.AM_PM, 0);
		        		//Dialog.alert(">menor a doce "+HoraSL);
		        	}
		        	//c.set(Calendar.HOUR, 12);
		        datetimeField = new DateField("", c2.getTime().getTime(), datetimeFormat, DateField.FIELD_HCENTER | DrawStyle.HCENTER);
		        datetimeField.setMargin(10, 10, 10, 10);
	        } else if (alertacompras.errorCode.equals("1")) {
	        	long date2 = System.currentTimeMillis();
	        	datetimeField = new DateField("", date2, datetimeFormat, DateField.FIELD_HCENTER | DrawStyle.HCENTER);
		        datetimeField.setMargin(10, 10, 10, 10);
	        }
	        
	        btnAceptarRegUser = new BitmapButtonField(btnAceptarReg, btnAceptarReg1, BitmapButtonField.FIELD_HCENTER | DrawStyle.HCENTER);
			btnAceptarRegUser.setChangeListener(new FieldChangeListener() {
				public void fieldChanged(Field field, int context) {
					if (cbTerminos.getChecked() == true) {
						String dia = "";
						//Dialog.alert(">"+(datetimeField.toString().substring(0, 6).toString())+"<");
						if ((datetimeField.toString().substring(0, 5).equals("Lunes")) || (datetimeField.toString().substring(0, 6).equals("Monday"))) {
							Dialog.alert(">"+(datetimeField.toString().substring(0, 6).toString())+"<");
							dia = "LU";
							if ((datetimeField.toString().substring(0, 5).equals("Lunes"))) {
								ampm = datetimeField.toString().substring(12, 14);
								//tiempo 11:50 - consubstring 3,5 obtiene :50
								//String tiempo = datetimeField.toString();
								tiempo2 = datetimeField.toString().substring(8, 11);
								//tiempoHora primero digitos 11
								tiempoHora = datetimeField.toString().substring(6, 8);
								//tiempoN convertir el string a int de tiempoHora
								tiempoN = 0;
								//Dialog.alert(ampm+"\n"+tiempo+"\n >"+tiempo2+"< \n >"+tiempoHora+"<");
							} else {
								ampm = datetimeField.toString().substring(13, 15);
								tiempo2 = datetimeField.toString().substring(9, 12);
								tiempoHora = datetimeField.toString().substring(7, 9);
								tiempoN = 0;
							}
							
							if (ampm.equals("PM")) {
								tiempoN = Integer.parseInt(tiempoHora);
								tiempoN = tiempoN + 12;
								if (tiempoN == 24) {
									//Dialog.alert("24 "+idLista+"2"+dia+"12"+tiempo2);
									alertacompras.validarAlertaCompras(idLista,"2",dia,"12"+tiempo2);
								}else{
									//Dialog.alert("24 "+idLista+"2"+dia+Integer.toString(tiempoN)+tiempo2);
									alertacompras.validarAlertaCompras(idLista,"2",dia,Integer.toString(tiempoN)+tiempo2);
								}
								
							}else if (ampm.equals("AM")) {
								//Dialog.alert("HORA: "+idLista+"1"+"0"+tiempo);
								tiempoN = Integer.parseInt(tiempoHora);
								if (tiempoN == 12) {
									//Dialog.alert("24 "+idLista+"2"+dia+"00"+tiempo2);
									alertacompras.validarAlertaCompras(idLista,"2",dia,"00"+tiempo2);
								}else{
									//Dialog.alert("24 "+idLista+"2"+dia+Integer.toString(tiempoN)+tiempo2);
									alertacompras.validarAlertaCompras(idLista,"2",dia,Integer.toString(tiempoN)+tiempo2);
								}
								//alertacompras.validarAlertaCompras(idLista,"1","0",tiempo);
							}
						}else if ((datetimeField.toString().substring(0, 6).equals("Martes")) || (datetimeField.toString().substring(0, 7).equals("Tuesday"))) {
							dia = "MA";
							if ((datetimeField.toString().substring(0, 6).equals("Martes"))) {
								ampm = datetimeField.toString().substring(13, 15);
								//tiempo 11:50 - consubstring 3,5 obtiene :50						
								tiempo2 = datetimeField.toString().substring(9, 12);
								//tiempoHora primero digitos 11
								tiempoHora = datetimeField.toString().substring(7, 9);
								//tiempoN convertir el string a int de tiempoHora
								tiempoN = 0;
							} else {
								ampm = datetimeField.toString().substring(14, 16);		
								tiempo2 = datetimeField.toString().substring(10, 13);
								tiempoHora = datetimeField.toString().substring(8, 10);
								tiempoN = 0;
							}
							
							if (ampm.equals("PM")) {
								tiempoN = Integer.parseInt(tiempoHora);
								tiempoN = tiempoN + 12;
								if (tiempoN == 24) {
									alertacompras.validarAlertaCompras(idLista,"2",dia,"12"+tiempo2);
								}else{
									alertacompras.validarAlertaCompras(idLista,"2",dia,Integer.toString(tiempoN)+tiempo2);
								}
								
							}else if (ampm.equals("AM")) {
								
								tiempoN = Integer.parseInt(tiempoHora);
								if (tiempoN == 12) {
									alertacompras.validarAlertaCompras(idLista,"2",dia,"00"+tiempo2);
								}else{
									alertacompras.validarAlertaCompras(idLista,"2",dia,Integer.toString(tiempoN)+tiempo2);
								}
							}
						}else if ((datetimeField.toString().substring(0, 9).equals("Miércoles")) || (datetimeField.toString().substring(0, 9).equals("Wednesday"))) {
							dia = "MI";
							String ampm = datetimeField.toString().substring(16, 18);
							//tiempo 11:50 - consubstring 3,5 obtiene :50						
							String tiempo2 = datetimeField.toString().substring(12, 15);
							//tiempoHora primero digitos 11
							String tiempoHora = datetimeField.toString().substring(10, 12);
							//tiempoN convertir el string a int de tiempoHora
							int tiempoN = 0;
							
							if (ampm.equals("PM")) {
								tiempoN = Integer.parseInt(tiempoHora);
								tiempoN = tiempoN + 12;
								if (tiempoN == 24) {
									alertacompras.validarAlertaCompras(idLista,"2",dia,"12"+tiempo2);
								}else{
									alertacompras.validarAlertaCompras(idLista,"2",dia,Integer.toString(tiempoN)+tiempo2);
								}							
							}else if (ampm.equals("AM")) {							
								tiempoN = Integer.parseInt(tiempoHora);
								if (tiempoN == 12) {
									alertacompras.validarAlertaCompras(idLista,"2",dia,"00"+tiempo2);
								}else{
									alertacompras.validarAlertaCompras(idLista,"2",dia,Integer.toString(tiempoN)+tiempo2);
								}
							}
						}else if ((datetimeField.toString().substring(0, 6).equals("Jueves")) || (datetimeField.toString().substring(0, 8).equals("Thursday"))) {
							dia = "JU";
							if ((datetimeField.toString().substring(0, 6).equals("Jueves"))) {
								ampm = datetimeField.toString().substring(13, 15);
								//tiempo 11:50 - consubstring 3,5 obtiene :50						
								tiempo2 = datetimeField.toString().substring(9, 12);
								//tiempoHora primero digitos 11
								tiempoHora = datetimeField.toString().substring(7, 9);
								//tiempoN convertir el string a int de tiempoHora
								tiempoN = 0;
							} else {
								ampm = datetimeField.toString().substring(15, 17);		
								tiempo2 = datetimeField.toString().substring(11, 14);
								tiempoHora = datetimeField.toString().substring(9, 11);
								tiempoN = 0;
							}
							
							if (ampm.equals("PM")) {
								tiempoN = Integer.parseInt(tiempoHora);
								tiempoN = tiempoN + 12;
								if (tiempoN == 24) {
									alertacompras.validarAlertaCompras(idLista,"2",dia,"12"+tiempo2);
								}else{
									alertacompras.validarAlertaCompras(idLista,"2",dia,Integer.toString(tiempoN)+tiempo2);
								}
								
							}else if (ampm.equals("AM")) {
								
								tiempoN = Integer.parseInt(tiempoHora);
								if (tiempoN == 12) {
									alertacompras.validarAlertaCompras(idLista,"2",dia,"00"+tiempo2);
								}else{
									alertacompras.validarAlertaCompras(idLista,"2",dia,Integer.toString(tiempoN)+tiempo2);
								}
							}
						}else if ((datetimeField.toString().substring(0, 7).equals("Viernes")) || (datetimeField.toString().substring(0, 6).equals("Friday"))) {
							dia = "VI";
							if ((datetimeField.toString().substring(0, 7).equals("Viernes"))) {
								ampm = datetimeField.toString().substring(14, 16);
								//tiempo 11:50 - consubstring 3,5 obtiene :50						
								tiempo2 = datetimeField.toString().substring(10, 13);
								//tiempoHora primero digitos 11
								tiempoHora = datetimeField.toString().substring(8, 10);
								//tiempoN convertir el string a int de tiempoHora
								tiempoN = 0;
							} else {
								ampm = datetimeField.toString().substring(13, 15);					
								tiempo2 = datetimeField.toString().substring(9, 12);
								tiempoHora = datetimeField.toString().substring(7, 9);
								tiempoN = 0;
							}
							
							if (ampm.equals("PM")) {
								tiempoN = Integer.parseInt(tiempoHora);
								tiempoN = tiempoN + 12;
								if (tiempoN == 24) {
									alertacompras.validarAlertaCompras(idLista,"2",dia,"12"+tiempo2);
								}else{
									alertacompras.validarAlertaCompras(idLista,"2",dia,Integer.toString(tiempoN)+tiempo2);
								}
								
							}else if (ampm.equals("AM")) {
								
								tiempoN = Integer.parseInt(tiempoHora);
								if (tiempoN == 12) {
									alertacompras.validarAlertaCompras(idLista,"2",dia,"00"+tiempo2);
								}else{
									alertacompras.validarAlertaCompras(idLista,"2",dia,Integer.toString(tiempoN)+tiempo2);
								}
							}
						}else if ((datetimeField.toString().substring(0, 6).equals("Sábado")) || (datetimeField.toString().substring(0, 8).equals("Saturday"))) {
							dia = "SA";
							if ((datetimeField.toString().substring(0, 6).equals("Sábado"))) {
								ampm = datetimeField.toString().substring(13, 15);
								//tiempo 11:50 - consubstring 3,5 obtiene :50						
								tiempo2 = datetimeField.toString().substring(9, 12);
								//tiempoHora primero digitos 11
								tiempoHora = datetimeField.toString().substring(7, 9);
								//tiempoN convertir el string a int de tiempoHora
								tiempoN = 0;
							} else {
								ampm = datetimeField.toString().substring(15, 17);				
								tiempo2 = datetimeField.toString().substring(11, 14);
								tiempoHora = datetimeField.toString().substring(9, 11);
								tiempoN = 0;
							}
							
							if (ampm.equals("PM")) {
								tiempoN = Integer.parseInt(tiempoHora);
								tiempoN = tiempoN + 12;
								if (tiempoN == 24) {
									alertacompras.validarAlertaCompras(idLista,"2",dia,"12"+tiempo2);
								}else{
									alertacompras.validarAlertaCompras(idLista,"2",dia,Integer.toString(tiempoN)+tiempo2);
								}
								
							}else if (ampm.equals("AM")) {
								
								tiempoN = Integer.parseInt(tiempoHora);
								if (tiempoN == 12) {
									alertacompras.validarAlertaCompras(idLista,"2",dia,"00"+tiempo2);
								}else{
									alertacompras.validarAlertaCompras(idLista,"2",dia,Integer.toString(tiempoN)+tiempo2);
								}
							}
						}else if ((datetimeField.toString().substring(0, 7).equals("Domingo")) || (datetimeField.toString().substring(0, 6).equals("Sunday"))) {
							dia = "DO";
							if ((datetimeField.toString().substring(0, 7).equals("Domingo"))) {
								ampm = datetimeField.toString().substring(14, 16);
								//tiempo 11:50 - consubstring 3,5 obtiene :50						
								tiempo2 = datetimeField.toString().substring(10, 13);
								//tiempoHora primero digitos 11
								tiempoHora = datetimeField.toString().substring(8, 10);
								//tiempoN convertir el string a int de tiempoHora
								tiempoN = 0;
							} else {
								ampm = datetimeField.toString().substring(13, 15);				
								tiempo2 = datetimeField.toString().substring(9, 12);
								tiempoHora = datetimeField.toString().substring(7, 9);
								tiempoN = 0;
							}
							
							if (ampm.equals("PM")) {
								tiempoN = Integer.parseInt(tiempoHora);
								tiempoN = tiempoN + 12;
								if (tiempoN == 24) {
									alertacompras.validarAlertaCompras(idLista,"2",dia,"12"+tiempo2);
								}else{
									alertacompras.validarAlertaCompras(idLista,"2",dia,Integer.toString(tiempoN)+tiempo2);
								}
								
							}else if (ampm.equals("AM")) {
								
								tiempoN = Integer.parseInt(tiempoHora);
								if (tiempoN == 12) {
									alertacompras.validarAlertaCompras(idLista,"2",dia,"00"+tiempo2);
								}else{
									alertacompras.validarAlertaCompras(idLista,"2",dia,Integer.toString(tiempoN)+tiempo2);
								}
							}
						}
					} else if (cbTerminos.getChecked() == false) {
						Dialog.alert("¡Debes aceptar recibir notificaciones para guardar una alerta!");
					}
				}
				
			});
			//btnAceptarRegUser.setMargin(0, 10, 15, 0);
			//btnAceptarRegUser.setPadding(0,50,0,61);
	        
	        _contentTwo.add(rtfDateTimeFormat);
	        _contentTwo.add(datetimeField);
	        _contentTwo.add(btnAceptarRegUser);
	        
	        
	        _contentThree = new FlowFieldManager(FlowFieldManager.FIELD_HCENTER);
	        
	        RichTextField rtfNDateTimeFormat = new RichTextField("Seleccionar día del mes y hora:", RichTextField.TEXT_ALIGN_HCENTER);
	        rtfNDateTimeFormat.setMargin(5,0,10,0);
	        SimpleDateFormat ndatetimeFormat = new SimpleDateFormat("dd hh:mm aa");
	        
	        if (alertacompras.errorCode.equals("0")) {
		        int puntos3 	= alertacompras.HoraS.indexOf(":");
		        int HoraSL3		= Integer.parseInt(alertacompras.HoraS.substring(0,puntos3));
		        int MinutoSL3	= Integer.parseInt(alertacompras.HoraS.substring(3,5));
		        //int puntos4 	= alertacompras.DiaS.indexOf(" ");
		        int DiaSL3 = 00;
		        if (alertacompras.idTipoN.equals("3")) {
		        	DiaSL3	= Integer.parseInt(alertacompras.DiaS.substring(0,2));
		        }
		        
		        Calendar c3 = Calendar.getInstance();
		        	
		        	c3.set(Calendar.DATE, DiaSL3);
		        	if (HoraSL3 > 12) {
		        		HoraSL3 = HoraSL3 - 12;
		        		c3.set(Calendar.HOUR, HoraSL3);
		        		c3.set(Calendar.MINUTE, MinutoSL3);
		        		c3.set(Calendar.AM_PM, 1);
		        		//Dialog.alert(">"+HoraSL);
		        	}else{
		        		c3.set(Calendar.HOUR, HoraSL3);
		        		c3.set(Calendar.MINUTE, MinutoSL3);
		        		c3.set(Calendar.AM_PM, 0);
		        		//Dialog.alert(">menor a doce "+HoraSL);
		        	}
		        ndatetimeField = new DateField("", c3.getTime().getTime(), ndatetimeFormat, DateField.FIELD_HCENTER | DrawStyle.HCENTER);
		        ndatetimeField.setMargin(10, 10, 10, 10);
		        
	        } else if (alertacompras.errorCode.equals("1")) {
	        	long date3 = System.currentTimeMillis();
	        	ndatetimeField = new DateField("", date3, ndatetimeFormat, DateField.FIELD_HCENTER | DrawStyle.HCENTER);
		        ndatetimeField.setMargin(10, 10, 10, 10);
	        }
	        
	        btnAceptarRegUser = new BitmapButtonField(btnAceptarReg, btnAceptarReg1, Field.FIELD_HCENTER);
			btnAceptarRegUser.setChangeListener(new FieldChangeListener() {
				public void fieldChanged(Field field, int context) {
					if (cbTerminos.getChecked() == true) {
						String ampm = ndatetimeField.toString().substring(9, 11);
						//tiempo 11:50 - consubstring 3,5 obtiene :50
						String tiempo2 = ndatetimeField.toString().substring(5, 8);
						//tiempoHora primero digitos 11
						String tiempoHora = ndatetimeField.toString().substring(3, 5);
						//tiempo# primero digitos 31
						String tiempoNumero = ndatetimeField.toString().substring(0, 2);
						//tiempoN convertir el string a int de tiempoHora
						int tiempoN = 0;
						
						if (ampm.equals("PM")) {
							tiempoN = Integer.parseInt(tiempoHora);
							tiempoN = tiempoN + 12;
							if (tiempoN == 24) {
								alertacompras.validarAlertaCompras(idLista,"3",tiempoNumero,"12"+tiempo2);
							}else{
								alertacompras.validarAlertaCompras(idLista,"3",tiempoNumero,Integer.toString(tiempoN)+tiempo2);
							}
							
						}else if (ampm.equals("AM")) {
							tiempoN = Integer.parseInt(tiempoHora);
							if (tiempoN == 12) {
								alertacompras.validarAlertaCompras(idLista,"3",tiempoNumero,"00"+tiempo2);
							}else{
								alertacompras.validarAlertaCompras(idLista,"3",tiempoNumero,Integer.toString(tiempoN)+tiempo2);
							}
						}
					
					} else if (cbTerminos.getChecked() == false) {
						Dialog.alert("¡Debes aceptar recibir notificaciones para guardar una alerta!");
					}
				}
			});
			//btnAceptarRegUser.setMargin(0, 10, 15, 0);
			//btnAceptarRegUser.setPadding(0,50,0,61);
	        
	        _contentThree.add(rtfNDateTimeFormat);
	        _contentThree.add(ndatetimeField);
	        _contentThree.add(btnAceptarRegUser);
	        
	        if (alertacompras.errorCode.equals("0")) {
	        	if (alertacompras.idTipoN.equals("1")) {
					pills.setSelectedField( pillOne );
		        	_currentBody = _contentOne;
		        	_bodyWrapper.add( _currentBody );
				}else if (alertacompras.idTipoN.equals("2")) {
					pills.setSelectedField( pillTwo );
		        	_currentBody = _contentTwo;
		        	_bodyWrapper.add( _currentBody );
				}else if (alertacompras.idTipoN.equals("3")) {
					pills.setSelectedField( pillThree );
		        	_currentBody = _contentThree;
		        	_bodyWrapper.add( _currentBody );
				}
	        } else if (alertacompras.errorCode.equals("1")) {
	        	pills.setSelectedField( pillOne );
	        	_currentBody = _contentOne;
	        	_bodyWrapper.add( _currentBody );
	        }
			
	        
	        
	        pillOne.setChangeListener( new FieldChangeListener( ) {
	            public void fieldChanged( Field field, int context ) {
	                if( _currentBody != _contentOne ) {
	        	           _bodyWrapper.replace( _currentBody, _contentOne );
	        	           _currentBody = _contentOne;
	                }
	            }
	        } );
	                
	        pillTwo.setChangeListener( new FieldChangeListener( ) {
	            public void fieldChanged( Field field, int context ) {
	                if( _currentBody != _contentTwo ) {
	        	           _bodyWrapper.replace( _currentBody, _contentTwo );
	        	           _currentBody = _contentTwo;
	                }
	            }
	        } );
	                
	        pillThree.setChangeListener( new FieldChangeListener( ) {
	            public void fieldChanged( Field field, int context ) {
	                if( _currentBody != _contentThree ) {
	        	           _bodyWrapper.replace( _currentBody, _contentThree );
	        	           _currentBody = _contentThree;
	                }
	            }
	        } );
	        
	        allContentDetalle.add( _bodyWrapper );
	        //add( allContentDetalle );
	        
			/*BitmapButtonField btnAceptarRegUser = new BitmapButtonField(btnAceptarReg, btnAceptarReg1, Field.FIELD_HCENTER);
			btnAceptarRegUser.setChangeListener(new FieldChangeListener() {
				public void fieldChanged(Field field, int context) {
					
					//UiApplication.getUiApplication().pushScreen(new VerMapa(latitud, longitud, establecimiento));
				}
			});
			btnAceptarRegUser.setMargin(0, 10, 15, 0);

			allContentDetalle.add(btnAceptarRegUser);*/

			add(allContentDetalle);
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			add(new RichTextField(e.getMessage()));
		}
		
		
	}
	
	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		
	}

}
