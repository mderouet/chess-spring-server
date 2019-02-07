package application.service;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import application.model.Bishop;
import application.model.Color;
import application.model.King;
import application.model.Knight;
import application.model.Pawn;
import application.model.Piece;
import application.model.Queen;
import application.model.Rook;

public class BoardBuilder {
	public static Map<String, Piece> initializeTestPosition() {

		Map<String, Piece> board = new LinkedHashMap<>();
		// Top line Black
		board.put("A8", new Pawn(Color.WHITE));
		board.put("B8", new Knight(Color.BLACK));
		board.put("C8", new Bishop(Color.BLACK));
		board.put("D8", new Queen(Color.BLACK));
		board.put("E8", new King(Color.BLACK));
		board.put("F8", new Bishop(Color.BLACK));
		board.put("G8", new Knight(Color.BLACK));
		board.put("H8", new Rook(Color.BLACK));

		// Bottom line Black
		board.put("A7", null);
		board.put("B7", new Pawn(Color.BLACK));
		board.put("C7", new Pawn(Color.BLACK));
		board.put("D7", null);
		board.put("E7", new Pawn(Color.BLACK));
		board.put("F7", null);
		board.put("G7", new Pawn(Color.BLACK));
		board.put("H7", null);

		// Null
		board.put("A6", null);
		board.put("B6", null);
		board.put("C6", null);
		board.put("D6", new Pawn(Color.BLACK));
		board.put("E6", null);
		board.put("F6", null);
		board.put("G6", new Rook(Color.BLACK));
		board.put("H6", null);

		board.put("A5", null);
		board.put("B5", null);
		board.put("C5", null);
		board.put("D5", null);
		board.put("E5", new Queen(Color.WHITE));
		board.put("F5", new Bishop(Color.WHITE));
		board.put("G5", null);
		board.put("H5", null);

		board.put("A4", null);
		board.put("B4", null);
		board.put("C4", new Pawn(Color.BLACK));
		board.put("D4", new Rook(Color.WHITE));
		board.put("E4", null);
		board.put("F4", new Pawn(Color.BLACK));
		board.put("G4", new Pawn(Color.WHITE));
		board.put("H4", new Pawn(Color.BLACK));

		board.put("A3", null);
		board.put("B3", null);
		board.put("C3", null);
		board.put("D3", new Pawn(Color.WHITE));
		board.put("E3", null);
		board.put("F3", new Knight(Color.WHITE));
		board.put("G3", null);
		board.put("H3", null);

		// Bottom line White
		board.put("A2", null);
		board.put("B2", new Pawn(Color.WHITE));
		board.put("C2", new Pawn(Color.WHITE));
		board.put("D2", null);
		board.put("E2", new Pawn(Color.WHITE));
		board.put("F2", new Pawn(Color.WHITE));
		board.put("G2", null);
		board.put("H2", new Pawn(Color.WHITE));

		// Top line White
		board.put("A1", new Rook(Color.WHITE));
		board.put("B1", new Knight(Color.WHITE));
		board.put("C1", new Bishop(Color.WHITE));
		board.put("D1", null);
		board.put("E1", new King(Color.WHITE));
		board.put("F1", null);
		board.put("G1", null);
		board.put("H1", null);

		return board;
	}
}
