package com.slam5.androidapplicationlivraison;
import java.util.ArrayList;
import java.util.List;

import com.slam5.androidapplicationlivraison.dataModel.Mission;
import com.slam5.androidapplicationlivraison.storage.TestStorage;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class BonDeLivraisonActivity extends Activity
{
	ListView liste_bon_de_livraison;
	public static int[] numColis = new int[] { 1,2,3,4,5,6,7,8};
	int idMission=1;
    TestStorage monTestStorage = new TestStorage();
    Intent monIntent;
	protected void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.bon_de_livraison);
	    liste_bon_de_livraison=(ListView) findViewById(R.id.listBonDeLivraisonlistView);
	    liste_bon_de_livraison.setVisibility(View.INVISIBLE);
		ArrayList<String> list = new ArrayList<String>();
		
		monIntent = getIntent();
		long idMissionCourante = monIntent.getLongExtra(ListeDesMissionsActivity.NUMERO_MISSION,0);
		
		List<Mission> listMissions=TestStorage.livraisons;
		Mission mission=null;
		
		for (int i = 0; i < listMissions.size(); ++i) 
		{
			Mission mission_temp =listMissions.get(i);
			if(mission_temp.id==idMission)
			{
				mission=mission_temp;
				break;
			}
		}
		if(mission==null )
		{
			Log.v("Mes logs","L'activité est null , ce n'est pas prévu");
		}
		TextView txtNomClient=(TextView) findViewById(R.id.txtNomClient);
		txtNomClient.setText(mission.client.name) ;

	         
	}

}
