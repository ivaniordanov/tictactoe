package com.example.tictactoe;

import java.util.Arrays;

public class Board {

	private int[] board;
	private int[] masks;
	private static final Pattern pattern = CachedPattern.create(3);
	private static final int EMPTY = 32;

	public Board(int[] board, int[] masks) {
		this.board = board;
		this.masks = masks;
	}

	public int nextAvailable(int move) {
		for (int i = move+1; i < board.length; i++) {
			if (board[i] == EMPTY) {
				//System.out.println(i);
				return i; 
			}
		}
		throw new RuntimeException("No available cells");
	}
	
	public int firstAvailable() {
		return nextAvailable(-1);
	}
	
	public boolean full() {
		return !hasAvailable(-1);
	}
	
	public Board set(int cell, int[] value) {
		int[] tmp = board.clone();
		tmp[cell] = value[0];
		int[] masksTmp = masks.clone();
		masksTmp[value[1]] |= 1 << cell;
		return new Board(tmp, masksTmp);
	}

	public static Board create(int rows) {
		int[] board = new int[rows*rows];
		Arrays.fill(board, EMPTY);
		return new Board(board, new int[] {0,0});
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < board.length;i++) {
			result.append(" | ");
			result.append((char) board[i]);
			if (i%3==2) {
			    result.append(" |\n");
			}
		}
		return result.toString();
	}

	public boolean hasAvailable(int move) {
		for (int i = move+1; i < board.length; i++) {
			if (board[i] == EMPTY) {
			    return true; 
			}
		}
		return false;
	}
	
	public boolean valid(int move) {
		return move > -1 && move < board.length && board[move] == EMPTY;
	}
	
	public int win(int[] signs) {
		for (int i=0;i<masks.length;i++) {
			if (pattern.match(masks[i])) {
				return signs[i];
			}
		}
		return 0;
	}
}
