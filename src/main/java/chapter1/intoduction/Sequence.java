package chapter1.intoduction;

import annotations.GuardedBy;
import annotations.ThreadSafe;

/**
 * Sequence
 *
 * @author Brian Goetz and Tim Peierls
 */

@ThreadSafe
public class Sequence {
	@GuardedBy("this")
	private int nextValue;

	public synchronized int getNext() {
		return nextValue++;
	}
}