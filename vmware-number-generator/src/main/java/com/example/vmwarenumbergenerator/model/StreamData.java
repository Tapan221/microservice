package com.example.vmwarenumbergenerator.model;

public class StreamData {
	private String result;
	
	
	@Override
	public String toString() {
		return "StreamData [result=" + result + "]";
	}

	public StreamData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StreamData(String result) {
		super();
		this.result = result;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	

}
