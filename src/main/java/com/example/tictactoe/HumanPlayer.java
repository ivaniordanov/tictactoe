package com.example.tictactoe;

import java.io.InputStream;
import java.util.Scanner;

public class HumanPlayer implements Player {

	private InputStream input;
	public HumanPlayer(InputStream input) {
		this.input = input;
	}
	@Override
	public int move(Game game) {
		Scanner s = new Scanner(input);
		int move = s.nextInt();
		while(!game.valid(move)) {
		    move = s.nextInt();
		}
		return move;
	}

}
