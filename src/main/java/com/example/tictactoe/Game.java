package com.example.tictactoe;


public interface Game extends Iterable<Integer> {

	int nextAvailable(int i);

	boolean hasMoves(int move);

	Game play(int move);

	int winner();

	boolean over();

	Score findMove(Reduce red);

	Game stop();

	boolean valid(int move);

}
