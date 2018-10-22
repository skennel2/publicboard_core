import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.almansa.app.core.entity.comment.RecommendRecordList;
import org.almansa.app.core.entity.comment.RecommendableTextComment;
import org.junit.Test;

public class RecommendTextCommentTest {

    @Test
    public void test() {
        
        RecommendRecordList recommends = new RecommendRecordList();
        Long postId = new Long(1);
        Long memberId = new Long(1);
        
        RecommendableTextComment rtc = new RecommendableTextComment(new Date(), "abc", postId, memberId, recommends);
                
        assertEquals("abc", rtc.getContents());
        
        assertEquals(false, rtc.isPossibleToDelete(new Long(2)));
        assertEquals(true, rtc.isPossibleToDelete(new Long(1)));               
    }
}
