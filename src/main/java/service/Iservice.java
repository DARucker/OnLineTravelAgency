package service;

import java.sql.SQLException;

public interface Iservice {
	void createAirTripList(String city) throws SQLException;

	void createLandTripList(String city)throws SQLException;
}
