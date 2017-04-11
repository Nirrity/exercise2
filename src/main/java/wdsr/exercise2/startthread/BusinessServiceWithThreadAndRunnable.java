package wdsr.exercise2.startthread;

public class BusinessServiceWithThreadAndRunnable {
	private NumericHelper helper;
	
	public BusinessServiceWithThreadAndRunnable(NumericHelper helper, Runnable r) {
		this.helper = helper;
	}

	public void computeFibonacci(int n, FibonacciCallback callback) {
		Runnable r = () -> {
			long value = helper.findFibonacciValue(n);
			callback.fibonacciComputed(value);
		};
		Thread t = new Thread();
		t.start();
		
	}
}
