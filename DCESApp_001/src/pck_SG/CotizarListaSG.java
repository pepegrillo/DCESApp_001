package pck_SG;

import java.util.Vector;

public class CotizarListaSG {
	
	 Vector idEstablecimiento		= new Vector();
	 Vector nombre				= new Vector();
	 Vector montoTotal			= new Vector();
	 Vector altitud				= new Vector();
	 Vector longitud				= new Vector();
	 Vector estadoCompleto		= new Vector();
	
	String errorCode 		= new String();
	String errorMessage 	= new String();
	
	String hashKey = new String();
	
	public CotizarListaSG(){
		
	}
	
	public CotizarListaSG(Vector idEstablecimiento, Vector nombre, Vector montoTotal, Vector altitud, Vector longitud, Vector estadoCompleto, String errorCode, String errorMessage){
		
		super();
		this.idEstablecimiento   		= idEstablecimiento;
		this.nombre						= nombre;
		this.montoTotal   				= montoTotal;
		this.altitud					= altitud;
		this.longitud   				= longitud;
		this.estadoCompleto				= estadoCompleto;
		
		this.errorCode    = errorCode;
		this.errorMessage = errorMessage;
		
	}

	public Vector getIdEstablecimiento() {
		return idEstablecimiento;
	}

	public void setIdEstablecimiento(Vector idEstablecimiento) {
		this.idEstablecimiento = idEstablecimiento;
	}

	public Vector getNombre() {
		return nombre;
	}

	public void setNombre(Vector nombre) {
		this.nombre = nombre;
	}

	public Vector getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(Vector montoTotal) {
		this.montoTotal = montoTotal;
	}

	public Vector getAltitud() {
		return altitud;
	}

	public void setAltitud(Vector altitud) {
		this.altitud = altitud;
	}

	public Vector getLongitud() {
		return longitud;
	}

	public void setLongitud(Vector longitud) {
		this.longitud = longitud;
	}

	public Vector getEstadoCompleto() {
		return estadoCompleto;
	}

	public void setEstadoCompleto(Vector estadoCompleto) {
		this.estadoCompleto = estadoCompleto;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getHashKey() {
		return hashKey;
	}

	public void setHashKey(String hashKey) {
		this.hashKey = hashKey;
	}
	
	

}
