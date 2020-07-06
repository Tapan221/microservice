package com.tapan.limitsservice.bean;

public class LimitConfiguration {
	
	private int max;
	private int min;
	
	
	
	public int getMax() {
		return max;
	}
	public LimitConfiguration(int max, int min) {
		super();
		this.max = max;
		this.min = min;
	}
	
	public LimitConfiguration() {
		
	}
	
	public int getMin() {
		return min;
	}	

}
