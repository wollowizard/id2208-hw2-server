/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pck;

import java.util.ArrayList;

/**
 *
 * @author alfredo
 */
public class Ticket {
    
    public static ArrayList<Ticket> TicketDB= new ArrayList<Ticket>();
    static Integer count=0;
    
    public String id;
    public Route theroute;
    public String cardNo;
    public Ticket(Route r, String cardNumber){
        this.id="ticket" + count;    
        this.theroute=r;
        this.cardNo=cardNumber;
    }
    
    
    
    
}
