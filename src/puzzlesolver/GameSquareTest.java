package puzzlesolver;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameSquareTest {

	GameSquare lightSquare;
	GameSquare darkSquare;
	
	@Before
	public void setUp() throws Exception {
		lightSquare = new GameSquare(Color.white);
		darkSquare = new GameSquare(Color.black);
	}

	@After
	public void tearDown() throws Exception {
		lightSquare = null;
		darkSquare = null;
	}

	@Test
	public void testNewlyCreatedSquare() {
		assertTrue(darkSquare.getColor().equals(Color.black));
		assertTrue(darkSquare.isEmpty());
		assertTrue(lightSquare.getColor().equals(Color.white));
		assertTrue(lightSquare.isEmpty());
	}
	
	@Test
	public void testPlaceAndRemovePiece(){
		GamePiece piece = new Knight();
		GamePiece removedPiece;
		darkSquare.place(piece);
		assertFalse(darkSquare.isEmpty());
		removedPiece = darkSquare.remove();
		assertTrue(darkSquare.isEmpty());
		assertTrue(removedPiece.equals(piece));
	}

}
