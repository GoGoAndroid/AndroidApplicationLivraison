package com.slam5.androidapplicationlivraison.dataModel;

import java.util.Map;

public class Mission {
	public Client client;
	public String description;
	public Map<Produit,Integer> produitsQte;
	public int id;
	public String etat;
	
	public Mission(int id, String etat, String description,Client client,Map<Produit,Integer> produitsQte){
		this.description=description;
		this.client=client;
		this.produitsQte=produitsQte;
		this.etat=etat;
		this.id=id;
	}
	
}
