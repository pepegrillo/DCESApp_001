package pck_WS;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.microedition.io.HttpConnection;

import net.rim.device.api.database.Cursor;
import net.rim.device.api.database.Database;
import net.rim.device.api.database.DatabaseFactory;
import net.rim.device.api.database.Row;
import net.rim.device.api.database.Statement;
import net.rim.device.api.io.URI;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.Status;

import org.json.me.JSONObject;

import pck_SG.AgregarEstablecimientoComprasSG;
import configurations.ConexionController;
import configurations.DbSql;
import configurations.Metodo;
import configurations.Strings;

public class AgregarEstablecimientoComprasPx {
	
	private HttpConnection conn;
	private InputStream is;
	private ByteArrayOutputStream bos;
	
	String tipoConexion = ConexionController.getConnectionString()[0];
	String getTipo = ConexionController.getConnectionString()[1];
	Metodo request = new Metodo();
	
	DbSql path = new DbSql();
	DbSql statement = new DbSql();
	
	String HashKey;
	int incremento;
	
	public String errorCode    		= new String();
	public String errorMessage 		= new String();
	
	public String errorRutaCompras 	= new String();
	
	
	AgregarEstablecimientoComprasSG agregarestablecimientocompras = new AgregarEstablecimientoComprasSG();
	
	
	
	public void postEstablecimientosCompras(String IdLista, String IdEstablecimiento){
		

		try{
			Status.show("Agregando establecimiento. Espera un momento...");
			URI uri = URI.create(path.Path());
			Database sqliteDB = DatabaseFactory.open(uri);

      		Statement selectR = sqliteDB.createStatement(statement.SelectUserHashKey());
      		selectR.prepare();
      		Cursor cursorR = selectR.getCursor();
      		Row rc;
      		//int i = 0;
      		while(cursorR.next()){
      			rc = cursorR.getRow();
         	    HashKey = rc.getString(0);
      		}
      		selectR.close();
      		cursorR.close();
      		sqliteDB.close();
			
			String url = Strings.HTTP_SW+"postGuardarEstablecimientosLista"+tipoConexion;
			String json = "'idLista'		: '"+IdLista.toString()+"'," +
						"'idEstablecimiento': '"+IdEstablecimiento.toString()+"'," +
						"'hashKey'			: '"+HashKey.toString()+"'";
			//Dialog.alert(json);
			String response = request.POST(url,json);
	            
	            JSONObject objeto1 =  new  JSONObject ( response );
	            String resultado1  = objeto1.getString("response");
	            //Dialog.alert(resultado1+"<<");
	            JSONObject objeto2 =  new  JSONObject ( resultado1 );
	            errorCode    = objeto2.getString("errorCode");
	            errorMessage = objeto2.getString("errorMessage");
	            
	            if(errorCode.equals("0")){
	            	//Dialog.alert(objeto2.getString("errorMessage"));
	            	Status.show("Establecimiento agregado satisfactoriamente.");
	            }else if (errorCode.equals("1")){
		            errorMessage = "En este momento no se pueden \n mostrar datos " +
		            		"intentelo de nuevo";	            	
	            }else if(errorCode.equals("5")){
	            	Status.show("El establecimiento seleccionado ya se encuentra agregado.");
	            }else if(errorCode.equals("8")){
	            	Status.show("El establecimiento seleccionado ya se encuentra agregado.");
	            }else{
	            	Dialog.alert("Ha ocurrido algo inesperado, inténtelo de nuevo.");
	            }
	            
	            
	        
	            
	        }catch (Exception e) {
				// TODO: handle exception
	        	errorMessage = "En este momento no se pueden \n mostrar datos " +
	            		"intentelo de nuevo más tarde";
			}finally{
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
			
			agregarestablecimientocompras.seterrorCode(errorCode);
			agregarestablecimientocompras.seterrorMessage(errorMessage);
		
	}
	

}
	

