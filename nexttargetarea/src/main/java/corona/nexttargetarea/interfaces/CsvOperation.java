package corona.nexttargetarea.interfaces;

import java.sql.Connection;

public interface CsvOperation
{
	public void readCsvFile(String filePath, String fileName);
	public void pushDataToStaggingTable(Connection connection);
}
