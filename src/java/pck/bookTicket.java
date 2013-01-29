/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pck;

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
        for (Flight f : route.flightsOfRoute){
            f.freeplaces--;
        }
        Ticket ticket = new Ticket(route, cardNumber);  
        DB.TicketDB.add(ticket);
        
        return ticket.id;
    }
}
