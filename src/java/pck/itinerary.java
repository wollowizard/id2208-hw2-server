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
@HandlerChain(file="handler-chain.xml")
public class itinerary {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getItinerary")
    public ArrayList<FlightsList> getItinerary(@WebParam(name = "from") String from, @WebParam(name = "to") String to) {
        /*ArrayList<ArrayList<Flight>> arr=Flight.getDirectFlights(from, to);
        if(arr.isEmpty()){
            arr=Flight.getIndirectFlights(from, to);
        }
        return arr;*/
        
        ArrayList<FlightsList> listOfLinks = Flight.getDirectFlights(from, to);
        if(listOfLinks.isEmpty()){
            listOfLinks=Flight.getIndirectFlights(from, to);
        }
        return listOfLinks;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "operation")
    public ArrayList<ArrayList<String>> operation(@WebParam(name = "from") String from, @WebParam(name = "to") String to) {
        //TODO write your implementation code here:
        ArrayList<String> arr = new ArrayList<String>();
        arr.add(from);
        arr.add(to);
        arr.add(from);
        arr.add(to);
        ArrayList<ArrayList<String>> arr2 = new ArrayList<ArrayList<String>>();
        arr2.add(arr);
        arr2.add(arr);
        return arr2;
    }
}

/*
 * @WebMethod(operationName = "getItinerary")
    public ArrayList<Route> getItinerary(@WebParam(name = "from") String from, @WebParam(name = "to") String to) {
        
        ArrayList<Route> arr=Flight.getDirectFlights(from, to);
        if(arr.isEmpty()){
            arr=Flight.getIndirectFlights(from, to);
        }
        return arr;
        
    }
 */
