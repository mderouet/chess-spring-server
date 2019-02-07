package application.model;

import java.util.Map;

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
		return false;
	}
}
