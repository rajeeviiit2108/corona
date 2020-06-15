package corona.nexttargetarea.awscloud;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import com.amazonaws.services.dynamodbv2.util.TableUtils.TableNeverTransitionedToStateException;

public class StagingTableCreationOnDyanamoDB 
{
	private static final String TRAVEL_TYPE_STG="Travel_Type_STG";
	private static final String DOMESTIC_TRAVEL_STG="Domestic_Travel_STG";
	private static final String INTERNATIONAL_TRAVEL_STG="International_Travel_STG";
	private static final String  HOSPITAL_DATA_STG="Hospital_Data_STG";
	private static final String  SOCIAL_MEDIA_STG="Social_Media_STG";
	private static final String INTERNET_DATA_STG="Internet_Data_STG";
	private static AmazonDynamoDB client =null;
	private static final String AWS_ACCESS_KEY_ID="AKIAIXSS4LTGV5TCMIZQ";
	private static final String AWS_SECRET_KEY="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";
	
	/*CREATE  TABLE  Travel_Type_STG(
			adhar_id  VARCHAR(255),
			passport_no  VARCHAR(255),
			is_domestic_travel  VARCHAR(255),
			date_of_journey  DATE
			);*/

	public void createTravelTypeStaggingTable()
	{
		System.out.println("Trying connecting to AWS cloud ......");
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(AWS_ACCESS_KEY_ID, AWS_SECRET_KEY);
    	 client = AmazonDynamoDBClientBuilder.standard()
    	                        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
    	                        .withRegion(Regions.US_EAST_2)
    	                        .build();
    	 System.out.println("AWS connection established ......");
		  System.out.println("Attempting to create table:::  "+ TRAVEL_TYPE_STG + " ::: please wait...");
		 CreateTableRequest createTableRequest = new CreateTableRequest().withTableName(TRAVEL_TYPE_STG)
	                .withKeySchema(new KeySchemaElement().withAttributeName("adhar_id").withKeyType(KeyType.HASH))
	                .withAttributeDefinitions(new AttributeDefinition().withAttributeName("adhar_id").withAttributeType(ScalarAttributeType.S))
	                .withProvisionedThroughput(new ProvisionedThroughput().withReadCapacityUnits(1L).withWriteCapacityUnits(1L));
	            System.out.println("table created" + createTableRequest.getClass());
	            TableUtils.createTableIfNotExists(client, createTableRequest);
	            try {
					TableUtils.waitUntilActive(client, TRAVEL_TYPE_STG);
				} catch (TableNeverTransitionedToStateException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	            System.out.println("Table:::  "+ TRAVEL_TYPE_STG + "::: Table created...");
	} 


	
	/*private static Map<String, AttributeValue> newItem() {
	 * 
        Map<String, AttributeValue> item = new HashMap<String, AttributeValue>();
        item.put("adhar_id", new AttributeValue("100"));
        item.put("Passport_num", new AttributeValue("200"));
        item.put("is_domestic_travel", new AttributeValue("Y"));
        item.put("Date_Of_Journey", new AttributeValue("24-March-2020"));
            /*PutItemRequest putItemRequest = new PutItemRequest(TRAVEL_TYPE_STG, newItem());
	            PutItemResult putItemResult = client.putItem(putItemRequest);
	            System.out.println("Result: " + putItemResult);*/

       // return item;
    //}*/
	
	
	
//}


	public void createDomesticTravelStaggingTable()
	{
		System.out.println("Trying connecting to AWS cloud ......");
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(AWS_ACCESS_KEY_ID, AWS_SECRET_KEY);
    	 client = AmazonDynamoDBClientBuilder.standard()
    	                        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
    	                        .withRegion(Regions.US_EAST_2)
    	                        .build();
    	 System.out.println("AWS connection established ......");
		  System.out.println("Attempting to create table:::  "+ DOMESTIC_TRAVEL_STG + " ::: please wait...");
		 CreateTableRequest createTableRequest = new CreateTableRequest().withTableName(DOMESTIC_TRAVEL_STG)
	                .withKeySchema(new KeySchemaElement().withAttributeName("adhar_id").withKeyType(KeyType.HASH))
	                .withAttributeDefinitions(new AttributeDefinition().withAttributeName("adhar_id").withAttributeType(ScalarAttributeType.S))
	                .withProvisionedThroughput(new ProvisionedThroughput().withReadCapacityUnits(1L).withWriteCapacityUnits(1L));
	            System.out.println("table created" + createTableRequest.getClass());
	            TableUtils.createTableIfNotExists(client, createTableRequest);
	            try {
					TableUtils.waitUntilActive(client, DOMESTIC_TRAVEL_STG);
				} catch (TableNeverTransitionedToStateException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	            System.out.println("Table:::  "+ DOMESTIC_TRAVEL_STG + "::: Table created...");
	} 




	public void createInternationalTravelStaggingTable()
	{
		System.out.println("Trying connecting to AWS cloud ......");
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(AWS_ACCESS_KEY_ID, AWS_SECRET_KEY);
    	 client = AmazonDynamoDBClientBuilder.standard()
    	                        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
    	                        .withRegion(Regions.US_EAST_2)
    	                        .build();
    	 System.out.println("AWS connection established ......");
		  System.out.println("Attempting to create table:::  "+ INTERNATIONAL_TRAVEL_STG + " ::: please wait...");
		 CreateTableRequest createTableRequest = new CreateTableRequest().withTableName(INTERNATIONAL_TRAVEL_STG)
	                .withKeySchema(new KeySchemaElement().withAttributeName("passport_no.").withKeyType(KeyType.HASH))
	                .withAttributeDefinitions(new AttributeDefinition().withAttributeName("passport_no.").withAttributeType(ScalarAttributeType.S))
	                .withProvisionedThroughput(new ProvisionedThroughput().withReadCapacityUnits(1L).withWriteCapacityUnits(1L));
	            System.out.println("table created" + createTableRequest.getClass());
	            TableUtils.createTableIfNotExists(client, createTableRequest);
	            try {
					TableUtils.waitUntilActive(client, INTERNATIONAL_TRAVEL_STG);
				} catch (TableNeverTransitionedToStateException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	            System.out.println("Table:::  "+ INTERNATIONAL_TRAVEL_STG + "::: Table created...");
	} 
  



	/*
CREATE  TABLE  Hospital_Data_STG(
adhar_id  VARCHAR(255),
passport_no  VARCHAR(255),
patient_disease_history  VARCHAR(255),
patient_admitted_date  DATE,
patient_discharged_date  DATE,
is_corona_confirmed  BIT,
corona_suscpected  BIT


			);*/

	public void createHospitalDataStaggingTable()
	{
		System.out.println("Trying connecting to AWS cloud ......");
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(AWS_ACCESS_KEY_ID, AWS_SECRET_KEY);
    	 client = AmazonDynamoDBClientBuilder.standard()
    	                        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
    	                        .withRegion(Regions.US_EAST_2)
    	                        .build();
    	 System.out.println("AWS connection established ......");
		  System.out.println("Attempting to create table:::  "+ HOSPITAL_DATA_STG + " ::: please wait...");
		 CreateTableRequest createTableRequest = new CreateTableRequest().withTableName(HOSPITAL_DATA_STG)
	                .withKeySchema(new KeySchemaElement().withAttributeName("adhar_id").withKeyType(KeyType.HASH))
	                .withAttributeDefinitions(new AttributeDefinition().withAttributeName("adhar_id").withAttributeType(ScalarAttributeType.S))
	                .withProvisionedThroughput(new ProvisionedThroughput().withReadCapacityUnits(1L).withWriteCapacityUnits(1L));
	            System.out.println("table created" + createTableRequest.getClass());
	            TableUtils.createTableIfNotExists(client, createTableRequest);
	            try {
					TableUtils.waitUntilActive(client, HOSPITAL_DATA_STG);
				} catch (TableNeverTransitionedToStateException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	            System.out.println("Table:::  "+ HOSPITAL_DATA_STG + "::: Table created...");
	} 
 


	
	/*
CREATE  TABLE  Social_Media_STG(
adhar_id  VARCHAR(255),
mobile_no  VARCHAR(255),
email_id  VARCHAR(255),
media_post  VARCHAR(255),
post_date  DATE


			);*/

	public void createSocialMediaStaggingTable()
	{
		System.out.println("Trying connecting to AWS cloud ......");
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(AWS_ACCESS_KEY_ID, AWS_SECRET_KEY);
    	 client = AmazonDynamoDBClientBuilder.standard()
    	                        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
    	                        .withRegion(Regions.US_EAST_2)
    	                        .build();
    	 System.out.println("AWS connection established ......");
		  System.out.println("Attempting to create table:::  "+ SOCIAL_MEDIA_STG + " ::: please wait...");
		 CreateTableRequest createTableRequest = new CreateTableRequest().withTableName(SOCIAL_MEDIA_STG)
	                .withKeySchema(new KeySchemaElement().withAttributeName("adhar_id").withKeyType(KeyType.HASH))
	                .withAttributeDefinitions(new AttributeDefinition().withAttributeName("adhar_id").withAttributeType(ScalarAttributeType.S))
	                .withProvisionedThroughput(new ProvisionedThroughput().withReadCapacityUnits(1L).withWriteCapacityUnits(1L));
	            System.out.println("table created" + createTableRequest.getClass());
	            TableUtils.createTableIfNotExists(client, createTableRequest);
	            try {
					TableUtils.waitUntilActive(client, SOCIAL_MEDIA_STG);
				} catch (TableNeverTransitionedToStateException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	            System.out.println("Table:::  "+ SOCIAL_MEDIA_STG + "::: Table created...");
	} 




	/*
CREATE  TABLE   Internet_Data_STG(
email_id  VARCHAR(255),
information  VARCHAR(255),
link  VARCHAR(255),
place_name  VARCHAR(255),
no_of_infected_people  VARCHAR(255)
);*/

	public void createInternetDataStaggingTable()
	{
		System.out.println("Trying connecting to AWS cloud ......");
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(AWS_ACCESS_KEY_ID, AWS_SECRET_KEY);
    	 client = AmazonDynamoDBClientBuilder.standard()
    	                        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
    	                        .withRegion(Regions.US_EAST_2)
    	                        .build();
    	 System.out.println("AWS connection established ......");
		  System.out.println("Attempting to create table:::  "+ INTERNET_DATA_STG + " ::: please wait...");
		 CreateTableRequest createTableRequest = new CreateTableRequest().withTableName(INTERNET_DATA_STG)
	                .withKeySchema(new KeySchemaElement().withAttributeName("adhar_id").withKeyType(KeyType.HASH))
	                .withAttributeDefinitions(new AttributeDefinition().withAttributeName("adhar_id").withAttributeType(ScalarAttributeType.S))
	                .withProvisionedThroughput(new ProvisionedThroughput().withReadCapacityUnits(1L).withWriteCapacityUnits(1L));
	            System.out.println("table created" + createTableRequest.getClass());
	            TableUtils.createTableIfNotExists(client, createTableRequest);
	            try {
					TableUtils.waitUntilActive(client, INTERNET_DATA_STG);
				} catch (TableNeverTransitionedToStateException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	            System.out.println("Table:::  "+ INTERNET_DATA_STG + "::: Table created...");
	} 
} 
