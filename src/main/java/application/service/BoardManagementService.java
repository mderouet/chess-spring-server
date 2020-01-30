package application.service;

import application.exception.*;
import application.model.*;
import lombok.RequiredArgsConstructor;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

@RequiredArgsConstructor
public class BoardManagementService {

    public Board initializeCustomPosition(Board board) {

        Map<String, Piece> chessBoard = new LinkedHashMap<>();
        // Top line Black
        chessBoard.put("A8", new Pawn(Color.WHITE));
        chessBoard.put("B8", new Knight(Color.BLACK));
        chessBoard.put("C8", new Bishop(Color.BLACK));
        chessBoard.put("D8", new Queen(Color.BLACK));
        chessBoard.put("E8", new King(Color.BLACK));
        chessBoard.put("F8", new Bishop(Color.BLACK));
        chessBoard.put("G8", new Knight(Color.BLACK));
        chessBoard.put("H8", new Rook(Color.BLACK));

        // Bottom line Black
        chessBoard.put("A7", null);
        chessBoard.put("B7", new Pawn(Color.BLACK));
        chessBoard.put("C7", new Pawn(Color.BLACK));
        chessBoard.put("D7", null);
        chessBoard.put("E7", new Pawn(Color.BLACK));
        chessBoard.put("F7", null);
        chessBoard.put("G7", new Pawn(Color.BLACK));
        chessBoard.put("H7", null);

        // Null
        chessBoard.put("A6", null);
        chessBoard.put("B6", null);
        chessBoard.put("C6", null);
        chessBoard.put("D6", new Pawn(Color.BLACK));
        chessBoard.put("E6", null);
        chessBoard.put("F6", null);
        chessBoard.put("G6", new Rook(Color.BLACK));
        chessBoard.put("H6", null);

        chessBoard.put("A5", null);
        chessBoard.put("B5", null);
        chessBoard.put("C5", null);
        chessBoard.put("D5", null);
        chessBoard.put("E5", new Queen(Color.WHITE));
        chessBoard.put("F5", new Bishop(Color.WHITE));
        chessBoard.put("G5", null);
        chessBoard.put("H5", null);

        chessBoard.put("A4", null);
        chessBoard.put("B4", null);
        chessBoard.put("C4", new Pawn(Color.BLACK));
        chessBoard.put("D4", new Rook(Color.WHITE));
        chessBoard.put("E4", null);
        chessBoard.put("F4", new Pawn(Color.BLACK));
        chessBoard.put("G4", new Pawn(Color.WHITE));
        chessBoard.put("H4", new Pawn(Color.BLACK));

        chessBoard.put("A3", null);
        chessBoard.put("B3", null);
        chessBoard.put("C3", null);
        chessBoard.put("D3", new Pawn(Color.WHITE));
        chessBoard.put("E3", null);
        chessBoard.put("F3", new Knight(Color.WHITE));
        chessBoard.put("G3", new King(Color.WHITE));
        chessBoard.put("H3", null);

        // Bottom line White
        chessBoard.put("A2", null);
        chessBoard.put("B2", new Pawn(Color.WHITE));
        chessBoard.put("C2", new Pawn(Color.WHITE));
        chessBoard.put("D2", null);
        chessBoard.put("E2", new Pawn(Color.WHITE));
        chessBoard.put("F2", new Pawn(Color.WHITE));
        chessBoard.put("G2", null);
        chessBoard.put("H2", new Pawn(Color.WHITE));

        // Top line White
        chessBoard.put("A1", new Rook(Color.WHITE));
        chessBoard.put("B1", new Knight(Color.WHITE));
        chessBoard.put("C1", new Bishop(Color.WHITE));
        chessBoard.put("D1", null);
        chessBoard.put("E1", null);
        chessBoard.put("F1", null);
        chessBoard.put("G1", null);
        chessBoard.put("H1", null);

        board.setChessBoard(chessBoard);
        return board;
    }
    // Initialize the chess chessBoard on map (coord => piece)

