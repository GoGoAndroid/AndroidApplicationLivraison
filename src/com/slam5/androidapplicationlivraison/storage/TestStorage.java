package com.slam5.androidapplicationlivraison.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.location.Location;

import com.slam5.androidapplicationlivraison.dataModel.Adress;
import com.slam5.androidapplicationlivraison.dataModel.Client;
import com.slam5.androidapplicationlivraison.dataModel.Mission;
import com.slam5.androidapplicationlivraison.dataModel.Produit;

public class TestStorage {
	
	
	public static List<Mission> livraisons=new ArrayList<Mission>();
	public static Map<Integer,Mission> etatDesLivraison=new HashMap<Integer,Mission>();
	public static Map<Mission,List<Produit> > produitsNonLivres=new HashMap<Mission,List<Produit> >();
	public static Location location;
	
	public TestStorage(){
		Client client_1=new Client("Dupont",new Adress("Annecy","3 rue de la paix",""));
		Client client_2=new Client("Franck et compagnie",new Adress("Veryer","2 rue du lac",""));
		Client client_3=new Client("les trois gros",new Adress("Lyon","4 impasse de la grosse bouffe",""));
		
		Map<Produit,Integer> produitsQte_1=new HashMap<Produit,Integer>();
		
		produitsQte_1.put(new Produit("Casserolle","AA"), 2);
		produitsQte_1.put(new Produit("Verre","BB"), 10);
		produitsQte_1.put(new Produit("Sucre","BB"), 500);
		
		livraisons.add(new Mission(1,"", "Première mission",client_1,produitsQte_1));


		Map<Produit,Integer> produitsQte_2=new HashMap<Produit,Integer>();
		
		produitsQte_2.put(new Produit("Orange","AA1"), 12);
		produitsQte_2.put(new Produit("Bannane","BB1"), 100);
		produitsQte_2.put(new Produit("Pomme","B1"), 50);
		
		livraisons.add(new Mission(2,"", "Deuxième mission",client_2,produitsQte_2));
	
		
		Map<Produit,Integer> produitsQte_3=new HashMap<Produit,Integer>();
		
		produitsQte_3.put(new Produit("Chaise","AA2"), 15);
		produitsQte_3.put(new Produit("Tabouret","BB2"), 160);
		produitsQte_3.put(new Produit("Table","B33"), 54);
		
		livraisons.add(new Mission(3,"", "Troisème mission",client_3,produitsQte_3));
	
		
		
	}
	

}
