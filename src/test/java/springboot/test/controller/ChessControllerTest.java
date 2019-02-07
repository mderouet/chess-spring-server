package springboot.test.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import application.exception.MoveImpossibleException;
import application.exception.NotYourTurnException;
import application.model.Board;
import application.service.BoardBuilder;

public class ChessControllerTest {

	// First turn white can play
	@Test(expected = NotYourTurnException.class)
	public void whiteTurnToPlay() throws Exception {
		Board board = new Board("Promethee", "Epimethee");
		board.move("Epimethee", "C1", "C2");
	}

	// Player name does not exist
	@Test(expected = NotYourTurnException.class)
	public void playerName() throws Exception {
		Board board = new Board("Promethee", "Epimethee");
		board.move("noname", "C1", "C2");
	}

	// Departure square must contain a piece
	@Test(expected = MoveImpossibleException.class)
	public void departurePieceExist() throws Exception {
		Board board = new Board("Promethee", "Epimethee");
		// After init, C4 does not contain any piece
		board.move("Promethee", "C4", "C2");
	}

	// Departure square must contain a piece
	@Test(expected = MoveImpossibleException.class)
	public void squaresExistOnTheBoard() throws Exception {
		Board board = new Board("Promethee", "Epimethee");
		// The board does not contain C9 position nor I6
		board.move("Promethee", "C9", "I6");
	}

	@Test(expected = MoveImpossibleException.class)
	public void sameSquare() throws Exception {
		Board board = new Board("Promethee", "Epimethee");
		// The board does not contain C9 position nor I6
		board.move("Promethee", "A2", "A2");
	}

	@Test
	public void rookMove() throws Exception {
		Board board = new Board("Promethee", "Epimethee");
		board.setBoard(BoardBuilder.initializeTestPosition());
		board.displayBoard();

		// Wrong moves
		assertEquals(false, board.move("Promethee", "D4", "A4"));
		assertEquals(false, board.move("Promethee", "D4", "G4"));
		assertEquals(false, board.move("Promethee", "D4", "G5"));
		assertEquals(false, board.move("Promethee", "D4", "A3"));
		assertEquals(false, board.move("Promethee", "D4", "A5"));
		assertEquals(false, board.move("Promethee", "D4", "D8"));
		assertEquals(false, board.move("Promethee", "D4", "D7"));
		assertEquals(false, board.move("Promethee", "D4", "D3"));

		// Right moves
		assertEquals(true, board.move("Promethee", "D4", "C4"));
		assertEquals(true, board.move("Promethee", "D4", "D6"));
		assertEquals(true, board.move("Promethee", "D4", "F4"));
		assertEquals(true, board.move("Promethee", "D4", "E4"));
		assertEquals(true, board.move("Promethee", "D4", "D5"));
	}

	@Test
	public void bishopMove() throws Exception {
		Board board = new Board("Promethee", "Epimethee");
		board.setBoard(BoardBuilder.initializeTestPosition());
		board.displayBoard();

		// Wrong moves
		assertEquals(false, board.move("Promethee", "F5", "G4"));
		assertEquals(false, board.move("Promethee", "F5", "H3"));
		assertEquals(false, board.move("Promethee", "F5", "D3"));
		assertEquals(false, board.move("Promethee", "F5", "C2"));
		assertEquals(false, board.move("Promethee", "F5", "C3"));
		assertEquals(false, board.move("Promethee", "F5", "H7"));

		// Right moves
		assertEquals(true, board.move("Promethee", "F5", "C8"));
		assertEquals(true, board.move("Promethee", "F5", "D7"));
		assertEquals(true, board.move("Promethee", "F5", "E6"));
		assertEquals(true, board.move("Promethee", "F5", "G6"));
		assertEquals(true, board.move("Promethee", "F5", "E4"));
	}

