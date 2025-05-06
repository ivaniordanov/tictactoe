package com.example.tictactoe;

import java.util.BitSet;
import java.util.stream.IntStream;

public class CachedPattern implements Pattern {

	private final BitSet bits;

	public CachedPattern(BitSet bits) {
		this.bits = bits;
	}

	@Override
	public boolean match(int mask) {
		return bits.get(mask);
	}

	public static CachedPattern create(int n) {
		Pattern pattern = BitPattern.create(n);
		BitSet bits = new BitSet(1 << (n*n));
		IntStream.range(0, bits.size()).filter(pattern::match).peek(bits::set).count();
		return new CachedPattern(bits);
	}
}
