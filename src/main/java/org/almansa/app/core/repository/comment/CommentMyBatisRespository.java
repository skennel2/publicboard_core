package org.almansa.app.core.repository.comment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.almansa.app.core.comment.Comment;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class CommentMyBatisRespository extends SqlSessionDaoSupport implements CommentRepository{
    
    private final String mapperNamespace = "COMMENT.";
    
    @Override
    public Comment getById(Long id) {       
        Comment comment = getSqlSession().selectOne(mapperNamespace + "getById", id);        
        return comment;
    }

    @Override
    public List<Comment> getAll() {
        List<Comment> comments = getSqlSession().selectList(mapperNamespace + "getAll");
        return comments;
    }
    
    @Override
    public List<Comment> getByWriterId(Long userId) {
        List<Comment> comments = getSqlSession().selectList(mapperNamespace + "getByWriterId", userId);
        return comments;
    }

    @Override
    public List<Comment> getByPostId(Long postId) {
        List<Comment> comments = getSqlSession().selectList(mapperNamespace + "getByPostId", postId);
        return comments;
    }    

    @Override
    public void delete(Long id) {
        int rowCount = getSqlSession().delete(mapperNamespace + "delete", id);
        System.out.println(rowCount);
    }

    @Override
    public void update(Comment target) {
       if(target.getId() == null) {           
           Map<String, Object> parameters = new HashMap<String, Object>();
           
           //TODO parameter setting
           
           getSqlSession().update(mapperNamespace + "insert", parameters);
       }
    }
}