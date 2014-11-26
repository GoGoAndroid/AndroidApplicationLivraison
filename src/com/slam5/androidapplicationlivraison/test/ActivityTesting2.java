package com.slam5.androidapplicationlivraison.test;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.util.Log;
import android.widget.Button;

import com.slam5.androidapplicationlivraison.DetailMissionActivity;
import com.slam5.androidapplicationlivraison.R;
import com.slam5.androidapplicationlivraison.SaisieEtatActivity;

public class ActivityTesting2 extends ActivityUnitTestCase<DetailMissionActivity> {
	Intent mLaunchIntent;
	Button boutonSaisieEtat;
	public ActivityTesting2(Class<DetailMissionActivity> activityClass) {
		super(activityClass);

	}
	public ActivityTesting2() {
        super(DetailMissionActivity.class);
    }
	 @Override
	    protected void setUp() throws Exception {
	        super.setUp();
	        Log.v("LOG","Setup done");
	        mLaunchIntent = new Intent(getInstrumentation()
	                .getTargetContext(), DetailMissionActivity.class);
	        Log.v("LOG","Intent created");
	        startActivity(mLaunchIntent, null, null);
	        Log.v("LOG","Activity started");
	        boutonSaisieEtat=(Button)  getActivity().findViewById(R.id.saisieEtatButton);
	        		
	   
	    }
	 
	
	 public void testNextActivityWasLaunchedWithIntent() {
		 
	     //startActivity(mLaunchIntent, null, null);
	     boutonSaisieEtat.performClick();

	     final Intent launchIntent = getStartedActivityIntent();
	     assertNotNull("Intent was null", launchIntent);
	   

	     final long idMission =  launchIntent.getLongExtra(DetailMissionActivity.NUMERO_MISSION,-1);
	     assertNotSame("IdMission not empty", -1, idMission);
	     
	     
	 }
}
