package application.service;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import application.exception.MoveImpossibleException;
import application.exception.NotYourTurnException;
import application.model.*;

public class BoardService {

	public Map<String, Piece> initializeTestPosition() {

		Map<String, Piece> board = new LinkedHashMap<>();
		// Top line Black
		board.put("A8", new Pawn(Color.WHITE));
		board.put("B8", new Knight(Color.BLACK));
		board.put("C8", new Bishop(Color.BLACK));
		board.put("D8", new Queen(Color.BLACK));
		board.put("E8", new King(Color.BLACK));
		board.put("F8", new Bishop(Color.BLACK));
		board.put("G8", new Knight(Color.BLACK));
		board.put("H8", new Rook(Color.BLACK));

		// Bottom line Black
		board.put("A7", null);
		board.put("B7", new Pawn(Color.BLACK));
		board.put("C7", new Pawn(Color.BLACK));
		board.put("D7", null);
		board.put("E7", new Pawn(Color.BLACK));
		board.put("F7", null);
		board.put("G7", new Pawn(Color.BLACK));
		board.put("H7", null);

		// Null
		board.put("A6", null);
		board.put("B6", null);
		board.put("C6", null);
		board.put("D6", new Pawn(Color.BLACK));
		board.put("E6", null);
		board.put("F6", null);
		board.put("G6", new Rook(Color.BLACK));
		board.put("H6", null);

		board.put("A5", null);
		board.put("B5", null);
		board.put("C5", null);
		board.put("D5", null);
		board.put("E5", new Queen(Color.WHITE));
		board.put("F5", new Bishop(Color.WHITE));
		board.put("G5", null);
		board.put("H5", null);

		board.put("A4", null);
		board.put("B4", null);
		board.put("C4", new Pawn(Color.BLACK));
		board.put("D4", new Rook(Color.WHITE));
		board.put("E4", null);
		board.put("F4", new Pawn(Color.BLACK));
		board.put("G4", new Pawn(Color.WHITE));
		board.put("H4", new Pawn(Color.BLACK));

		board.put("A3", null);
		board.put("B3", null);
		board.put("C3", null);
		board.put("D3", new Pawn(Color.WHITE));
		board.put("E3", null);
		board.put("F3", new Knight(Color.WHITE));
		board.put("G3", new King(Color.WHITE));
		board.put("H3", null);

		// Bottom line White
		board.put("A2", null);
		board.put("B2", new Pawn(Color.WHITE));
		board.put("C2", new Pawn(Color.WHITE));
		board.put("D2", null);
		board.put("E2", new Pawn(Color.WHITE));
		board.put("F2", new Pawn(Color.WHITE));
		board.put("G2", null);
		board.put("H2", new Pawn(Color.WHITE));

		// Top line White
		board.put("A1", new Rook(Color.WHITE));
		board.put("B1", new Knight(Color.WHITE));
		board.put("C1", new Bishop(Color.WHITE));
		board.put("D1", null);
		board.put("E1", null);
		board.put("F1", null);
		board.put("G1", null);
		board.put("H1", null);

		return board;
	}
	// Initialize the chess board on map (coord => piece)

