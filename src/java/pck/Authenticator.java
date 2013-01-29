/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pck;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author alfredo
 */
public class Authenticator {

    public static Boolean Autheticate(String tokeind) {
        removeOldTokens();
        
        for (Token t : DB.tokens) {
            if (t.id.equals(tokeind)) {
                if (t.validTo.after(new Date())) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;

    }

    public static void removeOldTokens() {
        ArrayList<Token> tokensToRemove = new ArrayList<Token>();
        for (Token t : DB.tokens) {
            //discard invalid tokens
            if (t.validTo.before(new Date())) {
                tokensToRemove.add(t);
            }
        }
        for (Token remo : tokensToRemove) {
            DB.tokens.remove(remo);
        }
    }
}
