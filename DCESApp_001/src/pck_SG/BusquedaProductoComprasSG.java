package pck_SG;

import java.util.Vector;

public class BusquedaProductoComprasSG {
	
	Vector IdArticulo			= new Vector();
	Vector NombreArticulo		= new Vector();
	Vector MarcaArticulo		= new Vector();
	Vector PresentacionArticulo	= new Vector();
	Vector PrecioArticulo		= new Vector();
	
	String errorCode 	= new String();
	String errorMessage = new String();
	
	String hashKey = new String();
	
	public BusquedaProductoComprasSG(){
		
	}
	
	public BusquedaProductoComprasSG(Vector idArticulo, Vector nombreArticulo, Vector marcaArticulo, Vector presentacionArticulo, Vector precioArticulo, String errorCode, String errorMessage, String hashkey){
		
		super();
		this.IdArticulo   			= idArticulo;
		this.NombreArticulo			= nombreArticulo;
		this.MarcaArticulo			= marcaArticulo;
		this.PresentacionArticulo	= marcaArticulo;
		this.PrecioArticulo			= marcaArticulo;
		
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

	public Vector getPresentacionArticulo() {
		return PresentacionArticulo;
	}

	public void setPresentacionArticulo(Vector presentacionArticulo) {
		PresentacionArticulo = presentacionArticulo;
	}

	public Vector getPrecioArticulo() {
		return PrecioArticulo;
	}

	public void setPrecioArticulo(Vector precioArticulo) {
		PrecioArticulo = precioArticulo;
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
