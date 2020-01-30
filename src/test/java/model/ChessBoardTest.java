package model;

import application.exception.*;
import application.model.Board;
import application.service.BoardManagementService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {BoardManagementService.class})
public class ChessBoardTest {

    private Board board;

    @Autowired
    private BoardManagementService boardManagementService;

    @BeforeEach
    public void init() {
        board = boardManagementService.initialize(Board.builder()
                .whitePlayerName("Promethee")
                .blackPlayerName("Epimethee")
                .whiteTurnToPlay(true)
                .build());
    }

    // First turn white can play
    @Test
    public void whiteTurnToPlay() {
        Assertions.assertThrows(NotYourTurnException.class, () -> {
            boardManagementService.move(board, "Epimethee", "C1", "C2");
        });
    }

    // Player name does not exist
    @Test
    public void playerName() {
        Assertions.assertThrows(NotYourTurnException.class, () -> {
            boardManagementService.move(board, "Epimethee", "C1", "C2");
        });
    }

    // Departure square must contain a piece
    @Test
    public void departurePieceExist() {
        Assertions.assertThrows(NoDeparturePieceException.class, () -> {
            // After init, C4 does not contain any piece
            boardManagementService.move(board, "Promethee", "C4", "C2");
        });
    }

    // Coords must be existing on the board
    @Test
    public void squaresExistOnTheBoard() {
        Assertions.assertThrows(OutOfBoardException.class, () -> {
            // The chessBoard does not contain C9 position nor I6
            boardManagementService.move(board, "Promethee", "C9", "I6");
        });
    }

    @Test
    public void sameSquare() {
        Assertions.assertThrows(SameSquareException.class, () -> {
            // The chessBoard does not contain C9 position nor I6
            boardManagementService.move(board, "Promethee", "A2", "A2");
        });
    }

    @Test
    public void whitePlayerMoveBlackPiece() {
        Assertions.assertThrows(NotYourPieceException.class, () -> {
            boardManagementService.move(board, "Promethee", "A7", "A5");
        });
    }
}
