package pck_SG;

import java.util.Vector;

public class MunicipioComprasSG {
	
	public Vector IdMunicipio		= new Vector();
	public Vector NombreMunicipio	= new Vector();
	
	String errorCode 	= new String();
	String errorMessage = new String();
	
	String hashKey = new String();
	
	public MunicipioComprasSG(){
		
	}
	
	public MunicipioComprasSG(Vector IdMunicipio, Vector NombreMunicipio, String errorCode, String errorMessage){
		
		super();
		this.IdMunicipio   		= IdMunicipio;
		this.NombreMunicipio		= NombreMunicipio;
		
		this.errorCode    = errorCode;
		this.errorMessage = errorMessage;
		
		
	}
	
	public Vector getIdMunicipio() {
		return IdMunicipio;
	}
	public void setIdMunicipio(Vector IdMunicipio) {
		this.IdMunicipio = IdMunicipio;
	}
	public Vector getNombreMunicipio() {
		return NombreMunicipio;
	}
	public void setNombreMunicipio(Vector NombreMunicipio) {
		this.NombreMunicipio = NombreMunicipio;
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
