package application.model;

import application.util.Utils;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class King extends Piece {

    public King(Color color) {
        super(color);
    }

    @Override
    public String getLetter() {
        return "K";
    }

    @Override
    public String getPieceName() {
        return "King";
    }

    @Override
    public boolean move(Map<String, Piece> board, String squareCoordDeparture, String squareCoordArrival) {
        log.info("Moving like the king");

        Color myColor = board.get(squareCoordDeparture).getColor();

        List<String> positionReachableByKing = new ArrayList<>();

        List<String> xArray = new ArrayList<>(Arrays.asList("--A", "-A", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"));

        String xCoord = Utils.getLetterFromNumber(squareCoordDeparture);
        int yCoord = Utils.getNumberFromString(squareCoordDeparture);

        // Diagonal positions
        positionReachableByKing.add((xArray.get(xArray.indexOf(xCoord) - 1) + (yCoord + 1)));
        positionReachableByKing.add((xArray.get(xArray.indexOf(xCoord) + 1) + (yCoord + 1)));
        positionReachableByKing.add((xArray.get(xArray.indexOf(xCoord) + 1) + (yCoord - 1)));
        positionReachableByKing.add((xArray.get(xArray.indexOf(xCoord) - 1) + (yCoord - 1)));

        // Cross positions
        positionReachableByKing.add((xArray.get(xArray.indexOf(xCoord)) + (yCoord + 1)));
        positionReachableByKing.add((xArray.get(xArray.indexOf(xCoord) + 1) + (yCoord)));
        positionReachableByKing.add((xArray.get(xArray.indexOf(xCoord)) + (yCoord - 1)));
        positionReachableByKing.add((xArray.get(xArray.indexOf(xCoord) - 1) + (yCoord)));

        // Error management
        Iterator<String> it = positionReachableByKing.iterator();
        while (it.hasNext()) {

            String position = it.next();

            // Position must exist on the chessBoard
            if (!board.containsKey(position)) {
                it.remove();
            }
            // Position exists on the chessBoard and are respecting king behavior
            else {
                if (board.get(position) != null && board.get(position).getColor() == myColor) {
                    it.remove();
                }
            }
        }

        return positionReachableByKing.contains(squareCoordArrival);
    }
}
