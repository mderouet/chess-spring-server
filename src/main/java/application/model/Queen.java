package application.model;

import java.util.Map;

import application.movement.BishopMove;
import application.movement.RookMove;

public class Queen extends Piece implements RookMove, BishopMove {

	public Queen(Color color) {
		super(color);
	}

	@Override
	public String getLetter() {
		return "Q";
	}

	@Override
	public boolean move(Map<String, Piece> board, String queenPosition, String queenArrivalPosition) {
		System.out.println("Je bouge comme la reine");
		// The queen move pretty much like rook + bishop (lateral + diagonal)
		// If diagonal or lateral function reveal that this move is allowed, then the
		// queen can move
		return (this.lateralMove(board, queenPosition, queenArrivalPosition)
				|| (this.diagonalMove(board, queenPosition, queenArrivalPosition)));
	}

}
