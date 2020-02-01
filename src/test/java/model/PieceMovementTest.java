package model;

import application.exception.MoveNotPossibleException;
import application.model.Board;
import application.model.Piece;
import application.service.BoardManagementService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {BoardManagementService.class})
class PieceMovementTest {

    private Board board;

    @Autowired
    public BoardManagementService boardManagementService;

    private void initBoard(boolean whiteTurnToPlay) {
        board = boardManagementService.initializeCustomPosition(Board.builder()
                .whitePlayerName("Promethee")
                .blackPlayerName("Epimethee")
                .whiteTurnToPlay(whiteTurnToPlay)
                .build()
        );
    }

    @Test
    void rookMove() {
        // Wrong moves
        Map<String, List<String>> wrongMoveMap = new HashMap<>();
        wrongMoveMap.put("D4", List.of("A4", "G4", "G5", "A3", "A5", "D8", "D7", "D3"));
        checkWrongMoves(wrongMoveMap);

        // Right moves
        Map<String, List<String>> rightMovesMap = new HashMap<>();
        rightMovesMap.put("D4", List.of("C4", "D6", "F4", "E4", "D5"));
        checkRightMoves(rightMovesMap);
    }

    @Test
    void bishopMove() {
        // Wrong moves
        Map<String, List<String>> wrongMoveMap = new HashMap<>();
        wrongMoveMap.put("F5", List.of("G4", "H3", "D3", "C2", "C3", "H7"));
        checkWrongMoves(wrongMoveMap);

        // Right moves
        Map<String, List<String>> rightMovesMap = new HashMap<>();
        rightMovesMap.put("F5", List.of("C8", "D7", "E6", "G6", "E4"));
        checkRightMoves(rightMovesMap);
    }

    @Test
    void queenMove() {

        // Wrong moves
        Map<String, List<String>> wrongMoveMap = new HashMap<>();
        wrongMoveMap.put("E5", List.of("F5", "G5", "H5", "H3", "C7", "B8", "E1", "E2", "E8", "D4", "C3"));
        checkWrongMoves(wrongMoveMap);

        // Right moves
        Map<String, List<String>> rightMovesMap = new HashMap<>();
        rightMovesMap.put("E5", List.of("E3", "E4", "E6", "E7", "F6", "G7", "A5", "B5", "C5", "D5", "F4"));
        checkRightMoves(rightMovesMap);
    }

    @Test
    void knightMove() {

        // Wrong moves
        Map<String, List<String>> wrongMoveMap = new HashMap<>();
        wrongMoveMap.put("F3", List.of("H2", "D4", "E5", "A4", "A3", "B8"));
        checkWrongMoves(wrongMoveMap);

        // Right moves
        Map<String, List<String>> rightMovesMap = new HashMap<>();
        rightMovesMap.put("F3", List.of("E1", "H4", "G1", "D2", "G5"));
        checkRightMoves(rightMovesMap);
    }

    @Test
    void pawnMove() {
        // Wrong moves
        Map<String, List<String>> wrongMoveWhitePieceMap = new HashMap<>();
        wrongMoveWhitePieceMap.put("H2", List.of("H1", "H4"));
        wrongMoveWhitePieceMap.put("G4", List.of("G2", "G3", "C6", "D2"));
        wrongMoveWhitePieceMap.put("D3", List.of("D4", "E4", "A4", "A3"));
        checkWrongMoves(wrongMoveWhitePieceMap);

        Map<String, List<String>> wrongMoveBlackPieceMap = new HashMap<>();
        wrongMoveWhitePieceMap.put("C4", List.of("C5"));
        checkWrongMoves(wrongMoveBlackPieceMap, false);

        // Right moves
        Map<String, List<String>> rightMoveWhitePieceMap = new HashMap<>();
        rightMoveWhitePieceMap.put("D3", List.of("C4"));
        rightMoveWhitePieceMap.put("E2", List.of("E3", "E4"));
        rightMoveWhitePieceMap.put("H2", List.of("H3"));
        rightMoveWhitePieceMap.put("B2", List.of("B4"));
        checkRightMoves(rightMoveWhitePieceMap);

        Map<String, List<String>> rightMoveBlackPieceMap = new HashMap<>();
        rightMoveBlackPieceMap.put("C4", List.of("C3"));
        checkRightMoves(rightMoveBlackPieceMap, false);
    }

    @Test
    void kingMove() {
        // Wrong moves
        Map<String, List<String>> wrongMoveMap = new HashMap<>();
        wrongMoveMap.put("G3", List.of("F2", "F3", "G4", "H2"));
        checkWrongMoves(wrongMoveMap);

        // Right moves
        Map<String, List<String>> rightMovesMap = new HashMap<>();
        rightMovesMap.put("G3", List.of("H3", "H4", "F4", "G2"));
        checkRightMoves(rightMovesMap);
    }


    private void checkWrongMoves(Map<String, List<String>> positions) {
        checkWrongMoves(positions, true);
    }

    private void checkWrongMoves(Map<String, List<String>> positions, boolean whiteTurnToPlay) {
        positions.forEach((squareDeparture, value) -> value.forEach(squareCoordArrival -> {
            initBoard(whiteTurnToPlay);
            Assertions.assertThrows(MoveNotPossibleException.class, () -> {
                Piece pieceOnDepartureSquare = board.getChessBoard().get(squareDeparture);
                boardManagementService.move(board, board.getPlayerNameByColor(pieceOnDepartureSquare.getColor()), squareDeparture, squareCoordArrival);
            });
        }));
    }

    private void checkRightMoves(Map<String, List<String>> positions) {
        checkRightMoves(positions, true);
    }

    private void checkRightMoves(Map<String, List<String>> positions, boolean whiteTurnToPlay) {
        positions.forEach((squareDeparture, value) -> value.forEach(squareCoordArrival -> {
            initBoard(whiteTurnToPlay);
            Piece pieceOnDepartureSquare = board.getChessBoard().get(squareDeparture);
            boardManagementService.move(board, board.getPlayerNameByColor(pieceOnDepartureSquare.getColor()), squareDeparture, squareCoordArrival);
            Assertions.assertEquals(board.getChessBoard().get(squareCoordArrival), pieceOnDepartureSquare);
            Assertions.assertNull(board.getChessBoard().get(squareDeparture));
        }));
    }
}
