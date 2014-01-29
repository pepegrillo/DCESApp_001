package configurations;

public class DbSql {

	private String version = "0.8.6.db";
	private String path;
	
	public String Path(){
		path = "file:///SDCard/Databases/DCESApp/dcesapp-db-"+version;
		return path;
	}
	
	/*Crear Tablas*/
	public String CreateUser(){
		String CreateUser = "CREATE TABLE IF NOT EXISTS USER(idmiembro TEXT, nombre TEXT, apellido TEXT, genero TEXT, correo TEXT, hashkey TEXT)";
		return CreateUser;
	}	
	public String CategoriaProducto(){
		String CategoriaProducto = "CREATE TABLE IF NOT EXISTS CATEGORIAPRODUCTO(idcategoria TEXT, nombrecategoria TEXT)";
		return CategoriaProducto;
	}	
	public String TemporadaCategoriaProducto(){
		String TemporadaCategoriaProducto = "CREATE TABLE IF NOT EXISTS TEMPORADACATEGORIAPRODUCTO(idcategoria TEXT, nombrecategoria TEXT)";
		return TemporadaCategoriaProducto;
	}
	public String Producto(){
		String Producto = "CREATE TABLE IF NOT EXISTS PRODUCTO(idcategoria TEXT, idproducto TEXT, nombreproducto TEXT)";
		return Producto;
	}
	public String TemporadaProducto(){
		String TemporadaProducto = "CREATE TABLE IF NOT EXISTS TEMPORADAPRODUCTO(idcategoria TEXT, idproducto TEXT, nombreproducto TEXT)";
		return TemporadaProducto;
	}
	public String Municipio(){
		String Municipio = "CREATE TABLE IF NOT EXISTS MUNICIPIO(idcategoria TEXT, idmunicipio TEXT, nombremunicipio TEXT)";
		return Municipio;
	}
	public String TemporadaMunicipio(){
		String TemporadaMunicipio = "CREATE TABLE IF NOT EXISTS TEMPORADAMUNICIPIO(idcategoria TEXT, idmunicipio TEXT, nombremunicipio TEXT)";
		return TemporadaMunicipio;
	}
	public String Establecimiento(){
		String Establecimiento = "CREATE TABLE IF NOT EXISTS ESTABLECIMIENTO(idmunicipio TEXT, idestablecimiento TEXT, nombreestablecimiento TEXT)";
		return Establecimiento;
	}
	public String TemporadaEstablecimiento(){
		String TemporadaEstablecimiento = "CREATE TABLE IF NOT EXISTS TEMPORADAESTABLECIMIENTO(idmunicipio TEXT, idestablecimiento TEXT, nombreestablecimiento TEXT)";
		return TemporadaEstablecimiento;
	}
	public String Presentacion(){
		String Presentacion = "CREATE TABLE IF NOT EXISTS PRESENTACION(idmunicipio TEXT, idpresentacion TEXT, nombrepresentacion TEXT)";
		return Presentacion;
	}
	public String TemporadaPresentacion(){
		String TemporadaPresentacion = "CREATE TABLE IF NOT EXISTS TEMPORADAPRESENTACION(idmunicipio TEXT, idpresentacion TEXT, nombrepresentacion TEXT)";
		return TemporadaPresentacion;
	}
	public String ProductoFiltrado(){
		String ProductoFiltrado = "CREATE TABLE IF NOT EXISTS PRODUCTOFILTRADO(idmunicipio TEXT, idproductoback TEXT, idcomboestablecimiento TEXT, idcombopresentacion TEXT" +
				", idproducto TEXT, producto TEXT, marca TEXT, presentacion TEXT, precioproducto TEXT" +
				", preciopromocion TEXT, nombre TEXT, latitud TEXT, longitud TEXT, fechasondeo TEXT)";
		return ProductoFiltrado;
	}
	public String TemporadaProductoFiltrado(){
		String TemporadaProductoFiltrado = "CREATE TABLE IF NOT EXISTS TEMPORADAPRODUCTOFILTRADO(idmunicipio TEXT, idproductoback TEXT, idcomboestablecimiento TEXT, idcombopresentacion TEXT" +
				", idproducto TEXT, producto TEXT, marca TEXT, presentacion TEXT, precioproducto TEXT" +
				", preciopromocion TEXT, nombre TEXT, latitud TEXT, longitud TEXT, fechasondeo TEXT)";
		return TemporadaProductoFiltrado;
	}
	public String Busqueda(){
		String Busqueda = "CREATE TABLE IF NOT EXISTS BUSQUEDA(idcategoria TEXT, palabrafiltro TEXT, idproducto TEXT, nombreproducto TEXT)";
		return Busqueda;
	}
	public String TemporadaBusqueda(){
		String TemporadaBusqueda = "CREATE TABLE IF NOT EXISTS TEMPORADABUSQUEDA(idcategoria TEXT, palabrafiltro TEXT, idproducto TEXT, nombreproducto TEXT)";
		return TemporadaBusqueda;
	}
	public String Favorito(){
		String Favorito = "CREATE TABLE IF NOT EXISTS FAVORITO(hashkey TEXT, idproducto TEXT, producto TEXT, marca TEXT, presentacion TEXT, establecimiento TEXT" +
				", precioproducto TEXT, preciopromocion TEXT, latitud TEXT, longitud TEXT, fechasondeo TEXT)";
		return Favorito;
	}
	public String TemporalUser(){
		String TemporalUser = "CREATE TABLE IF NOT EXISTS TEMPORALUSER(idMiembro TEXT, nombre TEXT)";
		return TemporalUser;
	}
	
