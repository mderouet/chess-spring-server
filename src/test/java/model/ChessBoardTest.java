package model;

import application.exception.*;
import application.model.Board;
import application.service.BoardManagementService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {BoardManagementService.class})
class ChessBoardTest {

    private Board board;

    @Autowired
    private BoardManagementService boardManagementService;

    @BeforeEach
    void init() {
        board = boardManagementService.initialize(Board.builder()
                .whitePlayerName("Promethee")
                .blackPlayerName("Epimethee")
                .whiteTurnToPlay(true)
                .build());
    }

    // First turn white can play
    @Test
    void whiteTurnToPlay() {
        Assertions.assertThrows(NotYourTurnException.class, () -> {
            boardManagementService.move(board, "Epimethee", "C1", "C2");
        });
    }

    // Player name does not exist
    @Test
    void playerName() {
        Assertions.assertThrows(NotYourTurnException.class, () -> {
            boardManagementService.move(board, "Epimethee", "C1", "C2");
        });
    }

    // Departure square must contain a piece
    @Test
    void departurePieceExist() {
        Assertions.assertThrows(NoDeparturePieceException.class, () -> {
            // After init, C4 does not contain any piece
            boardManagementService.move(board, "Promethee", "C4", "C2");
        });
    }

    // Coords must be existing on the board
    @Test
    void squaresExistOnTheBoard() {
        Assertions.assertThrows(OutOfBoardException.class, () -> {
            // The chessBoard does not contain C9 position nor I6
            boardManagementService.move(board, "Promethee", "C9", "I6");
        });
    }

    @Test
    void sameSquare() {
        Assertions.assertThrows(SameSquareException.class, () -> {
            // The chessBoard does not contain C9 position nor I6
            boardManagementService.move(board, "Promethee", "A2", "A2");
        });
    }

    @Test
    void whitePlayerMoveBlackPiece() {
        Assertions.assertThrows(NotYourPieceException.class, () -> {
            boardManagementService.move(board, "Promethee", "A7", "A5");
        });
    }
}
