package application.model;

import application.movement.BishopMove;
import application.movement.RookMove;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class Queen extends Piece implements RookMove, BishopMove {

    public Queen(Color color) {
        super(color);
    }

    @Override
    public String getLetter() {
        return "Q";
    }

    @Override
    public String getPieceName() {
        return "Queen";
    }

    @Override
    public boolean move(Map<String, Piece> board, String queenPosition, String queenArrivalPosition) {
        // The queen move pretty much like rook + bishop (lateral + diagonal)
        // If diagonal or lateral function reveal that this move is allowed, then the
        // queen can move
        return this.lateralMove(board, queenPosition, queenArrivalPosition)
                || (this.diagonalMove(board, queenPosition, queenArrivalPosition));
    }
}
