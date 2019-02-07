package application.movement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import application.model.Color;
import application.model.Piece;
import application.utils.Utility;

public interface RookMove {
	public default boolean lateralMove(Map<String, Piece> board, String squareCoordDeparture,
			String squareCoordArrival) {

		Color opponentColor = board.get(squareCoordDeparture).opponentColor();

		int[] yArray = { 1, 2, 3, 4, 5, 6, 7, 8 };
		String[] xArray = { "A", "B", "C", "D", "E", "F", "G", "H" };

		String xCoord = Utility.getLetterFromNumber(squareCoordDeparture);
		int yCoord = Utility.getNumberFromString(squareCoordDeparture);

		List<String> xPossibleMoves = new ArrayList<>();
		// All horizontal coords
		for (String currentChar : xArray) {
			xPossibleMoves.add(new StringBuilder(currentChar + yCoord).toString());
		}

		List<String> yPossibleMoves = new ArrayList<>();
		// All vertical coords
		for (int currentInt : yArray) {
			yPossibleMoves.add(new StringBuilder(xCoord + currentInt).toString());
		}

		List<String> totalPossibleMoves = new ArrayList<>();

		// Iterating top positions
		int i = yPossibleMoves.indexOf(squareCoordDeparture);
		boolean towerCanMoveTop = true;
		while (towerCanMoveTop) {
			i++;
			Piece pieceToCheck = board.get(yPossibleMoves.get(i));

			// Si il n'existe pas de piece c'est un move possible
			if (pieceToCheck == null) {
				totalPossibleMoves.add(yPossibleMoves.get(i));
			}
			// Si il existe une piece, mais qu'elle appartient à l'adversaire, c'est un move
			// possible, mais le dernier dans cette direction

			if ((pieceToCheck != null) && (pieceToCheck.getColor() == opponentColor)) {
				totalPossibleMoves.add(yPossibleMoves.get(i));
				towerCanMoveTop = false;
			}

			// Si une piece existe mais qu'elle est de la même couleur que ma piece ou que
			// nous arrivons au bout du tableau
			if ((pieceToCheck != null) && (pieceToCheck.getColor() == board.get(squareCoordDeparture).getColor())
					|| i == 0) {
				towerCanMoveTop = false;
			}
		}

		// Iterating bottom positions
		int indexBottom = yPossibleMoves.indexOf(squareCoordDeparture);
		boolean towerCanMoveBottom = true;
		while (towerCanMoveBottom) {
			indexBottom--;
			Piece pieceToCheck = board.get(yPossibleMoves.get(indexBottom));

			if (pieceToCheck == null) {
				totalPossibleMoves.add(yPossibleMoves.get(indexBottom));
			}
			if ((pieceToCheck != null) && (pieceToCheck.getColor() == opponentColor)) {
				totalPossibleMoves.add(yPossibleMoves.get(indexBottom));
				towerCanMoveBottom = false;
			}
			if ((pieceToCheck != null) && (pieceToCheck.getColor() == board.get(squareCoordDeparture).getColor())
					|| indexBottom == 0) {
				towerCanMoveBottom = false;
			}
		}

		// Iterating right positions
		int indexRight = xPossibleMoves.indexOf(squareCoordDeparture);
		boolean towerCanMoveRight = true;
		while (towerCanMoveRight) {
			indexRight++;
			Piece pieceToCheck = board.get(xPossibleMoves.get(indexRight));

			if (pieceToCheck == null) {
				totalPossibleMoves.add(xPossibleMoves.get(indexRight));
			}
			if ((pieceToCheck != null) && (pieceToCheck.getColor() == opponentColor)) {
				totalPossibleMoves.add(xPossibleMoves.get(indexRight));
				towerCanMoveRight = false;
			}
			if ((pieceToCheck != null) && (pieceToCheck.getColor() == board.get(squareCoordDeparture).getColor())
					|| indexRight == 0) {
				towerCanMoveRight = false;
			}
		}
		// Iterating left positions
		int indexLeft = xPossibleMoves.indexOf(squareCoordDeparture);
		boolean towerCanMoveLeft = true;
		while (towerCanMoveLeft) {
			indexLeft--;
			Piece pieceToCheck = board.get(xPossibleMoves.get(indexLeft));

			if (pieceToCheck == null) {
				totalPossibleMoves.add(xPossibleMoves.get(indexLeft));
			}
			if ((pieceToCheck != null) && (pieceToCheck.getColor() == opponentColor)) {
				totalPossibleMoves.add(xPossibleMoves.get(indexLeft));
				towerCanMoveLeft = false;
			}
			if ((pieceToCheck != null) && (pieceToCheck.getColor() == board.get(squareCoordDeparture).getColor())
					|| indexLeft == 0) {
				towerCanMoveLeft = false;
			}
		}

		return totalPossibleMoves.contains(squareCoordArrival);
	}
}
