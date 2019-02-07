package application.model;

import java.util.ArrayList;
import java.util.Arrays;
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
		Color opponentColor = Color.BLACK;
		if (board.get(squareCoordDeparture).getColor() == Color.BLACK) {
			opponentColor = Color.WHITE;
		}
		
		List<Integer> yArray = new ArrayList<Integer>();
		yArray.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

		List<String> xArray = new ArrayList<String>();
		xArray.addAll(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H"));
		
		
		String xCoord = Utility.getLetterFromNumber(squareCoordDeparture);
		int yCoord = Utility.getNumberFromString(squareCoordDeparture);

		System.out.println(xArray.indexOf(xCoord));
		
		System.out.println("je bouge comme le cavalier");
		return false;
	}
}
