package puzzlesolver;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Point;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import chesspuzzles.GameMove;
import chesspuzzles.GamePiece;
import chesspuzzles.Queen;

public class NQueensSolverTest {

	Queen queen;
	GameBoard board;
	NQueensSolver solver;
	
	@Before
	public void setUp() throws Exception {
		queen = new Queen();
		board = new GameBoard(5, Color.magenta, Color.cyan);
		solver = new NQueensSolver(board, queen);
	}

	@After
	public void tearDown() throws Exception {
		queen = null;
		board = null;
		solver = null;
	}

	@Test
	public void testIsThreatenedByQueenAt() {
		Point testPoint = new Point(2, 2);
		Point queenAPoint = new Point(0,0);
		Point queenBPoint = new Point(0,2);
		Point queenCPoint = new Point(0,3);
		Point queenDPoint = new Point(0,4);
		assertTrue(isThreatenedBy(testPoint, queenAPoint));
		assertTrue(isThreatenedBy(testPoint, queenBPoint));
		assertFalse(isThreatenedBy(testPoint, queenCPoint));
		assertTrue(isThreatenedBy(testPoint, queenDPoint));
	}
	
	@Test
	public void testIsSafe(){
		GamePiece queen = new Queen();
		Point testPoint = new Point(3,1);
		Point point1 = new Point(0,0);
		Point point2 = new Point(1,4);
		Point point3 = new Point(2,1);
		assertTrue(solver.isSafe(testPoint));
		GameMove move1 = new GameMove(queen, null, point1);
		GameMove move2 = new GameMove(queen, null, point2);
		GameMove move3 = new GameMove(queen, null, point3);
		List<GameMove> moves = sovler.getMoves();
		moves.add(move1);
		assertTrue(solver.isSafe(testPoint));
		moves.add(move2);
		assertTrue(solver.isSafe(testPoint));
		moves.add(move3);
		assertFalse(solver.isSafe(testPoint));
	}
	
	@Test
	public void testGetNextLegalMoves(){
		List<GameMove> nextMoves;
		nextMoves = solver.getNextLegalMoves();
		assertTrue(nextMoves.size() == 5);
		for(GameMove eachMove : nextMoves){
			assertTrue(eachMove.getEndLocation().x == 0);
		}
		GameMove move1 = new GameMove(new Queen(), null, new Point(0,1));
		solver.getMoves().add(move1);
		nextMoves = solver.getNextLegalMoves();
		assertTrue(nextMoves.size() == 2);
		assertTrue(nextMoves.get(0).getEndLocation().x == 1);
		assertTrue(nextMoves.get(1).getEndLocation().x == 1);
	}
	
	@Test
	public void testSolver(){
		assertTrue(solver.solve());
	}

}
