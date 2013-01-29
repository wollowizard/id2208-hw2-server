/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pck;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author alfredo
 */
public class Token {

    public String id;
    public Date validTo;

    public Token() {
        //it is unique
        id = UUID.randomUUID().toString();

        Calendar cal = Calendar.getInstance();
        cal.getTime();
        cal.add(Calendar.MINUTE, 60);
        validTo = cal.getTime();
        
        DB.tokens.add(this);
    }
}
