package com.example.tictactoe;

public class TicTacToeApp {
	public static void main(String[] args) {

		TicTacToe game = TicTacToe.create(3);
		while(!game.over()) {
			game = game.turn();
			System.out.println(game);
		}
		int winner = game.winner();
		System.out.println(winner > 0 ? "Winner: "+(char) winner : "Tie");
	}
}