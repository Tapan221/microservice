package com.example.zjpabasics.model;

public class ResponseObject {
	private int task;

	@Override
	public String toString() {
		return "ResponseObject [task=" + task + "]";
	}

	public ResponseObject() {
		
	}

	public ResponseObject(int task) {
		super();
		this.task = task;
	}

	public int getTask() {
		return task;
	}

	public void setTask(int task) {
		this.task = task;
	}
	
	

}
