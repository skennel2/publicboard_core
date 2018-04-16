package org.almansa.app.core.repository.comment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.almansa.app.core.entity.comment.Comment;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class CommentMyBatisRespository implements CommentRepository{
    
    private final String mapperNamespace = "COMMENT_MAPPER.";
         
    private SqlSession session;   

    @Autowired    
    public CommentMyBatisRespository(SqlSession session) {
        super();
        this.session = session;
    }

    @Override
    public Comment getById(Long id) {       
        Comment comment = session.selectOne(mapperNamespace + "getById", id);        
        return comment;
    }

    @Override
    public List<Comment> getAll() {
        List<Comment> comments = session.selectList(mapperNamespace + "getAll");
        return comments;
    }
    
    @Override
    public List<Comment> getByWriterId(Long userId) {
        List<Comment> comments = session.selectList(mapperNamespace + "getByWriterId", userId);
        return comments;
    }

    @Override
    public List<Comment> getByPostId(Long postId) {
        List<Comment> comments = session.selectList(mapperNamespace + "getByPostId", postId);
        return comments;
    }    

    @Override
    public void delete(Long id) {
        int rowCount = session.delete(mapperNamespace + "delete", id);
        System.out.println(rowCount);
    }

    @Override
    public void update(Comment target) {
       if(target.getId() == null) {           
           Map<String, Object> parameters = new HashMap<String, Object>();
           parameters.put("POST_ID", target.getOwnerPostInfomation().getPostId());
           parameters.put("MEMBER_ID", target.getWriterInfomation().getMemberId());
           parameters.put("CONTENTS", target.getContents());
           parameters.put("WRITE_DATE", target.getCreationDate());
           
           session.update(mapperNamespace + "insert", parameters);
       }
    }
}