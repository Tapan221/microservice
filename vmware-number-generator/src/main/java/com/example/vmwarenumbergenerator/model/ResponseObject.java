package com.example.vmwarenumbergenerator.model;

public class ResponseObject  {
	
	private int task;
	

	public ResponseObject(int task) {
		super();
		this.task = task;
	}

	public ResponseObject() {
		super();
		
	}

	@Override
	public String toString() {
		return "ResponseObject [task=" + task + "]";
	}


	public int getTask() {
		return task;
	}

	public void setTask(int task) {
		this.task = task;
	}

}
