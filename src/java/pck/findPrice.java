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
    }
  
}
