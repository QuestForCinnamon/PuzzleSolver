package puzzlesolver;

import java.io.StringWriter;

public class GameMove {
	//piece = aGamePiece
	//startLocation = aPoint or null
	//endLocation = aPoint
	
	public void undoOn(GameBoard board) {
		board.removePiece(endLocation);
		if(startLocation != null) {
			board.place(piece, startLocation);
		}
	}
	
	public String toString() {
		StringWriter writer = new StringWriter();
		if(startLocation != null) {
			writer.append(startLocation.toString());
			writer.append("->");
		}
		
	}

}
