package com.slam5.androidapplicationlivraison;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


public class ListeDesMissionsActivity extends Activity{

	ListView liste_des_missions;
	Activity activity;
	public static String[] nomsMission = new String[] { "Mission 1", "Mission 2", "Mission 3"};
	public String[] etatsMissions = new String[] { "", "", ""};
	
	public static int DETAIL_MISSION=0;
	public static int START_MISSION=1;
	public static String NUMERO_MISSION ="NUMERO_DE_LA_MISSION";
	public static int OK=999;
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		
		setContentView(R.layout.liste_des_missions);
		liste_des_missions=(ListView) findViewById(R.id.numMission);
		
		remplissageListMissions();
		
		liste_des_missions.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				
				Log.v("Mon log","Create intent");
				Intent intent = new Intent(ListeDesMissionsActivity.this, DetailMissionActivity.class);
				Log.v("Mon log","Put extra");
				intent.putExtra(NUMERO_MISSION, (long)position);
				
				Log.v("mon log", "num mission = " + position);
				Log.v("Mon log","Start");
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
		ArrayList<String> list = new ArrayList<String>();
		 for (int i = 0; i < nomsMission.length; ++i) {
			 list.add(nomsMission[i]+" "+etatsMissions[i]);
		 }
		 
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		        android.R.layout.simple_list_item_1, list);
		liste_des_missions.setAdapter(adapter);
	

	}
	

}
