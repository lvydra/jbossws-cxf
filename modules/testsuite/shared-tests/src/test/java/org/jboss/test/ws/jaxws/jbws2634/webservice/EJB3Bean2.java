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
package org.jboss.test.ws.jaxws.jbws2634.webservice;

import jakarta.ejb.Stateless;
import jakarta.jws.WebService;

import org.jboss.ws.api.annotation.WebContext;

/**
 * EJB3 bean published as WebService injecting other EJB3 bean.
 *
 * @author <a href="mailto:alessio.soldano@jboss.com">Alessio Soldano</a>
 */
@WebService
(
   name="EJB3",
   serviceName = "EJB3Service2", 
   targetNamespace = "http://jbossws.org/JBWS2634", 
   endpointInterface="org.jboss.test.ws.jaxws.jbws2634.webservice.EndpointIface"
)
@Stateless
@WebContext
(
   urlPattern = "/EJB3Service2",
   contextRoot = "/jaxws-jbws2634-ejb3"
)
public class EJB3Bean2 extends AbstractEndpointImpl
{

   public String echo(String msg)
   {
      return super.echo(msg) + ":EJB3Bean2";
   }

}
