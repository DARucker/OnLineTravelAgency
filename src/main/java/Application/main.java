package Application;

import java.sql.SQLException;
import java.util.Scanner;

import domain.AirTrip;
import domain.LandTrip;
import service.ImplService;
import service.Iservice;

public class main {

	private static Scanner inputKey;
	private static String city;
	
	private static Iservice iService;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		wellcome();
	}

	/**
	 * This method accepts the key letters to perform the search.
	 * The minimum number of letters to enter is 3, otherwise it
	 * will inform that you must enter a new search
	 */
	public static void wellcome() {
		
		
		System.out.println("\n" +"\n" +"\n" +"** Wellcome to On Line Travel Agency **" +  "\n" +
				"the app wil search for trips that include your selected citi" + "\n");
				
		city = captureString("please enter at least 3 letters to execute search or exit to finish: ");
		
		if(city.length() < 3) {
			
			do {
				city = captureString("please enter at least 3 letters to execute search or exit to finish: ");
			}while (city.length() < 3 );
		}
				App (city);
	}

	/**
	 * calls the methods that prepare the view with the data collected in the database
	 * @param city the input made by the user
	 */

	public static void App (String city) {

		if(city.equals("exit")){
			System.exit(0);
		}
		try {
			iService = new ImplService();
			iService.createAirTripList(city);
			iService.createLandTripList(city);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method captures the caracteres inserted by the user
 	 * @param message shows the message for the user
	 * @return the input made by the user through the keyboard
	 */
	public static String captureString(String message) {
		inputKey = new Scanner(System.in);
		System.out.println(message);
		return inputKey.nextLine();
	}
}
