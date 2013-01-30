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
    public String flightsId = "";

    public Route() {
        this.flightsOfRoute=new ArrayList<FlightInfo>();
        id="Route-";
        /*for(FlightInfo f : flightsOfRoute){
            id+=f.id;
        }*/
    }
    
    public void add(FlightInfo fi){
        flightsOfRoute.add(fi);
        id+=fi.id;
        flightsId+=fi.flight.from;
        flightsId+=fi.flight.to;
    }
    
    public FlightInfo get(int position){
        return flightsOfRoute.get(position);
    }
    
    public int size(){
        return flightsOfRoute.size();
    }
    
    public String getFrom(){ 
        return flightsOfRoute.get(0).flight.from;
    }
    
    public String getTo(){
        int pos = flightsOfRoute.size() - 1;
        return flightsOfRoute.get(pos).flight.to;
    }
    
    public String getDate(){
        String date = flightsOfRoute.get(0).date.getDate()+"/"+
                flightsOfRoute.get(0).date.getMonth()+"/"+
                flightsOfRoute.get(0).date.getYear();
        return date;
    }
    
}
