package com.example.tictactoe;

import java.util.Iterator;

public class Moves implements Iterator<Integer> {

	private TicTacToe game;
	private int state;

	public Moves(TicTacToe ticTacToe) {
		this.game = ticTacToe;
		this.state = -1;
	}

	@Override
	public boolean hasNext() {
		return game.hasMoves(state);
	}

	@Override
	public Integer next() {
		int next = game.nextAvailable(state);
		state = next;
		return next;
	}

}
