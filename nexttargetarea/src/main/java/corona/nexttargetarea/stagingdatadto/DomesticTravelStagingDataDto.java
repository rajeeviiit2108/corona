package corona.nexttargetarea.stagingdatadto;

import java.util.Date;

public class DomesticTravelStagingDataDto {
	private static final long serialVersionUID = 1L;
	private long adharId;
	private boolean isDomesticTravel;
	private String  travelHistory;
	private Date travelDate;
	private String  travelFrom;
	
	public long getAdharId() {
		return adharId;
	}
	public void setAdharId(long adharId) {
		this.adharId = adharId;
	}
	public String getTravelHistory() {
		return travelHistory;
	}
	public void setTravelHistory(String travelHistory) {
		this.travelHistory = travelHistory;
	}
	public Date getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}
	public String getTravelFrom() {
		return travelFrom;
	}
	public void setTravelFrom(String travelFrom) {
		this.travelFrom = travelFrom;
	}
	public boolean isDomesticTravel() {
		return isDomesticTravel;
	}
	public void setDomesticTravel(boolean isDomesticTravel) {
		this.isDomesticTravel = isDomesticTravel;
	}
	
}
