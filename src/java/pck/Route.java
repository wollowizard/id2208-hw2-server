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
    
       
    public ArrayList<FlightInfo> flightsOfRoute;
    public String id="Route-";

    public Route() {
        flightsOfRoute=new ArrayList<FlightInfo>();
        for(FlightInfo f : flightsOfRoute){
            id+=f.id;
        }
    }
    
    public void add(FlightInfo flight){
        flightsOfRoute.add(flight);
    }
    
    public FlightInfo get(int position){
        return flightsOfRoute.get(position);
    }
    
    public int size(){
        return flightsOfRoute.size();
    }
    
    
    
}
