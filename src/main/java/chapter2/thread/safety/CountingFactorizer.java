package chapter2.thread.safety;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import annotations.ThreadSafe;

/**
 * CountingFactorizer
 *
 * Servlet that counts requests using AtomicLong Responsibility of Thread safety
 * is delegated to concurrent utility(java.util.concurrent.atomic.AtomicLong)
 * class representing Long values.
 *
 * @author Brian Goetz and Tim Peierls
 */
@ThreadSafe
public class CountingFactorizer extends GenericServlet implements Servlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final AtomicLong count = new AtomicLong(0);

	public long getCount() {
		return count.get();
	}

	public void service(ServletRequest req, ServletResponse resp) {
		BigInteger i = extractFromRequest(req);
		BigInteger[] factors = factor(i);
		count.incrementAndGet();
		encodeIntoResponse(resp, factors);
	}

	void encodeIntoResponse(ServletResponse res, BigInteger[] factors) {
		// Doesn't really encode into a response.
	}

	BigInteger extractFromRequest(ServletRequest req) {
		// Doesn't really extract from an incoming request
		return null;
	}

	BigInteger[] factor(BigInteger i) {
		// Doesn't really factor BigInteger supplied
		return null;
	}
}