/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pck;

import java.util.Date;

/**
 *
 * @author alfredo
 */
public class FlightInfo {

    public Date date;
    public Integer freeplaces;
    public Double price;
    Flight flight;
    String id = "Flight-";

    public FlightInfo(Date date, Integer freeplaces, Double price, Flight f) {

        this.flight = f;
        id = f.from + f.to + date.toString();
        this.date = date;
        this.freeplaces = freeplaces;
        this.price = price;

    }
}
