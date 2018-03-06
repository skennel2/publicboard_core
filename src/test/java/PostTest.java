import static org.junit.Assert.*;

import java.util.Date;

import org.almansa.app.core.WriterInfomation;
import org.almansa.app.core.post.DefaultTextPost;
import org.almansa.app.core.post.OwnerBoardInfomation;
import org.junit.Test;

public class PostTest {

	@Test
	public void postTest() {

		DefaultTextPost post = new DefaultTextPost(
				"가입인사", 
				new Date(), 
				new Date(), 
				"잘부탁드립니다.", 
				new OwnerBoardInfomation() {
					
					@Override
					public long getOwnerBoardKey() {
						return 1;
					}
				}, 
				new WriterInfomation() {
					
					@Override
					public String getWriterLoginId() {
						// TODO Auto-generated method stub
						return "skennel";
					}
					
					@Override
					public long getWriterId() {
						// TODO Auto-generated method stub
						return 1;
					}
				},
				500, 
				30);
		
		post.changeName("가입인사입니다.");
		post.write("냉무");
		
		assertEquals("가입인사입니다.", post.getName());
		assertEquals("냉무", post.getContents());
		assertEquals("skennel", post.getWriterInfomation().getWriterLoginId());
	}

}
