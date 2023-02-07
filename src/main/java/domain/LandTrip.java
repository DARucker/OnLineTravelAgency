package domain;

import java.util.List;

public class LandTrip {

	private int id;
	private String name;
	private int duration;
	private String hotel1;
	private String hotel2;
	private List<City> citys;
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
	
	public List<City> getCitys() {
		return citys;
	}

	public void setCitys(List<City> citys) {
		this.citys = citys;
	}

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

	public void setLandTripHasCity(List<LandTripHasCity> landTripHasCities) {
	}

	@Override
	public String toString() {
		return "LandTrip{" +
				"id=" + id +
				", name='" + name + '\'' +
				", duration=" + duration +
				", hotel1='" + hotel1 + '\'' +
				", hotel2='" + hotel2 + '\'' +
				", citys=" + landTripHasCity +
				'}';
	}
}
