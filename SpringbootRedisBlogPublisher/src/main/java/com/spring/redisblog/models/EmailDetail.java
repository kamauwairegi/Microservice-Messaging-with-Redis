package com.spring.redisblog.models;

import java.io.Serializable;
import java.util.List;

public class EmailDetail implements Serializable {

	private static final long serialVersionUID = -1844574815655966922L;
	private String userId;
	private String blogId;
	private List<String> emails;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBlogId() {
		return blogId;
	}

	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}
	
	@Override
	public String toString() {
		return "EmailDetail{" + "userId=" + userId + ", blogId=" + blogId + ", emails=" + emails +  "}";
	}
}
