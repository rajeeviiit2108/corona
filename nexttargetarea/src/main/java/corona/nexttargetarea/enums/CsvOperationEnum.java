package corona.nexttargetarea.enums;

public enum CsvOperationEnum {

	CSV_FILE_PATH("C:\\Users\\earnjra\\csv_files\\"),
	TRAVEL_TYPE_CSV("Travel_Type.csv"),
	DOMESTIC_TRAVEL_CSV("Domestic_Travel.csv"),
	HOSPITAL_DATA_CSV("Hospital_Data.csv"),
	INTERNATIONAL_TRAVEL_CSV("International_Travel.csv"),
	SOCIAL_MEDIA_POST_CSV("Social_Media_Post.csv"),
	INTERNET_DATA_CSV("Internet_Data.csv");
	
	private String csvInformation; 
	 public String getCsvInformation() {
		return csvInformation;
	}
	private CsvOperationEnum(String csvInformation) 
	 { 
		 this.csvInformation =csvInformation; 
	 }
}
