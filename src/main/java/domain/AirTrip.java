package domain;

import java.time.LocalTime;
import java.util.List;

public class AirTrip {

	private int id;
	private String name;
	private int duration;
	private String departurCity1;
	private LocalTime departureTime1;
	private String departurCity2;
	private LocalTime departureTime2;
	private List<City> citys;
	private List<AirTripHasCity> airTripHasCity;

	public AirTrip(int id, String name, int duration, String departurCity1, LocalTime departureTime1, String departurCity2, LocalTime departureTime2, List<AirTripHasCity> airTripHasCity) {
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.departurCity1 = departurCity1;
		this.departureTime1 = departureTime1;
		this.departurCity2 = departurCity2;
		this.departureTime2 = departureTime2;
		this.airTripHasCity = airTripHasCity;
	}

	public AirTrip () {}

	public List<AirTripHasCity> getAirTripHasCity() {
		return airTripHasCity;
	}

	public void setAirTripHasCity(List<AirTripHasCity> airTripHasCity) {
		this.airTripHasCity = airTripHasCity;
	}

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

	public String getDeparturCity1() {
		return departurCity1;
	}

	public void setDeparturCity1(String departurCity1) {
		this.departurCity1 = departurCity1;
	}

	public LocalTime getDepartureTime1() {
		return departureTime1;
	}

	public void setDepartureTime1(LocalTime departureTime1) {
		this.departureTime1 = departureTime1;
	}

	public String getDeparturCity2() {
		return departurCity2;
	}

	public void setDeparturCity2(String departurCity2) {
		this.departurCity2 = departurCity2;
	}

	public LocalTime getDepartureTime2() {
		return departureTime2;
	}

	public void setDepartureTime2(LocalTime departureTime2) {
		this.departureTime2 = departureTime2;
	}

	@Override
	public String toString() {
		return
				  name + "; AirTrip; "
				+ duration + " days; "
				+ departurCity1 + "; "
				+ "departure time: " + departureTime1 + "; "
				+ departurCity2 + "; "
				+  "departure time: " + departureTime2 + "; visiting "
				+ airTripHasCity
				;
	}
}
