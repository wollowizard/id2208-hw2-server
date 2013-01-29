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
                for (Flight flight2 : DB.flights) {
                    if (flight2.to.equals(to)) {
                        itinerary.add(flight1);
                        itinerary.add(flight2);
                        list.add(itinerary);
                    }
                }
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