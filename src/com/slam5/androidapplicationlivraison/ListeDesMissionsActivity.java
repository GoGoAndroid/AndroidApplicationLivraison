package com.slam5.androidapplicationlivraison;

import java.util.ArrayList;

import com.slam5.androidapplicationlivraison.storage.TestStorage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
		
<<<<<<< HEAD
		liste_des_missions.setOnItemClickListener(new AdapterView.OnItemClickListener() 
		{
=======
		
		liste_des_missions.setOnItemClickListener(new AdapterView.OnItemClickListener() {

>>>>>>> 3b53023012008a8e8257fbb9218c8a9e70756206
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) 
				{
					Intent intent = new Intent(ListeDesMissionsActivity.this, DetailMissionActivity.class);
					intent.putExtra(NUMERO_MISSION, position);
					startActivityForResult(intent,DETAIL_MISSION);
				}
		});
		
		Button terminerButton=(Button) findViewById(R.id.TerminerButton);
		terminerButton.setOnClickListener(new View.OnClickListener() 
		{
            public void onClick(View v) 
            {
            	setResult(OK);
            	finish();
            }
		});
	}
	
	void remplissageListMissions(){
		ArrayList<String> list = new ArrayList<String>();
<<<<<<< HEAD
		 for (int i = 0; i < nomsMission.length; ++i) {
			 list.add(nomsMission[i]);
		 }
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity,
=======
		
		TestStorage Test = new TestStorage();
		 for (int i = 0; i < TestStorage.livraisons.size(); ++i) {
			 list.add(TestStorage.livraisons.get(i).client.name);
		 }
		 
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
>>>>>>> 3b53023012008a8e8257fbb9218c8a9e70756206
		        android.R.layout.simple_list_item_1, list);
		
		liste_des_missions.setAdapter(adapter);
	}
	
    protected void onActivityResult(int requestCode, int resultCode,
            Intent data) {
        if (requestCode == DETAIL_MISSION) {
            if (resultCode == START_MISSION) {
            	remplissageListMissions();
            }
        }
    }
    

}
