package corona.nexttargetarea.stagingdatadto;

import java.util.Date;

public class HospitalDataStagingDto {

	private static final long serialVersionUID = 1L;
	private long adharId;
	private long passportNo;
	private String firstName;
	private String lastName;
	private String patientDiseaseHistory;
	private Date patientAdmittedDate;
	private Date patientDischargedDate;
	private boolean isCoronaConfirmed;
	private boolean isCoronaSuspected;
	
	public long getAdharId() {
		return adharId;
	}
	public void setAdharId(long adharId) {
		this.adharId = adharId;
	}
	public long getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(long passportNo) {
		this.passportNo = passportNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPatientDiseaseHistory() {
		return patientDiseaseHistory;
	}
	public void setPatientDiseaseHistory(String patientDiseaseHistory) {
		this.patientDiseaseHistory = patientDiseaseHistory;
	}
	public Date getPatientAdmittedDate() {
		return patientAdmittedDate;
	}
	public void setPatientAdmittedDate(Date patientAdmittedDate) {
		this.patientAdmittedDate = patientAdmittedDate;
	}
	public Date getPatientDischargedDate() {
		return patientDischargedDate;
	}
	public void setPatientDischargedDate(Date patientDischargedDate) {
		this.patientDischargedDate = patientDischargedDate;
	}
	public boolean isCoronaConfirmed() {
		return isCoronaConfirmed;
	}
	public void setCoronaConfirmed(boolean isCoronaConfirmed) {
		this.isCoronaConfirmed = isCoronaConfirmed;
	}
	public boolean isCoronaSuspected() {
		return isCoronaSuspected;
	}
	public void setCoronaSuspected(boolean isCoronaSuspected) {
		this.isCoronaSuspected = isCoronaSuspected;
	}
}