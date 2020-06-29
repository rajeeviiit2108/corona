package corona.nexttargetarea.csvoperationimpl;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import corona.nexttargetarea.csvdto.TravellerDataDto;
import corona.nexttargetarea.customexception.CsvFileReadException;
import corona.nexttargetarea.customexception.FileResolutionException;
import corona.nexttargetarea.interfaces.CsvOperation;
import corona.nexttargetarea.util.NextTargetAreaUtil;

public class CsvOperationTravelType implements CsvOperation
{
	private static List<TravellerDataDto> travellerDataList=new ArrayList<>();
	@Override
	public void readCsvFile(String filePath, String fileName) 
	{
		CSVReader csvReader =null;
	    try 
	    { 
	        FileReader fileReader = new FileReader(filePath+fileName); 
	        csvReader = new CSVReader(fileReader);
	        TravellerDataDto travellerDataDto=null;
	        Object[] nextRecord; 
	        nextRecord = csvReader.readNext();
	        while ((nextRecord = csvReader.readNext()) != null) 
	        {
	        	travellerDataDto=new TravellerDataDto();
	        	if(nextRecord[0]!=null)
	        	{
	        	travellerDataDto.setAdharId((String)nextRecord[0]);
	        	}
	        	if(nextRecord[1]!=null)
	        	{
	        	travellerDataDto.setPassportNo((String)nextRecord[1]);
	        	}
	        	if(nextRecord[2]!=null)
	        	{
	        	travellerDataDto.setIsDomesticTravel((String)nextRecord[2]);
	        	}
	        	try 
	        	{
	        	if(nextRecord[3]!=null)
		        {
	        	travellerDataDto.setDateOfJourney(NextTargetAreaUtil.convertStringToDate((String)nextRecord[3]));
		        }	
				} 
	        	catch (ParseException e) 
	        	{
					e.printStackTrace();
				}
	        	travellerDataList.add(travellerDataDto);
	        } 
	    } 
	    catch (IOException e) 
	    { 
	       throw new FileResolutionException("Unable to read the data from Travel_Type.csv", "Unable to read the data from Travel_Type.csv"); 
	    } 
	    catch (CsvValidationException e) 
	    {
			throw new CsvFileReadException("Unable to validate the Travel_Type csv", "Unable to validate the Travel_Type csv");
		}
	    finally
	    {
	    	if(csvReader!=null)
	    	{
	    		try
	    		{
					csvReader.close();
				} catch (IOException e) 
	    		{
					e.printStackTrace();
				}
	    	}
	    }
	}
	
	@Override
	public void pushDataToStaggingTable(Connection connection) 
	{
		PreparedStatement stmt=null;
		String travelTypeSql="insert into Travel_Type_STG"
				+ "(adhar_id, passport_no, is_domestic_travel, date_of_journey)"
				+ "values(?,?,?,?)";
		try 
		{
			stmt=connection.prepareStatement(travelTypeSql);
			for(TravellerDataDto dto: travellerDataList)
			{
				stmt.setString(1, dto.getAdharId());
				stmt.setString(2, dto.getPassportNo());
				stmt.setString(3, dto.getIsDomesticTravel());
				stmt.setDate(4, new Date(dto.getDateOfJourney().getTime()));
				stmt.executeUpdate();
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
