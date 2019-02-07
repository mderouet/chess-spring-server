package application.movement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import application.model.Color;
import application.model.Piece;
import application.utils.Utility;

public interface BishopMove {
	public default boolean diagonalMove(Map<String, Piece> board, String squareCoordDeparture,
			String squareCoordArrival) {
		Color opponentColor = board.get(squareCoordDeparture).opponentColor();

		List<Integer> yArray = new ArrayList<Integer>();
		yArray.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

		List<String> xArray = new ArrayList<String>();
		xArray.addAll(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H"));

		String xCoord = Utility.getLetterFromNumber(squareCoordDeparture);
		int yCoord = Utility.getNumberFromString(squareCoordDeparture);

		List<String> totalPossibleMoves = new ArrayList<>();

		// Top Right diag checking
		boolean inbound = true;
		boolean bishopCanMove = true;
		int i = xArray.indexOf(xCoord);
		int y = yArray.indexOf(yCoord);
		while (inbound && bishopCanMove) {
			// Index of integer array which we are iterating
			i++;
			// Index of Letter (A,B,C..)
			y++;

			String pieceSquare = xArray.get(i) + yArray.get(y);

			// Current square we are checking
			Piece squareToCheck = board.get(pieceSquare);

			if (board.containsKey(pieceSquare)) {
				// Si il n'existe pas de piece c'est un move possible
				if (squareToCheck == null) {
					totalPossibleMoves.add(pieceSquare);
				}
				// Si il existe une piece, mais qu'elle appartient à l'adversaire, c'est un move
				// possible, mais le dernier dans cette direction
				if ((squareToCheck != null) && (squareToCheck.getColor() == opponentColor)) {
					totalPossibleMoves.add(pieceSquare);
					bishopCanMove = false;
				}
				// Si une piece existe mais qu'elle est de la même couleur que ma piece
				if ((squareToCheck != null)
						&& (squareToCheck.getColor() == board.get(squareCoordDeparture).getColor())) {
					bishopCanMove = false;
				}

				// Avoid index out bound when iterating over array
				if (xArray.size() <= i + 1 || yArray.size() <= y + 1) {
					inbound = false;
				}
			}
		}

		// Bottom left diag checking
		// Reset boolean
		inbound = true;
		bishopCanMove = true;
		i = xArray.indexOf(xCoord);
		y = yArray.indexOf(yCoord);

		while (inbound && bishopCanMove) {
			i--;
			y--;

			String pieceSquare = xArray.get(i) + yArray.get(y);
			Piece squareToCheck = board.get(pieceSquare);

			if (board.containsKey(pieceSquare)) {
				if (squareToCheck == null) {
					totalPossibleMoves.add(pieceSquare);
				}
				if ((squareToCheck != null) && (squareToCheck.getColor() == opponentColor)) {
					totalPossibleMoves.add(pieceSquare);
					bishopCanMove = false;
				}
				if ((squareToCheck != null)
						&& (squareToCheck.getColor() == board.get(squareCoordDeparture).getColor())) {
					bishopCanMove = false;
				}
				if (xArray.size() <= i + 1 || yArray.size() <= y + 1) {
					inbound = false;
				}
			}
		}

		// Bottom right diag checking

		inbound = true;
		bishopCanMove = true;
		i = xArray.indexOf(xCoord);
		y = yArray.indexOf(yCoord);

		while (inbound && bishopCanMove) {
			i++;
			y--;

			String pieceSquare = xArray.get(i) + yArray.get(y);
			Piece squareToCheck = board.get(pieceSquare);

			if (board.containsKey(pieceSquare)) {
				if (squareToCheck == null) {
					totalPossibleMoves.add(pieceSquare);
				}
				if ((squareToCheck != null) && (squareToCheck.getColor() == opponentColor)) {
					totalPossibleMoves.add(pieceSquare);
					bishopCanMove = false;
				}
				if ((squareToCheck != null)
						&& (squareToCheck.getColor() == board.get(squareCoordDeparture).getColor())) {
					bishopCanMove = false;
				}
				if (xArray.size() <= i + 1 || yArray.size() <= y + 1) {
					inbound = false;
				}
			}
		}

		// Top Left diag checking

		inbound = true;
		bishopCanMove = true;
		i = xArray.indexOf(xCoord);
		y = yArray.indexOf(yCoord);

		while (inbound && bishopCanMove) {
			i--;
			y++;

			String pieceSquare = xArray.get(i) + yArray.get(y);
			Piece squareToCheck = board.get(pieceSquare);

			if (board.containsKey(pieceSquare)) {
				if (squareToCheck == null) {
					totalPossibleMoves.add(pieceSquare);
				}
				if ((squareToCheck != null) && (squareToCheck.getColor() == opponentColor)) {
					totalPossibleMoves.add(pieceSquare);
					bishopCanMove = false;
				}
				if ((squareToCheck != null)
						&& (squareToCheck.getColor() == board.get(squareCoordDeparture).getColor())) {
					bishopCanMove = false;
				}
				if (xArray.size() <= i + 1 || yArray.size() <= y + 1) {
					inbound = false;
				}
			}
		}

		return totalPossibleMoves.contains(squareCoordArrival);
	}
}
