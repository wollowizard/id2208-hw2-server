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

    public static ArrayList<Route> getDirectFlights(String from, String to) {
        
        ArrayList<Route> list = new ArrayList<Route>();
        
        for (Flight flight : DB.flights) {
            
            if (flight.from.equals(from) && flight.to.equals(to)) {
                Route r = new Route();
                r.flightsOfRoute.add(flight);
                list.add(r);
            }
        }
        return list;

    }

    public static ArrayList<Route> getIndirectFlights(String from, String to) {
        ArrayList<Route> list = new ArrayList<Route>();
        for (Iterator<Flight> it1 = DB.flights.iterator(); it1.hasNext();) {
            Route route = new Route();
            Flight flight1 = it1.next();
            if (flight1.from.equals(from)) {
                String through = flight1.to;
                for (Iterator<Flight> it2 = DB.flights.iterator(); it2.hasNext();) {
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

    //Printing Functions
    public void printItineraries(ArrayList<Flight> list) {
    }

    public void printFlightsInfo(ArrayList<Flight> list) {
    }
}
