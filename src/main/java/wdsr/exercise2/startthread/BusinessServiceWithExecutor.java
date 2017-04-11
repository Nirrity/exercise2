package wdsr.exercise2.startthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BusinessServiceWithExecutor {
	private NumericHelper helper;
	
	public BusinessServiceWithExecutor(NumericHelper helper) {
		this.helper = helper;
	}

	/**
	 * Calculates Fibonacci number asynchronously and invokes the callback when result is available.
	 * This method returns immediately. 
	 * @param n Which Fibonacci number should be computed.
	 * @param callback Callback to be invoked when Fibonacci number is found.
	 */
	
	public void computeFibonacci(int n, FibonacciCallback callback) {

		ExecutorService executorService = Executors.newSingleThreadExecutor();

		executorService.execute(new Runnable() {
		    public void run() {
		        long value = helper.findFibonacciValue(n);
		        callback.fibonacciComputed(value);
		    }
		});

	}
}
