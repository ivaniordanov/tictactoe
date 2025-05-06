package com.example.tictactoe;

import java.util.Map;

public class AlphaBetaPlayerReduce implements Player, Bot {

	private Map<Integer, Integer> scoreMap;
	private int cnt;
	public AlphaBetaPlayerReduce(Map<Integer, Integer> scoreMap) {
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
		return game.findMove(new AlphaBetaReduce(this, max, game));
	}

	public int score(Game game, int max) {
		return game.over() ? scoreMap.get(game.winner()) : bestMove(game, -1*max).score;
	}
}