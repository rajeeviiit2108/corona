package corona.nexttargetarea.stagingdatadto;

public class InternetDataStagingDataDto {

	private static final long serialVersionUID = 1L;
	
	private String emailId;
	private String information;
	private String link;
	private String placeName;
	private String numberOfInfectedPeople;
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getNumberOfInfectedPeople() {
		return numberOfInfectedPeople;
	}
	public void setNumberOfInfectedPeople(String numberOfInfectedPeople) {
		this.numberOfInfectedPeople = numberOfInfectedPeople;
	}
	
	
}
