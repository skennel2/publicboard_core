import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class SimpleTest {

    @Test
    public void test() {
        Date date = new Date();
        String str = new SimpleDateFormat("yyyyMMdd:hhmmss").format(date);
        
        System.out.println(str);
    }
}
