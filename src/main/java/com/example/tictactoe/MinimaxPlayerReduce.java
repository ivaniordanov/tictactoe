package com.example.tictactoe;

import java.util.Map;

public class MinimaxPlayerReduce implements Player, Bot {

	private Map<Integer, Integer> scoreMap;
	private static int cnt;
	public MinimaxPlayerReduce(Map<Integer, Integer> scoreMap) {
		this.scoreMap = scoreMap;
	}

	@Override
	public int move(Game board) {
		cnt = 0;
		int r = bestMove(board, 1).move;
		System.out.println(cnt);
		return r;
	}

	public Score bestMove(Game game, int max) {
		cnt++;
		return game.findMove(new MinimaxReduce(this, max, game));
	}

	public int score(Game game, int max) {
		return game.over() ? scoreMap.get(game.winner()) : bestMove(game, -1*max).score;
	}
}