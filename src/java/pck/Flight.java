/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pck;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author alfredo
 */
public class Flight {

    public String from;
    public String to;

    public Flight(String from, String to) {

        this.from = from;
        this.to = to;
    }

    public static ArrayList<FlightsList> getDirectFlights(String from, String to) {
        //FlightsList itinerary = new FlightsList();
        ArrayList<FlightsList> list = new ArrayList<FlightsList>();
        for (Flight flight : DB.flights) {
            FlightsList itinerary = new FlightsList();
            if (flight.from.equals(from) && flight.to.equals(to)) {
                itinerary.add(flight);
                list.add(itinerary);
            }
        }
        return list;
    }

    public static ArrayList<FlightsList> getIndirectFlights(String from, String to) {
        FlightsList itinerary = new FlightsList();
        ArrayList<FlightsList> list = new ArrayList<FlightsList>();

        for (Flight flight1 : DB.flights) {
            if (flight1.from.equals(from)) {
                String through = flight1.to;
                for (Flight flight2 : DB.flights) {
                    if (flight2.to.equals(to) && flight2.from.equals(through)) {
                        itinerary.add(flight1);
                        itinerary.add(flight2);
                        list.add(itinerary);
                        break;
                    }
                }
                itinerary = new FlightsList();
            }
        }
        return list;
    }

    //Printing Functions
    public void printItineraries(ArrayList<Flight> list) {
    }

    public void printFlightsInfo(ArrayList<Flight> list) {
    }
}