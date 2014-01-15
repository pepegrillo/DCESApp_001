package pck_SG;

import java.util.Vector;

public class ProductoFiltroSG {
	
	public Vector IdProducto   = new Vector();
	public Vector Producto     = new Vector();
	public Vector Marca        = new Vector();
	public Vector Presentacion = new Vector();
	public Vector Precio       = new Vector();
	public Vector PrecioPromo  = new Vector();
	public Vector Nombre       = new Vector();
	public Vector Latitud      = new Vector();
	public Vector Longitud     = new Vector();
	public Vector Fecha        = new Vector();
	
	String errorCode 	= new String();
	String errorMessage = new String();
	
	public ProductoFiltroSG(){
		
	}
	
	public ProductoFiltroSG(Vector IdProducto, Vector Producto, Vector Marca, Vector Presentacion, Vector Precio, Vector PrecioPromo, Vector Nombre, Vector Latitud, Vector Longitud, Vector Fecha, String errorCode, String errorMessage){
		
		super();
		this.IdProducto   = IdProducto;
		this.Producto	  = Producto;
		this.Marca 		  = Marca;
		this.Presentacion = Presentacion;
		this.Precio		  = Precio;
		this.PrecioPromo  = PrecioPromo;
		this.Nombre		  = Nombre;
		this.Latitud 	  = Latitud;
		this.Longitud	  = Longitud;
		this.Fecha 		  = Fecha;
		
		this.errorCode    = errorCode;
		this.errorMessage = errorMessage;
		
	}
	
	public Vector getIdProducto() {
		return IdProducto;
	}
	public void setIdProducto(Vector IdProducto) {
		this.IdProducto = IdProducto;
	}
	public Vector getProducto() {
		return Producto;
	}
	public void setProducto(Vector Producto) {
		this.Producto = Producto;
	}
	public Vector getMarca() {
		return Marca;
	}
	public void setMarca(Vector Marca) {
		this.Marca = Marca;
	}
	public Vector getPresentacion() {
		return Presentacion;
	}
	public void setPresentacion(Vector Presentacion) {
		this.Presentacion = Presentacion;
	}
	public Vector getPrecio() {
		return Precio;
	}
	public void setPrecio(Vector Precio) {
		this.Precio = Precio;
	}
	public Vector getPrecioPromo() {
		return PrecioPromo;
	}
	public void setPrecioPromo(Vector PrecioPromo) {
		this.PrecioPromo = PrecioPromo;
	}
	public Vector getNombre() {
		return Nombre;
	}
	public void setNombre(Vector Nombre) {
		this.Nombre = Nombre;
	}
	public Vector getLatitud() {
		return Latitud;
	}
	public void setLatitud(Vector Latitud) {
		this.Latitud = Latitud;
	}
	public Vector getLongitud() {
		return Longitud;
	}
	public void setLongitud(Vector Longitud) {
		this.Longitud = Longitud;
	}
	public Vector getFecha() {
		return Fecha;
	}
	public void setFecha(Vector Fecha) {
		this.Fecha = Fecha;
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
