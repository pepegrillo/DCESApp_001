package pck_SG;


public class LoginSG {
	
	String errorCode 	= new String();
	String errorMessage = new String();
	
	public LoginSG(){
		
	}
	
	public LoginSG(String errorCode, String errorMessage){
		
		super();
		this.errorCode    = errorCode;
		this.errorMessage = errorMessage;
		
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