	@Test
	public void queenMove() throws Exception {
		Board board = new Board("Promethee", "Epimethee");
		board.setBoard(BoardBuilder.initializeTestPosition());
		board.displayBoard();

		// Wrong moves
		assertEquals(false, board.move("Promethee", "E5", "F5"));
		assertEquals(false, board.move("Promethee", "E5", "G5"));
		assertEquals(false, board.move("Promethee", "E5", "H5"));
		assertEquals(false, board.move("Promethee", "E5", "H3"));
		assertEquals(false, board.move("Promethee", "E5", "C7"));
		assertEquals(false, board.move("Promethee", "E5", "B8"));
		assertEquals(false, board.move("Promethee", "E5", "E1"));
		assertEquals(false, board.move("Promethee", "E5", "E2"));
		assertEquals(false, board.move("Promethee", "E5", "E8"));
		assertEquals(false, board.move("Promethee", "E5", "D4"));
		assertEquals(false, board.move("Promethee", "E5", "C3"));

		// Right moves
		assertEquals(true, board.move("Promethee", "E5", "E3"));
		assertEquals(true, board.move("Promethee", "E5", "E4"));
		assertEquals(true, board.move("Promethee", "E5", "E6"));
		assertEquals(true, board.move("Promethee", "E5", "E7"));
		assertEquals(true, board.move("Promethee", "E5", "F6"));
		assertEquals(true, board.move("Promethee", "E5", "G7"));
		assertEquals(true, board.move("Promethee", "E5", "A5"));
		assertEquals(true, board.move("Promethee", "E5", "B5"));
		assertEquals(true, board.move("Promethee", "E5", "C5"));
		assertEquals(true, board.move("Promethee", "E5", "D5"));
		assertEquals(true, board.move("Promethee", "E5", "F4"));

	}

	@Test
	public void knightMove() throws Exception {
		Board board = new Board("Promethee", "Epimethee");
		board.setBoard(BoardBuilder.initializeTestPosition());
		board.displayBoard();

		// Wrong moves
		assertEquals(false, board.move("Promethee", "F3", "H2"));
		assertEquals(false, board.move("Promethee", "F3", "D4"));
		assertEquals(false, board.move("Promethee", "F3", "E5"));
		assertEquals(false, board.move("Promethee", "F3", "A4"));
		assertEquals(false, board.move("Promethee", "F3", "A3"));
		assertEquals(false, board.move("Promethee", "F3", "B8"));

		// Right moves
		assertEquals(true, board.move("Promethee", "F3", "E1"));
		assertEquals(true, board.move("Promethee", "F3", "H4"));
		assertEquals(true, board.move("Promethee", "F3", "G1"));
		assertEquals(true, board.move("Promethee", "F3", "D2"));
		assertEquals(true, board.move("Promethee", "F3", "G5"));
	}

	@Test
	public void pawnMove() throws Exception {
		Board board = new Board("Promethee", "Epimethee");
		board.setBoard(BoardBuilder.initializeTestPosition());
		board.displayBoard();

		// Wrong moves
		// Pawn white can't go back
		assertEquals(false, board.move("Promethee", "H2", "H1"));
		assertEquals(false, board.move("Promethee", "G4", "G2"));
		assertEquals(false, board.move("Promethee", "G4", "G3"));

		// Pawn black can't go back
		assertEquals(false, board.move("Promethee", "C4", "C5"));
		assertEquals(false, board.move("Promethee", "G4", "C6"));

		assertEquals(false, board.move("Promethee", "D3", "D4"));
		assertEquals(false, board.move("Promethee", "D3", "E4"));
		assertEquals(false, board.move("Promethee", "D3", "A4"));
		assertEquals(false, board.move("Promethee", "D3", "A3"));
		assertEquals(false, board.move("Promethee", "G4", "D2"));
		assertEquals(false, board.move("Promethee", "H2", "H4"));

		// Right moves
		// Pawn black can't go back
		assertEquals(true, board.move("Promethee", "C4", "C3"));
		assertEquals(true, board.move("Promethee", "D3", "C4"));
		assertEquals(true, board.move("Promethee", "E2", "E3"));
		assertEquals(true, board.move("Promethee", "E2", "E4"));
		assertEquals(true, board.move("Promethee", "H2", "H3"));
		assertEquals(true, board.move("Promethee", "D3", "C4"));
		assertEquals(true, board.move("Promethee", "B2", "B4"));
	}

	@Test
	public void kingMove() throws Exception {
		Board board = new Board("Promethee", "Epimethee");
		board.setBoard(BoardBuilder.initializeTestPosition());
		board.displayBoard();

		// Wrong moves
		assertEquals(false, board.move("Promethee", "G3", "F2"));
		assertEquals(false, board.move("Promethee", "G3", "F3"));
		assertEquals(false, board.move("Promethee", "G3", "G4"));
		assertEquals(false, board.move("Promethee", "G3", "H2"));

		// Right moves
		assertEquals(true, board.move("Promethee", "G3", "H3"));
		assertEquals(true, board.move("Promethee", "G3", "H4"));
		assertEquals(true, board.move("Promethee", "G3", "F4"));
		assertEquals(true, board.move("Promethee", "G3", "G2"));
	}
}
