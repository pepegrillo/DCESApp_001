package pck_SG;

import java.util.Vector;

public class ListaComprasSG {
	
	public Vector IdLista   	= new Vector();
	public Vector NombreLista   = new Vector();
	
	String errorCode 		= new String();
	String errorMessage 	= new String();
	String IdListaReturn 	= new String();
	
	String hashKey = new String();
	
	public ListaComprasSG(){
		
	}
	
	public ListaComprasSG(Vector IdLista, Vector NombreLista, String errorCode, String errorMessage, String hashkey, String idlistareturn){
		
		super();
		this.IdLista   		= IdLista;
		this.NombreLista	= NombreLista;
		
		this.errorCode    = errorCode;
		this.errorMessage = errorMessage;
		this.IdListaReturn = idlistareturn;
		
		this.hashKey	  = hashkey;
		
	}
	
	public Vector getIdLista() {
		return IdLista;
	}
	public void setIdLista(Vector IdLista) {
		this.IdLista = IdLista;
	}
	public Vector getNombreLista() {
		return NombreLista;
	}
	public void setNombreLista(Vector NombreLista) {
		this.NombreLista = NombreLista;
	}
	
	public String geterrorCode() {
		return errorCode;
	}
	public void seterrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String geterrorMessage() {
		return errorMessage;
	}
	public void seterrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getIdListaReturn() {
		return IdListaReturn;
	}
	public void setIdListaReturn(String idlistareturn) {
		this.IdListaReturn = idlistareturn;
	}

	public String gethashKey() {
		return hashKey;
	}
	public void sethashKey(String hashKey) {
		this.hashKey = hashKey;
	}

}
