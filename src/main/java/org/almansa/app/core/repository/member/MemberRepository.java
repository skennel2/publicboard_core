package org.almansa.app.core.repository.member;

import java.util.List;

import org.almansa.app.core.entity.member.Member;
import org.almansa.app.core.repository.Repository;

public interface MemberRepository extends Repository<Long, Member>{
    Member getByLoginId(String loginId);
    List<Member> getAdminMembers();
}
