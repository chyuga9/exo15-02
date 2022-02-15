package org.shoes.model;

import java.util.HashMap;
import java.util.Map;

import org.shoes.model.impl.Shoe;

public class Caisse {

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	private float solde;
	
	public float sales(Shoe soldShoe) {
		solde +=  soldShoe.getCustomerPrice();
		return solde ;
	}

	public float orders(Map<Shoe, Integer> listShoes) {
		listShoes.forEach((shoe,quantity) -> 
			solde -= (shoe.getPrice() * quantity));	
		return solde;

	}

}
