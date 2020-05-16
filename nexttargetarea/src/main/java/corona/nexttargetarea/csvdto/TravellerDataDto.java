package corona.nexttargetarea.csvdto;

import java.io.Serializable;
import java.util.Date;
public class TravellerDataDto implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String adharId;
	private String passportNo;
	private String isDomesticTravel;
	private Date dateOfJourney;

	public String getAdharId() {
		return adharId;
	}
	public void setAdharId(String adharId) {
		this.adharId = adharId;
	}
	public String getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	public String getIsDomesticTravel() {
		return isDomesticTravel;
	}
	public void setIsDomesticTravel(String isDomesticTravel) {
		this.isDomesticTravel = isDomesticTravel;
	}
	public Date getDateOfJourney() {
		return dateOfJourney;
	}
	public void setDateOfJourney(Date dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}
}
