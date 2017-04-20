package puzzlesolver;

import java.util.ArrayList;
import java.util.List;

public abstract class PuzzleSolver {
		protected GameBoard board;
		protected List<GameMove> moves = new ArrayList<GameMove>();
		
		public List<GameMove> getMoves(){
			return moves;
		}
		
		public boolean solve(){
			if(hasWonGame()){
				return true;
			}
			List<GameMove> nextMoves = getNextLegalMoves();
			for(GameMove eachMove : nextMoves){
				eachMove.doOn(board);
				moves.add(eachMove);
				if(solve()){
					return true;
				}
				moves.remove(eachMove);
				eachMove.undoOn(board);
			}
			return false;
		}
		
		public abstract boolean hasWonGame();
		public abstract List<GameMove> getNextLegalMoves();
}
