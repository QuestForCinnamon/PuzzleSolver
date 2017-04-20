package puzzlesolver;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Point;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameMoveTest {

	GamePiece piece;
	GameBoard board;
	GameMove placePieceMove;
	GameMove movePieceMove;
	Point	pointA = new Point(2, 2);
	Point	pointB = new Point(4, 1);
	
	@Before
	public void setUp() throws Exception {
		piece = new Knight();
		board = new GameBoard(5, Color.black, Color.white);
		placePieceMove = new GameMove(piece, null, pointA);
		movePieceMove = new GameMove(piece, pointA, pointB);
	}

	@After
	public void tearDown() throws Exception {
		piece = null;
		piece = null;
		placePieceMove = null;
		movePieceMove = null;
	}

	@Test
	public void testPlacePieceMove() {
		assertTrue(board.isEmpty(pointA));
		placePieceMove.doOn(board);
		assertFalse(board.isEmpty(pointA));
		placePieceMove.undoOn(board);
		assertTrue(board.isEmpty(pointA));
	}
	
	@Test
	public void testMovePieceMove(){
		board.place(piece, pointA);
		assertTrue(board.isEmpty(pointB));
		movePieceMove.doOn(board);
		assertTrue(board.isEmpty(pointA));
		assertFalse(board.isEmpty(pointB));
		movePieceMove.undoOn(board);
		assertFalse(board.isEmpty(pointA));
		assertTrue(board.isEmpty(pointB));
	}

}
