package com.example.tictactoe;

public class MinimaxReduce implements Reduce {
	private int max;
	private Bot player;
	private Game game;

	public MinimaxReduce(Bot player, int max, Game game) {
		this.max = max;
		this.player = player;
		this.game = game;
	}
	public Score map(Integer move) {
		return new Score(move, player.score(game.play(move), max));
	}
	
	public Score reduce(Score best, Score current) {
		return best.bestOf(current, max);
	}
	public boolean valid(Integer x) {
		return true;
	}
}
