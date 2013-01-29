/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pck;

import java.util.ArrayList;
import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author alfredo
 */
@WebService(serviceName = "itinerary")
@HandlerChain(file = "handler-chain.xml")
public class itinerary {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getItinerary")
    public ArrayList<FlightsList> getItinerary(@WebParam(name = "from") String from, @WebParam(name = "to") String to, @WebParam(name = "tokenid") String tokenid) throws AuthenticationException {
        
        if(!Authenticator.Autheticate(tokenid)){
            throw new AuthenticationException();
        }
        
        
        ArrayList<FlightsList> listOfLinks = Flight.getDirectFlights(from, to);
        if (listOfLinks.isEmpty()) {
            listOfLinks = Flight.getIndirectFlights(from, to);
        }
        /*
         if(listOfLinks.isEmpty()){
         listOfLinks = new ArrayList<FlightsList>();
         }
         */
        return listOfLinks;
    }
}
