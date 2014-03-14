package pck_SG;

import java.util.Vector;

public class AlertaComprasSG {
	
	Vector IdTipoNotificacion   = new Vector();
	Vector Hora					= new Vector();
	Vector Dia					= new Vector();
	Vector IdListaN				= new Vector();
	Vector Notificacion			= new Vector();
	
	String errorCode 	= new String();
	String errorMessage = new String();
	
	String idTipoN		= new String();
	String HoraS		= new String();
	String DiaS			= new String();
	boolean Check;
	
	public AlertaComprasSG(){
		
	}
	
	public AlertaComprasSG(Vector IdTipoNotificacion, Vector Hora, Vector Dia, Vector IdListaN, Vector Notificacion, String errorCode, String errorMessage, boolean Check, String HoraS, String idTipoN, String DiaS){
		
		super();
		this.IdTipoNotificacion = IdTipoNotificacion;
		this.Hora 				= Hora;
		this.Dia 				= Dia;
		this.IdListaN 			= IdListaN;
		this.Notificacion		= Notificacion;
		this.errorCode    		= errorCode;
		this.errorMessage 		= errorMessage;
		this.Check 				= Check;
		this.HoraS 				= HoraS;
		this.idTipoN			= idTipoN;
		this.DiaS				= DiaS;
		
	}

	

	public Vector getIdTipoNotificacion() {
		return IdTipoNotificacion;
	}

	public void setIdTipoNotificacion(Vector idTipoNotificacion) {
		this.IdTipoNotificacion = idTipoNotificacion;
	}

	public Vector getHora() {
		return Hora;
	}

	public void setHora(Vector hora) {
		this.Hora = hora;
	}

	public Vector getDia() {
		return Dia;
	}

	public void setDia(Vector dia) {
		this.Dia = dia;
	}

	public Vector getIdListaN() {
		return IdListaN;
	}

	public void setIdListaN(Vector idListaN) {
		this.IdListaN = idListaN;
	}

	public Vector getNotificacion() {
		return Notificacion;
	}

	public void setNotificacion(Vector notificacion) {
		this.Notificacion = notificacion;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public boolean isCheck() {
		return Check;
	}

	public void setCheck(boolean check) {
		this.Check = check;
	}

	public String getHoraS() {
		return HoraS;
	}

	public void setHoraS(String horaS) {
		HoraS = horaS;
	}

	public String getIdTipoN() {
		return idTipoN;
	}

	public void setIdTipoN(String idTipoN) {
		this.idTipoN = idTipoN;
	}

	public String getDiaS() {
		return DiaS;
	}

	public void setDiaS(String diaS) {
		DiaS = diaS;
	}
	

}
