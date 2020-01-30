package application.service;

import application.dao.BoardRepository;
import application.model.Board;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public void createBoard(List<Board> board) {
        boardRepository.saveAll(board);
    }

    @Override
    public Collection<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    @Override
    public Optional<Board> findBoardById(String id) {
        return boardRepository.findById(id);
    }

    @Override
    public void deleteBoardById(String id) {
        boardRepository.deleteById(id);
    }

    @Override
    public void updateBoard(Board board) {
        boardRepository.save(board);
    }

    @Override
    public void deleteAllBoards() {
        boardRepository.deleteAll();
    }
}
