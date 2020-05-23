package corona.nexttargetarea.impl;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import corona.nexttargetarea.csvdto.InternetDataDto;
import corona.nexttargetarea.customexception.CsvFileReadException;
import corona.nexttargetarea.customexception.FileResolutionException;
import corona.nexttargetarea.interfaces.CsvOperation;

public class CsvOperationInternetData implements CsvOperation{
	
	

	private static List<InternetDataDto> internetData=new ArrayList<>();
	@Override
	public void readCsvFile(String filePath, String fileName) 
	{
		CSVReader csvReader =null;
	    try 
	    { 
	        FileReader fileReader = new FileReader(filePath+fileName); 
	        csvReader = new CSVReader(fileReader);
	        InternetDataDto internetDataDto =null;
	        Object[] nextRecord; 
	        nextRecord = csvReader.readNext();
	        while ((nextRecord = csvReader.readNext()) != null) 
	        {
	        	internetDataDto=new InternetDataDto();
	        	if(nextRecord[0]!=null)
	        	{
	        		internetDataDto.setEmail_id((String)nextRecord[0]);
	        	}
	        	if(nextRecord[1]!=null)
	        	{
	        		internetDataDto.setInformation((String)nextRecord[1]);
	        	}
	        	if(nextRecord[2]!=null)
	        	{
	        		internetDataDto.setLink((String)nextRecord[2]);
	        	}
	        	
	        	if(nextRecord[3]!=null)
		        {
	        		internetDataDto.setPlace_name((String)nextRecord[3]);
		        }	
	        	if(nextRecord[4]!=null)
		        {
	        		internetDataDto.setNo_of_infected_people((String)nextRecord[4]);
		        }	
				
	        	internetData.add(internetDataDto);
	        } 
	    } 
	    catch (IOException e) 
	    { 
	       throw new FileResolutionException("Unable to read the data from Internet_Data.csv", "Unable to read the data from Internet_Data.csv"); 
	    } 
	    catch (CsvValidationException e) 
	    {
			throw new CsvFileReadException("Unable to validate the Internet_Data csv", "Unable to validate the Internet_Data csv");
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
		for(InternetDataDto dto:internetData )
		{
			System.out.println("E-mail id is:::"+ dto.getEmail_id() +"\t");
			System.out.println("Information is:::"+ dto.getInformation() +"\t");
			System.out.println("Link is:::"+ dto.getLink() +"\t");
			System.out.println("Place Name is:::"+ dto.getPlace_name() +"\t");
			System.out.println("No. of Infected People is:::"+ dto.getNo_of_infected_people() +"\t");
            System.out.println("--------------------------------------------");
		}	
	}
}


