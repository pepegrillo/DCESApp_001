package pck_SG;

import java.util.Vector;

public class AgregarEstablecimientoComprasSG {
	
	public Vector IdEstablecimiento			= new Vector();
	public Vector NombreEstablecimiento		= new Vector();
	public Vector DireccionEstablecimiento	= new Vector();
	
	String errorCode 		= new String();
	String errorMessage 	= new String();
	
	
	public AgregarEstablecimientoComprasSG(){
		
	}
	
	public AgregarEstablecimientoComprasSG(Vector IdEstablecimiento, Vector NombreEstablecimiento, Vector DireccionEstablecimiento,  String errorCode, String errorMessage, String errorRutaCompras){
		
		super();
		this.IdEstablecimiento   		= IdEstablecimiento;
		this.NombreEstablecimiento		= NombreEstablecimiento;
		this.DireccionEstablecimiento	= DireccionEstablecimiento;
		
		this.errorCode    = errorCode;
		this.errorMessage = errorMessage;
		
		
		
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
	public Vector getDireccionEstablecimiento() {
		return DireccionEstablecimiento;
	}
	public void setDireccionEstablecimiento(Vector DireccionEstablecimiento) {
		this.DireccionEstablecimiento = DireccionEstablecimiento;
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
	
	

}
