package application.model;

import java.util.Map;
import application.exception.MoveImpossibleException;
import application.exception.NotYourTurnException;
import application.service.BoardService;
import lombok.*;

@Getter
@Setter
public class Board {

	private BoardService boardService = new BoardService();

	private int id;
	private String whitePlayerName;
	private String blackPlayerName;
	private boolean whiteTurnToPlay = true;
	private Map<String, Piece> board;

	@Builder
	public Board(int id, String whitePlayerName, String blackPlayerName) {
		this.board = boardService.initialize();
		this.id = id;
		this.whitePlayerName = whitePlayerName;
		this.blackPlayerName = blackPlayerName;
	}
}
