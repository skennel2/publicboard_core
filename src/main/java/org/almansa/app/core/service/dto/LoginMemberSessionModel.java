package org.almansa.app.core.service.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoginMemberSessionModel implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String loginId;
	private boolean isLoginSuccess;
	private List<String> failureMessages;
	private Date loginDate;

	public LoginMemberSessionModel() {
		super();
		this.failureMessages = new ArrayList<String>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public boolean isLoginSuccess() {
		return isLoginSuccess;
	}

	public void setLoginSuccess(boolean isLoginSuccess) {
		this.isLoginSuccess = isLoginSuccess;
	}

	public List<String> getFailureMessages() {
		return failureMessages;
	}

	public void setFailureMessages(List<String> failureMessages) {
		this.failureMessages = failureMessages;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	@Override
	public String toString() {
		return "LoginMemberSessionModel [id=" + id + ", loginId=" + loginId + ", isLoginSuccess=" + isLoginSuccess
				+ ", failureMessages=" + failureMessages + "]";
	}
}
