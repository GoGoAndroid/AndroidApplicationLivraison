package com.slam5.androidapplicationlivraison;

import com.slam5.androidapplicationlivraison.storage.TestStorage;
import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

public class LocalisationActivity extends Activity {
	Activity activity;
	LocationListener locationListener = new LocationListener() {
		@Override
	    public void onLocationChanged(Location location) {
			TestStorage.location = location;
	    }

		@Override
		public void onProviderDisabled(String arg0) {
			
		}

		@Override
		public void onProviderEnabled(String arg0) {
			
		}

		@Override
		public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
			
		}
	};
	
	LocationManager locationManger;
	protected void onCreate(Bundle savedInstanceState){
		
	}
	protected void onResume() {
	    super.onResume();
	    locationManger = (LocationManager) this.getSystemService(LOCATION_SERVICE);
	    locationManger.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10000, 0, locationListener);
	}
	protected void onPause() {
	    super.onPause();
	    locationManger.removeUpdates(locationListener);
	}
}
