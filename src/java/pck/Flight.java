/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pck;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author alfredo
 */
public class Flight {

    public static ArrayList<Flight> flights = new ArrayList<Flight>();
    public String id = "Flight-";
    public String from;
    public String to;
    public Date date;
    public Integer freeplaces;
    public Double price;

    public Flight(String from, String to, Date date, Integer freeplaces, Double price) {

        id = from + to + date.toString();

        this.from = from;
        this.to = to;
        this.date = date;
        this.freeplaces = freeplaces;
        this.price = price;
    }

    public static void populate() {
        Flight f = new Flight("Barcelona", "Stockholm",
                new Date(2013, 2, 5), 100, 120.0);
        flights.add(f);

        f = new Flight("Barcelona", "Rome",
                new Date(2013, 2, 5), 100, 110.0);
        flights.add(f);

        f = new Flight("Rome", "Berlin",
                new Date(2013, 2, 5), 90, 150.0);
        flights.add(f);

        f = new Flight("Berlin", "Paris",
                new Date(2013, 2, 5), 100, 125.5);
        flights.add(f);

        f = new Flight("Rome", "Barcelona",
                new Date(2013, 2, 5), 100, 120.0);
        flights.add(f);

        f = new Flight("Barcelona", "Madrid",
                new Date(2013, 2, 5), 100, 120.0);
        flights.add(f);

        f = new Flight("Stockholm", "Barcelona",
                new Date(2013, 2, 5), 100, 120.0);
        flights.add(f);

    }

    /*
     * 
     public static ArrayList<Route> getDirectFlights(String from, String to) {
     ArrayList<Route> list = new ArrayList<Route>();

     for (Iterator<Flight> it = flights.iterator(); it.hasNext();) {
     Flight flight = it.next();
     if (flight.from.equals(from) && flight.to.equals(to)) {
     Route r = new Route();
     r.flightsOfRoute.add(flight);
     list.add(r);
     }
     }
     return list;
     }
     */
    public static ArrayList<ArrayList<Flight>> getDirectFlights(String from, String to) {
        ArrayList<Flight> itinerary = new ArrayList<Flight>();
        ArrayList<ArrayList<Flight>> list = new ArrayList<ArrayList<Flight>>();

        for (Flight flight : DB.flights) {
            if (flight.from.equals(from) && flight.to.equals(to)) {
                itinerary.add(flight);
                list.add(itinerary);
            }
        }
        return list;
    }

    public static ArrayList<ArrayList<Flight>> getIndirectFlights(String from, String to) {
        ArrayList<Flight> itinerary = new ArrayList<Flight>();
        ArrayList<ArrayList<Flight>> list = new ArrayList<ArrayList<Flight>>();

        for (Flight flight1 : DB.flights) {
            if (flight1.from.equals(from)) {
                String through = flight1.to;
                for (Flight flight2 : DB.flights){
                    if(flight2.to.equals(to)){
                        itinerary.add(flight1);
                        itinerary.add(flight2);
                        list.add(itinerary);
                    }
                }
            }
        }
        return list;
    }

    /*
     * public static ArrayList<Route> getIndirectFlights(String from, String to) {
     ArrayList<Route> list = new ArrayList<Route>();
     for (Iterator<Flight> it1 = flights.iterator(); it1.hasNext();) {
     Route route = new Route();
     Flight flight1 = it1.next();
     if (flight1.from.equals(from)) {
     String through = flight1.to;
     for (Iterator<Flight> it2 = flights.iterator(); it2.hasNext();) {
     Flight flight2 = it2.next();
     if (flight2.from.equals(through) && flight2.to.equals(to)) {
     route.add(flight1);
     route.add(flight2);
     list.add(route);
     }
     }
     }
     }
     return list;
     }
     * 
     * 
     */
    //Printing Functions
    public void printItineraries(ArrayList<Flight> list) {
    }

    public void printFlightsInfo(ArrayList<Flight> list) {
    }
}
