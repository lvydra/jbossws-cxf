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
package org.jboss.test.ws.jaxws.calendar;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;

@WebService(targetNamespace = "http://org.jboss.ws/jaxws/calendar", name = "CalendarEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface CalendarEndpoint {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "echoXMLGregorianCalendar", targetNamespace = "http://org.jboss.ws/jaxws/calendar", className = "org.jboss.test.ws.jaxws.calendar.EchoXMLGregorianCalendar")
    @WebMethod
    @ResponseWrapper(localName = "echoXMLGregorianCalendarResponse", targetNamespace = "http://org.jboss.ws/jaxws/calendar", className = "org.jboss.test.ws.jaxws.calendar.EchoXMLGregorianCalendarResponse")
    public java.lang.Object echoXMLGregorianCalendar(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Object arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "echoCalendar", targetNamespace = "http://org.jboss.ws/jaxws/calendar", className = "org.jboss.test.ws.jaxws.calendar.EchoCalendar")
    @WebMethod
    @ResponseWrapper(localName = "echoCalendarResponse", targetNamespace = "http://org.jboss.ws/jaxws/calendar", className = "org.jboss.test.ws.jaxws.calendar.EchoCalendarResponse")
    public java.util.Calendar echoCalendar(
        @WebParam(name = "arg0", targetNamespace = "")
        java.util.Calendar arg0
    );
}