    public Board initialize(Board board) {
        Map<String, Piece> chessBoard = new LinkedHashMap<>();

        // Top line Black
        chessBoard.put("A8", new Rook(Color.BLACK));
        chessBoard.put("B8", new Knight(Color.BLACK));
        chessBoard.put("C8", new Bishop(Color.BLACK));
        chessBoard.put("D8", new Queen(Color.BLACK));
        chessBoard.put("E8", new King(Color.BLACK));
        chessBoard.put("F8", new Bishop(Color.BLACK));
        chessBoard.put("G8", new Knight(Color.BLACK));
        chessBoard.put("H8", new Rook(Color.BLACK));

        // Bottom line Black
        chessBoard.put("A7", new Pawn(Color.BLACK));
        chessBoard.put("B7", new Pawn(Color.BLACK));
        chessBoard.put("C7", new Pawn(Color.BLACK));
        chessBoard.put("D7", new Pawn(Color.BLACK));
        chessBoard.put("E7", new Pawn(Color.BLACK));
        chessBoard.put("F7", new Pawn(Color.BLACK));
        chessBoard.put("G7", new Pawn(Color.BLACK));
        chessBoard.put("H7", new Pawn(Color.BLACK));

        // Null
        chessBoard.put("A6", null);
        chessBoard.put("B6", null);
        chessBoard.put("C6", null);
        chessBoard.put("D6", null);
        chessBoard.put("E6", null);
        chessBoard.put("F6", null);
        chessBoard.put("G6", null);
        chessBoard.put("H6", null);

        chessBoard.put("A5", null);
        chessBoard.put("B5", null);
        chessBoard.put("C5", null);
        chessBoard.put("D5", null);
        chessBoard.put("E5", null);
        chessBoard.put("F5", null);
        chessBoard.put("G5", null);
        chessBoard.put("H5", null);

        chessBoard.put("A4", null);
        chessBoard.put("B4", null);
        chessBoard.put("C4", null);
        chessBoard.put("D4", null);
        chessBoard.put("E4", null);
        chessBoard.put("F4", null);
        chessBoard.put("G4", null);
        chessBoard.put("H4", null);

        chessBoard.put("A3", null);
        chessBoard.put("B3", null);
        chessBoard.put("C3", null);
        chessBoard.put("D3", null);
        chessBoard.put("E3", null);
        chessBoard.put("F3", null);
        chessBoard.put("G3", null);
        chessBoard.put("H3", null);

        // Bottom line White
        chessBoard.put("A2", new Pawn(Color.WHITE));
        chessBoard.put("B2", new Pawn(Color.WHITE));
        chessBoard.put("C2", new Pawn(Color.WHITE));
        chessBoard.put("D2", new Pawn(Color.WHITE));
        chessBoard.put("E2", new Pawn(Color.WHITE));
        chessBoard.put("F2", new Pawn(Color.WHITE));
        chessBoard.put("G2", new Pawn(Color.WHITE));
        chessBoard.put("H2", new Pawn(Color.WHITE));

        // Top line White
        chessBoard.put("A1", new Rook(Color.WHITE));
        chessBoard.put("B1", new Knight(Color.WHITE));
        chessBoard.put("C1", new Bishop(Color.WHITE));
        chessBoard.put("D1", new Queen(Color.WHITE));
        chessBoard.put("E1", new King(Color.WHITE));
        chessBoard.put("F1", new Bishop(Color.WHITE));
        chessBoard.put("G1", new Knight(Color.WHITE));
        chessBoard.put("H1", new Rook(Color.WHITE));

        board.setChessBoard(chessBoard);
        return board;
    }

    public void move(Board board, String playerName, String squareCoordDeparture, String squareCoordArrival) {
        squareCoordDeparture = squareCoordDeparture.toUpperCase();
        squareCoordArrival = squareCoordArrival.toUpperCase();

        RuntimeException runtimeException = validateMove(board, playerName, squareCoordDeparture, squareCoordArrival);
        if (runtimeException != null) {
            throw runtimeException;
        }

        if (!board.getChessBoard().get(squareCoordDeparture).move(board.getChessBoard(), squareCoordDeparture, squareCoordArrival)) {
            throw new MoveNotPossibleException(board.getChessBoard().get(squareCoordDeparture).getPieceName()
                    + " in " + squareCoordDeparture + " is not allowed to move to " + squareCoordArrival + " square");
        }

        board.getChessBoard().put(squareCoordArrival, board.getChessBoard().get(squareCoordDeparture));
        board.getChessBoard().put(squareCoordDeparture, null);
    }

    private RuntimeException validateMove(Board board, String playerName, String squareCoordDeparture, String squareCoordArrival) {
        if (!playAutorization(board, playerName)) {
            return new NotYourTurnException(
                    "Cannot find player : " + playerName + " in the game or it's your not your turn, White turn : " + board.isWhiteTurnToPlay());
        }
        if (!board.getChessBoard().containsKey(squareCoordDeparture) || !board.getChessBoard().containsKey(squareCoordArrival)) {
            return new OutOfBoardException(
                    "Departure and/or arrival coords are not correct " + "[" + squareCoordDeparture + "," + squareCoordArrival + "]");
        }
        if (board.getChessBoard().get(squareCoordDeparture) == null) {
            return new NoDeparturePieceException(
                    "No piece found in : " + squareCoordDeparture);
        }
        if (board.isWhiteTurnToPlay() && board.getChessBoard().get(squareCoordDeparture).getColor() == Color.BLACK
                || !board.isWhiteTurnToPlay() && board.getChessBoard().get(squareCoordDeparture).getColor() == Color.WHITE) {
            return new NotYourPieceException("Piece in " + squareCoordDeparture + " is " +
                    board.getChessBoard().get(squareCoordDeparture).getColor() + " meanwhile " + playerName + " play the other side");
        }
        if (squareCoordDeparture.equalsIgnoreCase(squareCoordArrival)) {
            return new SameSquareException(
                    "Square departure : " + squareCoordDeparture + " equals square arrival : " + squareCoordArrival);
        }
        return null;
    }

    // Does the player exists ? Is it his turn to play ?
    private boolean playAutorization(Board board, String playerName) {
        return ((board.isWhiteTurnToPlay() && playerName.toLowerCase().equals(board.getWhitePlayerName().toLowerCase()))
                || (!board.isWhiteTurnToPlay() && playerName.toLowerCase().equals(board.getBlackPlayerName().toLowerCase())));
    }

    public void displayBoard(Map<String, Piece> boardPositions) {
        String line = " [";
        int index = 0;
        Iterator<Map.Entry<String, Piece>> it = boardPositions.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Piece> currentPair = it.next();

            if (currentPair.getValue() != null) {
                line += " " + currentPair.getValue().getLetter() + " , ";
            } else {
                line += "▢ , ";
            }
            index++;
            if (index % 8 == 0) {
                line = line.substring(0, line.length() - 2);
                System.out.println(line + "]");
                line = " [";
            }
        }
    }
}
