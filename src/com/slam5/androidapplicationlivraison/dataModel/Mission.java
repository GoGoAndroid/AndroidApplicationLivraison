package com.slam5.androidapplicationlivraison.dataModel;

import java.util.Map;

public class Mission {
	public int id;
	public Client client;
	public String description;
	public Map<Produit,Integer> produitsQte;
	public String etat;
	

	public Mission(int id, String etat, String description,Client client,Map<Produit,Integer> produitsQte){
		this.etat=etat;
		this.id=id;
		this.description=description;
		this.client=client;
		this.produitsQte=produitsQte;
	}
	
}
