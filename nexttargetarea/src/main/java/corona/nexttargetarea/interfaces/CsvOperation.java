package corona.nexttargetarea.interfaces;
public interface CsvOperation
{
	public void readCsvFile(String filePath, String fileName);
	public void pushDataToStaggingTable();
}
