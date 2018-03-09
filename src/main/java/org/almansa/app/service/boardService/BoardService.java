package org.almansa.app.service.boardService;

import java.util.List;

import org.almansa.app.core.board.Board;

public interface BoardService {
    List<Board> getBoardList();

    void addBoard(Board board);

    void deleteBoard(long boardId);
}
