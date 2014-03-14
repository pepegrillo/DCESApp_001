package pck_SG;

import java.util.Vector;

public class RutaComprasSG {
	
	public Vector IdEstablecimiento   	  = new Vector();
	public Vector NombreEstablecimiento   = new Vector();
	
	String errorCode 	= new String();
	String errorMessage = new String();
	
	String hashKey = new String();
	
	public RutaComprasSG(){
		
	}
	
	public RutaComprasSG(Vector IdEstablecimiento, Vector NombreEstablecimiento, String errorCode, String errorMessage, String hashkey){
		
		super();
		this.IdEstablecimiento   		= IdEstablecimiento;
		this.NombreEstablecimiento		= NombreEstablecimiento;
		
		this.errorCode    = errorCode;
		this.errorMessage = errorMessage;
		
		this.hashKey	  = hashkey;
		
	}
	
	public Vector getIdEstablecimiento() {
		return IdEstablecimiento;
	}
	public void setIdEstablecimiento(Vector IdEstablecimiento) {
		this.IdEstablecimiento = IdEstablecimiento;
	}
	public Vector getNombreEstablecimiento() {
		return NombreEstablecimiento;
	}
	public void setNombreEstablecimiento(Vector NombreEstablecimiento) {
		this.NombreEstablecimiento = NombreEstablecimiento;
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

	public String gethashKey() {
		return hashKey;
	}
	public void sethashKey(String hashKey) {
		this.hashKey = hashKey;
	}

}
