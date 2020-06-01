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

import corona.nexttargetarea.csvdto.DomesticTravelDto;
import corona.nexttargetarea.customexception.CsvFileReadException;
import corona.nexttargetarea.customexception.FileResolutionException;
import corona.nexttargetarea.dbconnection.DataBaseConnection;
import corona.nexttargetarea.interfaces.CsvOperation;
import corona.nexttargetarea.util.NextTargetAreaUtil;
public class CsvOperationDomesticTravel implements CsvOperation {
	
	private static List<DomesticTravelDto> domesticTravelList=new ArrayList<>();
	@Override
	public void readCsvFile(String filePath, String fileName) 
	{
		CSVReader csvReader =null;
	    try 
	    { 
	        FileReader fileReader = new FileReader(filePath+fileName); 
	        csvReader = new CSVReader(fileReader);
	        DomesticTravelDto domestictravelDto=null;
	        Object[] nextRecord; 
	        nextRecord = csvReader.readNext();
	        while ((nextRecord = csvReader.readNext()) != null) 
	        {
	        	domestictravelDto=new DomesticTravelDto();
	        	if(nextRecord[0]!=null)
	        	{
	        		domestictravelDto.setAdhar_id((String)nextRecord[0]);
	        	}
	        	if(nextRecord[1]!=null)
	        	{
	        		domestictravelDto.setIs_domestic_travel((String)nextRecord[1]);
	        	}
	        	if(nextRecord[2]!=null)
	        	{
	        		domestictravelDto.setTravel_history((String)nextRecord[2]);
	        	}
	        	try 
	        	{
	        	if(nextRecord[3]!=null)
		        {
	        		domestictravelDto.setTravel_date(NextTargetAreaUtil.convertStringToDate((String)nextRecord[3]));
		        }	
	        	if(nextRecord[4]!=null)
	        	{
	        		domestictravelDto.setTravel_from((String)nextRecord[4]);
	        	}
				} 
	        	catch (ParseException e) 
	        	{
					e.printStackTrace();
				}
	        	domesticTravelList.add(domestictravelDto);
	        } 
	    } 
	    catch (IOException e) 
	    { 
	       throw new FileResolutionException("Unable to read the data from Domestic-Travel.csv", "Unable to read the data from Domestic-Travel.csv"); 
	    } 
	    catch (CsvValidationException e) 
	    {
			throw new CsvFileReadException("Unable to validate the Domestic-Travel csv", "Unable to validate the Domestic-Travel csv");
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
		String domesticTravelSql="insert into Domestic_Travel_STG"
				+ "(adhar_id, is_domestic_travel, travel_history, travel_date, travel_from)"
				+ "values(?,?,?,?,?)";
		try 
		{
			stmt=connection.prepareStatement(domesticTravelSql);
		for(DomesticTravelDto dto:domesticTravelList )
		{
			
			stmt.setString(1, dto.getAdhar_id());
			stmt.setString(2, dto.getIs_domestic_travel());
			stmt.setString(3, dto.getTravel_history());
			stmt.setDate(4, java.sql.Date.valueOf(NextTargetAreaUtil.convertDateToString(dto.getTravel_date())));
			stmt.setString(5, dto.getTravel_from());
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


