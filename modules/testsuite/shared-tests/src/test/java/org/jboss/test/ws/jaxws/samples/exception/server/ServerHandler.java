/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jboss.test.ws.jaxws.samples.exception.server;

import java.util.Iterator;

import javax.xml.namespace.QName;
import jakarta.xml.soap.SOAPBody;
import jakarta.xml.soap.SOAPBodyElement;
import jakarta.xml.soap.SOAPElement;
import jakarta.xml.soap.SOAPMessage;
import jakarta.xml.ws.WebServiceException;
import jakarta.xml.ws.handler.soap.SOAPMessageContext;

import org.jboss.ws.api.handler.GenericSOAPHandler;

/**
 * A simple server side handler applying uppercase function to the error message strings.
 *
 * @author alessio.soldano@jboss.org
 * @since 12-Feb-2008
 */
public class ServerHandler extends GenericSOAPHandler<SOAPMessageContext>
{
   @Override
   public boolean handleFault(SOAPMessageContext msgContext)
   {
      try
      {
         SOAPMessage soapMessage = msgContext.getMessage();
         SOAPBody soapBody = soapMessage.getSOAPBody();
         SOAPBodyElement soapBodyElement = (SOAPBodyElement)soapBody.getChildElements().next();
         SOAPElement faultStringElement = (SOAPElement)soapBodyElement.getChildElements(new QName("faultstring")).next();
         faultStringElement.setValue(faultStringElement.getValue().toUpperCase());
         Iterator<?> itDetail = soapBodyElement.getChildElements(new QName("detail"));
         if (itDetail.hasNext())
         {
            Iterator<?> itException = ((SOAPElement)itDetail.next()).getChildElements(new QName("http://server.exception.samples.jaxws.ws.test.jboss.org/","UserException"));
            if (itException.hasNext())
            {
               SOAPElement messageElement = (SOAPElement)(((SOAPElement)itException.next()).getChildElements(new QName("message"))).next();
               messageElement.setValue(messageElement.getValue().toUpperCase());
            }
         }
      }
      catch (Exception e)
      {
         throw  new WebServiceException(e);
      }
      return true;
   }
}
