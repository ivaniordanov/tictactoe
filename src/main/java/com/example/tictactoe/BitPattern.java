package com.example.tictactoe;

public class BitPattern implements Pattern {
	private int[] patterns;

	public BitPattern(int[] patterns) {
		this.patterns = patterns;
	}

	public boolean match(int mask) {
		for (int i = 0; i < patterns.length;i++) {
			if ((patterns[i] & mask) == patterns[i]) {
				return true;
			}
		}
		return false;
	}

	public static BitPattern create(int n) { 
		return new BitPattern(new int[] {
			7, 7<<3, 7<<6, //rows
			73, 73<<1, 73<<2, //columns
			273, 84
		});
	}
}
