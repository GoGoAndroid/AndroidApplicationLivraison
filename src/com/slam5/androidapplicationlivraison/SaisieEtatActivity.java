package com.slam5.androidapplicationlivraison;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class SaisieEtatActivity extends Activity {

	ListView liste_des_colis;

	public static String[] nomsColis = new String[] { "Colis 1", "Colis 2", "Colis 3"};
	public static String[] etatColis = new String[] { "", "", ""};

	
	//public String[] etatsMissions = new String[] { "", "", ""};

	long idMission;
	public static String NUMERO_MISSION ="NUMERO_DE_LA_MISSION";
	public static int OK=999;
	protected void onCreate(Bundle savedInstanceState)
	{
		liste_des_colis.setVisibility(View.INVISIBLE);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.etat_mission);
		Intent intent = getIntent();
		idMission  = intent.getLongExtra(ListeDesMissionsActivity.NUMERO_MISSION,0);


		liste_des_colis=(ListView) findViewById(R.id.listColisListView);
		
		//liste_des_colis.setVisibility(View.INVISIBLE);
		
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < nomsColis.length; ++i) {
			list.add(nomsColis[i]+" "+etatColis[i]);
		}

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, list);

		liste_des_colis.setAdapter(adapter);

		
		RadioButton livre = (RadioButton) findViewById(R.id.radioLivre);
		
		livre.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				boolean checked  = ((RadioButton) v) .isChecked();
				switch(v.getId())
				case R.id.radioLivre
			}});
		
	    boolean checked = ((RadioButton) view).isChecked();
	    
	    // Check which radio button was clicked
	    switch(view.getId()) {
	        case R.id.radio_pirates:
	            if (checked)
	                // Pirates are the best
	            break;
	        case R.id.radio_ninjas:
	            if (checked)
	                // Ninjas rule
	            break;



		//((TextView) findViewById(R.id.descriptionTextView)).setText(descriptionDesMissions.get(idMission));
		//Button boutonSaisieEtat=(Button) findViewById(R.id.saisieEtatButton) ;

		Button buttonClick = (Button) findViewById(R.id.btnAjoutColisManquant);
		buttonClick.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setResult(OK);
				finish();
			}});
		//Spinner spinner = (Spinner) findViewById(R.id.spinner1);
		// Create an ArrayAdapter using the string array and a default spinner layout
		//ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		//R.array.planets_array, android.R.layout.simple_spinner_item);
		//ArrayAdapter<String> adapterListMissions = 
		//		new ArrayAdapter<String>(
		//		activity, android.R.layout.simple_list_item_1, listeDesValeurs);

		// Specify the layout to use when the list of choices appears
		//adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		//spinner.setAdapter(adapter);
	}


}
