package concurrency.my;

import java.util.concurrent.Callable;

class TaskWithResult implements Callable<String> {
	private int id;
	
	public TaskWithResult(int id) {
		this.id = id;
	}

	public String call() throws Exception {
		return "result of TaskWithResult "+id;
	}
	
}
