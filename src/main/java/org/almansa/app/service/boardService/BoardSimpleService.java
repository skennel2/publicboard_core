package org.almansa.app.service.boardService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.almansa.app.core.board.Board;
import org.almansa.app.core.board.DefaultTextBoard;
import org.springframework.stereotype.Component;

@Component
public class BoardSimpleService implements BoardService{

	@Override
	public List<Board> getBoardList() {
		DefaultTextBoard board = new DefaultTextBoard(1, "자유", new Date(), new ArrayList<String>(), 20, true);
		ArrayList<Board> boards = new ArrayList<Board>();
		boards.add(board);
		
		return boards;
	}

	@Override
	public void addBoard(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoard(long boardId) {
		// TODO Auto-generated method stub
		
	}
	
}