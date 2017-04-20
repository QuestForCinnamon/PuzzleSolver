package puzzlesolver;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Knight extends GamePiece {

	public boolean isOnBoard(Point aPoint, GameBoard board){
		return aPoint.x >= 0 && aPoint.y >= 0 
				&& aPoint.x < board.size() && aPoint.y < board.size();
	}
	
	@Override
	public List<GameMove> nextPossibleMoves(Point aLocation, GameBoard aBoard) {
		int[] rowOffsets = {1, 2, 2, 1, -1, -2, -2, -1};
		int[] colOffsets = {-2, -1, 1, 2, 2, 1, -1, -2};
		List<GameMove> nextMoves = new ArrayList<GameMove>();
		for(int i=0; i < rowOffsets.length; ++i){
			Point newLoc = new Point(aLocation.x + rowOffsets[i], aLocation.y + colOffsets[i]);
			if(isOnBoard(newLoc, aBoard)){
				GameMove aMove = new GameMove(this, aLocation, newLoc);
				nextMoves.add(aMove);
			}
		}
		return nextMoves;
	}

}
