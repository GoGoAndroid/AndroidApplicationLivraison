package com.slam5.androidapplicationlivraison;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
		 descriptionDesMissions.put((long) 5, "Mission 5");
		 descriptionDesMissions.put((long) 6, "Mission 6");
		 descriptionDesMissions.put((long) 7, "Mission 7");
	    }
	 
	public static int ETAT_MISSION=0;
	public static int PARTIELLE=1;
	public static int COMPLETE=2;
	public static int NON_LIVREE=2;
	
	long idMission;
	public static String NUMERO_MISSION ="NUMERO_DE_LA_MISSION";
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_mission);
		 Intent intent = getIntent();
		   idMission  = intent.getIntExtra(ListeDesMissionsActivity.NUMERO_MISSION,0);
		   Log.v("Mon log","Mission reçue dans la detail "+idMission);
		   Log.v("Mon log","Decription "+descriptionDesMissions.get(idMission));
			  
			
		  ((TextView) findViewById(R.id.descriptionTextView)).setText(descriptionDesMissions.get(idMission));

		  Button boutonSaisieEtat=(Button) findViewById(R.id.saisieEtatButton) ;
		  
		  
		  boutonSaisieEtat.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            		Intent intent = new Intent(DetailMissionActivity.this, SaisieEtatActivity.class);
	    				intent.putExtra(NUMERO_MISSION, idMission);
	    				startActivityForResult(intent,ETAT_MISSION);

	             }
	         });
		
		
	}
	
    protected void onActivityResult(int requestCode, int resultCode,
            Intent data) {
        if (requestCode == ETAT_MISSION) {
        	setResult(resultCode);
        	finish();
        }
    }
}
