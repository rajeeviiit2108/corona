package corona.nexttargetarea.impl;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import corona.nexttargetarea.csvdto.InternationalTravelDto;
import corona.nexttargetarea.customexception.CsvFileReadException;
import corona.nexttargetarea.customexception.FileResolutionException;
import corona.nexttargetarea.dbconnection.DataBaseConnection;
import corona.nexttargetarea.interfaces.CsvOperation;
import corona.nexttargetarea.util.NextTargetAreaUtil;

public class CsvOperationInternationalTravel implements CsvOperation {
	
	private static List<InternationalTravelDto> internationalTravelDataList=new ArrayList<>();
	@Override
	public void readCsvFile(String filePath, String fileName) 
	{
		CSVReader csvReader =null;
	    try 
	    { 
	        FileReader fileReader = new FileReader(filePath+fileName); 
	        csvReader = new CSVReader(fileReader);
	        InternationalTravelDto internationaltravelDto=null;
	        Object[] nextRecord; 
	        nextRecord = csvReader.readNext();
	        while ((nextRecord = csvReader.readNext()) != null) 
	        {
	        	internationaltravelDto=new InternationalTravelDto();
	        	if(nextRecord[0]!=null)
	        	{
	        		internationaltravelDto.setPassport_no((String)nextRecord[0]);
	        	}
	        	if(nextRecord[1]!=null)
	        	{
	        		internationaltravelDto.setIs_domestic_travel((String)nextRecord[1]);
	        	}
	        	if(nextRecord[2]!=null)
	        	{
	        		internationaltravelDto.setTravel_history((String)nextRecord[2]);
	        	}
	        	try 
	        	{
	        	if(nextRecord[3]!=null)
		        {
	        		internationaltravelDto.setTravel_date(NextTargetAreaUtil.convertStringToDate((String)nextRecord[3]));
		        }
	        	if(nextRecord[4]!=null)
	        	{
	        		internationaltravelDto.setTravel_from((String)nextRecord[4]);
	        	}
				} 
	        	catch (ParseException e) 
	        	{
					e.printStackTrace();
				}
	        	internationalTravelDataList.add(internationaltravelDto);
	        } 
	    } 
	    catch (IOException e) 
	    { 
	       throw new FileResolutionException("Unable to read the data from International_Travel.csv", "Unable to read the data from International_Travel.csv"); 
	    } 
	    catch (CsvValidationException e) 
	    {
			throw new CsvFileReadException("Unable to validate the International_Travel csv", "Unable to validate the International_Travel csv");
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
	public void pushDataToStaggingTable() 
	{

		PreparedStatement stmt=null;
		Connection connection=DataBaseConnection.createConnection();
		String internationalTravelSql="insert into International_Travel_STG"
				+ "(passport_no, is_domestic_travel, travel_history, travel_date, travel_from)"
				+ "values(?,?,?,?,?)";
	try 
	{
			stmt=connection.prepareStatement(internationalTravelSql);
		for(InternationalTravelDto dto: internationalTravelDataList)
		{
			stmt.setString(1, dto.getPassport_no());
			stmt.setString(2, dto.getIs_domestic_travel());
			stmt.setString(3, dto.getTravel_history());
			stmt.setDate(4, java.sql.Date.valueOf(NextTargetAreaUtil.convertDateToString(dto.getTravel_date())));
			stmt.setString(5, dto.getTravel_from());
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
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
}
	}


	
	


