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
@WebService(serviceName = "getToken")
public class getToken {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getTkn")
    public String getTkn(@WebParam(name = "usr") String usr, @WebParam(name = "pwd") String pwd) {
        //TODO write your implementation code here:
        for(User u : DB.users){
            if(u.username.equals(usr)&& u.password.equals(pwd)){
                return (new Token().id);
            }
        }
       
        return "INVALID USERNAME OR PASSWORD";
      
    }

}
