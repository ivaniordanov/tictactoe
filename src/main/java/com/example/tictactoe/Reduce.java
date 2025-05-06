package com.example.tictactoe;

public interface Reduce {
	public Score map(Integer move);
	
	public Score reduce(Score best, Score current);
}
