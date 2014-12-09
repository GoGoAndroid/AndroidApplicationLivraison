package com.slam5.androidapplicationlivraison;

import java.util.ArrayList;

import com.slam5.androidapplicationlivraison.storage.TestStorage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.ListAdapter;

import android.widget.ListView;

public class ListeDesMissionsActivity extends Activity{

	ListView liste_des_missions;
	Activity activity;
	public static String[] nomsMission = new String[] { "Mission 1", "Mission 2", "Mission 3"};
	public String[] etatsMissions = new String[] { "livré", "partiellement livré", "non livré"};
	
	public static int DETAIL_MISSION=0;
	public static int START_MISSION=1;
	public static String NUMERO_MISSION ="NUMERO_DE_LA_MISSION";
	public static int OK=999;
	ArrayList<String> list = new ArrayList<String>();
	TestStorage database = new TestStorage();
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		Log.v("Mes_logs","Starting onCReate");
		
		setContentView(R.layout.liste_des_missions);
		
			liste_des_missions=(ListView) findViewById(R.id.numMission);
		
			remplissageListMissions();
		
		
			liste_des_missions.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				
				Intent intent = new Intent(ListeDesMissionsActivity.this, DetailMissionActivity.class);
				Log.v("Mes_logs", "intent crée");
				intent.putExtra(NUMERO_MISSION, (long)(position+1));
				Log.v("Mes_logs", "putExtra ");
				Log.v("Mes_logs", " start activity for result");
				startActivityForResult(intent,DETAIL_MISSION);
			
			}
		    });
		
		Button terminerButton=(Button) findViewById(R.id.TerminerButton);
		terminerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            setResult(OK);
        	finish();

         }
     });
		
		
		 
}
	
	void remplissageListMissions(){
		
		
		
		 for (int i = 0; i < TestStorage.livraisons.size(); ++i) {
			 list.add(TestStorage.livraisons.get(i).client.name + "-" + TestStorage.livraisons.get(i).etat);
		 }
		 
		 
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		        android.R.layout.simple_list_item_1, list);
		
		liste_des_missions.setAdapter(adapter);

		Log.v("Mes_logs", "livraison.size" + TestStorage.livraisons.size());
	}
	
	
	
    protected void onActivityResult(int requestCode, int resultCode,
            Intent data) { 
    	Log.v("Mes_logs", "ListeDesMissionsActivity onActivityResult");

        list.clear();
    	remplissageListMissions();
    
    }
    

}
