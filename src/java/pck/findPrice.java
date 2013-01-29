/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pck;

import java.util.ArrayList;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Gerard
 */
@WebService(serviceName = "findPrice")
@Stateless()
public class findPrice {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findPrice")
    public Route findPrice(@WebParam(name = "flights") FlightsList flights, @WebParam(name = "date") String date) {
        //TODO write your implementation code here:
        int IDate, IMonth, IYear;
        IDate = Integer.parseInt(date.split("/")[0]);
        IMonth = Integer.parseInt(date.split("/")[1]);
        IYear = Integer.parseInt(date.split("/")[2]);
        Date myDate = new Date(IYear, IMonth, IDate);

        Route route = new Route();
        for (Flight f : flights.list) {
            FlightInfo fi = FlightInfo.getFlightInfo(f);
            if (fi.date.equals(myDate)) {
                route.add(fi);
            }
        }
        return route;
    }

    @WebMethod(operationName = "findPrice2")
    public Route findPrice2(@WebParam(name = "from") String from, @WebParam(name = "to") String to, @WebParam(name = "date") String date) {
        int IDate, IMonth, IYear;
        IDate = Integer.parseInt(date.split("/")[0]);
        IMonth = Integer.parseInt(date.split("/")[1]);
        IYear = Integer.parseInt(date.split("/")[2]);
        Date myDate = new Date(IYear, IMonth, IDate);

        ArrayList<FlightsList> listOfLinks = Flight.getDirectFlights(from, to);
        if (listOfLinks.isEmpty()) {
            listOfLinks = Flight.getIndirectFlights(from, to);
        }
        //We use the first FlightsList of the ListOfLinks
        //Will there be more than possible FlightsList for the same tuple from/to???
        Route route = new Route();

        if (!listOfLinks.isEmpty()) {
            FlightsList flights = listOfLinks.get(0);
            for (Flight f : flights.list) {
                FlightInfo fi = FlightInfo.getFlightInfo(f);
                if (fi.date.equals(myDate)) {
                    route.add(fi);
                }
            }
        }

        return route;
    }
    /*
     @WebMethod(operationName = "find")
     public Route find(@WebParam(name = "flight1") Flight flight1, @WebParam(name = "flight2") Flight flight2, @WebParam(name = "date") Date date) {
     Route route = new Route();
     FlightInfo fi = FlightInfo.getFlightInfo(flight1);
     route.add(fi);
        
     if(flight2!=null){
     fi = FlightInfo.getFlightInfo(flight2);
     route.add(fi);
     }
     return route;
     }*/
    /**
     * Web service operation
     */
}
