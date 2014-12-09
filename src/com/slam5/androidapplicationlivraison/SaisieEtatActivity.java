package com.slam5.androidapplicationlivraison;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.slam5.androidapplicationlivraison.dataModel.Mission;
import com.slam5.androidapplicationlivraison.dataModel.Produit;
import com.slam5.androidapplicationlivraison.storage.TestStorage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class SaisieEtatActivity extends Activity {

	ListView liste_des_colis;
	ListView liste_des_colis_manquant;

	//TestStorage testStorage = new TestStorage();

	TestStorage monTestStorage;
	Mission mission;
	RadioButton livre;
	RadioButton nonLivre;
	RadioButton partiellementLivre;
	Map <Integer, Produit> positionProduit;


	long idMission;
	public static String NUMERO_MISSION ="NUMERO_DE_LA_MISSION";
	public static int OK=999;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		monTestStorage = new TestStorage();
		Log.v("Mes log","onCreate");
		//TestStorage.livraisons;
		setContentView(R.layout.etat_mission);
		Intent intent = getIntent();
		idMission  = intent.getLongExtra(ListeDesMissionsActivity.NUMERO_MISSION,0);


		liste_des_colis=(ListView) findViewById(R.id.listColisListView);
		liste_des_colis.setVisibility(View.INVISIBLE);
		
		liste_des_colis_manquant=(ListView) findViewById(R.id.listColisListView);
		liste_des_colis_manquant.setVisibility(View.INVISIBLE);

		List<Mission> missions=monTestStorage.livraisons;
		liste_des_colis.setVisibility(View.INVISIBLE);
		Log.v("Mes log","Before array");
		ArrayList<String> list = new ArrayList<String>();

		
		for (int i = 0; i < missions.size(); ++i) {
			Log.v("Mes log","Before mission");
			Mission mission_temp =missions.get(i);
			if(i == idMission)
			{
				Log.v("Mes log","mission");
				mission = mission_temp;
			}
			//list.add(missions.get(i).description+" - "+missions.get(i));
		}
		Log.v("Mes log","After Mission");
		positionProduit = new HashMap<Integer,Produit>();
		int i= 0;
		for(Produit produit : mission.produitsQte.keySet())
		{
			Log.v("Mes log","QteMission");
			list.add(produit.name+ " - "+ mission.produitsQte.get(produit));
			positionProduit.put(i, produit);
		}
		Log.v("Mes log","After Qtemission");
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, list);

		liste_des_colis.setAdapter(adapter);




		livre = (RadioButton) findViewById(R.id.radioLivre);
		livre.setOnClickListener(
				new View.OnClickListener(){
					public void onClick(View v){
						if(livre.isChecked()) {
							liste_des_colis.setVisibility(View.INVISIBLE);
						}
					}
				}

		);

		nonLivre = (RadioButton) findViewById(R.id.radioNonLivre);
		nonLivre.setOnClickListener(
				new View.OnClickListener() {
					public void onClick(View v){
						if(nonLivre.isChecked()){
							liste_des_colis.setVisibility(View.INVISIBLE);;
						}
					}
				}
		);

		partiellementLivre = (RadioButton)findViewById(R.id.radioPartiellementLivre);
		partiellementLivre.setOnClickListener(
				new View.OnClickListener() {
					public void onClick(View v){	
						Log.v("mes log", "PartiellementLivre");
						//checkedPartiellementLivre = partiellementLivre.isChecked();
						if (partiellementLivre.isChecked()){
							liste_des_colis.setVisibility(View.VISIBLE);
						}
					}
				}
			);


		
		liste_des_colis.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				liste_des_colis_manquant.setVisibility(View.VISIBLE);

				
			}
		    });


		//@Override
		//public void onClick(View v) {
		// TODO Auto-generated method stub

		//}
		//}







		Button buttonClick = (Button) findViewById(R.id.btnAjoutColisManquant);
		buttonClick.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setResult(OK);
				Intent intent = new Intent(SaisieEtatActivity.this, BonDeLivraisonActivity.class);
				intent.putExtra(NUMERO_MISSION, idMission);
				startActivity(intent);
			}});

	}


}
