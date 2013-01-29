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
 * @author alfredo
 */
@WebService(serviceName = "Issue")
@Stateless()
public class Issue {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "issueTicket")
    public Ticket issueTicket(@WebParam(name = "tck") String ticketId, @WebParam(name = "tokenid") String tokenid) throws AuthenticationException {
        
        if(!Authenticator.Autheticate(tokenid)){
            throw new AuthenticationException();
        }
        //TODO write your implementation code here:
        for(Ticket t : DB.TicketDB){
            if(ticketId.equals(t.id)){
                return t;
            }
        }
        return null;    
    }
}
