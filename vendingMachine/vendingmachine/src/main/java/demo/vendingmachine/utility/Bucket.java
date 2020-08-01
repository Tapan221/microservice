package demo.vendingmachine.utility;

public class Bucket<E1, E2> { 
	
	private E1 item; 
	private E2 change; 
	
	public Bucket(E1 item, E2 change){ 
		this.item = item; 
		this.change = change; 
	} 
	
	public E1 getItem(){ 
		return item; 
	} 
	
	public E2 getChange(){ 
		return change; 
	} 
}


