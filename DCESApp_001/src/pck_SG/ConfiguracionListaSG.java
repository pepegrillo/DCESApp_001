package pck_SG;


public class ConfiguracionListaSG {
	
	String rutas		= new String();
	String alertas		= new String();
	String productos	= new String();
	
	String errorCode 	= new String();
	String errorMessage = new String();
	
	
	
	public ConfiguracionListaSG(){
		
	}
	
	public ConfiguracionListaSG(String rutas, String alertas, String productos, String errorCode, String errorMessage){
		
		super();
		this.rutas		= rutas;
		this.alertas	= alertas;
		this.productos	= productos;
		
		this.errorCode    = errorCode;
		this.errorMessage = errorMessage;
		
	}

	public String getRutas() {
		return rutas;
	}

	public void setRutas(String rutas) {
		this.rutas = rutas;
	}

	public String getAlertas() {
		return alertas;
	}

	public void setAlertas(String alertas) {
		this.alertas = alertas;
	}

	public String getProductos() {
		return productos;
	}

	public void setProductos(String productos) {
		this.productos = productos;
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
