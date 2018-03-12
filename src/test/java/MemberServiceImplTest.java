import static org.junit.Assert.assertEquals;

import org.almansa.app.core.member.SimpleMember;
import org.almansa.app.core.service.repository.MemberMockRepository;
import org.almansa.app.service.memberService.MemberService;
import org.almansa.app.service.memberService.MemberServiceImpl;
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
