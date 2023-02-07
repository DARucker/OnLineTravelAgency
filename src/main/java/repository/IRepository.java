package repository;

import domain.*;

import java.sql.SQLException;
import java.util.List;

public interface IRepository {

    List<City> createCityList() throws SQLException;
    int findCityByName(String city);
    List<AirTripHasCity> findAirTripByCityId(int cityId)throws SQLException;
    List<AirTrip> findAirTripById(List<AirTripHasCity> airTripHasCities) throws SQLException;

    List<LandTripHasCity> findLandTripByCityId(int cityId)throws SQLException;
    List<LandTrip> findLandTripById(List<LandTripHasCity> landTripHasCities) throws SQLException;


}
