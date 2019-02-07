package application.model;

import java.util.Map;

import application.movement.RookMove;

public class Rook extends Piece implements RookMove {

	public Rook(Color color) {
		super(color);
	}

	@Override
	public String getLetter() {
		return "R";
	}

	@Override
	public boolean move(Map<String, Piece> board, String rookPosition, String rookArrivalPosition) {

		// Inherit from RookMove interface
		return this.lateralMove(board, rookPosition, rookArrivalPosition);
	}
}
