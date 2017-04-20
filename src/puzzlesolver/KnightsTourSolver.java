package puzzlesolver;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class KnightsTourSolver extends PuzzleSolver {

	private Knight knight;
	
	public KnightsTourSolver(GameBoard aBoard, Knight aKnight){
		board = aBoard;
		knight = aKnight;
	}
	
	@Override
	public boolean hasWonGame() {
		return moves.size() == board.size() * board.size();
	}

	@Override
	public List<GameMove> getNextLegalMoves() {
		List<GameMove> legalMoves = new ArrayList<GameMove>();
		if(moves.isEmpty()){
			GameMove firstMove = new GameMove(new Knight(), null, new Point(0,0));
			legalMoves.add(firstMove);
			return legalMoves;
		}
		GameMove lastMove = moves.get(moves.size()-1);
		GamePiece knight = lastMove.getPiece();
		Point currLoc = lastMove.getEndLocation();
		List<GameMove> possibleMoves = knight.nextPossibleMoves(currLoc, board);
		for(GameMove eachMove : possibleMoves){
			if(!hasBeenVisited(eachMove.getEndLocation())){
				legalMoves.add(eachMove);
			}
		}
		return legalMoves;
	}
	
	public boolean hasBeenVisited(Point aPoint){
		for(GameMove eachMove : moves){
			if(aPoint.equals(eachMove.getEndLocation())){
				return true;
			}
		}
		return false;
	}

}
