package pck_SG;

import java.util.Vector;

public class CotizarListaDetalleSG {
	
	Vector idArticulo			= new Vector();
	Vector nombre				= new Vector();
	Vector presentacion			= new Vector();
	Vector marca				= new Vector();
	Vector precio				= new Vector();
	Vector fechaSondeo			= new Vector();
	Vector estadoExistencia		= new Vector();
	
	String errorCode 		= new String();
	String errorMessage 	= new String();
	
	
	public CotizarListaDetalleSG(){
		
	}
	
	public CotizarListaDetalleSG(Vector idArticulo, Vector nombre, Vector presentacion, Vector marca, Vector precio, Vector fechaSondeo, Vector estadoExistencia, String errorCode, String errorMessage){
		
		super();
		this.idArticulo   		= idArticulo;
		this.nombre				= nombre;
		this.presentacion   	= presentacion;
		this.marca				= marca;
		this.precio   			= precio;
		this.fechaSondeo		= fechaSondeo;
		this.estadoExistencia	= estadoExistencia;
		
		this.errorCode    = errorCode;
		this.errorMessage = errorMessage;
		
	}

	public Vector getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(Vector idArticulo) {
		this.idArticulo = idArticulo;
	}

	public Vector getNombre() {
		return nombre;
	}

	public void setNombre(Vector nombre) {
		this.nombre = nombre;
	}

	public Vector getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(Vector presentacion) {
		this.presentacion = presentacion;
	}

	public Vector getMarca() {
		return marca;
	}

	public void setMarca(Vector marca) {
		this.marca = marca;
	}

	public Vector getPrecio() {
		return precio;
	}

	public void setPrecio(Vector precio) {
		this.precio = precio;
	}

	public Vector getFechaSondeo() {
		return fechaSondeo;
	}

	public void setFechaSondeo(Vector fechaSondeo) {
		this.fechaSondeo = fechaSondeo;
	}

	public Vector getEstadoExistencia() {
		return estadoExistencia;
	}

	public void setEstadoExistencia(Vector estadoExistencia) {
		this.estadoExistencia = estadoExistencia;
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
	
	
	
	

}
