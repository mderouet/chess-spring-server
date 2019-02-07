package application;

import application.exception.MoveImpossibleException;
import application.exception.NotYourTurnException;
import application.model.Board;

public class Main {

	public static void main(String[] args) {
		Board b = new Board("David", "Goliath");
		b.setBoard(application.service.BoardBuilder.initializeTestPosition());
		try {
			b.move("David", "F3", "G5");
		} catch (NotYourTurnException | MoveImpossibleException e) {
			System.out.println(e);
		}
		
	}

}
