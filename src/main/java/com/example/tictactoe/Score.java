package com.example.tictactoe;

class Score {
	int move;
	int score;

	Score(int move, int score) {
		this.move = move;
		this.score = score;
	}
	
	public Score bestOf(Score other, int max) {
		return max * score >= max * other.score ? this : other;
	}
	
	public boolean exceeds(int max, int threshold) {
		return max * score >= threshold;
	}
}