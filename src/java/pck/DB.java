/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pck;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author alfredo
 */
public class DB {

    public static ArrayList<Ticket> TicketDB = new ArrayList<Ticket>();
    public static ArrayList<Flight> flights = new ArrayList<Flight>();
    public static ArrayList<FlightInfo> flightsInfo = new ArrayList<FlightInfo>();
    public static ArrayList<User> users = new ArrayList<User>();
    
    public static ArrayList<Token> tokens=new ArrayList<Token>();

    static {
        DB.populate();
    }

    public static void populate() {
        Flight f = new Flight("Barcelona", "Stockholm");
        FlightInfo f1 = new FlightInfo(new Date(2013, 2, 5), 100, 120.0, f);
        flights.add(f);
        flightsInfo.add(f1);

        f = new Flight("Barcelona", "Rome");
        f1 = new FlightInfo(new Date(2013, 2, 5), 100, 110.0, f);
        flights.add(f);
        flightsInfo.add(f1);

        f = new Flight("Rome", "Berlin");
        f1 = new FlightInfo(new Date(2013, 2, 5), 90, 150.0, f);
        flights.add(f);
        flightsInfo.add(f1);

        f = new Flight("Berlin", "Paris");
        f1 = new FlightInfo(new Date(2013, 2, 5), 100, 125.5, f);
        flights.add(f);
        flightsInfo.add(f1);

        f = new Flight("Rome", "Barcelona");
        f1 = new FlightInfo(new Date(2013, 2, 5), 100, 120.0, f);
        flights.add(f);
        flightsInfo.add(f1);

        f = new Flight("Barcelona", "Madrid");

        f1 = new FlightInfo(new Date(2013, 2, 5), 100, 120.0, f);
        flights.add(f);
        flightsInfo.add(f1);

        f = new Flight("Stockholm", "Barcelona");
        f1 = new FlightInfo(new Date(2013, 2, 5), 100, 120.0, f);
        flights.add(f);
        flightsInfo.add(f1);
        
        users.add(new User("gerard", "1234"));
        users.add(new User("alfredo", "1234"));

    }
}
