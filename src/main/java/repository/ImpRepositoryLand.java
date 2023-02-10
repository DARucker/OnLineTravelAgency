package repository;

import domain.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class contains the implementations to interact with the database
 * and provide the requested information about land trips
 */
public class ImpRepositoryLand implements IRepository{

    private Connector myConnection;
    private PreparedStatement ps;
    private ResultSet rs;
    private List<City> citiesList;
    private List<LandTripHasCity> landTripHasCities;
    private List<LandTrip> landTrips;

    /**
     * creates the complete list of cities
     * @return list of cities
     * @throws SQLException
     */
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

    public List<LandTripHasCity> findLandTripByCityId(int cityId) throws SQLException {
        landTripHasCities = new ArrayList<>();
        String sql = "SELECT * from land_trip_has_city where city_id = ?";
        ps = myConnection.connector().prepareStatement(sql);
        ps.setInt(1, cityId);
        rs = ps.executeQuery();
        while (rs.next()) {
            LandTripHasCity landTripHasCity = new LandTripHasCity();
            landTripHasCity.setLandTripId(rs.getInt("land_trip_id"));
            landTripHasCity.setCityId(rs.getInt("city_id"));
            landTripHasCities.add(landTripHasCity);
        }
        ps.close();
        rs.close();
        return landTripHasCities;
    }

    public List<LandTrip> findLandTripById(List<LandTripHasCity> landTripHasCities) throws SQLException {

        landTrips = new ArrayList<>();
        String sql = "Select * from land_trip where land_trip_id = ?";

        for (LandTripHasCity a : landTripHasCities) {
            ps = myConnection.connector().prepareStatement(sql);
            ps.setInt(1, a.getLandTripId());
            rs = ps.executeQuery();

            while (rs.next()) {
                LandTrip landTrip = new LandTrip();
                landTrip.setId(rs.getInt("land_trip_id"));
                landTrip.setName(rs.getString("land_trip_name"));
                landTrip.setDuration((rs.getInt("land_trip_duration")));
                landTrip.setHotel1(rs.getString("land_trip_hotel1"));
                landTrip.setHotel2(rs.getString("land_trip_hotel2"));

                landTripHasCities = findLandTripByLandTripId(rs.getInt("land_trip_id"));
                landTrip.setLandTripHasCity(landTripHasCities);

                landTrips.add(landTrip);
            }
        }
        rs.close();
        ps.close();
        return landTrips;
    }
    public List<LandTripHasCity> findLandTripByLandTripId(int LandTripId) throws SQLException {
        landTripHasCities = new ArrayList<>();
        String sql = "SELECT * from land_trip_has_city where land_trip_id = ?";
        ps = myConnection.connector().prepareStatement(sql);
        ps.setInt(1, LandTripId);
        rs = ps.executeQuery();
        while (rs.next()) {
            LandTripHasCity landTripHasCity = new LandTripHasCity();
            landTripHasCity.setLandTripId(rs.getInt("land_trip_id"));
            landTripHasCity.setCityId(rs.getInt("city_id"));
            landTripHasCity.setName(citiesList.stream().filter(x -> x.getId() == landTripHasCity.getCityId()).map(x -> x.getName()).collect(Collectors.joining()));
            landTripHasCities.add(landTripHasCity);
        }
        return landTripHasCities;
    }


    @Override
    public List<AirTripHasCity> findAirTripByCityId(int cityId) throws SQLException {
        return null;}

    @Override
    public List<AirTrip> findAirTripById(List<AirTripHasCity> airTripHasCities) throws SQLException {
        return null;}


}