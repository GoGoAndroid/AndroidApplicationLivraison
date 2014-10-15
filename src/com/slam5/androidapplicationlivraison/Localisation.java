package com.slam5.androidapplicationlivraison;
public class Localisation {

	private int _id;
	private double _latitude;
	private double _longitude;
	private String _ville;
	
	public Localisation(int unId, double uneLatitude, double uneLongitude, String uneVille) {
		_id = unId;
		_latitude = uneLatitude;
		_longitude = uneLongitude;
		_ville = uneVille;
	}
	public static void main(String[] args) {
		Localisation maLocalisation = new Localisation(1, 45.9, 6.1167, "Annecy");
		System.out.println(maLocalisation.ToString());
	}
	
	public String ToString()
	{
		String resultat = "Id : "+this._id + " Latitude : "+this._latitude + " Longitude : "+this._longitude + " Ville : "+this._ville;
		return resultat;
	}
}
