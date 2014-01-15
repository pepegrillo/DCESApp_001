package pck_SG;

import java.util.Vector;

public class CategoriaProductoSG {
	
	Vector idCategoria   = new Vector();
	Vector categoria     = new Vector();
	
	public CategoriaProductoSG(){
		
	}
	
	public CategoriaProductoSG(Vector idCategoria, Vector categoria){
		
		super();
		this.idCategoria = idCategoria;
		this.categoria = categoria;
		
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

}
