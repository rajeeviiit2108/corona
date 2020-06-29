package corona.nexttargetarea.stagingdatadto;

import java.util.Date;

public class SocialMediaPostStagingDataDto {
	private static final long serialVersionUID = 1L;
	
	private long adharId;
	private long mobileNumber;
	private String emailId;
	private String mediaPost;
	private Date postDate;
	
	public long getAdharId() {
		return adharId;
	}
	public void setAdharId(long adharId) {
		this.adharId = adharId;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMediaPost() {
		return mediaPost;
	}
	public void setMediaPost(String mediaPost) {
		this.mediaPost = mediaPost;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
}
