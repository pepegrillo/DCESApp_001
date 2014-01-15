package listaProductos;

import java.util.Vector;

public class ListaProductosSG {
	
	Vector idLista     = new Vector();
	Vector nombreLista = new Vector();
	
	public ListaProductosSG(){
		
	}
	
	public ListaProductosSG(Vector idLista, Vector nombreLista){
		
		super();
		this.idLista     = idLista;
		this.nombreLista = nombreLista;
		
	}
	
	public Vector getIdLista() {
		return idLista;
	}
	public void setIdLista(Vector idLista) {
		this.idLista = idLista;
	}
	public Vector getNombreLista() {
		return nombreLista;
	}
	public void setNombreLista(Vector nombreLista) {
		this.nombreLista = nombreLista;
	}

}
