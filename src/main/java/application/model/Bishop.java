package application.model;

import java.util.Map;

import application.movement.BishopMove;

public class Bishop extends Piece implements BishopMove {

	public Bishop(Color color) {
		super(color);
	}

	@Override
	public String getLetter() {
		return "B";
	}

	@Override
	public boolean move(Map<String, Piece> board, String squareCoordDeparture, String squareCoordArrival) {

		// inherit from bishopmove interface
		return this.diagonalMove(board, squareCoordDeparture, squareCoordArrival);
	}
}
