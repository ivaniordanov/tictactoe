package com.example.tictactoe;

public class AlphaBeta {
	private int alpha;
	private int beta;

	public AlphaBeta() {
		this(Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	public AlphaBeta(int alpha, int beta) {
		this.alpha = alpha;
		this.beta = beta;
	}
	
	public int threshold(int max) {
		return max * (max < 0 ? alpha : beta);
	}
	public AlphaBeta apply(Score score, int max) {
		return max < 0 ? new AlphaBeta(Math.min(alpha, score.score), beta)
				       : new AlphaBeta(alpha, Math.max(beta, score.score)); 
	}
}
