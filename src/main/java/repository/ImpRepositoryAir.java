package repository;

import domain.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImpRepositoryAir implements IRepository{

    private Connector myConnection;
    private PreparedStatement ps, ps1, ps2;
    private ResultSet rs, rs1, rs2;
    private List<City> citiesList;
    private List<AirTripHasCity> airTripHasCities;
    private List<AirTrip> airTrips;


    public List<City> createCityList() throws SQLException {
        citiesList = new ArrayList<>();
        myConnection = new Connector();
        String sqlCities = "Select * from city";
        Statement st = myConnection.connector().createStatement();
        rs = st.executeQuery(sqlCities);

        while (rs.next()) {
            City city = new City();
            city.setId(rs.getInt("city_id"));
            city.setName(rs.getString("city_name").toLowerCase());
            citiesList.add(city);
        }
        return citiesList;
    }

    public int findCityByName(String city) {
        return Integer.valueOf(citiesList.stream().filter(x -> x.getName().contains(city)).mapToInt(x -> x.getId()).toString());
    }

    public List<AirTripHasCity> findAirTripByCityId(int cityId) throws SQLException {
        airTripHasCities = new ArrayList<>();
        String sql = "SELECT * from air_trip_has_city where city_id = ?";
        ps = myConnection.connector().prepareStatement(sql);
        ps.setInt(1, cityId);
        rs = ps.executeQuery();
        while (rs.next()) {
            AirTripHasCity airTripHasCity = new AirTripHasCity();
            airTripHasCity.setAirTripId(rs.getInt("air_trip_id"));
            airTripHasCity.setCityId(rs.getInt("city_id"));
            airTripHasCities.add(airTripHasCity);
        }
        return airTripHasCities;
    }

    public List<AirTrip> findAirTripById(List<AirTripHasCity> airTripHasCities) throws SQLException {

        airTrips = new ArrayList<>();
        String sql = "Select * from air_trip where air_trip_id = ?";

        for (AirTripHasCity a : airTripHasCities) {
            ps = myConnection.connector().prepareStatement(sql);
            ps.setInt(1, a.getAirTripId());
            rs = ps.executeQuery();

            while (rs.next()) {
                AirTrip airTrip = new AirTrip();
                airTrip.setId(rs.getInt("air_trip_id"));
                airTrip.setName(rs.getString("air_trip_name"));
                airTrip.setDuration((rs.getInt("air_trip_duration")));
                airTrip.setDeparturCity1(rs.getString("air_trip_departure_city_1"));
                airTrip.setDeparturCity2(rs.getString("air_trip_departure_city_2"));
                airTrip.setDepartureTime1(rs.getTime("air_trip_departure1_time").toLocalTime());
                airTrip.setDepartureTime2(rs.getTime("air_trip_departure2_time").toLocalTime());
                // airTripHasCities = new ArrayList<>();
                airTripHasCities = findAirTripByAirTripId(rs.getInt("air_trip_id"));
                airTrip.setAirTripHasCity(airTripHasCities);


                airTrips.add(airTrip);
            }
        }
        return airTrips;
    }



    public List<AirTripHasCity> findAirTripByAirTripId(int AirTripId) throws SQLException {
        airTripHasCities = new ArrayList<>();
        String sql = "SELECT * from air_trip_has_city where air_trip_id = ?";
        ps = myConnection.connector().prepareStatement(sql);
        ps.setInt(1, AirTripId);
        rs = ps.executeQuery();
        while (rs.next()) {
            AirTripHasCity airTripHasCity = new AirTripHasCity();
            airTripHasCity.setAirTripId(rs.getInt("air_trip_id"));
            airTripHasCity.setCityId(rs.getInt("city_id"));
            airTripHasCity.setName(citiesList.stream().filter(x -> x.getId() == airTripHasCity.getCityId()).toString());
            airTripHasCities.add(airTripHasCity);
        }
        return airTripHasCities;
    }
    @Override
    public List<LandTripHasCity> findLandTripByCityId(int cityId) throws SQLException {
        return null;}

    @Override
    public List<LandTrip> findLandTripById(List<LandTripHasCity> landTripHasCities) throws SQLException {
        return null;}

}