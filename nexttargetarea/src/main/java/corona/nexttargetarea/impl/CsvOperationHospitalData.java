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
import corona.nexttargetarea.csvdto.HospitalDataDto;
import corona.nexttargetarea.customexception.CsvFileReadException;
import corona.nexttargetarea.customexception.FileResolutionException;
import corona.nexttargetarea.dbconnection.DataBaseConnection;
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
		PreparedStatement stmt=null;
		Connection connection=DataBaseConnection.createConnection();
		String hospitalDataSql="insert into Hospital_Data_STG"
				+ "(adhar_id, passport_no, patient_disease_history, patient_admitted_date, patient_discharged_date)"
				+ "values(?,?,?,?,?)";
	try 
	{
			stmt=connection.prepareStatement(hospitalDataSql);
		for(HospitalDataDto dto: hospitalDataList)
		{
			stmt.setString(1, dto.getAdhar_id());
			stmt.setString(2, dto.getPassport_no());
			stmt.setString(3, dto.getPatient_disease_history());
			stmt.setDate(4, java.sql.Date.valueOf(NextTargetAreaUtil.convertDateToString(dto.getPatient_admitted_date())));
			stmt.setDate(5, java.sql.Date.valueOf(NextTargetAreaUtil.convertDateToString(dto.getPatient_discharged_date())));
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