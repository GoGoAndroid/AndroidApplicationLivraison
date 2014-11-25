package com.slam5.androidapplicationlivraison;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.slam5.androidapplicationlivraison.dataModel.Mission;
import com.slam5.androidapplicationlivraison.storage.TestStorage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class DetailMissionActivity extends Activity {

	static Map<Long,String> descriptionDesMissions;
	 static
	    {
		 descriptionDesMissions = new HashMap<Long, String>();
		 descriptionDesMissions.put((long) 0, "Mission 0");
		 descriptionDesMissions.put((long) 1, "Mission 1");
		 descriptionDesMissions.put((long) 2, "Mission 2");
		 descriptionDesMissions.put((long) 3, "Mission 3");
		 descriptionDesMissions.put((long) 4, "Mission 4");
	    }
	 
	public static int ETAT_MISSION=0;
	public static int PARTIELLE=1;
	public static int COMPLETE=2;
	public static int NON_LIVREE=2;
	TestStorage Test = new TestStorage();
	TestStorage testStorage=new TestStorage();
	
	
	
	long idMission;
	public static String NUMERO_MISSION ="NUMERO_DE_LA_MISSION";
	
	
	ListView liste_des_colis;
	
	public static String[] nomsColis = new String[] { "Colis 1", "Colis 2", "Colis 3", "Colis 4", "Colis 5"};
	public static String[] qteColis = new String[] {"25", "7","13","10","3"};
	public String[] etatsMissions = new String[] { "", "", ""};	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_mission);
		 Intent intent = getIntent();
		   idMission  = intent.getLongExtra(ListeDesMissionsActivity.NUMERO_MISSION,0);

		   Log.v("Mes logs",""+idMission);
		   TextView descriptionMission=((TextView) findViewById(R.id.descriptionTextView));
		   String valeurDeLaDescription = descriptionDesMissions.get(idMission);
		   descriptionMission.setText(valeurDeLaDescription);


		   liste_des_colis=(ListView) findViewById(R.id.ListeColisListView);
		   
		   remplissageListColis();
		   
		  
		  
		   Button boutonSaisieEtat=(Button) findViewById(R.id.saisieEtatButton) ;
		  boutonSaisieEtat.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            		Intent intent = new Intent(DetailMissionActivity.this, SaisieEtatActivity.class);
	    				intent.putExtra(NUMERO_MISSION, idMission);
	    				startActivityForResult(intent,ETAT_MISSION);

	             }
	         });
		
	}
	
	void remplissageListColis(){
		ArrayList<String> list = new ArrayList<String>();
		
		Mission mission=getMission((int) idMission);

		if (mission == null){
				 Log.v("monTag", "Il n'y a aucun colis.");
		}
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		        android.R.layout.simple_list_item_1, list);
		
		liste_des_colis.setAdapter(adapter);
	
	}
	
	Mission getMission(int id){
		Mission mission=null;
		 for (int i = 0; i < TestStorage.livraisons.size(); ++i) {
			 
			 Mission uneMission=TestStorage.livraisons.get(i);
			 
			 	if (uneMission.id == id){
			 		mission  = uneMission;
			 		break;
			 	}
		 }
			return mission;
	}
	
    protected void onActivityResult(int requestCode, int resultCode,
            Intent data) {
        if (requestCode == ETAT_MISSION) {
        	setResult(resultCode);
        	finish();
        }
    }
    
    
    
//    void remplissageListColis(){
//		ArrayList<String> list = new ArrayList<String>();
//		 for (int i = 0; i < nomsColis.length; ++i) {
//			 list.add(nomsColis[i] + ", quantité : " + qteColis[i]);
//		 }
//		 
//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//		        android.R.layout.simple_list_item_1, list);
//		liste_des_colis.setAdapter(adapter);
//		
//	}
    
}
