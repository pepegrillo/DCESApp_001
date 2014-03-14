package pck_SG;

import java.util.Vector;

public class ProductoComprasSG {
	
	Vector IdArticulo		= new Vector();
	Vector NombreArticulo	= new Vector();
	Vector MarcaArticulo	= new Vector();
	
	String errorCode 	= new String();
	String errorMessage = new String();
	
	String hashKey = new String();
	
	public ProductoComprasSG(){
		
	}
	
	public ProductoComprasSG(Vector IdArticulo, Vector NombreArticulo, Vector MarcaArticulo, String errorCode, String errorMessage, String hashkey){
		
		super();
		this.IdArticulo   		= IdArticulo;
		this.NombreArticulo		= NombreArticulo;
		this.MarcaArticulo		= MarcaArticulo;
		
		this.errorCode    = errorCode;
		this.errorMessage = errorMessage;
		
		this.hashKey	  = hashkey;
		
	}
	
	
	
	public Vector getIdArticulo() {
		return IdArticulo;
	}

	public void setIdArticulo(Vector idArticulo) {
		IdArticulo = idArticulo;
	}

	public Vector getNombreArticulo() {
		return NombreArticulo;
	}

	public void setNombreArticulo(Vector nombreArticulo) {
		NombreArticulo = nombreArticulo;
	}

	public Vector getMarcaArticulo() {
		return MarcaArticulo;
	}

	public void setMarcaArticulo(Vector marcaArticulo) {
		MarcaArticulo = marcaArticulo;
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
