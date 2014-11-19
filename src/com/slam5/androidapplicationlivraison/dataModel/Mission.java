package com.slam5.androidapplicationlivraison.dataModel;

import java.util.Map;

public class Mission {
	public int id;
	public Client client;
	public String description;
	public Map<Produit,Integer> produitsQte;
	
	public Mission(String description,Client client,Map<Produit,Integer> produitsQte){
		this.description=description;
		this.client=client;
		this.produitsQte=produitsQte;
	}
	
}
