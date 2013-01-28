/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pck;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author alfredo
 */
@WebService(serviceName = "itinerary")
public class itinerary {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getItinerary")
    public ArrayList<Route> getItinerary(@WebParam(name = "from") String from, @WebParam(name = "to") String to) {
        ArrayList<Route> arr=Flight.getDirectFlights(from, to);
        if(arr.isEmpty()){
            arr=Flight.getIndirectFlights(from, to);
        }
        return arr;
        
    }
}
