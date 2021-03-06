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
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

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
    public Route findPrice(@WebParam(name = "from") String from, @WebParam(name = "to") String to,
            @WebParam(name = "flightsId") String flightsId, @WebParam(name = "date") String date, @WebParam(name = "tokenid") String tokenid) throws AuthenticationException {

        
        if (!Authenticator.Autheticate(tokenid)) {
            throw new AuthenticationException();
        }
        DateFormat format;
        Date myDate = null;
        Route route=null;
        
        format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            myDate = (Date) format.parse(date);

            ArrayList<FlightsList> listOfLinks = Flight.getDirectFlights(from, to);
            if (listOfLinks.isEmpty()) {
                listOfLinks = Flight.getIndirectFlights(from, to);
            }
            ArrayList<FlightInfo> flights = new ArrayList<FlightInfo>();
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
                    System.out.println("DATE " + fi.date.toString());
                    System.out.println("MYDATE " + myDate.toString());
                    if (fi.date.equals(myDate)) {
                        flights.add(fi);
                    }
                }
            }
            route = new Route(flights);

        } catch (ParseException ex) {
            route=new Route(new ArrayList<FlightInfo>());
        }


        return route;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findPrice2")
    public Route findPrice2(@WebParam(name = "flights") FlightsList flights, @WebParam(name = "date") String date, @WebParam(name = "tokenid") String tokenid) throws AuthenticationException {

        if (!Authenticator.Autheticate(tokenid)) {
            throw new AuthenticationException();
        }
        //TODO write your implementation code here:
        int IDate, IMonth, IYear;
        IDate = Integer.parseInt(date.split("/")[0]);
        IMonth = Integer.parseInt(date.split("/")[1]);
        IYear = Integer.parseInt(date.split("/")[2]);
        Date myDate = new Date(IYear, IMonth, IDate);


        ArrayList<FlightInfo> flightsInfoArr = new ArrayList<FlightInfo>();
        for (Flight f : flights.list) {
            FlightInfo fi = FlightInfo.getFlightInfo(f);
            if (fi.date.equals(myDate)) {
                flightsInfoArr.add(fi);
            }
        }
        Route route = new Route(flightsInfoArr);
        return route;
    }
}
