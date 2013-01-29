/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pck;

import java.util.Iterator;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;
import org.w3c.dom.NodeList;

public class AuthenticationHandler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        System.out.println("Server : handleMessage()......");

        Boolean isRequest = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        //for response message only, true for outbound messages, false for inbound
        if (!isRequest) {

            try {
                SOAPMessage soapMsg = context.getMessage();
                SOAPEnvelope soapEnv = soapMsg.getSOAPPart().getEnvelope();
                SOAPHeader soapHeader = soapEnv.getHeader();

                //if no header, add one
                if (soapHeader == null) {
                    soapHeader = soapEnv.addHeader();
                    //throw exception
                    generateSOAPErrMessage(soapMsg, "No SOAP header.");
                }

                Iterator allAttributes = soapHeader.getChildElements();

                System.out.println("abccahgtjahg" + allAttributes.toString() + allAttributes.hasNext());

                while (allAttributes.hasNext()) {
                    Node qname = (Node) allAttributes.next();
                    System.out.println(qname.getNodeName());
                    if (qname.getNodeName().equals("wsse:Security")) {
                        NodeList childNodes = qname.getChildNodes();
                        int length = childNodes.getLength();
                        System.out.println("length\n:" + length);
                        for (int i = 0; i < length; i++) {
                            org.w3c.dom.Node item = childNodes.item(i);
                            System.out.println(item.getNodeName());
                            if (item.getNodeName().equals("wsse:Username")) {
                                System.out.println(item.getTextContent());
                            }
                            if (item.getNodeName().equals("wsse:Password")) {
                                System.out.println(item.getTextContent());
                            }
                            //check username and pwd
                            //if not valid:
                            //throw exception
                            //generateSOAPErrMessage(soapMsg, "No SOAP header.");
                            

                        }
                    }
                    //System.out.println("aaaaaaaaaaaa +++" + qname.toString() +"    " + qname.getNodeName());

                }
            } catch (SOAPException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {

        System.out.println("Server : handleFault()......");

        return true;
    }

    @Override
    public void close(MessageContext context) {
        System.out.println("Server : close()......");
    }

    @Override
    public Set<QName> getHeaders() {
        System.out.println("Server : getHeaders()......");
        return null;
    }

    private void generateSOAPErrMessage(SOAPMessage msg, String reason) {
        try {
            SOAPBody soapBody = msg.getSOAPPart().getEnvelope().getBody();
            SOAPFault soapFault = soapBody.addFault();
            soapFault.setFaultString(reason);
            throw new SOAPFaultException(soapFault);
        } catch (SOAPException e) {
        }
    }
}