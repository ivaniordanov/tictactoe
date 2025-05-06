package com.example.tictactoe;

public class Players {
	private int currentPlayer;
	private Player[] players;
	private static final int[] values = new int[] {'X', 'O'}; 


	public Players(Player[] players, int currentPlayer) {
		this.players = players;
		this.currentPlayer = currentPlayer;
	}
	
	public Players(Player[] players) {
		this(players, 0);
	}
	
	public Players next() {
		return new Players(players, (currentPlayer + 1) % players.length);
	}
	
	public int move(Game game)
	{
		return players[currentPlayer].move(game);
	}

	public int[] sign(int move)
	{
		return new int[] {values[currentPlayer], currentPlayer};
	}

	public int win(Board board) {
		return board.win(values);
	}
}
