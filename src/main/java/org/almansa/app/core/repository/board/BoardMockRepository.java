package org.almansa.app.core.repository.board;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.almansa.app.core.board.Board;
import org.almansa.app.core.board.DefaultTextBoard;
import org.springframework.stereotype.Component;

@Component
public class BoardMockRepository implements BoardRepository {

    private Map<Long, Board> map = new HashMap<Long, Board>();

    public BoardMockRepository() {
        map.put((long) 1, new DefaultTextBoard((long) 1, "자유게", new Date(), new ArrayList<String>(), true));
        map.put((long) 2, new DefaultTextBoard((long) 2, "개발게", new Date(), new ArrayList<String>(), true));
    }

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
        if (!map.containsKey(target.getId())) {
            map.put(target.getId(), target);
        } else {
            Board board = map.get(target.getId());

            board.changeName(target.getName());

            if (target.isAbleToWrite()) {
                board.allowToWrite();
            } else {
                board.blockToWrite();
            }

            delete(target.getId());
            map.put(board.getId(), board);
        }
    }
}