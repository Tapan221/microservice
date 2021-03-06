package com.example.vmwarenumbergenerator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Generator {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int goal;
	private int step;
	
	
	@Override
	public String toString() {
		return "Generator [id=" + id + ", goal=" + goal + ", step=" + step + "]";
	}
	public Generator() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Generator(int id, int goal, int step) {
		super();
		this.id = id;
		this.goal = goal;
		this.step = step;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGoal() {
		return goal;
	}
	public void setGoal(int goal) {
		this.goal = goal;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
			

}
