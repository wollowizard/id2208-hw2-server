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
        this.flightsOfRoute=new ArrayList<FlightInfo>();
        id="Route-";
        /*for(FlightInfo f : flightsOfRoute){
            id+=f.id;
        }*/
    }
    
    public void add(FlightInfo flight){
        flightsOfRoute.add(flight);
        id+=flight.id;
    }
    
    public FlightInfo get(int position){
        return flightsOfRoute.get(position);
    }
    
    public int size(){
        return flightsOfRoute.size();
    }
    
    
    
}
