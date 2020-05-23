package corona.nexttargetarea.impl;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import corona.nexttargetarea.csvdto.InternationalTravelDto;
import corona.nexttargetarea.customexception.CsvFileReadException;
import corona.nexttargetarea.customexception.FileResolutionException;
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
		for(InternationalTravelDto dto: internationalTravelDataList)
		{
			System.out.println("Passport number is:::"+ dto.getPassport_no() +"\t");
			System.out.println(" Is Domestic travel is:::"+ dto.getIs_domestic_travel() +"\t");
			System.out.println(" Travel History is:::"+ dto.getTravel_history() +"\t");
			System.out.println("Travel Date is:::"+ dto.getTravel_date() +"\t");
			System.out.println("Travel From is:::"+ dto.getTravel_from() +"\t");
			System.out.println("--------------------------------------------");
		}	
	}
}


	
	


