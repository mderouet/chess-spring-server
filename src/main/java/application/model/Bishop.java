package application.model;

import application.movement.BishopMove;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class Bishop extends Piece implements BishopMove {

    public Bishop(Color color) {
        super(color);
    }

    @Override
    public String getLetter() {
        return "B";
    }

    @Override
    public String getPieceName() {
        return "Bishop";
    }

    @Override
    public boolean move(Map<String, Piece> board, String squareCoordDeparture, String squareCoordArrival) {

        // inherit from bishopmove interface
        return this.diagonalMove(board, squareCoordDeparture, squareCoordArrival);
    }
}
