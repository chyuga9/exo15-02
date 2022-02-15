package org.shoes.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.shoes.model.impl.Shoe;

public class ShoeArray implements ShoeDB {

	public List<Shoe> getReserve() {
		return reserve;
	}

	List<Shoe> reserve = new ArrayList<>();
	
	
	
	
	@Override
	public Shoe getId(int nextInt) {
		reserve.get(nextInt);
		return null;
	}




	public void addToStock(Map<Shoe, Integer> listShoes) {
		 for (Entry<Shoe, Integer> entry : listShoes.entrySet()) {
	            for(int i = 0; i < entry.getValue(); i++) {
	            	reserve.add(entry.getKey());
	            };
	        }
	}

}
