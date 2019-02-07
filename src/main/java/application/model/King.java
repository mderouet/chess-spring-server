package application.model;

import java.util.Map;

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

		return false;
	}
}
