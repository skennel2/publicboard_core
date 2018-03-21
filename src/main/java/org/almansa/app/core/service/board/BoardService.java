package org.almansa.app.core.service.board;

import java.util.List;

import org.almansa.app.core.entity.board.Board;

public interface BoardService {
    List<Board> getBoardList();

    void addBoard(Board board);

    void deleteBoard(long boardId);
}
