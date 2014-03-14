package configurations;

public class Strings {
	
	public static final String EMAIL = "Email";
	public static final String PWD   = "Contraseña";
	
	//Registro
	public static final String REGISTRO   = "REGISTRO";
	public static final String NAME       = "NOMBRE";
	public static final String LASTNAME   = "APELLIDO";
	public static final String GENERO     = "GÉNERO";
	public static final String EMAILS	  = "CORREO ELECTRÓNICO";
	public static final String PWDS       = "CONTRASEÑA";
	public static final String RPWDS      = "CONFIRMAR CONTRASEÑA";
	public static final String CHANGEPW   = "CAMBIAR CONTRASEÑA";
	public static final String PWACTUAL   = "CONTRASEÑA ACTUAL";
	public static final String PWNEW	  = "CONTRASEÑA NUEVA";
	public static final String REPWNEW	  = "CONFIRMAR CONTRASEÑA NUEVA";

	
	//Observatorio Precios
	public static final String CATEGORIA   = "Categoría";
	public static final String CATEGORIAT  = "Categorías de Temporada";
	public static final String PRODUCTO    = "Productos";
	public static final String FILTRO      = "Filtro de búsqueda";
	public static final String FILTROB     = "Lista de productos filtrados";
	public static final String PERFIL      = "Perfil de producto";
	
	//Listas
	public static final String LPRODUCTO   = "Lista de productos";
	public static final String LCOMPRAS    = "Lista de compras";
	public static final String LSMART      = "Lista Inteligente";
	
	//Favoritos
	public static final String FAVORITOS   = "Favoritos";
	
	//Config
	public static final String CONFIG        = "Configuración";
	public static final String CHANGECONFIG  = "Configuración puntos mapa";
	public static final String LISTESTABLEC  = "Lista de establecimientos";
	
	//Servicios Web
	public static final String HTTP_SW       = "http://observatoriodeprecios.defensoria.gob.sv/ApiREST.php/v1/";
	
	//Mensajes
	public static final String MSG_DESCARGANDO 			= "Descargando Datos...";
	public static final String MSG_DESCARGANDO_SLOW 	= "Parece que está en una conexion lenta, puede tardar un momento.";
	public static final String CONEXION_DESCONECTED 	= "No posee conexión a internet, intentelo más tarde";
	public static final String CONEXION_UNEXPECTED	 	= "Ha ocurrido algo inesperado intentelo otra vez";
	public static final String MSG_WAITING			 	= "Iniciando Sesión...";
	public static final String MSG_WAITING_SLOW		 	= MSG_DESCARGANDO_SLOW+"\nIniciando Sesión...";
	
	//Form Validation
	public static final String VT_GENERAL		= "¡Todos los campos son obligatorios!";
	public static final String VT_CAMPOTRES		= "¡Los campos nombre y/o apellido son muy cortos!";
	public static final String VT_CAMPODIEZ		= "¡El correo electrónico es muy corto o inválido!";
	public static final String VT_CAMPOPW		= "¡El nivel de seguridad de tu contraseña es muy bajo!";
	public static final String VT_CAMPORPW		= "¡La contraseña no coincide!";
	
}
