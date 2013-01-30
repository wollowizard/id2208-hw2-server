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
    public Ticket book(@WebParam(name = "from") String from, @WebParam(name = "to") String to, @WebParam(name = "flightsId") String flightsId,
    @WebParam(name = "date") String date, @WebParam(name = "cardNumber") String cardNumber, @WebParam(name = "tokenid") String tokenid) throws AuthenticationException {
       
        if(!Authenticator.Autheticate(tokenid)){
            throw new AuthenticationException();
        }
        
        int IDate, IMonth, IYear;
        IDate = Integer.parseInt(date.split("/")[0]);
        IMonth = Integer.parseInt(date.split("/")[1]);
        IYear = Integer.parseInt(date.split("/")[2]);
        Date myDate = new Date(IYear, IMonth, IDate);

        ArrayList<FlightsList> listOfLinks = Flight.getDirectFlights(from, to);
        if (listOfLinks.isEmpty()) {
            listOfLinks = Flight.getIndirectFlights(from, to);
        }
        
        ArrayList<FlightInfo> flightinfoarr=new ArrayList<FlightInfo>(); 
        if (!listOfLinks.isEmpty()) {
            FlightsList myFl = null;
            
            for (FlightsList fl : listOfLinks) {
                if (fl.id.equals(flightsId)) {
                    myFl = fl;
                    break;
                }
            }
            for (Flight f : myFl.list) {
                FlightInfo fi = FlightInfo.getFlightInfo(f);
                if (fi.date.equals(myDate)) {
                    flightinfoarr.add(fi);
                }
            }
        }
        Route route = new Route(flightinfoarr);

        for (FlightInfo f : route.flightsOfRoute) {
            f.freeplaces--;
        }
        Ticket ticket = new Ticket(route, cardNumber);
        DB.TicketDB.add(ticket);
        
        //return ticket.id;
        return ticket;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "book2")
    public String book2(@WebParam(name = "route") Route route, @WebParam(name = "cardNumber") String cardNumber, @WebParam(name = "tokenid") String tokenid) throws AuthenticationException {
        
        if(!Authenticator.Autheticate(tokenid)){
            throw new AuthenticationException();
        }

        for (FlightInfo f : route.flightsOfRoute) {
            f.freeplaces--;
        }
        Ticket ticket = new Ticket(route, cardNumber);
        DB.TicketDB.add(ticket);

        return ticket.id;
    }

}
