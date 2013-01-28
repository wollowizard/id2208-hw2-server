/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pck;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author alfredo
 */
public class Flight implements Serializable {

    public static ArrayList<Flight> flights = new ArrayList<Flight>();
    public String from;
    public String to;
    public Date date;
    public Integer freeplaces;
    public Double price;

    public Flight(String from, String to, Date date, Integer freeplaces, Double price) {
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

    public ArrayList<Flight> getDirectFlights(String from, String to) {
        ArrayList<Flight> list = new ArrayList<Flight>();
        for (Iterator<Flight> it = flights.iterator(); it.hasNext();) {
            Flight flight = it.next();
            if (flight.from.equals(from) && flight.to.equals(to)) {
                list.add(flight);
            }
        }
        return list;

    }

    public ArrayList<Route> getIndirectFlights(String from, String to) {
        ArrayList<Flight> list = new ArrayList<Flight>();
        for (Iterator<Flight> it1 = flights.iterator(); it1.hasNext();) {
            Flight flight1 = it1.next();
            if (flight1.from.equals(from)) {
                String through = flight1.to;
                for (Iterator<Flight> it2 = list.iterator(); it2.hasNext();) {
                    Flight flight2 = it2.next();
                    if (flight2.from.equals(through) && flight2.to.equals(to)) {
                        list.add(flight1);
                        list.add(flight2);
                    }
                }
            }
        }
        return list;
    }
    
    //Printing Functions
    public void printItineraries(ArrayList<Flight> list){
        
    }
    
    public void printFlightsInfo(ArrayList<Flight> list){
        
    }
    
}