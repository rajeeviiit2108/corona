package corona.nexttargetarea.csvdto;

import java.io.Serializable;
import java.util.Date;
public class Social_MediaDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private String adhar_id;
	private String mobile_no;
    private String email_id;
	private String media_post;
	private Date post_date;
	public String getAdhar_id() {
		return adhar_id;
	}
	public void setAdhar_id(String adhar_id) {
		this.adhar_id = adhar_id;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getMedia_post() {
		return media_post;
	}
	public void setMedia_post(String media_post) {
		this.media_post = media_post;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
}
