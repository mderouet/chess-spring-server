package application.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import application.utils.Utility;

public class Pawn extends Piece {

	public Pawn(Color color) {
		super(color);
	}

	@Override
	public String getLetter() {
		return "P";
	}

	@Override
	public boolean move(Map<String, Piece> board, String squareCoordDeparture, String squareCoordArrival) {
		System.out.println("Je bouge comme un pion");

		// A pawn can only go forward we need the color in order to know whether we are
		// going forward or not

		Color myColor = board.get(squareCoordDeparture).getColor();

		List<String> xArray = new ArrayList<String>();
		xArray.addAll(Arrays.asList("--A", "-A", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"));

		String xCoord = Utility.getLetterFromNumber(squareCoordDeparture);
		int yCoord = Utility.getNumberFromString(squareCoordDeparture);

		// White pawn can only increase his ordonate
		if (myColor == Color.WHITE && Utility.getNumberFromString(squareCoordArrival) < yCoord) {
			return false;
		}
		// Black pawn can only decrease his ordonate
		if (myColor == Color.BLACK && Utility.getNumberFromString(squareCoordArrival) > yCoord) {
			return false;
		}

		// At this stage our pawn goes to the right direction

		List<String> positionReachableByPawn = new ArrayList<>();
		if (myColor == Color.WHITE) {
			positionReachableByPawn.add((xArray.get(xArray.indexOf(xCoord) - 1) + (yCoord + 1)));
			positionReachableByPawn.add((xArray.get(xArray.indexOf(xCoord)) + (yCoord + 1)));
			positionReachableByPawn.add((xArray.get(xArray.indexOf(xCoord) + 1) + (yCoord + 1)));
			if (yCoord == 2) {
				positionReachableByPawn.add((xArray.get(xArray.indexOf(xCoord)) + (yCoord + 2)));
			}
		}
		if (myColor == Color.BLACK) {
			positionReachableByPawn.add((xArray.get(xArray.indexOf(xCoord) + 1) + (yCoord - 1)));
			positionReachableByPawn.add((xArray.get(xArray.indexOf(xCoord)) + (yCoord - 1)));
			positionReachableByPawn.add((xArray.get(xArray.indexOf(xCoord) - 1) + (yCoord - 1)));
			if (yCoord == 7) {
				positionReachableByPawn.add((xArray.get(xArray.indexOf(xCoord)) + (yCoord - 2)));
			}
		}

		// Find possible moves
		Iterator<String> it = positionReachableByPawn.iterator();
		while (it.hasNext()) {
			// Position must exist on the board
			String position = it.next();

			// Delete position if it's not even on the board (overflow array behavior)
			if (!board.containsKey(position)) {
				it.remove();
				
				// The positions exists on the board
			} else {
				// Same column of departure / arrival
				// Arrival position must be Null (pawn behavior)
				if ((Utility.getLetterFromNumber(position).contains(xCoord)) && (board.get(position) != null)) {
					it.remove();
				}

				// Diagonal left / right ?
				// Checking if we can "eat" something in diagonal
				if (!(Utility.getLetterFromNumber(position).contains(xCoord))
						&& ((board.get(position) == null) || (board.get(position).getColor() == myColor))) {
					it.remove();
				}
			}
		}

		return positionReachableByPawn.contains(squareCoordArrival);
	}
}
