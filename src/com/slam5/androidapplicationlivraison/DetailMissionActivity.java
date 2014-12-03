package com.slam5.androidapplicationlivraison;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.slam5.androidapplicationlivraison.dataModel.Mission;
import com.slam5.androidapplicationlivraison.storage.TestStorage;

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
		setContentView(R.layout.detail_mission);
		   Log.v("Mes_logs", "DetailMissionActivity started");
		 Intent intent = getIntent();
		   idMission  = intent.getLongExtra(ListeDesMissionsActivity.NUMERO_MISSION,0);
		   Log.v("Mes_logs"," idMission : "+ idMission );
		   
		   
		   List<Mission> missions = TestStorage.livraisons;
		   
		   for(int i=0 ; i < missions.size(); ++i )
		   {
			   
			   Mission mission_temp = missions.get(i);
			   Log.v("Mes_Logs", "Mission_temp : " + mission_temp.id);
			   if (mission_temp.id == idMission)
			   {
				   Log.v("Mes_logs", "Mission trouvée");
				   
				   mission_temp.etat = "Livré";
				   Log.v("Mes_logs", "Etat changé");
				   
				   break;
			   }
			   
			   
		   }
		   
		Log.v("Mes_logs", "DetailMission onCreate Finish");
		finish();
		

	
		
	}
	

}
