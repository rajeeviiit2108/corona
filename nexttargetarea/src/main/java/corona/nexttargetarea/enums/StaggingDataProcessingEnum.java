package corona.nexttargetarea.enums;

public enum StaggingDataProcessingEnum {
	ADHAR_ID("adhar_id"),
	PASSPORT_NO("passport_no"),
	IS_DOMESTIC_TRAVEL("is_domestic_travel"),
	DATE_OF_JOURNEY("date_of_journey");
	
	private String stagingDataInformation; 
	 public String getStagingDataInformation() {
		return stagingDataInformation;
	}
	private StaggingDataProcessingEnum(String stagingDataInformation) 
	 { 
		 this.stagingDataInformation =stagingDataInformation; 
	 }
}
