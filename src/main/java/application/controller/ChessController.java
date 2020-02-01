package application.controller;

import application.model.Board;
import application.service.BoardManagementService;
import application.service.BoardService;
import application.util.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
public class ChessController {

    private final BoardManagementService boardManagementService;

    private final BoardService boardService;

    @PostMapping(value = "/board", produces = "application/json")
    public Board createBoard(@Valid @RequestBody Board board) {

        Board newBoard = boardManagementService.initialize(Board.builder()
                .id(Utils.sha256HashFromString(board.getBlackPlayerName() + board.getWhitePlayerName() + new Date().toString()))
                .blackPlayerName(board.getBlackPlayerName())
                .whitePlayerName(board.getWhitePlayerName())
                .whiteTurnToPlay(true)
                .build()
        );

        boardService.createBoard(List.of(newBoard));
        return newBoard;
    }

    @GetMapping(value = "/status", produces = "application/json")
    public Optional<Board> boardStatus(@RequestParam String id) {
        return boardService.findBoardById(id);
    }

    @PostMapping(value = "/move", produces = "application/json")
    public void move(@RequestBody Map<String, String> params) {
        boardManagementService.move(
                boardService.findBoardById(params.get("boardId")).get(),
                params.get("playerName"),
                params.get("squareCoordDeparture"),
                params.get("squareCoordArrival")
        );
    }
}
