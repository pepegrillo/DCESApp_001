package pck_SG;


public class LoginSG {
	
	String nombre 	= new String();
	String apellido = new String();
	
	String errorCode 	= new String();
	String errorMessage = new String();
	
	public LoginSG(){
		
	}
	
	public LoginSG(String nombre, String apellido, String errorCode, String errorMessage){
		
		super();
		this.nombre    	  = nombre;
		this.apellido     = apellido;
		this.errorCode    = errorCode;
		this.errorMessage = errorMessage;
		
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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
