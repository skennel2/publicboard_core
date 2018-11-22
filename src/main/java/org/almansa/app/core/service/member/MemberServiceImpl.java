package org.almansa.app.core.service.member;

import java.util.Date;
import java.util.Objects;

import org.almansa.app.core.entity.member.Member;
import org.almansa.app.core.entity.member.SimpleMember;
import org.almansa.app.core.exception.EntityExistsException;
import org.almansa.app.core.repository.member.MemberRepository;
import org.almansa.app.core.service.dto.LoginMemberSessionModel;
import org.almansa.app.core.util.Entities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
public class MemberServiceImpl implements MemberService {

	private MemberRepository memberRepo;

	@Autowired
	public MemberServiceImpl(MemberRepository memberRepo) {
		super();
		this.memberRepo = memberRepo;
	}

	@Override
	@Transactional(readOnly = true)
	public LoginMemberSessionModel loginAndGetUserSessionModel(String loginId, String password) {
		LoginMemberSessionModel loginModel = new LoginMemberSessionModel();

		try {
			Member member = getByLoginId(loginId);
			if (Objects.isNull(member)) {
				loginModel.setLoginSuccess(false);
				loginModel.getFailureMessages().add("아이디가 존재하지 않습니다.");
				return loginModel;
			}

			if (!Objects.equals(member.getPassword(), password)) {
				loginModel.setLoginSuccess(false);
				loginModel.getFailureMessages().add("비밀번호를 확인해주세요.");
				return loginModel;
			}

			loginModel.setId(member.getId());
			loginModel.setLoginId(member.getLoginId());
			loginModel.setLoginSuccess(true);
			loginModel.setLoginDate(new Date());

		} catch (Exception ex) {
			loginModel.setLoginSuccess(false);
			loginModel.getFailureMessages().add(ex.getMessage());
		}

		return loginModel;
	}

	@Override
	@Transactional(readOnly = true)
	public Member getByLoginId(String loginId) {
		return memberRepo.getByLoginId(loginId);
	}

	@Override
	@Transactional
	public void joinSimply(String loginId, String password, String passwordCheck) throws EntityExistsException, MemberJoinException {
		try {
			Assert.notNull(loginId, "loginId can't be null");
			Assert.notNull(password, "password can't be null");
			Assert.notNull(passwordCheck, "passwordCheck can't be null");
		}catch(IllegalArgumentException ex) {
			throw new MemberJoinException("required value is null", ex);
		}
		
		if(!password.equals(passwordCheck)) {
			throw new MemberJoinException("passwordCheck");
		}
		
		Member member = getByLoginId(loginId);
		Entities.assertEntityNotAleadyExists(member, "member aleady exists");

		member = new SimpleMember(loginId, password, false);
		memberRepo.update(member);
	}

	@Override
	@Transactional(readOnly = true)
	public Member getById(Long id) {
		return memberRepo.getById(id);
	}
}
