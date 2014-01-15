package pck_SG;

import java.util.Vector;

public class ProductoSG {
	
	Vector idProducto   = new Vector();
	Vector nombre       = new Vector();
	
	String errorCode 	= new String();
	String errorMessage = new String();
	
	public ProductoSG(){
		
	}
	
	public ProductoSG(Vector idProducto, Vector nombre, String errorCode, String errorMessage){
		
		super();
		this.idProducto   = idProducto;
		this.nombre       = nombre;
		this.errorCode    = errorCode;
		this.errorMessage = errorMessage;
		
	}
	
	public Vector getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Vector idProducto) {
		this.idProducto = idProducto;
	}
	public Vector getNombre() {
		return nombre;
	}
	public void setNombre(Vector nombre) {
		this.nombre = nombre;
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
