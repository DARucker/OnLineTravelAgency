package Application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * The purpose of this class is to provide the scripts to create the database and tables
 * in case you cannot create them directly using the script file with your database
 * administrator.
 */
public class Databases {

	private final static String url = "jdbc:mysql://localhost:3306/";
	private final static String user = "root";
	private final static String pass = "administrador";

	public static void main (String[] args){
		pruebas();
	}

	public static Connection connector() {

		Connection myConnection = null;
		try {
			myConnection = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return myConnection;
	}

	public static void pruebas() {
		String sql =
		/*	"	-- MySQL Workbench Synchronization"
			+	"	-- Generated: 2023-02-08 09:23"
			+	"	-- Model: New Model"
			+	"	-- Version: 1.0"
			+	"	-- Project: Name of the project"
			+	"	-- Author: Dario"
			+	"	SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;"
			+	"	SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;"
			+	"	SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';"
*/
				"	CREATE SCHEMA IF NOT EXISTS `travel_search` DEFAULT CHARACTER SET utf8mb3 ;";

		String sqlTable1 =
				"	CREATE TABLE IF NOT EXISTS `travel_search`.`city` "
						+	"  (`city_id` INT(11) NOT NULL AUTO_INCREMENT,"
						+	"  `city_name` VARCHAR(45) NOT NULL,"
						+	"	PRIMARY KEY (`city_id`))"
						+	"	ENGINE = InnoDB"
						+	"	AUTO_INCREMENT = 13"
						+	"	DEFAULT CHARACTER SET = utf8mb3;";

		String sqlTable2 =
				"	CREATE TABLE IF NOT EXISTS `travel_search`.`air_trip` "
			+	"  (`air_trip_id` INT(11) NOT NULL AUTO_INCREMENT,"
			+	"  `air_trip_name` VARCHAR(45) NOT NULL,"
			+	"  `air_trip_duration` INT(11) NOT NULL,"
			+	"  `air_trip_departure_city_1` VARCHAR(45) NOT NULL,"
			+	"  `air_trip_departure1_time` TIME NOT NULL,"
			+	"  `air_trip_departure_city_2` VARCHAR(45) NOT NULL,"
			+	"  `air_trip_departure2_time` TIME NOT NULL,"
			+	"			PRIMARY KEY (`air_trip_id`))"
			+	"	ENGINE = InnoDB"
			+	"	AUTO_INCREMENT = 3"
			+	"	DEFAULT CHARACTER SET = utf8mb3;";

		String sqlTable3 =
				"	CREATE TABLE IF NOT EXISTS `travel_search`.`air_trip_has_city` "
			+	"  (`air_trip_id` INT(11) NOT NULL,"
			+	"  `city_id` INT(11) NOT NULL,"
			+	"	PRIMARY KEY (`air_trip_id`, `city_id`),"
			+	"	INDEX `fk_air_trip_has_city_city1_idx` (`city_id` ASC) VISIBLE,"
			+	"			INDEX `fk_air_trip_has_city_air_trip_idx` (`air_trip_id` ASC) VISIBLE,"
			+	"			CONSTRAINT `fk_air_trip_has_city_air_trip`"
			+	"	FOREIGN KEY (`air_trip_id`)"
			+	"	REFERENCES `travel_search`.`air_trip` (`air_trip_id`)"
			+	"	ON DELETE CASCADE"
			+	"	ON UPDATE CASCADE,"
			+	"			CONSTRAINT `fk_air_trip_has_city_city1`"
			+	"	FOREIGN KEY (`city_id`)"
			+	"	REFERENCES `travel_search`.`city` (`city_id`)"
			+	"	ON DELETE CASCADE"
			+	"	ON UPDATE CASCADE)"
			+	"	ENGINE = InnoDB"
			+	"	DEFAULT CHARACTER SET = utf8mb3;";



		String sqlTable4 =
				"	CREATE TABLE IF NOT EXISTS `travel_search`.`land_trip` "
			+	"  (`land_trip_id` INT(11) NOT NULL AUTO_INCREMENT,"
			+	"  `land_trip_name` VARCHAR(45) NULL DEFAULT NULL,"
			+	"  `land_trip_duration` INT(11) NOT NULL,"
			+	"  `land_trip_hotel1` VARCHAR(45) NOT NULL,"
			+	"  `land_trip_hotel2` VARCHAR(45) NOT NULL,"
			+	"	PRIMARY KEY (`land_trip_id`))"
			+	"	ENGINE = InnoDB"
			+	"	AUTO_INCREMENT = 3"
			+	"	DEFAULT CHARACTER SET = utf8mb3;";

		String sqlTable5 =
				"	CREATE TABLE IF NOT EXISTS `travel_search`.`land_trip_has_city` "
			+	"  (`land_trip_id` INT(11) NOT NULL,"
			+	" `city_id` INT(11) NOT NULL,"
			+	"	PRIMARY KEY (`land_trip_id`, `city_id`),"
			+	"	INDEX `fk_city_has_land_trip_land_trip1_idx` (`land_trip_id` ASC) VISIBLE,"
			+	"			INDEX `fk_city_has_land_trip_city1_idx` (`city_id` ASC) VISIBLE,"
			+	"			CONSTRAINT `fk_city_has_land_trip_city1`"
			+	"	FOREIGN KEY (`city_id`)"
			+	"	REFERENCES `travel_search`.`city` (`city_id`)"
			+	"	ON DELETE CASCADE"
			+	"	ON UPDATE CASCADE,"
			+	"			CONSTRAINT `fk_city_has_land_trip_land_trip1`"
			+	"	FOREIGN KEY (`land_trip_id`)"
			+	"	REFERENCES `travel_search`.`land_trip` (`land_trip_id`)"
			+	"	ON DELETE CASCADE"
			+	"	ON UPDATE CASCADE)"
			+	"	ENGINE = InnoDB"
			+	"	DEFAULT CHARACTER SET = utf8mb3;";
		/*
			+	"	SET SQL_MODE=@OLD_SQL_MODE;"
			+	"	SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;"
			+	"	SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;";*/

		try {
			PreparedStatement ps = Databases.connector().prepareStatement(sql);
			ps.execute();
			PreparedStatement ps1 = Databases.connector().prepareStatement(sqlTable1);
			ps1.execute();
			PreparedStatement ps2 = Databases.connector().prepareStatement(sqlTable2);
			ps2.execute();
			PreparedStatement ps3 = Databases.connector().prepareStatement(sqlTable3);
			ps3.execute();
			PreparedStatement ps4 = Databases.connector().prepareStatement(sqlTable4);
			ps4.execute();
			PreparedStatement ps5 = Databases.connector().prepareStatement(sqlTable5);
			ps5.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}
