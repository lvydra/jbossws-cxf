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
package org.jboss.test.ws.jaxws.samples.eardeployment;

import jakarta.ejb.Stateless;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

import org.jboss.logging.Logger;

// Test that the wsdl can be read from the nested deployment
@WebService(name = "Endpoint", serviceName = "EndpointService", targetNamespace="http://eardeployment.jaxws/", wsdlLocation = "META-INF/wsdl/Endpoint.wsdl")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@Stateless
public class EJB3Bean
{
   private static Logger log = Logger.getLogger(EJB3Bean.class);

   @WebMethod
   @WebResult(name = "return")
   public String echo(@WebParam(name = "arg0") String input)
   {
      log.info("echo: " + input);
      return input;
   }
}
