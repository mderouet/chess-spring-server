package application.controller;

import application.model.Board;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class ChessController {
    @PostMapping(value = "/game", consumes = "application/json", produces = "application/json")
    public Board createPerson(@Valid @RequestBody Board board) {
        return Board.builder()
                .id(board.getId())
                .blackPlayerName(board.getBlackPlayerName())
                .whitePlayerName(board.getWhitePlayerName())
            .build();
    }
}
