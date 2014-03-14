package pck_SG;


public class ValidarRutaListaComprasSG {
	
	String errorRutaCompras 	= new String();
	String errorProductoCompras = new String();
	
	public ValidarRutaListaComprasSG(){
		
	}
	
	public ValidarRutaListaComprasSG(String errorRutaCompras, String errorProductoCompras){
		
		super();
		this.errorRutaCompras = errorRutaCompras;
		this.errorProductoCompras = errorProductoCompras;
		
	}
	
	public String geterrorRutaCompras() {
		return errorRutaCompras;
	}
	
	public void seterrorRutaCompras(String errorRutaCompras) {
		this.errorRutaCompras = errorRutaCompras;
	}

	public String getErrorProductoCompras() {
		return errorProductoCompras;
	}

	public void setErrorProductoCompras(String errorProductoCompras) {
		this.errorProductoCompras = errorProductoCompras;
	}

}