	public Map<String, Piece> initialize() {
		Map<String, Piece> board = new LinkedHashMap<>();

		// Top line Black
		board.put("A8", new Rook(Color.BLACK));
		board.put("B8", new Knight(Color.BLACK));
		board.put("C8", new Bishop(Color.BLACK));
		board.put("D8", new Queen(Color.BLACK));
		board.put("E8", new King(Color.BLACK));
		board.put("F8", new Bishop(Color.BLACK));
		board.put("G8", new Knight(Color.BLACK));
		board.put("H8", new Rook(Color.BLACK));

		// Bottom line Black
		board.put("A7", new Pawn(Color.BLACK));
		board.put("B7", new Pawn(Color.BLACK));
		board.put("C7", new Pawn(Color.BLACK));
		board.put("D7", new Pawn(Color.BLACK));
		board.put("E7", new Pawn(Color.BLACK));
		board.put("F7", new Pawn(Color.BLACK));
		board.put("G7", new Pawn(Color.BLACK));
		board.put("H7", new Pawn(Color.BLACK));

		// Null
		board.put("A6", null);
		board.put("B6", null);
		board.put("C6", null);
		board.put("D6", null);
		board.put("E6", null);
		board.put("F6", null);
		board.put("G6", null);
		board.put("H6", null);

		board.put("A5", null);
		board.put("B5", null);
		board.put("C5", null);
		board.put("D5", null);
		board.put("E5", null);
		board.put("F5", null);
		board.put("G5", null);
		board.put("H5", null);

		board.put("A5", null);
		board.put("B5", null);
		board.put("C5", null);
		board.put("D5", null);
		board.put("E5", null);
		board.put("F5", null);
		board.put("G5", null);
		board.put("H5", null);

		board.put("A4", null);
		board.put("B4", null);
		board.put("C4", null);
		board.put("D4", null);
		board.put("E4", null);
		board.put("F4", null);
		board.put("G4", null);
		board.put("H4", null);

		board.put("A3", null);
		board.put("B3", null);
		board.put("C3", null);
		board.put("D3", null);
		board.put("E3", null);
		board.put("F3", null);
		board.put("G3", null);
		board.put("H3", null);

		// Bottom line White
		board.put("A2", new Pawn(Color.WHITE));
		board.put("B2", new Pawn(Color.WHITE));
		board.put("C2", new Pawn(Color.WHITE));
		board.put("D2", new Pawn(Color.WHITE));
		board.put("E2", new Pawn(Color.WHITE));
		board.put("F2", new Pawn(Color.WHITE));
		board.put("G2", new Pawn(Color.WHITE));
		board.put("H2", new Pawn(Color.WHITE));

		// Top line White
		board.put("A1", new Rook(Color.WHITE));
		board.put("B1", new Knight(Color.WHITE));
		board.put("C1", new Bishop(Color.WHITE));
		board.put("D1", new Queen(Color.WHITE));
		board.put("E1", new King(Color.WHITE));
		board.put("F1", new Bishop(Color.WHITE));
		board.put("G1", new Knight(Color.WHITE));
		board.put("H1", new Rook(Color.WHITE));

		return board;
	}

	private void displayBoard(Map<String, Piece> boardPositions) {
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

	// Does the player exists ? Is it his turn to play ?
	private boolean playAutorization(Board board, String playerName) {
		return ((board.isWhiteTurnToPlay() && playerName == board.getWhitePlayerName())
				|| (!board.isWhiteTurnToPlay() && playerName == board.getBlackPlayerName()));
	}

	// Is there a Piece on squareCoordDeparture ? Does the arrival square exists on
	// the board? square coord is not the same square as square arrival?
	private boolean movePossible(Board board, String squareCoordDeparture, String squareCoordArrival) {
		if ((board.getBoard().get(squareCoordDeparture) == null) || (board.getBoard().containsKey(squareCoordArrival) == false)
				|| (squareCoordDeparture.equalsIgnoreCase(squareCoordArrival))) {
			return false;
		}
		return true;
	}

	public boolean move(Board board, String playerName, String squareCoordDeparture, String squareCoordArrival)
			throws NotYourTurnException, MoveImpossibleException {
		squareCoordDeparture = squareCoordDeparture.toUpperCase();
		squareCoordArrival = squareCoordArrival.toUpperCase();

		if (!playAutorization(board, playerName)) {
			throw new NotYourTurnException("Cannot find player : " + playerName
					+ " in the game or it's your not your turn, White turn : " + board.isWhiteTurnToPlay());
		}

		if (!movePossible(board, squareCoordDeparture, squareCoordArrival)) {
			throw new MoveImpossibleException("Impossible to do such a move square departure : " + squareCoordDeparture
					+ " square arrival : " + squareCoordArrival);
		}

		displayBoard(board.getBoard());

		return board.getBoard().get(squareCoordDeparture).move(board.getBoard(), squareCoordDeparture, squareCoordArrival);
	}
}
