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
@WebService(serviceName = "bookTicket")
@Stateless()
public class bookTicket {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "book")
    public String book(@WebParam(name = "route") Route route, @WebParam(name = "cardNumber") String cardNumber) {

        for (FlightInfo f : route.flightsOfRoute) {
            f.freeplaces--;
        }
        Ticket ticket = new Ticket(route, cardNumber);
        DB.TicketDB.add(ticket);

        return ticket.id;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "book2")
    public Ticket book2(@WebParam(name = "from") String from, @WebParam(name = "to") String to, @WebParam(name = "date") String date, @WebParam(name = "cardNumber") String cardNumber) {
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

        for (FlightInfo f : route.flightsOfRoute) {
            f.freeplaces--;
        }
        Ticket ticket = new Ticket(route, cardNumber);
        DB.TicketDB.add(ticket);
        
        //return ticket.id;
        return ticket;
    }
}
