package corona.nexttargetarea.awscloud;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

public class AWSConnection {

	private static AmazonDynamoDB client =null;
	private static final String AWS_ACCESS_KEY_ID="AKIAIXSS4LTGV5TCMIZQ";
	private static final String AWS_SECRET_KEY="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";
	
	public static DynamoDB getDynamoDbInstance() 
	{
		System.out.println("Trying connecting to AWS cloud ......");
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(AWS_ACCESS_KEY_ID, AWS_SECRET_KEY);
    	 client = AmazonDynamoDBClientBuilder.standard()
    	                        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
    	                        .withRegion(Regions.US_EAST_2)
    	                        .build();
    	 System.out.println("AWS connection established ......");
    	 return new DynamoDB(client);
	}
	
	/*public static AmazonDynamoDB getAmazonDynamoDbInstance() 
	{
		System.out.println("Trying connecting to AWS cloud ......");
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(AWS_ACCESS_KEY_ID, AWS_SECRET_KEY);
    	 client = AmazonDynamoDBClientBuilder.standard()
    	                        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
    	                        .withRegion(Regions.US_EAST_2)
    	                        .build();
    	 System.out.println("AWS connection established ......");
    	 
	}*/
	
	
}
