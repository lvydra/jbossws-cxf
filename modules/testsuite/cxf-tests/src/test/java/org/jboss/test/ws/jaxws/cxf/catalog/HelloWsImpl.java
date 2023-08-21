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
package org.jboss.test.ws.jaxws.cxf.catalog;

import org.jboss.test.ws.jaxws.cxf.catalog.HelloRequest;
import org.jboss.test.ws.jaxws.cxf.catalog.HelloResponse;
import org.jboss.test.ws.jaxws.cxf.catalog.HelloWs;

import jakarta.jws.WebService;

@WebService(wsdlLocation = "META-INF/wsdl/HelloService.wsdl",
   name = org.jboss.test.ws.jaxws.cxf.catalog.HelloWs.NAME,
   serviceName = org.jboss.test.ws.jaxws.cxf.catalog.HelloWs.NAME,
   targetNamespace = org.jboss.test.ws.jaxws.cxf.catalog.HelloWs.TARGET_NAMESPACE,
   endpointInterface = "org.jboss.test.ws.jaxws.cxf.catalog.HelloWs")
public class HelloWsImpl implements HelloWs {
   public HelloResponse doHello(HelloRequest request) {
      HelloResponse response = new HelloResponse();
      response.getMultiHello().add(request.getInput());
      response.getMultiHello().add("world");
      return response;
   }
}
