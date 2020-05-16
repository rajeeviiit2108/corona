package corona.nexttargetarea.enums;

public enum CsvOperationEnum {

	CSV_FILE_PATH("C:\\Users\\earnjra\\csv_files\\"),
	TRAVEL_TYPE_CSV("Travel_type.csv");
	
	private String csvInformation; 
	 public String getCsvInformation() {
		return csvInformation;
	}
	private CsvOperationEnum(String csvInformation) 
	 { 
		 this.csvInformation =csvInformation; 
	 }
}
