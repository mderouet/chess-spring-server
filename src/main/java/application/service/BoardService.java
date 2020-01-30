package application.service;

import application.model.Board;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface BoardService {

    void createBoard(List<Board> boards);

    Collection<Board> getAllBoards();

    Optional<Board> findBoardById(String id);

    void deleteBoardById(String id);

    void updateBoard(Board board);

    void deleteAllBoards();
}
