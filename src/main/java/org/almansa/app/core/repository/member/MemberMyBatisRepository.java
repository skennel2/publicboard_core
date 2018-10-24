package org.almansa.app.core.repository.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.almansa.app.core.entity.member.Member;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberMyBatisRepository implements MemberRepository {

    private SqlSession session;
    
    private final String mapperNamespace = "MEMBER_MAPPER.";
    
    @Autowired
    public MemberMyBatisRepository(SqlSession session) {
        super();
        this.session = session;
    }
    
    @Override
    public Member getById(Long id) {        
        return session.selectOne(mapperNamespace + "getById", id);
    }

    @Override
    public List<Member> getAll() {        
        return session.selectList(mapperNamespace + "getAll");
    }

    @Override
    public List<Member> getAdminMembers() {
        return session.selectList(mapperNamespace + "getAdminMembers");
    }    
    
    @Override
    public void delete(Long id) {
        session.delete(mapperNamespace + "delete", id);
    }

    @Override
    public void update(Member target) {        
        if(target.getId() == null) {
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("ID" , target.getId());
            parameters.put("LOGIN_ID" , target.getId());
            parameters.put("ID" , target.getId());
            parameters.put("ID" , target.getId());
            
            session.update(mapperNamespace + "insert", parameters);
        }
    }

    @Override
    public Member getByLoginId(String loginId) { 
        return session.selectOne(mapperNamespace + "getByLoginId", loginId);
    }

}
