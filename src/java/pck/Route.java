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
    public String from;
    public String to;
    public String id="Route-";

    public Route(ArrayList<FlightInfo> flightInfoArray) {
        this.flightsOfRoute=flightInfoArray;
        from=this.flightsOfRoute.get(0).flight.from;
        to=this.flightsOfRoute.get(this.flightsOfRoute.size()-1).flight.to;
        for(FlightInfo f : flightInfoArray){
            id+=f.id;
        }
    }
    
    public void add(FlightInfo fi){
        flightsOfRoute.add(fi);
        id+=fi.id;
    }
    
    public FlightInfo get(int position){
        return flightsOfRoute.get(position);
    }
    
    public int size(){
        return flightsOfRoute.size();
    }
    
    
    
    
}
