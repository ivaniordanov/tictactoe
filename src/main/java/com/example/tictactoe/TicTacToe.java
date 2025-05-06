package com.example.tictactoe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class TicTacToe implements Game {

	private Board board;
	private Players players;
	private boolean stop = false;
	
	public TicTacToe(Board board, Players players) {
		this(board, players, false);
	}
	
	public TicTacToe(Board board, Players players, boolean stop) {
		this.board = board;
		this.players = players;
		this.stop = stop;
	}
	
	public int nextAvailable(int move) {
		return board.nextAvailable(move);
	}
	
	public boolean hasMoves(int move) {
		return !stop && board.hasAvailable(move);
	}

	public boolean over() {
		return board.full() || winner() != 0;
	}

	public int winner() {
		return players.win(board);
	}

	public TicTacToe turn() {
		return play(players.move(this));
	}

	public TicTacToe play(int move) {
		return new TicTacToe(board.set(move, players.sign(move)), players.next());
	}

	public static TicTacToe create(int rows) {
		Map<Integer, Integer> scores = new HashMap<Integer, Integer>() {{
		    put((int) 'X', 1);
		    put((int) 'O', -1);
		    put(0, 0);
		}};
		
		Map<Integer, Integer> scores2 = new HashMap<Integer, Integer>() {{
		    put((int) 'X', -1);
		    put((int) 'O', 1);
		    put(0, 0);
		}};
		return new TicTacToe(Board.create(rows), new Players(new Player[]{new AlphaBetaPlayerReduce(scores), new HumanPlayer(System.in)}));
	}

	@Override
	public String toString() {
		return board.toString();
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Moves(this);
	}

	@Override
	public Score findMove(Reduce strategy) {
		return stream().map(strategy::map).reduce(strategy::reduce).get();
	}
	
	private Stream<Integer> stream() {
		return StreamSupport.stream(spliterator(), false);
	}

	@Override
	public Game stop() {
		this.stop = true;
		return this;
	}

	@Override
	public boolean valid(int move) {
		return board.valid(move);
	}
}
