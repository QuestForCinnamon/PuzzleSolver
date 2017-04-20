package puzzlesolver;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Point;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameBoardTest {

	GameBoard fiveByFiveBoard;
	GameBoard eightByEightBoard;
	
	@Before
	public void setUp() throws Exception {
		fiveByFiveBoard = new GameBoard(5, Color.green, Color.yellow);
		eightByEightBoard = new GameBoard(8, Color.black, Color.red);
	}

	@After
	public void tearDown() throws Exception {
		fiveByFiveBoard = null;
		eightByEightBoard = null;
	}

	@Test
	public void testBoardSetup() {
		for(int row=0; row < 5; row++){
			for(int col=0; col < 5; col++){
				Color expectedColor = ((row+col)%2 == 0)
						? Color.green
						: Color.yellow;
				GameSquare boardSquare = fiveByFiveBoard.getSquare(new Point(row, col));
				assertTrue(expectedColor.equals(boardSquare.getColor()));
				assertTrue(boardSquare.isEmpty());
			}
		}
	}
	
	@Test
	public void testPlaceAndRemovePiece(){
		GamePiece aPiece = new Queen();
		Point aLocation = new Point(3, 2);
		eightByEightBoard.place(aPiece, aLocation);
		assertFalse(eightByEightBoard.isEmpty(aLocation));
		assertTrue(eightByEightBoard.getPiece(aLocation).equals(aPiece));
		GamePiece removedPiece;
		removedPiece = eightByEightBoard.removePiece(aLocation);
		assertTrue(eightByEightBoard.isEmpty(aLocation));
		assertTrue(removedPiece.equals(aPiece));
	}
	
	@Test
	public void testIsRowEmpty(){
		GamePiece aPiece = new Queen();
		Point aLocation = new Point(2, 2);
		assertTrue(fiveByFiveBoard.rowIsEmpty(2));
		fiveByFiveBoard.place(aPiece, aLocation);
		assertFalse(fiveByFiveBoard.rowIsEmpty(2));
	}

}
