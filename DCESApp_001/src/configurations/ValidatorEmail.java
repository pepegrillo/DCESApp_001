package configurations;

public class ValidatorEmail {

	public boolean validateEmailID(String email) {
	    email = email.trim();
	    String reverse = new StringBuffer(email).reverse().toString();
	    if (email == null || email.length() == 0 || email.indexOf("@") == -1) {
	        return false;
	    }
	    int emailLength = email.length();
	    int atPosition = email.indexOf("@");
	    int atDot = reverse.indexOf(".");

	    String beforeAt = email.substring(0, atPosition);
	    String afterAt = email.substring(atPosition + 1, emailLength);

	    if (beforeAt.length() == 0 || afterAt.length() == 0) {
	        return false;
	    }
	    for (int i = 0; email.length() - 1 > i; i++) {
	        char i1 = email.charAt(i);
	        char i2 = email.charAt(i + 1);
	        if (i1 == '.' && i2 == '.') {
	            return false;
	        }
	    }
	    if (email.charAt(atPosition - 1) == '.' || email.charAt(0) == '.' || email.charAt(atPosition + 1) == '.' || afterAt.indexOf("@") != -1 || atDot < 2) {
	        return false;
	    }

	    return true;
	}
	
}
