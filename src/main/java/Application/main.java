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

	public static void wellcome() {
		
		
		System.out.println("\n" +"\n" +"\n" +"** Wellcome to On Line Travel Agency **" +  "\n" +
				"the app wil search for trips that include your selected citi" + "\n");
				
		city = captureString("please enter at least 3 letters to execute search");	
		
		if(city.length() < 3) {
			
			do {
				city = captureString("please enter at least 3 letters to execute search");	
			}while (city.length() < 3 );
		}
				pruebas(city);
	}

	public static void pruebas(String city) {

		try {
			iService = new ImplService();
			iService.createAirTripList(city);
			iService.createLandTripList(city);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	public static String captureString(String mensaje) {
		inputKey = new Scanner(System.in);
		System.out.println(mensaje);
		return inputKey.nextLine();
	}
	
}
