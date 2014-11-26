package com.slam5.androidapplicationlivraison;

import com.slam5.androidapplicationlivraison.storage.TestStorage;
import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class LocalisationActivity extends Activity {
	Activity activity;
	TextView lblLatitudeLib;
	TextView lblLatitudeVal;
	TextView lblLongitudeLib;
	TextView lblLongitudeVal;
	LocationListener locationListener = new LocationListener() {
		@Override
	    public void onLocationChanged(Location location) {
			TestStorage.location = location;
			location.getLatitude();
			location.getLongitude();
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
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vue_localisation);
		lblLatitudeLib=(TextView) findViewById(R.id.tvLatitudeLibelle);
		lblLatitudeVal=(TextView) findViewById(R.id.tvLatitudeValeur);
		lblLongitudeLib=(TextView) findViewById(R.id.tvLongitudeLibelle);
		lblLongitudeVal=(TextView) findViewById(R.id.tvLongitudeValeur);
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
