package com.example.tictactoe;

import java.util.Map;

public class MinimaxPlayerFirst implements Player {

	private Map<Integer, Integer> scoreMap;
	public MinimaxPlayerFirst(Map<Integer, Integer> scoreMap) {
		this.scoreMap = scoreMap;
	}

	@Override
	public int move(Game board) {
		return bestMove(board, 1)[1];
	}
	
	public int[] bestMove(Game game, int max) {
		int move = game.nextAvailable(-1);
		int bestMove = move;
		int bestScore = minimax(game.play(move), max);
		while (game.hasMoves(move)) {
			move = game.nextAvailable(move); 
			int score = minimax(game.play(move), max);
			if (max * score > max * bestScore) {
				bestScore = score;
				bestMove = move; 
			}
		}
		return new int[] {bestScore, bestMove};
	}

	public int minimax(Game game, int max) {
		return game.over() ? scoreMap.get(game.winner()) : bestMove(game, -1*max)[0];
	}
}