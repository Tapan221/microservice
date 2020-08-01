package demo.vendingmachine;

import java.util.List;

import org.junit.BeforeClass;

import demo.vendingmachine.exception.NotFullPaidException;
import demo.vendingmachine.exception.NotSufficientChangeException;
import demo.vendingmachine.exception.SoldOutException;
import demo.vendingmachine.factory.VendingMachine;
import demo.vendingmachine.factory.VendingMachineFactory;
import demo.vendingmachine.model.Coin;
import demo.vendingmachine.model.Item;
import demo.vendingmachine.utility.Bucket;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{
	private static VendingMachine vm; 
	@BeforeClass public  void setUp(){ 
		vm = VendingMachineFactory.createVendingMachine(); 
		
	}
	
	@org.junit.Test 
	public void testCokePrice(){ 
		long price = vm.selectItemAndGetPrice(Item.COKE); 
		assertEquals(Item.COKE.getPrice(), price); 
		vm.insertCoin(Coin.QUARTER); 
		Bucket<Item, List<Coin>> bucket = vm.collectItemAndChange(); 
		Item item = bucket.getItem() ;
		List<Coin> change = bucket.getChange();
		//should be Coke 
		assertEquals(Item.COKE, item); 		 
		assertEquals(25 - Item.COKE.getPrice(), getTotal(change)); 
	}
	
	@org.junit.Test 
	public void testChangeReceivedAfterCokeOrdered(){ 
		long price = vm.selectItemAndGetPrice(Item.COKE); 
		assertEquals(Item.COKE.getPrice(), price); 
		vm.insertCoin(Coin.DIME); 
		vm.insertCoin(Coin.DIME); 
		vm.insertCoin(Coin.DIME); 
		Bucket<Item, List<Coin>> bucket = vm.collectItemAndChange(); 
		Item item = bucket.getItem() ;
		List<Coin> change = bucket.getChange();			 
		assertEquals(30 - Item.COKE.getPrice(), getTotal(change)); 		
	}
	
	
	@org.junit.Test 
	public void testChoco(){ 
		long price = vm.selectItemAndGetPrice(Item.CHOKOLATE); 
		assertEquals(Item.CHOKOLATE.getPrice(), price); 
		vm.insertCoin(Coin.QUARTER); 
		vm.insertCoin(Coin.QUARTER);
		Bucket<Item, List<Coin>> bucket = vm.collectItemAndChange(); 
		Item item = bucket.getItem() ;
		List<Coin> change = bucket.getChange();
		//should be Coke 
		assertEquals(Item.CHOKOLATE, item); 		 
		assertEquals(50 - Item.CHOKOLATE.getPrice(), getTotal(change)); 
	}
	

	
	
	@org.junit.Test(expected=NotFullPaidException.class)
	public void testChangeReceivedAfterChocoOrdered(){ 
		long price = vm.selectItemAndGetPrice(Item.CHOKOLATE); 
		vm.insertCoin(Coin.QUARTER); 
		vm.insertCoin(Coin.DIME); 
		vm.insertCoin(Coin.DIME); 
		vm.insertCoin(Coin.DIME); 
		Bucket<Item, List<Coin>> bucket = vm.collectItemAndChange(); 
		Item item = bucket.getItem() ;
		List<Coin> change = bucket.getChange();			 
		assertEquals(55 - Item.CHOKOLATE.getPrice(), getTotal(change)); 		
	}
	
	@org.junit.Test 
	public void testCandyPrice(){ 
		long price = vm.selectItemAndGetPrice(Item.CANDY); 
		assertEquals(Item.CANDY.getPrice(), price); 
		vm.insertCoin(Coin.QUARTER); 
		vm.insertCoin(Coin.DIME); 
		Bucket<Item, List<Coin>> bucket = vm.collectItemAndChange(); 
		Item item = bucket.getItem() ;
		List<Coin> change = bucket.getChange();		
		assertEquals(Item.CANDY, item); 		 
		assertEquals(35 - Item.CANDY.getPrice(), getTotal(change)); 
	}
	
	@org.junit.Test 
	public void testChangeReceivedAfterCandyOrdered(){ 
		long price = vm.selectItemAndGetPrice(Item.CANDY); 
		assertEquals(Item.CANDY.getPrice(), price); 
		vm.insertCoin(Coin.DIME); 
		vm.insertCoin(Coin.DIME); 
		vm.insertCoin(Coin.DIME); 
		Bucket<Item, List<Coin>> bucket = vm.collectItemAndChange(); 
		Item item = bucket.getItem() ;
		List<Coin> change = bucket.getChange();			 
		assertEquals(30 - Item.CANDY.getPrice(), getTotal(change)); 		
	}
	
	
	@org.junit.Test (expected=SoldOutException.class) 
	public void allSoldException(){ 
		for (int i = 0; i < 5; i++) { 
			vm.selectItemAndGetPrice(Item.CHOKOLATE); 
			vm.insertCoin(Coin.QUARTER); 
			vm.insertCoin(Coin.QUARTER); 
			vm.collectItemAndChange();
			
		} 
		
	}

	@org.junit.Test(expected=NotSufficientChangeException.class) 
	public void testNotSufficientChangeException(){ 
		for (int i = 0; i < 5; i++) { 
			vm.selectItemAndGetPrice(Item.CHOKOLATE); 
			vm.insertCoin(Coin.DIME); 
			vm.insertCoin(Coin.QUARTER); 
			vm.insertCoin(Coin.QUARTER);
			vm.insertCoin(Coin.QUARTER);
			vm.collectItemAndChange(); 
			vm.selectItemAndGetPrice(Item.COKE); 
			vm.insertCoin(Coin.DIME); 
			vm.insertCoin(Coin.QUARTER);
			vm.insertCoin(Coin.QUARTER);
			vm.collectItemAndChange(); 
			
		} 
		
	}
	
	private long getTotal(List<Coin> change){ 
		long total = 0; 
		for(Coin c : change){ 
			total = total + c.getDenomination(); 
			
		} 
		return total; 
		
	}

	

	
	
		
}
