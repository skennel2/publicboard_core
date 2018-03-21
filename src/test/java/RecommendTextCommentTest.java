import static org.junit.Assert.*;

import java.util.Date;

import org.almansa.app.core.MemberDefaultInfomationImpl;
import org.almansa.app.core.PostDefaultInfomationImpl;
import org.almansa.app.core.entity.comment.RecommendRecords;
import org.almansa.app.core.entity.comment.RecommendableTextComment;
import org.junit.Test;

public class RecommendTextCommentTest {

    @Test
    public void test() {
        
        RecommendRecords recommends = new RecommendRecords();
        PostDefaultInfomationImpl pdi = new PostDefaultInfomationImpl(new Long(1));
        MemberDefaultInfomationImpl mdi = new MemberDefaultInfomationImpl(new Long(1), "skennel");
        
        RecommendableTextComment rtc = new RecommendableTextComment(new Date(), "abc", pdi, mdi, recommends);
                
        assertEquals("abc", rtc.getContents());

        rtc.recommend(new MemberDefaultInfomationImpl(new Long(1), "skennel"));
        assertEquals(1, rtc.getRecommendCount());
        
        rtc.recommend(new MemberDefaultInfomationImpl(new Long(2), "skennel2"));
        assertEquals(2, rtc.getRecommendCount());       
        
        rtc.recommend(new MemberDefaultInfomationImpl(new Long(2), "skennel2"));
        assertEquals(2, rtc.getRecommendCount());            
                
        assertEquals(false, rtc.isPossibleToDelete(new Long(2)));
        assertEquals(true, rtc.isPossibleToDelete(new Long(1)));               
    }

}
