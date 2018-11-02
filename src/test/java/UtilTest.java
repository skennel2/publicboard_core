import static org.junit.Assert.assertEquals;

import java.util.Objects;

import org.junit.Test;
import org.springframework.util.Assert;

public class UtilTest {

	@Test(expected = IllegalArgumentException.class)
	public void assertNotNullTest() {		
		Assert.notNull(null, "no null");
	}
	
	@Test
	public void objectNonNull() {		
		Boolean result = Objects.nonNull("asdf");
		
		assertEquals(true, result);
		
		result = Objects.nonNull(null);
		
		assertEquals(false, result);
		
		result = Objects.nonNull("");
		
		assertEquals(true, result);		
		
	}
}
