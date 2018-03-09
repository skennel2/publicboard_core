import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.almansa.app.core.board.DefaultTextBoard;
import org.junit.Test;

public class BoardTest {

    @Test
    public void boardTest() {
        DefaultTextBoard board = new DefaultTextBoard("자유", new Date(), new ArrayList<String>(), 20, true);
        board.changeName("자유게시판");

        assertEquals("자유게시판", board.getName());
        assertEquals(true, board.isAbleToWrite());

        board.blockToWrite();

        assertEquals(false, board.isAbleToWrite());

        System.out.println(board.toString());
    }
}
