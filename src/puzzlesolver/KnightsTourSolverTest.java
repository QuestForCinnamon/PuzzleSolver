package puzzlesolver;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Point;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KnightsTourSolverTest {

	Knight knight;
	GameBoard board;
	KnightsTourSolver solver;
	
	@Before
	public void setUp() throws Exception {
		knight = new Knight();
		board = new GameBoard(5, Color.black, Color.red);
		solver = new KnightsTourSolver(board, knight);
	}

	@After
	public void tearDown() throws Exception {
		knight = null;
		board = null;
		solver = null;
	}

	@Test
	public void testHasWonGame() {
		assertFalse(solver.hasWonGame());
		List<GameMove> moves = solver.getMoves();
		for(int i = 0; i < 24; ++i){
			GameMove aMove = new GameMove(knight, new Point(0,0), new Point(0,0));
			moves.add(aMove);
		}
		assertFalse(solver.hasWonGame());
		GameMove aMove = new GameMove(knight, new Point(0,0), new Point(0,0));
		moves.add(aMove);
		assertTrue(solver.hasWonGame());
	}
	
	@Test
	public void testHasVisitedALocation(){
		Point center = new Point(2,2);
		Point upLeft = new Point(4,1);
		GameMove placePiece = new GameMove(knight, null, center);
		GameMove movePiece = new GameMove(knight, center, upLeft);
		assertFalse(solver.hasBeenVisited(center));
		placePiece.doOn(board);
		solver.getMoves().add(placePiece);
		assertTrue(solver.hasBeenVisited(center));
		assertFalse(solver.hasBeenVisited(upLeft));
		movePiece.doOn(board);
		solver.getMoves().add(movePiece);
		assertTrue(solver.hasBeenVisited(center));
		assertTrue(solver.hasBeenVisited(upLeft));
	}
	
	@Test
	public void testGetNextLegalMovesOnEmptyBoard(){
		
	}
	
	@Test
	public void testGetNextLegalMovesAfterMovesHaveBeenMade(){
		
	}
	
	@Test
	public void testSolver(){
		boolean result = solver.solve();
		assertTrue(result);
	}
	
	
	

}
