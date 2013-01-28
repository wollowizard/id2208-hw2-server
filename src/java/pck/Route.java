/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pck;

import java.util.ArrayList;

/**
 *
 * @author alfredo
 */
public class Route {
    
    
    
    public ArrayList<Flight> flightsOfRoute;
    public String id="Route-";

    public Route() {
        flightsOfRoute=new ArrayList<Flight>();
        for(Flight f : flightsOfRoute){
            id+=f.id;
        }
    }
    
    public void add(Flight flight){
        flightsOfRoute.add(flight);
    }
    
    public Flight get(int position){
        return flightsOfRoute.get(position);
    }
    
    public int size(){
        return flightsOfRoute.size();
    }
    
    
    
}
