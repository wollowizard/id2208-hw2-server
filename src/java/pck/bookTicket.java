/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pck;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
        DateFormat format;
        Date myDate=null;
        format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            myDate = (Date) format.parse(date);
            /*int IDate, IMonth, IYear;
            IDate = Integer.parseInt(date.split("/")[0]);
            IMonth = Integer.parseInt(date.split("/")[1]);
            IYear = Integer.parseInt(date.split("/")[2]);
            Date myDate = new Date(IYear, IMonth, IDate);*/
        } catch (ParseException ex) {
            Logger.getLogger(bookTicket.class.getName()).log(Level.SEVERE, null, ex);
        }

        ArrayList<FlightsList> listOfLinks = Flight.getDirectFlights(from, to);
        if (listOfLinks.isEmpty()) {
            listOfLinks = Flight.getIndirectFlights(from, to);
        }
        
        ArrayList<FlightInfo> flightinfoarr=new ArrayList<FlightInfo>(); 
        if (!listOfLinks.isEmpty()) {
            FlightsList myFl = null;
            
            for (FlightsList fl : listOfLinks) {
                System.out.println(fl.id + " - " + flightsId);
                if (fl.id.equals(flightsId)) {
                    myFl = fl;
                    break;
                }
            }
            for (Flight f : myFl.list) {
                FlightInfo fi = FlightInfo.getFlightInfo(f);
                System.out.println("DATE: "+fi.date.toString() + "\nMYDATE: "+myDate.toString());
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
