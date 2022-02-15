package org.shoes.business;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;

import org.shoes.consumer.ShoeArray;
import org.shoes.consumer.ShoeDB;
import org.shoes.model.Caisse;
import org.shoes.model.impl.Shoe;

public class ShoeBusiness {
	
	ShoeDB shoeDB;
	Caisse caisse = new Caisse();
	ShoeArray shoeArray = new ShoeArray();
	Scanner sc = new Scanner(System.in);
	
	public void initializeStock() {
		if(shoeArray.getReserve().isEmpty()) {
			for(int i = 0; i < 7; i++) {
				Shoe shoe = new Shoe();
			shoe.setBrand("Nike");
			shoe.setSize(45);
			shoe.setCustomerPrice(250);
			shoeArray.getReserve().add(shoe);
			}
		}
	}
	
	public float initializeCaisse() {
		
		System.out.println("Combien avez vous dans la caisse ? ");
		float caisse = sc.nextFloat();
		this.caisse.setSolde(caisse);
		System.out.println("Vous avez " + caisse + "euros dans la caisse");
		return this.caisse.getSolde();

	}
	
	public boolean isComingCustomer() {
		Random random = new Random();
		int chance = random.nextInt(100);
		System.out.println(chance);
		if(chance>49) {
			return true;
		}else {
			return false;
		}
	}
	
	public float customerBuys() {
		Random random = new Random();
		int chance = random.nextInt(6);
		System.out.println(chance);
		Shoe soldShoe = shoeArray.getReserve().remove(chance);
		System.out.println("Le client a acheté une paire de " + soldShoe.getBrand() + " à " + soldShoe.getCustomerPrice() + " euros.");
		System.out.println("Il y a " + (caisse.getSolde() + soldShoe.getCustomerPrice()) + " euros dans la caisse");
		return caisse.sales(soldShoe);
	}
	
	public float orderShoesFromProvider(Map<Shoe,Integer> listShoes) {
		caisse.orders(listShoes);
		shoeArray.addToStock(listShoes);
		System.out.println("Voici ce que vous avez acheté :");
		for(Entry<Shoe,Integer> entry : listShoes.entrySet()) {
			System.out.println(entry.getValue() + " paires de "+ entry.getKey());
		}
		System.out.println("Il y a " + caisse.getSolde() + " euros dans la caisse");
		return caisse.getSolde();
	}
	
	public void isClosed() {
		if(caisse.getSolde() > 0) {
			System.out.println("Aujourd'hui, vous avez fait un gain de "+ caisse.getSolde() + " euros");
		}
		else {
			System.out.println("Aujourd'hui, vous avez fait une perte de "+ caisse.getSolde() + " euros");
		}
	}
	
	public void workDay() {
		initializeStock();
		initializeCaisse();
		boolean isClosed = false;
		while(!isClosed) {
			System.out.println("Voulez-vous commander des chaussures à votre fournisseur ?");
			if(sc.nextBoolean() == true) {
				Map<Shoe,Integer> listShoes = prepareOrder();
				orderShoesFromProvider(listShoes);
			}
			if(isComingCustomer())
				customerBuys();
			
			System.out.println("Voulez-vous fermer la boutique pour aujourd'hui ?");
		isClosed = sc.nextBoolean();
		}
		isClosed();

	}

	private Map<Shoe, Integer> prepareOrder() {
		Map<Shoe,Integer> list = new HashMap<>();
		Shoe shoe = new Shoe();
		boolean ajouterArticle = true;
		while(ajouterArticle) {
			System.out.println("Quelle marque de chaussure voulez-vous commander ? ");
			shoe.setBrand(sc.next());
			System.out.println("Combien en voulez-vous ? ");
			int quantity = sc.nextInt();
			System.out.println("Quel est le prix de chaque paire?");
			shoe.setPrice(sc.nextFloat());
			list.put(shoe,quantity);
			System.out.println("Voulez-vous ajouter d'autres chaussures ? ");
			ajouterArticle = sc.nextBoolean();
		}
		return list;
	}
}
