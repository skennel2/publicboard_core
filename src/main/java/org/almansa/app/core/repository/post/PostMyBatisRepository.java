package org.almansa.app.core.repository.post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.almansa.app.core.post.Post;
import org.almansa.app.typehandler.DateToStringTypeConverter;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostMyBatisRepository implements PostRepository{
    
    private SqlSession sqlSession;
    private DateToStringTypeConverter dateToStringTypeConverter;
    
    private final String namespace = "POST_MAPPER.";

    @Autowired
    public PostMyBatisRepository(SqlSession sqlSession, DateToStringTypeConverter dateToStringTypeConverter) {
        super();
        this.sqlSession = sqlSession;
        this.dateToStringTypeConverter = dateToStringTypeConverter;
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
        if(target.getId() == null) {
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("NAME", target.getName());
            parameters.put("CREATION_DATE", dateToStringTypeConverter.convert(target.getCreationDate()));
            parameters.put("MODIFIED_DATE", dateToStringTypeConverter.convert(target.getCreationDate()));
            parameters.put("CONTENTS", target.getContents());
            parameters.put("BOARD_ID", target.getOwnerBoardInfomation().getOwnerBoardKey());
            parameters.put("MEMBER_ID", target.getWriterInfomation().getWriterId());
            
            int cnt =  sqlSession.update(namespace + "insert", parameters);
            System.out.println(cnt);
        }
    }

    @Override
    public List<Post> getByWriterId(long writerId) {
        return sqlSession.selectList(namespace + "getByWriterId", writerId);
    }
}
