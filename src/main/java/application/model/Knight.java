package application.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import application.utils.Utility;

public class Knight extends Piece {

	public Knight(Color color) {
		super(color);
	}

	@Override
	public String getLetter() {
		return "N";
	}

	@Override
	public boolean move(Map<String, Piece> board, String squareCoordDeparture, String squareCoordArrival) {
		List<String> positionReachableByKnight = new ArrayList<>();

		List<String> xArray = new ArrayList<String>();

		// array with overflow in order to get all position even if it's not on the
		// board
		xArray.addAll(Arrays.asList("--A", "-A", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"));

		String xCoord = Utility.getLetterFromNumber(squareCoordDeparture);
		int yCoord = Utility.getNumberFromString(squareCoordDeparture);

		// Right moves
		positionReachableByKnight.add((xArray.get(xArray.indexOf(xCoord) + 2)) + (+yCoord + 1));
		positionReachableByKnight.add((xArray.get(xArray.indexOf(xCoord) + 2)) + (+yCoord - 1));
		// Left moves
		positionReachableByKnight.add((xArray.get(xArray.indexOf(xCoord) - 2)) + (+yCoord + 1));
		positionReachableByKnight.add((xArray.get(xArray.indexOf(xCoord) - 2)) + (+yCoord - 1));
		// Top moves
		positionReachableByKnight.add((xArray.get(xArray.indexOf(xCoord) - 1)) + (+yCoord + 2));
		positionReachableByKnight.add((xArray.get(xArray.indexOf(xCoord) + 1)) + (+yCoord + 2));
		// Bottom moves
		positionReachableByKnight.add((xArray.get(xArray.indexOf(xCoord) - 1)) + (+yCoord - 2));
		positionReachableByKnight.add((xArray.get(xArray.indexOf(xCoord) + 1)) + (+yCoord - 2));

		// Error management
		Iterator<String> it = positionReachableByKnight.iterator();
		while (it.hasNext()) {
			// Position must exist on the board
			if (!board.containsKey(it.next())) {
				it.remove();
			}
		}

		// Position reachable only show position but don't look at the current content
		// of the square (friend piece in here ? no piece ?)
		// We need check whether the move is possible

		boolean movePossible = false;

		// the square must be empty, or opponent piece
		if ((board.get(squareCoordArrival) == null) || (board.get(squareCoordArrival) != null
				&& board.get(squareCoordArrival).getColor() == board.get(squareCoordDeparture).opponentColor())) {
			movePossible = true;
		}

		// The square arrival must be in the position reachable by the knight and also,
		return positionReachableByKnight.contains(squareCoordArrival) && movePossible;
	}
}
