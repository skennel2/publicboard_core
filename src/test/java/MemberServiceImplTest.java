import static org.junit.Assert.assertEquals;

import org.almansa.app.core.repository.member.MemberMockRepository;
import org.almansa.app.core.service.member.MemberService;
import org.almansa.app.core.service.member.MemberServiceImpl;
import org.junit.Test;

public class MemberServiceImplTest {
    
    @Test
    public void joinSimplyTest() {
        MemberMockRepository repo = new MemberMockRepository();        
        MemberService service = new MemberServiceImpl(repo);
        
        service.joinSimply("gggg", "1234");

        assertEquals("1234", repo.getByLoginId("gggg").getPassword());
        assertEquals("gggg", repo.getByLoginId("gggg").getLoginId());
    }
}
