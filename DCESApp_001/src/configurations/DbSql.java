package configurations;

public class DbSql {

	private String version = "0.7.0.db";
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
	public String ProductoFiltrado(){
		String ProductoFiltrado = "CREATE TABLE IF NOT EXISTS PRODUCTOFILTRADO(idmunicipio TEXT, idproductoback TEXT, idcomboestablecimiento TEXT, idcombopresentacion TEXT" +
				", idproducto TEXT, producto TEXT, marca TEXT, presentacion TEXT, precioproducto TEXT" +
				", preciopromocion TEXT, nombre TEXT, latitud TEXT, longitud TEXT, fechasondeo TEXT)";
		return ProductoFiltrado;
	}
	public String Busqueda(){
		String Busqueda = "CREATE TABLE IF NOT EXISTS BUSQUEDA(idcategoria TEXT, palabrafiltro TEXT, idproducto TEXT, nombreproducto TEXT)";
		return Busqueda;
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
	public String InsertProductoFiltrado(String idMunicipio, String idProductoBack, String selectedValue2, String selectedValue3, String idProducto, String producto, String marca,
										String presentacion, String precioProducto, String precioProm, String nombre, String latitud, String longitud, String fechaSondeo){
		String InsertProductoFiltrado = "INSERT INTO PRODUCTOFILTRADO(idmunicipio,idproductoback,idcomboestablecimiento,idcombopresentacion" +
				",idproducto,producto,marca,presentacion,precioproducto,preciopromocion,nombre,latitud,longitud,fechasondeo)VALUES('"+
				idMunicipio+"','"+idProductoBack+"','"+selectedValue2+"','"+selectedValue3+"','"+idProducto+"','"+producto+"'" +
						",'"+marca+"','"+presentacion+"','"+precioProducto+"','"+precioProm+"','"+nombre+"','"+latitud+"'" +
								",'"+longitud+"','"+fechaSondeo+"')";
		return InsertProductoFiltrado;
	}
	public String InsertBusqueda(String idCategoria, String palabraFiltro, String idProducto, String nombreproducto){
		String InsertBusqueda = "INSERT INTO BUSQUEDA(idcategoria,palabrafiltro,idproducto,nombreproducto)VALUES('"+idCategoria+"','"+palabraFiltro+"','"+idProducto+"','"+nombreproducto+"')";
		return InsertBusqueda;
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
	public String SelectProductoFiltrado(String idMunicipio, String idProdutoBack, String selectedValue2, String selectedValue3){
		String SelectProductoFiltrado = "SELECT * FROM PRODUCTOFILTRADO WHERE idmunicipio='"+idMunicipio+"' AND " +
										"idproductoback='"+idProdutoBack+"' AND " +
										"idcomboestablecimiento='"+selectedValue2+"' AND " +
										"idcombopresentacion='"+selectedValue3+"'";
		return SelectProductoFiltrado;
	}
	public String SelectBusqueda(String idCategoria, String palabraFiltro){
		String SelectBusqueda = "SELECT * FROM BUSQUEDA WHERE idcategoria='"+idCategoria+"' AND nombreproducto LIKE '%"+palabraFiltro+"%'";
		return SelectBusqueda;
	}
	
	
	/*Deletes*/
	public String DeleteCategoriaProducto(){
		String DeleteCategoriaProducto = "DELETE FROM CATEGORIAPRODUCTO";
		return DeleteCategoriaProducto;
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
	public String DeleteProductoFiltrado(String idMunicipio, String idProdutoBack, String selectedValue2, String selectedValue3){
		String DeleteProductoFiltrado = "DELETE FROM PRODUCTOFILTRADO WHERE idmunicipio='"+idMunicipio+"' AND " +
									"idproductoback='"+idProdutoBack+"' AND " +
									"idcomboestablecimiento='"+selectedValue2+"' AND " +
									"idcombopresentacion='"+selectedValue3+"'";
		return DeleteProductoFiltrado;
	}
	public String DeleteBusqueda(String idCategoria){
		String DeleteBusqueda = "DELETE FROM BUSQUEDA WHERE idcategoria='"+idCategoria+"'";
		return DeleteBusqueda;
	}
}
