package application.model;

import java.util.Map;

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
		return (board.get(squareCoordArrival) == null)
				|| (board.get(squareCoordArrival).getColor() == board.get(squareCoordDeparture).opponentColor());
	}
}
