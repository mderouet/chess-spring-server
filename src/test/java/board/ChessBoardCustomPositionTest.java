package board;

import application.model.Board;
import application.service.BoardService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class ChessBoardCustomPositionTest {

	private BoardService boardService = new BoardService();

	private Board board;

	@Before
	public void init() {
		board = new Board(0,"Promethee", "Epimethee");
		board.setBoard(boardService.initializeTestPosition());
	}

	@Test
	public void rookMove() throws Exception {
		// Wrong moves
		assertEquals(false, boardService.move(board,"Promethee", "D4", "A4"));
		assertEquals(false, boardService.move(board,"Promethee", "D4", "G4"));
		assertEquals(false, boardService.move(board,"Promethee", "D4", "G5"));
		assertEquals(false, boardService.move(board,"Promethee", "D4", "A3"));
		assertEquals(false, boardService.move(board,"Promethee", "D4", "A5"));
		assertEquals(false, boardService.move(board,"Promethee", "D4", "D8"));
		assertEquals(false, boardService.move(board,"Promethee", "D4", "D7"));
		assertEquals(false, boardService.move(board,"Promethee", "D4", "D3"));

		// Right moves
		assertEquals(true, boardService.move(board,"Promethee", "D4", "C4"));
		assertEquals(true, boardService.move(board,"Promethee", "D4", "D6"));
		assertEquals(true, boardService.move(board,"Promethee", "D4", "F4"));
		assertEquals(true, boardService.move(board,"Promethee", "D4", "E4"));
		assertEquals(true, boardService.move(board,"Promethee", "D4", "D5"));
	}

	@Test
	public void bishopMove() throws Exception {
		// Wrong moves
		assertEquals(false, boardService.move(board,"Promethee", "F5", "G4"));
		assertEquals(false, boardService.move(board,"Promethee", "F5", "H3"));
		assertEquals(false, boardService.move(board,"Promethee", "F5", "D3"));
		assertEquals(false, boardService.move(board,"Promethee", "F5", "C2"));
		assertEquals(false, boardService.move(board,"Promethee", "F5", "C3"));
		assertEquals(false, boardService.move(board,"Promethee", "F5", "H7"));

		// Right moves
		assertEquals(true, boardService.move(board,"Promethee", "F5", "C8"));
		assertEquals(true, boardService.move(board,"Promethee", "F5", "D7"));
		assertEquals(true, boardService.move(board,"Promethee", "F5", "E6"));
		assertEquals(true, boardService.move(board,"Promethee", "F5", "G6"));
		assertEquals(true, boardService.move(board,"Promethee", "F5", "E4"));
	}

	@Test
	public void queenMove() throws Exception {
		// Wrong moves
		assertEquals(false, boardService.move(board,"Promethee", "E5", "F5"));
		assertEquals(false, boardService.move(board,"Promethee", "E5", "G5"));
		assertEquals(false, boardService.move(board,"Promethee", "E5", "H5"));
		assertEquals(false, boardService.move(board,"Promethee", "E5", "H3"));
		assertEquals(false, boardService.move(board,"Promethee", "E5", "C7"));
		assertEquals(false, boardService.move(board,"Promethee", "E5", "B8"));
		assertEquals(false, boardService.move(board,"Promethee", "E5", "E1"));
		assertEquals(false, boardService.move(board,"Promethee", "E5", "E2"));
		assertEquals(false, boardService.move(board,"Promethee", "E5", "E8"));
		assertEquals(false, boardService.move(board,"Promethee", "E5", "D4"));
		assertEquals(false, boardService.move(board,"Promethee", "E5", "C3"));

		// Right moves
		assertEquals(true, boardService.move(board,"Promethee", "E5", "E3"));
		assertEquals(true, boardService.move(board,"Promethee", "E5", "E4"));
		assertEquals(true, boardService.move(board,"Promethee", "E5", "E6"));
		assertEquals(true, boardService.move(board,"Promethee", "E5", "E7"));
		assertEquals(true, boardService.move(board,"Promethee", "E5", "F6"));
		assertEquals(true, boardService.move(board,"Promethee", "E5", "G7"));
		assertEquals(true, boardService.move(board,"Promethee", "E5", "A5"));
		assertEquals(true, boardService.move(board,"Promethee", "E5", "B5"));
		assertEquals(true, boardService.move(board,"Promethee", "E5", "C5"));
		assertEquals(true, boardService.move(board,"Promethee", "E5", "D5"));
		assertEquals(true, boardService.move(board,"Promethee", "E5", "F4"));

	}

	@Test
	public void knightMove() throws Exception {
		// Wrong moves
		assertEquals(false, boardService.move(board,"Promethee", "F3", "H2"));
		assertEquals(false, boardService.move(board,"Promethee", "F3", "D4"));
		assertEquals(false, boardService.move(board,"Promethee", "F3", "E5"));
		assertEquals(false, boardService.move(board,"Promethee", "F3", "A4"));
		assertEquals(false, boardService.move(board,"Promethee", "F3", "A3"));
		assertEquals(false, boardService.move(board,"Promethee", "F3", "B8"));

		// Right moves
		assertEquals(true, boardService.move(board,"Promethee", "F3", "E1"));
		assertEquals(true, boardService.move(board,"Promethee", "F3", "H4"));
		assertEquals(true, boardService.move(board,"Promethee", "F3", "G1"));
		assertEquals(true, boardService.move(board,"Promethee", "F3", "D2"));
		assertEquals(true, boardService.move(board,"Promethee", "F3", "G5"));
	}

	@Test
	public void pawnMove() throws Exception {
		// Wrong moves
		// Pawn white can't go back
		assertEquals(false, boardService.move(board,"Promethee", "H2", "H1"));
		assertEquals(false, boardService.move(board,"Promethee", "G4", "G2"));
		assertEquals(false, boardService.move(board,"Promethee", "G4", "G3"));

		// Pawn black can't go back
		assertEquals(false, boardService.move(board,"Promethee", "C4", "C5"));
		assertEquals(false, boardService.move(board,"Promethee", "G4", "C6"));

		assertEquals(false, boardService.move(board,"Promethee", "D3", "D4"));
		assertEquals(false, boardService.move(board,"Promethee", "D3", "E4"));
		assertEquals(false, boardService.move(board,"Promethee", "D3", "A4"));
		assertEquals(false, boardService.move(board,"Promethee", "D3", "A3"));
		assertEquals(false, boardService.move(board,"Promethee", "G4", "D2"));
		assertEquals(false, boardService.move(board,"Promethee", "H2", "H4"));

		// Right moves
		// Pawn black can't go back
		assertEquals(true, boardService.move(board,"Promethee", "C4", "C3"));
		assertEquals(true, boardService.move(board,"Promethee", "D3", "C4"));
		assertEquals(true, boardService.move(board,"Promethee", "E2", "E3"));
		assertEquals(true, boardService.move(board,"Promethee", "E2", "E4"));
		assertEquals(true, boardService.move(board,"Promethee", "H2", "H3"));
		assertEquals(true, boardService.move(board,"Promethee", "D3", "C4"));
		assertEquals(true, boardService.move(board,"Promethee", "B2", "B4"));
	}

	@Test
	public void kingMove() throws Exception {
		// Wrong moves
		assertEquals(false, boardService.move(board,"Promethee", "G3", "F2"));
		assertEquals(false, boardService.move(board,"Promethee", "G3", "F3"));
		assertEquals(false, boardService.move(board,"Promethee", "G3", "G4"));
		assertEquals(false, boardService.move(board,"Promethee", "G3", "H2"));

		// Right moves
		assertEquals(true, boardService.move(board,"Promethee", "G3", "H3"));
		assertEquals(true, boardService.move(board,"Promethee", "G3", "H4"));
		assertEquals(true, boardService.move(board,"Promethee", "G3", "F4"));
		assertEquals(true, boardService.move(board,"Promethee", "G3", "G2"));
	}
}
