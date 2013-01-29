/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pck;

import java.util.ArrayList;

/**
 *
 * @author Gerard
 */
public class FlightsList {

    public ArrayList<Flight> list;
    public String id = "";

    /*  public FlightsList() {
     list = new ArrayList<Flight>();
       
     }*/
    public FlightsList(ArrayList<Flight> list) {
        this.list = list;
        for (Flight f : this.list) {
            id += f.from + f.to;
        }

    }

    public void add(Flight f) {
        list.add(f);
    }
}
