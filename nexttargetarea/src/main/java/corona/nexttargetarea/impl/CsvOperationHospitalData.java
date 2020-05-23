package corona.nexttargetarea.impl;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import corona.nexttargetarea.csvdto.HospitalDataDto;
import corona.nexttargetarea.customexception.CsvFileReadException;
import corona.nexttargetarea.customexception.FileResolutionException;
import corona.nexttargetarea.interfaces.CsvOperation;
import corona.nexttargetarea.util.NextTargetAreaUtil;
public class CsvOperationHospitalData implements CsvOperation {
	private static List<HospitalDataDto> hospitalDataList=new ArrayList<>();
	@Override
	public void readCsvFile(String filePath, String fileName) 
	{
		CSVReader csvReader =null;
	    try 
	    { 
	        FileReader fileReader = new FileReader(filePath+fileName); 
	        csvReader = new CSVReader(fileReader);
	        HospitalDataDto hospitalDataDto=null;
	        Object[] nextRecord; 
	        nextRecord = csvReader.readNext();
	        while ((nextRecord = csvReader.readNext()) != null) 
	        {
	        	hospitalDataDto=new HospitalDataDto();
	        	if(nextRecord[0]!=null)
	        	{
	        	hospitalDataDto.setAdhar_id((String)nextRecord[0]);
	        	}
	        	if(nextRecord[1]!=null)
	        	{
	        	hospitalDataDto.setPassport_no((String)nextRecord[1]);
	        	}
	        	if(nextRecord[2]!=null)
	        	{
	        	hospitalDataDto.setPatient_disease_history((String)nextRecord[2]);
	        	}
	        	try 
	        	{
	        	if(nextRecord[3]!=null)
		        {
	             hospitalDataDto.setPatient_admitted_date(NextTargetAreaUtil.convertStringToDate((String)nextRecord[3]));
		        }	
	        	if(nextRecord[4]!=null)
	        	{
	        	hospitalDataDto.setPatient_discharged_date(NextTargetAreaUtil.convertStringToDate((String)nextRecord[4]));
	        	}
				} 
	        	catch (ParseException e) 
	        	{
					e.printStackTrace();
				}
	        	hospitalDataList.add(hospitalDataDto);
	        } 
	    } 
	    catch (IOException e) 
	    { 
	       throw new FileResolutionException("Unable to read the data from Hospital_Data.csv", "Unable to read the data from Hospital_Data.csv"); 
	    } 
	    catch (CsvValidationException e) 
	    {
			throw new CsvFileReadException("Unable to validate the Hospital_Data csv", "Unable to validate the Hospital_Data csv");
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
		for(HospitalDataDto dto: hospitalDataList)
		{
			System.out.println("AAdhar id is:::"+ dto.getAdhar_id() +"\t");
			System.out.println("Passport number is:::"+ dto.getPassport_no() +"\t");
			System.out.println("Patient Disease History is:::"+ dto.getPatient_disease_history() +"\t");
			System.out.println("Patient admitted date is:::"+ dto.getPatient_admitted_date() +"\t");
			System.out.println("Patient discharged date is:::"+ dto.getPatient_discharged_date() +"\t");
            System.out.println("--------------------------------------------");
		}	
	}
}