package pck_WS;

import net.rim.device.api.database.Cursor;
import net.rim.device.api.database.Database;
import net.rim.device.api.database.DatabaseFactory;
import net.rim.device.api.database.Row;
import net.rim.device.api.database.Statement;
import net.rim.device.api.io.URI;
import pck_SG.ValidarRutaListaComprasSG;
import configurations.DbSql;

public class ValidarRutaListaCompras {
	
	DbSql path = new DbSql();
	DbSql statement = new DbSql();
	private int incremento;
	private int incremento_p;
	
	public String errorRutaCompras	   = new String();
	public String errorProductoCompras = new String();
	
	ValidarRutaListaComprasSG validarRuta = new ValidarRutaListaComprasSG();
	
	public ValidarRutaListaCompras(String idLista){
		try{
			URI uri = URI.create(path.Path());
			Database sqliteDB = DatabaseFactory.open(uri);
	
	  		Statement selectR = sqliteDB.createStatement(statement.SelectRutaComprasValidar(idLista));
	  		selectR.prepare();
	  		Cursor cursorR = selectR.getCursor();
	  		Row rc;
	  		//int i = 0;
	  		while(cursorR.next()){
	  			rc = cursorR.getRow();
	     	    incremento++;
	  		}
	  		selectR.close();
	  		cursorR.close();
	  		
	  		Statement selectRV = sqliteDB.createStatement(statement.SelectProductoComprasValidar(idLista));
	  		selectRV.prepare();
	  		Cursor cursorRV = selectRV.getCursor();
	  		Row rcV;
	  		//int i = 0;
	  		while(cursorRV.next()){
	  			rcV = cursorRV.getRow();
	     	    incremento_p++;
	  		}
	  		selectRV.close();
	  		cursorRV.close();
	  		
	  		sqliteDB.close();
	  		
	  		if ((incremento == 0)) {
	  			//Debes agregar establecimientos a la ruta de compras.
	  			errorRutaCompras 	 = "0";
	  			
	  			//Dialog.alert("Debes agregar establecimientos en ruta de compras para agregar productos.");
	  		}else if ((incremento > 0)) {
	  			errorRutaCompras = "1";
	  			
	  		}
	  		
	  		if ((incremento_p == 0)) {
	  			//Debes agregar establecimientos a la ruta de compras.
	  			
	  			errorProductoCompras = "0";
	  			//Dialog.alert("Debes agregar establecimientos en ruta de compras para agregar productos.");
	  		}else if ((incremento_p > 0)) {
	  			
	  			errorProductoCompras = "1";
	  		}
	  		
		} catch (Exception e) {
			// TODO: handle exception
			errorRutaCompras	 = "0";
			errorProductoCompras = "0";
		}finally{
			validarRuta.seterrorRutaCompras(errorRutaCompras);
			validarRuta.setErrorProductoCompras(errorProductoCompras);
		}
	}
	
	

}
