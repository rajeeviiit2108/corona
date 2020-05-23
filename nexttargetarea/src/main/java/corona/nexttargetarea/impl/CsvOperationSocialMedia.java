package corona.nexttargetarea.impl;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import corona.nexttargetarea.csvdto.Social_MediaDto;
import corona.nexttargetarea.customexception.CsvFileReadException;
import corona.nexttargetarea.customexception.FileResolutionException;
import corona.nexttargetarea.interfaces.CsvOperation;
import corona.nexttargetarea.util.NextTargetAreaUtil;
public class CsvOperationSocialMedia implements CsvOperation {
	
	private static List<Social_MediaDto> socialMedia=new ArrayList<>();
	@Override
	public void readCsvFile(String filePath, String fileName) 
	{
		CSVReader csvReader =null;
	    try 
	    { 
	        FileReader fileReader = new FileReader(filePath+fileName); 
	        csvReader = new CSVReader(fileReader);
	        Social_MediaDto socialMediaDto=null;
	        Object[] nextRecord; 
	        nextRecord = csvReader.readNext();
	        while ((nextRecord = csvReader.readNext()) != null) 
	        {
	        	socialMediaDto=new Social_MediaDto();
	        	if(nextRecord[0]!=null)
	        	{
	        		socialMediaDto.setAdhar_id((String)nextRecord[0]);
	        	}
	        	if(nextRecord[1]!=null)
	        	{
	        		socialMediaDto.setMobile_no((String)nextRecord[1]);
	        	}
	        	if(nextRecord[2]!=null)
	        	{
	        		socialMediaDto.setEmail_id((String)nextRecord[2]);
	        	}
	        	if(nextRecord[3]!=null)
	        	{
	        		socialMediaDto.setMedia_post((String)nextRecord[3]);
	        	}
	        	try 
	        	{
	        	if(nextRecord[4]!=null)
		        {
	        		socialMediaDto.setPost_date(NextTargetAreaUtil.convertStringToDate((String)nextRecord[4]));
		        }					} 
	        	catch (ParseException e) 
	        	{
					e.printStackTrace();
				}
	        	socialMedia.add(socialMediaDto);
	        } 
	    } 
	    catch (IOException e) 
	    { 
	       throw new FileResolutionException("Unable to read the data from Social_Media_Post.csv", "Unable to read the data from Social_Media_Post.csv"); 
	    } 
	    catch (CsvValidationException e) 
	    {
			throw new CsvFileReadException("Unable to validate the Social_Media_Post csv", "Unable to validate the Social_Media_Post csv");
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
		for(Social_MediaDto dto:socialMedia )
		{
			System.out.println("AAdhar id is:::"+ dto.getAdhar_id() +"\t");
			System.out.println("Mobile No. is:::"+ dto.getMobile_no() +"\t");
			System.out.println("E-mail id is:::"+ dto.getEmail_id() +"\t");
			System.out.println("Media Post is:::"+ dto.getMedia_post() +"\t");
			System.out.println("Post Date is:::"+ dto.getPost_date() +"\t");
			System.out.println("--------------------------------------------");
		}	
	}
}





