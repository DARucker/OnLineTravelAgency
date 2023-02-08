package service;

import Application.main;
import domain.*;
import repository.IRepository;
import repository.ImpRepositoryAir;
import repository.ImpRepositoryLand;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ImplService implements Iservice{

	private IRepository iRepositoryAir = new ImpRepositoryAir();
	private IRepository iRepositoryLand = new ImpRepositoryLand();
	private List<City> requestedCities = new ArrayList<>();


	public void createAirTripList(String cityParameter) throws SQLException {

		String city = cityParameter.toLowerCase();
		List<City> cityList = iRepositoryAir.createCityList().stream().toList();
		requestedCities = cityList.stream().filter(x -> x.getName().contains(city)).collect(Collectors.toList());
		if (requestedCities.isEmpty()) {
			System.out.println("There are o tours with any city containing " + city + ". Please try again");
			main.wellcome();
		}
		for (City c : requestedCities) {
			int city_id = c.getId();
			List<AirTripHasCity> airTripHasCities = iRepositoryAir.findAirTripByCityId(city_id);
			List<AirTrip> airTripList = iRepositoryAir.findAirTripById(airTripHasCities);
			airTripList.forEach(x -> System.out.println(x));
		}
	}

	public void createLandTripList(String cityParameter) throws SQLException {

		String city = cityParameter.toLowerCase();
		List<City> cityList = iRepositoryLand.createCityList().stream().toList();
		requestedCities = cityList.stream().filter(x -> x.getName().contains(city)).collect(Collectors.toList());
		if (requestedCities.isEmpty()) {
			System.out.println("There are o tours with any city containing " + city + ". Please try again");
			main.wellcome();
		}
		for (City c : requestedCities) {
			int city_id = c.getId();
			List<LandTripHasCity> landTripHasCities = iRepositoryLand.findLandTripByCityId(city_id);
			List<LandTrip> landTripList = iRepositoryLand.findLandTripById(landTripHasCities);
			landTripList.forEach(x -> System.out.println(x));
		}
		main.wellcome();
	}
}




