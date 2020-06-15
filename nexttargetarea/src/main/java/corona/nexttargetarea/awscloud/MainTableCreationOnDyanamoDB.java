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



public class MainTableCreationOnDyanamoDB {
	private static final String SOCIAL_MEDIA_MAIN="Social_Media";
	private static final String INTERNET_DATA_MAIN="Internet_Data";
	private static final String ADHAR_CARD_MAIN="Adhar_Card";
	private static final String PASSPORT_MAIN="Passport";
	
	
    private static AmazonDynamoDB client =null;
    private static final String AWS_ACCESS_KEY_ID="AKIAIXSS4LTGV5TCMIZQ";
    private static final String AWS_SECRET_KEY="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";

    /*CREATE  TABLE  Social_Media_Post(
adhar_id   BIGINT(12),
mobile_no   BIGINT(10)PRIMARY KEY,
email_id  VARCHAR(255),
media_post  VARCHAR(255),
post_date  DATE,
FOREIGN KEY (adhar_id) references Adhar_Card(adhar_id)
)*/
    
public void createSocialMediaMainTable()
{
	System.out.println("Trying connecting to AWS cloud ......");
	BasicAWSCredentials awsCreds = new BasicAWSCredentials(AWS_ACCESS_KEY_ID, AWS_SECRET_KEY);
	 client = AmazonDynamoDBClientBuilder.standard()
	                        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
	                        .withRegion(Regions.US_EAST_2)
	                        .build();
	 System.out.println("AWS connection established ......");
	  System.out.println("Attempting to create table:::  "+ SOCIAL_MEDIA_MAIN + " ::: please wait...");
	 CreateTableRequest createTableRequest = new CreateTableRequest().withTableName(SOCIAL_MEDIA_MAIN)
                .withKeySchema(new KeySchemaElement().withAttributeName("adhar_id").withKeyType(KeyType.HASH))
                .withAttributeDefinitions(new AttributeDefinition().withAttributeName("adhar_id").withAttributeType(ScalarAttributeType.S))
                .withProvisionedThroughput(new ProvisionedThroughput().withReadCapacityUnits(1L).withWriteCapacityUnits(1L));
            System.out.println("table created" + createTableRequest.getClass());
            TableUtils.createTableIfNotExists(client, createTableRequest);
            try {
				TableUtils.waitUntilActive(client, SOCIAL_MEDIA_MAIN);
			} catch (TableNeverTransitionedToStateException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
            System.out.println("Table:::  "+ SOCIAL_MEDIA_MAIN + "::: Table created...");
} 
/*CREATE  TABLE  Internet_Data(
email_id  VARCHAR(255)PRIMARY KEY,
information  VARCHAR(255),
link  VARCHAR(255),
place_name  VARCHAR(255),
no_of_infected_people  DOUBLE
 
 	);*/

public void createInternetDataMainTable()
{
	System.out.println("Trying connecting to AWS cloud ......");
	BasicAWSCredentials awsCreds = new BasicAWSCredentials(AWS_ACCESS_KEY_ID, AWS_SECRET_KEY);
	 client = AmazonDynamoDBClientBuilder.standard()
	                        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
	                        .withRegion(Regions.US_EAST_2)
	                        .build();
	 System.out.println("AWS connection established ......");
	  System.out.println("Attempting to create table:::  "+ INTERNET_DATA_MAIN + " ::: please wait...");
	 CreateTableRequest createTableRequest = new CreateTableRequest().withTableName(INTERNET_DATA_MAIN)
               .withKeySchema(new KeySchemaElement().withAttributeName("adhar_id").withKeyType(KeyType.HASH))
               .withAttributeDefinitions(new AttributeDefinition().withAttributeName("adhar_id").withAttributeType(ScalarAttributeType.S))
               .withProvisionedThroughput(new ProvisionedThroughput().withReadCapacityUnits(1L).withWriteCapacityUnits(1L));
           System.out.println("table created" + createTableRequest.getClass());
           TableUtils.createTableIfNotExists(client, createTableRequest);
           try {
				TableUtils.waitUntilActive(client, INTERNET_DATA_MAIN);
			} catch (TableNeverTransitionedToStateException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
           System.out.println("Table:::  "+ INTERNET_DATA_MAIN + "::: Table created...");
} 
/*CREATE TABLE Adhar_Card(
adhar_id  BIGINT(12) PRIMARY KEY,
mobile_no  BIGINT(10),
first_name  VARCHAR(255),
last_name  VARCHAR(255),
email_id  VARCHAR(255),
address  VARCHAR(255),
dob  DATE,
city  VARCHAR(255),
password  VARCHAR(255)
 	);*/

public void createAdharCardMainTable()
{
	System.out.println("Trying connecting to AWS cloud ......");
	BasicAWSCredentials awsCreds = new BasicAWSCredentials(AWS_ACCESS_KEY_ID, AWS_SECRET_KEY);
	 client = AmazonDynamoDBClientBuilder.standard()
	                        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
	                        .withRegion(Regions.US_EAST_2)
	                        .build();
	 System.out.println("AWS connection established ......");
	  System.out.println("Attempting to create table:::  "+ ADHAR_CARD_MAIN + " ::: please wait...");
	 CreateTableRequest createTableRequest = new CreateTableRequest().withTableName(ADHAR_CARD_MAIN)
               .withKeySchema(new KeySchemaElement().withAttributeName("adhar_id").withKeyType(KeyType.HASH))
               .withAttributeDefinitions(new AttributeDefinition().withAttributeName("adhar_id").withAttributeType(ScalarAttributeType.S))
               .withProvisionedThroughput(new ProvisionedThroughput().withReadCapacityUnits(1L).withWriteCapacityUnits(1L));
           System.out.println("table created" + createTableRequest.getClass());
           TableUtils.createTableIfNotExists(client, createTableRequest);
           try {
				TableUtils.waitUntilActive(client, ADHAR_CARD_MAIN);
			} catch (TableNeverTransitionedToStateException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
           System.out.println("Table:::  "+ ADHAR_CARD_MAIN + "::: Table created...");
} 
/*CREATE TABLE Passport(
passport_no  BIGINT(9)  PRIMARY  KEY,
first_name  VARCHAR(255),
last_name  VARCHAR(255),
address  VARCHAR(255),
dob  DATE,
state_of_issue  VARCHAR(255),
password  VARCHAR(255)

		);*/

public void createInternationalTravelMainTable()
{
	System.out.println("Trying connecting to AWS cloud ......");
	BasicAWSCredentials awsCreds = new BasicAWSCredentials(AWS_ACCESS_KEY_ID, AWS_SECRET_KEY);
	 client = AmazonDynamoDBClientBuilder.standard()
	                        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
	                        .withRegion(Regions.US_EAST_2)
	                        .build();
	 System.out.println("AWS connection established ......");
	  System.out.println("Attempting to create table:::  "+ PASSPORT_MAIN + " ::: please wait...");
	 CreateTableRequest createTableRequest = new CreateTableRequest().withTableName(PASSPORT_MAIN)
                .withKeySchema(new KeySchemaElement().withAttributeName("passsport_no.").withKeyType(KeyType.HASH))
                .withAttributeDefinitions(new AttributeDefinition().withAttributeName("passport_no.").withAttributeType(ScalarAttributeType.S))
                .withProvisionedThroughput(new ProvisionedThroughput().withReadCapacityUnits(1L).withWriteCapacityUnits(1L));
            System.out.println("table created" + createTableRequest.getClass());
            TableUtils.createTableIfNotExists(client, createTableRequest);
            try {
				TableUtils.waitUntilActive(client, PASSPORT_MAIN);
			} catch (TableNeverTransitionedToStateException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
            System.out.println("Table:::  "+ PASSPORT_MAIN + "::: Table created...");
} 


}  


