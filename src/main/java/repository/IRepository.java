package repository;

import domain.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Defines the methods to find air or land trips in the database
 */
public interface IRepository {

    List<City> createCityList() throws SQLException;
    List<AirTripHasCity> findAirTripByCityId(int cityId)throws SQLException;
    List<AirTrip> findAirTripById(List<AirTripHasCity> airTripHasCities) throws SQLException;
    List<LandTripHasCity> findLandTripByCityId(int cityId)throws SQLException;
    List<LandTrip> findLandTripById(List<LandTripHasCity> landTripHasCities) throws SQLException;


}
