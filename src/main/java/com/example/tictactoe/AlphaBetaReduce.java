package com.example.tictactoe;

public class AlphaBetaReduce implements Reduce {
	private AlphaBeta ab;
	private int max;
	private Game game;
	private Bot player;

	public AlphaBetaReduce(Bot player, int max, Game game) {
		this.ab = new AlphaBeta(-1, 1);
		this.player = player;
		this.max = max;
		this.game = game;
	}
	
	public Score map(Integer move) {
		return new Score(move, player.score(game.play(move), max));
	}
	
	public Score reduce(Score best, Score current) {
		best = best.bestOf(current, max);
		if (current.exceeds(max, ab.threshold(max))) {
			game.stop();
		}
		ab = ab.apply(current, max);
		return best;
	}
}
