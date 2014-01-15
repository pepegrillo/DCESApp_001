package configurations;

public class DbSql {

	private String version = "0.6.1.db";
	private String path;
	
	public String Path(){
		path = "file:///SDCard/Databases/DCESApp/dcesapp-db-"+version;
		return path;
	}
	
	/*Crear Tablas*/
	public String CreateUser(){
		String CreateUser = "CREATE TABLE IF NOT EXISTS USER(id_user TEXT, email TEXT, pw TEXT)";
		return CreateUser;
	}	
	public String CategoriaProducto(){
		String CategoriaProducto = "CREATE TABLE IF NOT EXISTS CATEGORIAPRODUCTO(idcategoria TEXT, nombrecategoria TEXT)";
		return CategoriaProducto;
	}
	public String Producto(){
		String Producto = "CREATE TABLE IF NOT EXISTS PRODUCTO(idcategoria TEXT, idproducto TEXT, nombreproducto TEXT)";
		return Producto;
	}
	public String Municipio(){
		String Municipio = "CREATE TABLE IF NOT EXISTS MUNICIPIO(idcategoria TEXT, idmunicipio TEXT, nombremunicipio TEXT)";
		return Municipio;
	}
	public String Establecimiento(){
		String Establecimiento = "CREATE TABLE IF NOT EXISTS ESTABLECIMIENTO(idmunicipio TEXT, idestablecimiento TEXT, nombreestablecimiento TEXT)";
		return Establecimiento;
	}
	public String Presentacion(){
		String Presentacion = "CREATE TABLE IF NOT EXISTS PRESENTACION(idmunicipio TEXT, idpresentacion TEXT, nombrepresentacion TEXT)";
		return Presentacion;
	}
	
	/*Inserts*/
	public String InsertCategoriaProducto(String idCategoria, String nombreCategoria){
		String InsertCategoriaProducto = "INSERT INTO CATEGORIAPRODUCTO(idcategoria,nombrecategoria)VALUES('"+idCategoria+"','"+nombreCategoria+"')";
		return InsertCategoriaProducto;
	}
	public String InsertProducto(String idCategoria, String idProducto, String nombreProducto){
		String InsertProducto = "INSERT INTO PRODUCTO(idcategoria,idproducto,nombreproducto)VALUES('"+idCategoria+"','"+idProducto+"','"+nombreProducto+"')";
		return InsertProducto;
	}
	public String InsertMunicipio(String idCategoria, String idMunicipio, String nombreMunicipio){
		String InsertMunicipio = "INSERT INTO MUNICIPIO(idcategoria,idmunicipio,nombremunicipio)VALUES('"+idCategoria+"','"+idMunicipio+"','"+nombreMunicipio+"')";
		return InsertMunicipio;
	}
	public String InsertEstablecimiento(String idMunicipio, String idEstablecimiento, String nombreEstablecimiento){
		String InsertEstablecimiento = "INSERT INTO ESTABLECIMIENTO(idmunicipio,idestablecimiento,nombreestablecimiento)VALUES('"+idMunicipio+"','"+idEstablecimiento+"','"+nombreEstablecimiento+"')";
		return InsertEstablecimiento;
	}
	public String InsertPresentacion(String idMunicipio, String idPresentacion, String nombrePresentacion){
		String InsertPresentacion = "INSERT INTO PRESENTACION(idmunicipio,idpresentacion,nombrepresentacion)VALUES('"+idMunicipio+"','"+idPresentacion+"','"+nombrePresentacion+"')";
		return InsertPresentacion;
	}
	
	/*Selects*/
	public String SelectCategoriaProducto(){
		String SelectCategoriaProducto = "SELECT * FROM CATEGORIAPRODUCTO";
		return SelectCategoriaProducto;
	}	
	public String SelectProducto(String idPorCategoria){
		String SelectProducto = "SELECT * FROM PRODUCTO WHERE idcategoria='"+idPorCategoria+"'";
		return SelectProducto;
	}	
	public String SelectMunicipio(String idCategoria){
		String SelectMunicipio = "SELECT * FROM MUNICIPIO WHERE idcategoria='"+idCategoria+"'";
		return SelectMunicipio;
	}
	/*public String SelectFiltro2(String idMunicipio){
		String SelectFiltro2 = "SELECT es.*, pr.* FROM ESTABLECIMIENTO AS es INNER JOIN PRESENTACION AS pr ON es.idmunicipio = pr.idmunicipio";
		return SelectFiltro2;
	}*/
	public String SelectFiltro2(String idMunicipio){
		String SelectFiltro2 = "SELECT * FROM ESTABLECIMIENTO WHERE idmunicipio='"+idMunicipio+"'";
		return SelectFiltro2;
	}
	public String SelectFiltro3(String idMunicipio){
		String SelectFiltro3 = "SELECT * FROM PRESENTACION WHERE idmunicipio='"+idMunicipio+"'";
		return SelectFiltro3;
	}
	
	
	/*Deletes*/
	public String DeleteCategoriaProducto(){
		String SelectCategoriaProducto = "DELETE FROM CATEGORIAPRODUCTO";
		return SelectCategoriaProducto;
	}
	public String DeleteProducto(String idPorCategoria){
		String DeleteProducto = "DELETE FROM PRODUCTO WHERE idcategoria='"+idPorCategoria+"'";
		return DeleteProducto;
	}
	public String DeleteMunicipio(String idCategoria){
		String DeleteMunicipio = "DELETE FROM MUNICIPIO WHERE idcategoria='"+idCategoria+"'";
		return DeleteMunicipio;
	}
	public String DeleteEstablecimiento(String idMunicipio){
		String DeleteEstablecimiento = "DELETE FROM ESTABLECIMIENTO WHERE idmunicipio='"+idMunicipio+"'";
		return DeleteEstablecimiento;
	}
	public String DeletePresentacion(String idMunicipio){
		String DeletePresentacion = "DELETE FROM PRESENTACION WHERE idmunicipio='"+idMunicipio+"'";
		return DeletePresentacion;
	}
}