package service;

import java.sql.SQLException;

public interface Iservice {
	/**
	 *	This class returns the AIR tours list with all their information
	 *
	 * @param city binds the request made by the user to find
	 *             the cities in the database.
	 *             First finds all the tours that contain the requested
	 *             city and the helps to create the tours list
	 * @throws SQLException in case of any trouble connecting with the database or
	 * atemping to make the request
	 */
	void createAirTripList(String city) throws SQLException;

	/**
	 * This class returns the LAND tours list with all their information
	 * @param city binds the request made by the user to find
	 * 	 *             the cities in the database.
	 * 	 *             First finds all the tours that contain the requested
	 * 	 *             city and the helps to create the tours list
	 * @throws SQLException in case of any trouble connecting with the database or
	 * 	 * atemping to make the request
	 */
	void createLandTripList(String city)throws SQLException;
}
