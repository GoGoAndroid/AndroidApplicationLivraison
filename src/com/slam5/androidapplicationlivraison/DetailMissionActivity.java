package com.slam5.androidapplicationlivraison;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class DetailMissionActivity extends Activity {

	static Map<Long,String> descriptionDesMissions;
	 static
	    {
		 descriptionDesMissions = new HashMap<Long, String>();
		 descriptionDesMissions.put((long) 1, "Mission 1");
		 descriptionDesMissions.put((long) 2, "Mission 2");
		 descriptionDesMissions.put((long) 3, "Mission 3");
		 descriptionDesMissions.put((long) 4, "Mission 4");
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
		
		 Intent intent = getIntent();
		   idMission  = intent.getLongExtra(ListeDesMissionsActivity.NUMERO_MISSION,0);
		  ((TextView) findViewById(R.id.descriptionTextView)).setText(descriptionDesMissions.get(idMission));

		  Button boutonSaisieEtat=(Button) findViewById(R.id.saisieEtatButton) ;
		  
		  
		  boutonSaisieEtat.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            		Intent intent = new Intent(DetailMissionActivity.this, SaisieEtatActivity.class);
	    				intent.putExtra(NUMERO_MISSION, idMission);
	    				startActivityForResult(intent,ETAT_MISSION);

	             }
	         });
		setContentView(R.layout.detail_mission);
		
	}
	
    protected void onActivityResult(int requestCode, int resultCode,
            Intent data) {
        if (requestCode == ETAT_MISSION) {
        	setResult(resultCode);
        	finish();
        }
    }
}
