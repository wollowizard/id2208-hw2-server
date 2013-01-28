/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pck;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author alfredo
 */
@WebService(serviceName = "getFlight")
public class getFlight {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "operation")
    public Flight operation(@WebParam(name = "parameter") String parameter, @WebParam(name = "parameter1") String parameter1) {
        //TODO write your implementation code here:
        
        
        
        return null;
    }
}