package org.almansa.app.core.repository.post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.almansa.app.core.entity.post.Post;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostMyBatisRepository implements PostRepository{
    
    private SqlSession sqlSession;
    
    private final String namespace = "POST_MAPPER.";

    @Autowired
    public PostMyBatisRepository(SqlSession sqlSession) {
        super();
        this.sqlSession = sqlSession;
    }

    @Override
    public Post getById(Long id) {
        return sqlSession.selectOne(namespace + "getById", id);
    }

    @Override
    public List<Post> getAll() {        
        return sqlSession.selectList(namespace + "all");
    }

    @Override
    public void delete(Long id) {
        int cnt = sqlSession.delete(namespace + "delete", id);
        System.out.println(cnt);
    }

    @Override
    public void update(Post target) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        String statementId = "";
        
        if(target.getId() == null) {
            parameters.put("NAME", target.getName());
            parameters.put("CREATION_DATE", target.getCreationDate());
            parameters.put("MODIFIED_DATE", target.getCreationDate());
            parameters.put("CONTENTS", target.getContents());
            parameters.put("BOARD_ID", target.getOwnerBoardId());
            parameters.put("MEMBER_ID", target.getWriterId());
            
            statementId = "insert"; 
        }else {
            parameters.put("ID", target.getId());
            parameters.put("NAME", target.getName());
            parameters.put("CREATION_DATE", target.getCreationDate()); 
            parameters.put("MODIFIED_DATE", target.getCreationDate());
            parameters.put("CONTENTS", target.getContents());
            parameters.put("BOARD_ID", target.getOwnerBoardId());
            parameters.put("MEMBER_ID", target.getWriterId());
            parameters.put("CLICK_CNT", target.getClickCount());    
            
            statementId = "update"; 
        }
        
        int cnt =  sqlSession.update(namespace + statementId, parameters);
        System.out.println(cnt);        
    }

    @Override
    public List<Post> getByWriterId(long writerId) {
        return sqlSession.selectList(namespace + "getByWriterId", writerId);
    }
}
