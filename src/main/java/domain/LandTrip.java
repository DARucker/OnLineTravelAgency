package domain;

import java.util.List;

public class LandTrip {

	private int id;
	private String name;
	private int duration;
	private String hotel1;
	private String hotel2;

	private List<LandTripHasCity> landTripHasCity;

	public LandTrip(int id, String name, int duration, String hotel1, String hotel2, List<LandTripHasCity> landTripHasCity) {
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.hotel1 = hotel1;
		this.hotel2 = hotel2;
		this.landTripHasCity = landTripHasCity;
	}

	public LandTrip (){}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getHotel1() {
		return hotel1;
	}
	public void setHotel1(String hotel1) {
		this.hotel1 = hotel1;
	}
	public String getHotel2() {
		return hotel2;
	}
	public void setHotel2(String hotel2) {
		this.hotel2 = hotel2;
	}

	public void setLandTripHasCity(List<LandTripHasCity> landTripHasCity) {
		this.landTripHasCity = landTripHasCity;
	}

	public List<LandTripHasCity> getLandTripHasCity() {
		return landTripHasCity;
	}

	@Override
	public String toString() {
		return name + "; LandTrip; "
				+  duration + " days; "
				+ "hotel1: " + hotel1
				+ "; hotel2: " + hotel2
				+ "; visiting "
				+ landTripHasCity +
				";";
	}
}
