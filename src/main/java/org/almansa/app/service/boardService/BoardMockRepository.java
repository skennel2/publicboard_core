package org.almansa.app.service.boardService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.almansa.app.core.board.Board;
import org.springframework.stereotype.Component;

@Component
public class BoardMockRepository implements BoardRepository{

	private Map<Long, Board> map = new HashMap<Long, Board>()	;
	
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
		if(!map.containsKey(target.getId())) {
			map.put(target.getId(), target);
		}else {
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
	
}