package application.model;

import java.util.Map;

public abstract class Piece {

	private Color color;

	public Piece(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public abstract String getLetter();

	public abstract boolean move(Map<String, Piece> board, String piecePosition, String pieceArrivalPosition);
}
