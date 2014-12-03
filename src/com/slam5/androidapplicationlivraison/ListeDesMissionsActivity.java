package com.slam5.androidapplicationlivraison;

import android.app.Activity;
import android.os.Bundle;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
>>>>>>> prototype_1
>>>>>>> DetailMission
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
		
		

	}
	

}
