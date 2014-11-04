package com.slam5.androidapplicationlivraison;

import com.slam5.androidapplicationlivraison.R.id;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        RadioButton buttonLivraison=(RadioButton) findViewById(R.id.radioLivre);
        buttonLivraison.setOnClickListener(new OnClickListener()
        {

			@Override
			public void onClick(View view) 
			{
				selectionEtatMission(view);
				
				
			}
		});
        
        Button button=(Button) findViewById(R.id.textView2);
        // a supprimer
        button.setText("toto");
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void validerEtatMission()
    {
    	// rg1.getCheckedRadioButtonId()!=-1
    	RadioGroup radioGroupSelectionEtatMission = (RadioGroup) findViewById(R.id.radioGroupEtatMission);
    	int selectId = radioGroupSelectionEtatMission.getCheckedRadioButtonId();
    	
    	
    	if(radioGroupSelectionEtatMission.getCheckedRadioButtonId() != 1)
    	{
    		RadioButton btn = (RadioButton) radioGroupSelectionEtatMission.getChildAt(selectId);
    	    String selection = (String) btn.getText();
    	}
    	

    }
    

}
