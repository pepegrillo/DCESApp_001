package pck_SG;

import java.util.Vector;

public class FiltroSG {
	
	Vector IdMunicipio = new Vector();
	Vector Municipio   = new Vector();
	
	String errorCode 	= new String();
	String errorMessage = new String();
	
	public FiltroSG(){
		
	}
	
	public FiltroSG(Vector IdMunicipio, Vector Municipio, String errorCode, String errorMessage){
		
		super();
		this.IdMunicipio = IdMunicipio;
		this.Municipio   = Municipio;
		this.errorCode    = errorCode;
		this.errorMessage = errorMessage;
		
	}

	public Vector getIdMunicipio(){
		return IdMunicipio;
	}
	public void setIdMunicipio(Vector IdMunicipio){
		this.IdMunicipio = IdMunicipio;
	}
	
	public Vector getMunicipio(){
		return Municipio;
	}
	public void setMunicipio(Vector Municipio){
		this.Municipio = Municipio;
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
