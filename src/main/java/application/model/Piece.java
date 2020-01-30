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

    public Color opponentColor() {
        return this.getColor() == Color.WHITE ? Color.BLACK : Color.WHITE;
    }

    public abstract String getLetter();

    public abstract String getPieceName();

    public abstract boolean move(Map<String, Piece> board, String piecePosition, String pieceArrivalPosition);
}
