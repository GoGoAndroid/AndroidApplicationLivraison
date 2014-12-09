package com.slam5.androidapplicationlivraison;
import java.util.ArrayList;
import java.util.List;

import com.slam5.androidapplicationlivraison.dataModel.Mission;
import com.slam5.androidapplicationlivraison.dataModel.Produit;
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
	    //liste_bon_de_livraison=(ListView) findViewById(R.id.listBonDeLivraisonlistView);
	    liste_bon_de_livraison.setVisibility(View.INVISIBLE);
		ArrayList<String> list = new ArrayList<String>();
		
		monIntent = getIntent();
		long idMissionCourante = monIntent.getLongExtra(ListeDesMissionsActivity.NUMERO_MISSION,0);
		
		List<Mission> listMissions=TestStorage.livraisons;
		Mission maMission=null;
		
		for (int i = 0; i < listMissions.size(); ++i) 
		{
			Mission mission_temp =listMissions.get(i);
			if(mission_temp.id==idMission)
			{
				maMission=mission_temp;
				break;
			}
		}
		
		if(maMission==null )
		{
			Log.v("Mes logs","L'activité est null , ce n'est pas prévu");
		}
		else
		{
			for(Produit leProduit : maMission.produitsQte.keySet() )
			{
				//créer adapteur
				//list.add();
				
			}
		}
		
		
		
		/*TextView txtNumCommande=(TextView) findViewById(R.id.txtNumCommande);
		txtNumCommande.setText(maMission.id);
		
		TextView txtNomClient=(TextView) findViewById(R.id.txtNomClient);
		txtNomClient.setText(maMission.client.name) ;
		
		TextView txtAdresseClient=(TextView) findViewById(R.id.txtAdresseClient);
		txtAdresseClient.setText(maMission.client.adress.adress_1);
		
		TextView txtCPClient=(TextView) findViewById(R.id.txtCPClient);
		txtCPClient.setText(maMission.client.adress.adress_2);
		
		TextView txtVilleClient = (TextView) findViewById(R.id.txtVilleClient);
		txtVilleClient.setText(maMission.client.adress.city);*/

	         
	}

}