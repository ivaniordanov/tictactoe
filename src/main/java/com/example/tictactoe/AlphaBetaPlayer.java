package com.example.tictactoe;

import java.util.Map;

public class AlphaBetaPlayer implements Player {
	private Map<Integer, Integer> scoreMap;
	private AlphaBeta alphabeta;
	private int cnt;
	public AlphaBetaPlayer(Map<Integer, Integer> scoreMap) {
		this.scoreMap = scoreMap;
		this.alphabeta = new AlphaBeta(-1, 1);
	}

	@Override
	public int move(Game board) {
		cnt = 0;
		this.alphabeta = new AlphaBeta(-1, 1);
		int move = bestMove(board, 1, board.nextAvailable(-1)).move;
		System.out.println(cnt);
		return move;
	}
	public Score bestMove(Game game, int max, int move) {
		cnt++;
		Score bestScore = new Score(move, minimax(game.play(move), max, move));
		while (game.hasMoves(move)) {
			move = game.nextAvailable(move);
			Score score = new Score(move, minimax(game.play(move), max, move));
			bestScore = bestScore.bestOf(score, max);
			if (score.exceeds(max, alphabeta.threshold(max))) {
				return bestScore;
			}
			alphabeta = alphabeta.apply(score, max);
		}
		return bestScore;
	}

	public int minimax(Game game, int max, int move) {
		return game.over() ? scoreMap.get(game.winner()) : bestMove(game, -1*max, game.nextAvailable(-1)).score;
	}
}
