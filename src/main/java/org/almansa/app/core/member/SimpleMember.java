package org.almansa.app.core.member;

public class SimpleMember implements Member{

	private long id;
	private String loginId;
	
	public SimpleMember(long id, String loginId) {
		super();
		this.id = id;
		this.loginId = loginId;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String loginId() {
		return loginId;
	}

	@Override
	public String toString() {
		return "SimpleMember [id=" + id + ", loginId=" + loginId + "]";
	}
}
