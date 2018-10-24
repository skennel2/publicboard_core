import org.junit.Test;
import org.springframework.util.Assert;

public class UtilTest {

	@Test(expected = IllegalArgumentException.class)
	public void assertNotNullTest() {		
		Assert.notNull(null, "no null");
	}
}
