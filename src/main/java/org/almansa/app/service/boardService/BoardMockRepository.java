package org.almansa.app.service.boardService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.almansa.app.core.board.Board;

public class BoardMockRepository implements BoardRepository{

	private Map<Long, Board> map;
	
	@Override
	public Board getById(Long id) {
		return map.get(id);
	}

	@Override
	public List<Board> getAll() {
		List<Board> board = new ArrayList<Board>();
		board.addAll(map.values());
		return board;
	}

	@Override
	public void delete(Long id) {
		map.remove(id);		
	}

	@Override
	public void update(Board target) {
		Board board = map.get(target.getId());
		
		board.changeName(target.getName());
		
		if(target.isAbleToWrite()) {
			board.allowToWrite();
		}else {
			board.blockToWrite();
		}
		
		delete(target.getId());
		map.put(board.getId(), board);		
	}
	
}