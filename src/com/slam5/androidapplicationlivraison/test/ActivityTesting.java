package com.slam5.androidapplicationlivraison.test;

import com.slam5.androidapplicationlivraison.DetailMissionActivity;
import com.slam5.androidapplicationlivraison.R;
import com.slam5.androidapplicationlivraison.SaisieEtatActivity;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.MediumTest;
import android.util.Log;
import android.widget.Button;

public class ActivityTesting extends ActivityInstrumentationTestCase2<DetailMissionActivity> {

	DetailMissionActivity detailMissionActivity;
	Intent mLaunchIntent;
	Button boutonSaisieEtat;
	
	public ActivityTesting(Class<DetailMissionActivity> activityClass) {
		super(DetailMissionActivity.class);
	}
	public ActivityTesting() {
        super(DetailMissionActivity.class);
    }
	

	 @Override
	    protected void setUp() throws Exception {
	        super.setUp();
	        Log.v("LOG","Setup done");
	        detailMissionActivity = getActivity();

	        Log.v("LOG","Activity started");
	        boutonSaisieEtat=(Button)  getActivity().findViewById(R.id.saisieEtatButton);
	        		
	   
	    }
	 
	 public void testPreconditions() {
		    assertNotNull("detailMissionActivity is null", detailMissionActivity);
		    assertNotNull("boutonSaisieEtat is null", boutonSaisieEtat);
		}
	/* public void testClick() {
		 boutonSaisieEtat.performClick();
		 
		 
	 }*/

}
