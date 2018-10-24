package org.almansa.app.core.service.board;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.almansa.app.core.entity.board.Board;
import org.almansa.app.core.entity.board.DefaultTextBoard;
import org.springframework.stereotype.Service;

@Service
public class BoardSimpleService implements BoardService {

    @Override
    public List<Board> getBoardList() {
        DefaultTextBoard board = new DefaultTextBoard((long) 1, "자유", new Date(), new ArrayList<String>(), true);
        ArrayList<Board> boards = new ArrayList<Board>();
        boards.add(board);

        return boards;
    }

    @Override
    public void addBoard(Board board) {
        // TODO 게시판 추가 로직

    }

    @Override
    public void deleteBoard(long boardId) {
        // TODO 게시판 삭제 로직

    }
}