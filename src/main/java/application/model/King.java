package application.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import application.utils.Utility;

public class King extends Piece {

	public King(Color color) {
		super(color);
	}

	@Override
	public String getLetter() {
		return "K";
	}

	@Override
	public boolean move(Map<String, Piece> board, String squareCoordDeparture, String squareCoordArrival) {
		System.out.println("Je bouge comme le roi");

		Color myColor = board.get(squareCoordDeparture).getColor();

		List<String> positionReachableByKing = new ArrayList<>();

		List<String> xArray = new ArrayList<String>();

		xArray.addAll(Arrays.asList("--A", "-A", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"));

		String xCoord = Utility.getLetterFromNumber(squareCoordDeparture);
		int yCoord = Utility.getNumberFromString(squareCoordDeparture);

		// Diagonal positions
		positionReachableByKing.add((xArray.get(xArray.indexOf(xCoord) - 1) + (yCoord + 1)));
		positionReachableByKing.add((xArray.get(xArray.indexOf(xCoord) + 1) + (yCoord + 1)));
		positionReachableByKing.add((xArray.get(xArray.indexOf(xCoord) + 1) + (yCoord - 1)));
		positionReachableByKing.add((xArray.get(xArray.indexOf(xCoord) - 1) + (yCoord - 1)));

		// Cross positions
		positionReachableByKing.add((xArray.get(xArray.indexOf(xCoord)) + (yCoord + 1)));
		positionReachableByKing.add((xArray.get(xArray.indexOf(xCoord) + 1) + (yCoord)));
		positionReachableByKing.add((xArray.get(xArray.indexOf(xCoord)) + (yCoord - 1)));
		positionReachableByKing.add((xArray.get(xArray.indexOf(xCoord) - 1) + (yCoord)));

		// Error management
		Iterator<String> it = positionReachableByKing.iterator();
		while (it.hasNext()) {

			String position = it.next();

			// Position must exist on the board
			if (!board.containsKey(position)) {
				it.remove();
			}
			// Position exists on the board and are respecting king behavior
			else {
				if (board.get(position) != null && board.get(position).getColor() == myColor) {
					it.remove();
				}
			}
		}

		return positionReachableByKing.contains(squareCoordArrival);
	}
}
