package corona.nexttargetarea.stagingdatadto;

import java.io.Serializable;
import java.util.Date;

public class TravelTypeStagingDataDto implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private long adharId;
	private long passportNo;
	private boolean isDomesticTravel;
	private Date dateOfJourney;
	
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
	public boolean isDomesticTravel() {
		return isDomesticTravel;
	}
	public void setDomesticTravel(boolean isDomesticTravel) {
		this.isDomesticTravel = isDomesticTravel;
	}
	public Date getDateOfJourney() {
		return dateOfJourney;
	}
	public void setDateOfJourney(Date dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}
}
