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
package org.jboss.test.ws.jaxws.samples.webservice;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

/**
 * Test the JSR-181 jakarta.jws.WebService on a JSE endpoint.
 *
 * Uses the wsdlLocation attribute.
 * 
 * @author Thomas.Diesler@jboss.org
 * @since 29-Apr-2005
 */
@WebService(name = "EndpointInterface", targetNamespace = "http://www.openuri.org/2004/04/HelloWorld", serviceName = "EndpointService", wsdlLocation = "WEB-INF/wsdl/TestService.wsdl")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class JSEBean02
{
   @WebMethod
   public String echo(String input)
   {
      return input;
   }
}
