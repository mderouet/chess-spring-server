package board;

import static org.junit.Assert.assertEquals;

import application.service.BoardService;
import org.junit.Before;
import org.junit.Test;
import application.exception.MoveImpossibleException;
import application.exception.NotYourTurnException;
import application.model.Board;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ChessBoardDefaultPositionTest {

	BoardService boardService = new BoardService();
	private Board board;

	@Before
	public void init() {
		board = new Board(0,"Promethee","Epimethee");
	}

	// First turn white can play
	@Test(expected = NotYourTurnException.class)
	public void whiteTurnToPlay() throws Exception {
		boardService.move(board,"Epimethee", "C1", "C2");
	}

	// Player name does not exist
	@Test(expected = NotYourTurnException.class)
	public void playerName() throws Exception {
		boardService.move(board,"noname", "C1", "C2");
	}

	// Departure square must contain a piece
	@Test(expected = MoveImpossibleException.class)
	public void departurePieceExist() throws Exception {
		// After init, C4 does not contain any piece
		boardService.move(board,"Promethee", "C4", "C2");
	}

	// Departure square must contain a piece
	@Test(expected = MoveImpossibleException.class)
	public void squaresExistOnTheBoard() throws Exception {
		// The board does not contain C9 position nor I6
		boardService.move(board,"Promethee", "C9", "I6");
	}

	@Test(expected = MoveImpossibleException.class)
	public void sameSquare() throws Exception {
		// The board does not contain C9 position nor I6
		boardService.move(board,"Promethee", "A2", "A2");
	}
}
