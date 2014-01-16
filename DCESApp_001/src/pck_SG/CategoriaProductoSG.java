package pck_SG;

import java.util.Vector;

public class CategoriaProductoSG {
	
	Vector idCategoria   = new Vector();
	Vector categoria     = new Vector();
	
	String errorCode 	= new String();
	String errorMessage = new String();
	
	public CategoriaProductoSG(){
		
	}
	
	public CategoriaProductoSG(Vector idCategoria, Vector categoria){
		
		super();
		this.idCategoria = idCategoria;
		this.categoria = categoria;
		this.errorCode    = errorCode;
		this.errorMessage = errorMessage;
		
	}
	
	public Vector getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Vector idCategoria) {
		this.idCategoria = idCategoria;
	}
	public Vector getCategoria() {
		return categoria;
	}
	public void setCategoria(Vector categoria) {
		this.categoria = categoria;
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
