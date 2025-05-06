package com.example.tictactoe;

import java.util.Map;

public class MinimaxPlayer implements Player {

	private Map<Integer, Integer> scoreMap;
	private int cnt;
	public MinimaxPlayer(Map<Integer, Integer> scoreMap) {
		this.scoreMap = scoreMap;
	}

	@Override
	public int move(Game board) {
		cnt = 0;
		int r = bestMove(board, 1, board.nextAvailable(-1)).move;
		System.out.println(cnt);
		return r;
	}
	
	public Score bestMove(Game game, int max, int move) {
		cnt++;
		Score bestScore = new Score(move, minimax(game.play(move), max, move));
		while (game.hasMoves(move)) {
			move = game.nextAvailable(move); 
			bestScore = bestScore.bestOf(new Score(move, minimax(game.play(move), max, move)), max);
		}
		return bestScore;
	}

	public int minimax(Game game, int max, int move) {
		return game.over() ? scoreMap.get(game.winner()) : bestMove(game, -1*max, game.nextAvailable(-1)).score;
	}
}