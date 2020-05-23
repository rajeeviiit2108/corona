package corona.nexttargetarea.csvdto;

import java.io.Serializable;
import java.util.Date;
public class HospitalDataDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String adhar_id;
	private String passport_no;
	private String patient_disease_history;
	private Date patient_admitted_date;
	private Date patient_discharged_date;
	
	public String getAdhar_id() {
		return adhar_id;
	}
	public void setAdhar_id(String adhar_id) {
		this.adhar_id = adhar_id;
	}
	public String getPassport_no() {
		return passport_no;
	}
	public void setPassport_no(String passport_no) {
		this.passport_no = passport_no;
	}
	public String getPatient_disease_history() {
		return patient_disease_history;
	}
	public void setPatient_disease_history(String patient_disease_history) {
		this.patient_disease_history = patient_disease_history;
	}
	public Date getPatient_admitted_date() {
		return patient_admitted_date;
	}
	public void setPatient_admitted_date(Date patient_admitted_date) {
		this.patient_admitted_date = patient_admitted_date;
	}
	public Date getPatient_discharged_date() {
		return patient_discharged_date;
	}
	public void setPatient_discharged_date(Date patient_discharged_date) {
		this.patient_discharged_date = patient_discharged_date;
	}
	

}