	/*Inserts*/
	public String InsertUser(String idMiembro, String nombre, String apellido, String genero, String correo, String hashKey){
		String InsertUser = "INSERT INTO USER(idmiembro,nombre,apellido,genero,correo,hashkey)VALUES('"+idMiembro+"','"+nombre+"','"+apellido+"','"+genero+"','"+correo+"','"+hashKey+"')";
		return InsertUser;
	}
	public String InsertCategoriaProducto(String idCategoria, String nombreCategoria){
		String InsertCategoriaProducto = "INSERT INTO CATEGORIAPRODUCTO(idcategoria,nombrecategoria)VALUES('"+idCategoria+"','"+nombreCategoria+"')";
		return InsertCategoriaProducto;
	}
	public String InsertTemporadaCategoriaProducto(String idCategoria, String nombreCategoria){
		String InsertTemporadaCategoriaProducto = "INSERT INTO TEMPORADACATEGORIAPRODUCTO(idcategoria,nombrecategoria)VALUES('"+idCategoria+"','"+nombreCategoria+"')";
		return InsertTemporadaCategoriaProducto;
	}
	public String InsertProducto(String idCategoria, String idProducto, String nombreProducto){
		String InsertProducto = "INSERT INTO PRODUCTO(idcategoria,idproducto,nombreproducto)VALUES('"+idCategoria+"','"+idProducto+"','"+nombreProducto+"')";
		return InsertProducto;
	}
	public String InsertTemporadaProducto(String idCategoria, String idProducto, String nombreProducto){
		String InsertTemporadaProducto = "INSERT INTO TEMPORADAPRODUCTO(idcategoria,idproducto,nombreproducto)VALUES('"+idCategoria+"','"+idProducto+"','"+nombreProducto+"')";
		return InsertTemporadaProducto;
	}
	public String InsertMunicipio(String idCategoria, String idMunicipio, String nombreMunicipio){
		String InsertMunicipio = "INSERT INTO MUNICIPIO(idcategoria,idmunicipio,nombremunicipio)VALUES('"+idCategoria+"','"+idMunicipio+"','"+nombreMunicipio+"')";
		return InsertMunicipio;
	}
	public String InsertTemporadaMunicipio(String idCategoria, String idMunicipio, String nombreMunicipio){
		String InsertTemporadaMunicipio = "INSERT INTO TEMPORADAMUNICIPIO(idcategoria,idmunicipio,nombremunicipio)VALUES('"+idCategoria+"','"+idMunicipio+"','"+nombreMunicipio+"')";
		return InsertTemporadaMunicipio;
	}
	public String InsertEstablecimiento(String idMunicipio, String idEstablecimiento, String nombreEstablecimiento){
		String InsertEstablecimiento = "INSERT INTO ESTABLECIMIENTO(idmunicipio,idestablecimiento,nombreestablecimiento)VALUES('"+idMunicipio+"','"+idEstablecimiento+"','"+nombreEstablecimiento+"')";
		return InsertEstablecimiento;
	}
	public String InsertTemporadaEstablecimiento(String idMunicipio, String idEstablecimiento, String nombreEstablecimiento){
		String InsertTemporadaEstablecimiento = "INSERT INTO TEMPORADAESTABLECIMIENTO(idmunicipio,idestablecimiento,nombreestablecimiento)VALUES('"+idMunicipio+"','"+idEstablecimiento+"','"+nombreEstablecimiento+"')";
		return InsertTemporadaEstablecimiento;
	}
	public String InsertPresentacion(String idMunicipio, String idPresentacion, String nombrePresentacion){
		String InsertPresentacion = "INSERT INTO PRESENTACION(idmunicipio,idpresentacion,nombrepresentacion)VALUES('"+idMunicipio+"','"+idPresentacion+"','"+nombrePresentacion+"')";
		return InsertPresentacion;
	}
	public String InsertTemporadaPresentacion(String idMunicipio, String idPresentacion, String nombrePresentacion){
		String InsertTemporadaPresentacion = "INSERT INTO TEMPORADAPRESENTACION(idmunicipio,idpresentacion,nombrepresentacion)VALUES('"+idMunicipio+"','"+idPresentacion+"','"+nombrePresentacion+"')";
		return InsertTemporadaPresentacion;
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
	public String InsertTemporadaProductoFiltrado(String idMunicipio, String idProductoBack, String selectedValue2, String selectedValue3, String idProducto, String producto, String marca,
										String presentacion, String precioProducto, String precioProm, String nombre, String latitud, String longitud, String fechaSondeo){
		String InsertTemporadaProductoFiltrado = "INSERT INTO TEMPORADAPRODUCTOFILTRADO(idmunicipio,idproductoback,idcomboestablecimiento,idcombopresentacion" +
		",idproducto,producto,marca,presentacion,precioproducto,preciopromocion,nombre,latitud,longitud,fechasondeo)VALUES('"+
		idMunicipio+"','"+idProductoBack+"','"+selectedValue2+"','"+selectedValue3+"','"+idProducto+"','"+producto+"'" +
		",'"+marca+"','"+presentacion+"','"+precioProducto+"','"+precioProm+"','"+nombre+"','"+latitud+"'" +
			",'"+longitud+"','"+fechaSondeo+"')";
		return InsertTemporadaProductoFiltrado;
	}
	public String InsertBusqueda(String idCategoria, String palabraFiltro, String idProducto, String nombreproducto){
		String InsertBusqueda = "INSERT INTO BUSQUEDA(idcategoria,palabrafiltro,idproducto,nombreproducto)VALUES('"+idCategoria+"','"+palabraFiltro+"','"+idProducto+"','"+nombreproducto+"')";
		return InsertBusqueda;
	}
	public String InsertTemporadaBusqueda(String idCategoria, String palabraFiltro, String idProducto, String nombreproducto){
		String InsertTemporadaBusqueda = "INSERT INTO TEMPORADABUSQUEDA(idcategoria,palabrafiltro,idproducto,nombreproducto)VALUES('"+idCategoria+"','"+palabraFiltro+"','"+idProducto+"','"+nombreproducto+"')";
		return InsertTemporadaBusqueda;
	}
	public String InsertFavorito(String hashKey, String idProducto, String producto, String marca,
								String presentacion, String establecimiento, String precioProducto, String precioProm, String latitud, String longitud, String fechaSondeo){
			String InsertFavorito = "INSERT INTO FAVORITO(hashkey,idproducto,producto,marca,presentacion,establecimiento,precioproducto,preciopromocion,latitud,longitud,fechasondeo)" +
					"VALUES('"+hashKey+"','"+idProducto+"','"+producto+"','"+marca+"','"+presentacion+"','"+establecimiento+"','"+precioProducto+"','"+precioProm+"','"+latitud+"'" +
				",'"+longitud+"','"+fechaSondeo+"')";
		return InsertFavorito;
	}
	public String InsertTemporalUser(String idMiembro, String nombre){
		String InsertTemporalUser = "INSERT INTO TEMPORALUSER(idMiembro,nombre)VALUES('"+idMiembro+"','"+nombre+"')";
		return InsertTemporalUser;
	}
	
	
	
	/*Selects*/
	public String SelectUser(){
		String SelectUser = "SELECT * FROM USER";
		return SelectUser;
	}
	public String SelectUserValidar(){
		String SelectUserValidar = "SELECT idmiembro FROM USER";
		return SelectUserValidar;
	}	
	public String SelectUserHashKey(){
		String SelectUserHashKey = "SELECT hashkey FROM USER";
		return SelectUserHashKey;
	}
	public String SelectCategoriaProducto(){
		String SelectCategoriaProducto = "SELECT * FROM CATEGORIAPRODUCTO";
		return SelectCategoriaProducto;
	}
	public String SelectTemporadaCategoriaProducto(){
		String SelectTemporadaCategoriaProducto = "SELECT * FROM TEMPORADACATEGORIAPRODUCTO";
		return SelectTemporadaCategoriaProducto;
	}
	public String SelectProducto(String idPorCategoria){
		String SelectProducto = "SELECT * FROM PRODUCTO WHERE idcategoria='"+idPorCategoria+"'";
		return SelectProducto;
	}
	public String SelectTemporadaProducto(String idPorCategoria){
		String SelectTemporadaProducto = "SELECT * FROM TEMPORADAPRODUCTO WHERE idcategoria='"+idPorCategoria+"'";
		return SelectTemporadaProducto;
	}	
	public String SelectMunicipio(String idCategoria){
		String SelectMunicipio = "SELECT * FROM MUNICIPIO WHERE idcategoria='"+idCategoria+"'";
		return SelectMunicipio;
	}	
	public String SelectTemporadaMunicipio(String idCategoria){
		String SelectTemporadaMunicipio = "SELECT * FROM TEMPORADAMUNICIPIO WHERE idcategoria='"+idCategoria+"'";
		return SelectTemporadaMunicipio;
	}
	/*public String SelectFiltro2(String idMunicipio){
		String SelectFiltro2 = "SELECT es.*, pr.* FROM ESTABLECIMIENTO AS es INNER JOIN PRESENTACION AS pr ON es.idmunicipio = pr.idmunicipio";
		return SelectFiltro2;
	}*/
	public String SelectFiltro2(String idMunicipio){
		String SelectFiltro2 = "SELECT * FROM ESTABLECIMIENTO WHERE idmunicipio='"+idMunicipio+"'";
		return SelectFiltro2;
	}
	public String SelectTemporadaFiltro2(String idMunicipio){
		String SelectTemporadaFiltro2 = "SELECT * FROM TEMPORADAESTABLECIMIENTO WHERE idmunicipio='"+idMunicipio+"'";
		return SelectTemporadaFiltro2;
	}
	public String SelectFiltro3(String idMunicipio){
		String SelectFiltro3 = "SELECT * FROM PRESENTACION WHERE idmunicipio='"+idMunicipio+"'";
		return SelectFiltro3;
	}
	public String SelectTemporadaFiltro3(String idMunicipio){
		String SelectTemporadaFiltro3 = "SELECT * FROM TEMPORADAPRESENTACION WHERE idmunicipio='"+idMunicipio+"'";
		return SelectTemporadaFiltro3;
	}
	public String SelectProductoFiltrado(String idMunicipio, String idProdutoBack, String selectedValue2, String selectedValue3){
		String SelectProductoFiltrado = "SELECT * FROM PRODUCTOFILTRADO WHERE idmunicipio='"+idMunicipio+"' AND " +
										"idproductoback='"+idProdutoBack+"' AND " +
										"idcomboestablecimiento='"+selectedValue2+"' AND " +
										"idcombopresentacion='"+selectedValue3+"'";
		return SelectProductoFiltrado;
	}
	public String SelectTemporadaProductoFiltrado(String idMunicipio, String idProdutoBack, String selectedValue2, String selectedValue3){
		String SelectTemporadaProductoFiltrado = "SELECT * FROM TEMPORADAPRODUCTOFILTRADO WHERE idmunicipio='"+idMunicipio+"' AND " +
										"idproductoback='"+idProdutoBack+"' AND " +
										"idcomboestablecimiento='"+selectedValue2+"' AND " +
										"idcombopresentacion='"+selectedValue3+"'";
		return SelectTemporadaProductoFiltrado;
	}
	public String SelectBusqueda(String idCategoria, String palabraFiltro){
		String SelectBusqueda = "SELECT * FROM BUSQUEDA WHERE idcategoria='"+idCategoria+"' AND nombreproducto LIKE '%"+palabraFiltro+"%'";
		return SelectBusqueda;
	}
	public String SelectTemporadaBusqueda(String idCategoria, String palabraFiltro){
		String SelectTemporadaBusqueda = "SELECT * FROM TEMPORADABUSQUEDA WHERE idcategoria='"+idCategoria+"' AND nombreproducto LIKE '%"+palabraFiltro+"%'";
		return SelectTemporadaBusqueda;
	}
	public String SelectHashKey(){
		String SelectHashKey = "SELECT hashkey FROM USER";
		return SelectHashKey;
	}
	public String SelectFavoritos(){
		String SelectFavoritos = "SELECT * FROM FAVORITO";
		return SelectFavoritos;
	}
	public String SelectTemporalUser(){
		String SelectTemporalUser = "SELECT * FROM TEMPORALUSER";
		return SelectTemporalUser;
	}
	
	
	/*Deletes*/
	public String DeleteUser(){
		String DeleteUser = "DELETE FROM USER";
		return DeleteUser;
	}
	public String DeleteCategoriaProducto(){
		String DeleteCategoriaProducto = "DELETE FROM CATEGORIAPRODUCTO";
		return DeleteCategoriaProducto;
	}
	public String DeleteTemporadaCategoriaProducto(){
		String DeleteTemporadaCategoriaProducto = "DELETE FROM TEMPORADACATEGORIAPRODUCTO";
		return DeleteTemporadaCategoriaProducto;
	}
	public String DeleteProducto(String idPorCategoria){
		String DeleteProducto = "DELETE FROM PRODUCTO WHERE idcategoria='"+idPorCategoria+"'";
		return DeleteProducto;
	}
	public String DeleteTemporadaProducto(String idPorCategoria){
		String DeleteTemporadaProducto = "DELETE FROM TEMPORADAPRODUCTO WHERE idcategoria='"+idPorCategoria+"'";
		return DeleteTemporadaProducto;
	}
	public String DeleteMunicipio(String idCategoria){
		String DeleteMunicipio = "DELETE FROM MUNICIPIO WHERE idcategoria='"+idCategoria+"'";
		return DeleteMunicipio;
	}
	public String DeleteTemporadaMunicipio(String idCategoria){
		String DeleteTemporadaMunicipio = "DELETE FROM TEMPORADAMUNICIPIO WHERE idcategoria='"+idCategoria+"'";
		return DeleteTemporadaMunicipio;
	}
	public String DeleteEstablecimiento(String idMunicipio){
		String DeleteEstablecimiento = "DELETE FROM ESTABLECIMIENTO WHERE idmunicipio='"+idMunicipio+"'";
		return DeleteEstablecimiento;
	}
	public String DeleteTemporadaEstablecimiento(String idMunicipio){
		String DeleteTemporadaEstablecimiento = "DELETE FROM TEMPORADAESTABLECIMIENTO WHERE idmunicipio='"+idMunicipio+"'";
		return DeleteTemporadaEstablecimiento;
	}
	public String DeletePresentacion(String idMunicipio){
		String DeletePresentacion = "DELETE FROM PRESENTACION WHERE idmunicipio='"+idMunicipio+"'";
		return DeletePresentacion;
	}
	public String DeleteTemporadaPresentacion(String idMunicipio){
		String DeleteTemporadaPresentacion = "DELETE FROM TEMPORADAPRESENTACION WHERE idmunicipio='"+idMunicipio+"'";
		return DeleteTemporadaPresentacion;
	}
	public String DeleteProductoFiltrado(String idMunicipio, String idProdutoBack, String selectedValue2, String selectedValue3){
		String DeleteProductoFiltrado = "DELETE FROM PRODUCTOFILTRADO WHERE idmunicipio='"+idMunicipio+"' AND " +
									"idproductoback='"+idProdutoBack+"' AND " +
									"idcomboestablecimiento='"+selectedValue2+"' AND " +
									"idcombopresentacion='"+selectedValue3+"'";
		return DeleteProductoFiltrado;
	}
	public String DeleteTemporadaProductoFiltrado(String idMunicipio, String idProdutoBack, String selectedValue2, String selectedValue3){
		String DeleteTemporadaProductoFiltrado = "DELETE FROM TEMPORADAPRODUCTOFILTRADO WHERE idmunicipio='"+idMunicipio+"' AND " +
									"idproductoback='"+idProdutoBack+"' AND " +
									"idcomboestablecimiento='"+selectedValue2+"' AND " +
									"idcombopresentacion='"+selectedValue3+"'";
		return DeleteTemporadaProductoFiltrado;
	}
	public String DeleteBusqueda(String idCategoria){
		String DeleteBusqueda = "DELETE FROM BUSQUEDA WHERE idcategoria='"+idCategoria+"'";
		return DeleteBusqueda;
	}
	public String DeleteTemporadaBusqueda(String idCategoria){
		String DeleteTemporadaBusqueda = "DELETE FROM TEMPORADABUSQUEDA WHERE idcategoria='"+idCategoria+"'";
		return DeleteTemporadaBusqueda;
	}
	public String DeleteFavorito(){
		String DeleteFavorito = "DELETE FROM FAVORITO";
		return DeleteFavorito;
	}
	public String DeleteTemporalUser(){
		String DeleteTemporalUser = "DELETE FROM TEMPORALUSER";
		return DeleteTemporalUser;
	}
}
