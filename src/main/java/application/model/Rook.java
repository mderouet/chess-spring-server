package application.model;

import application.movement.RookMove;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class Rook extends Piece implements RookMove {

    public Rook(Color color) {
        super(color);
    }

    @Override
    public String getLetter() {
        return "R";
    }

    @Override
    public String getPieceName() {
        return "Rook";
    }

    @Override
    public boolean move(Map<String, Piece> board, String rookPosition, String rookArrivalPosition) {

        // Inherit from RookMove interface
        return this.lateralMove(board, rookPosition, rookArrivalPosition);
    }
}
