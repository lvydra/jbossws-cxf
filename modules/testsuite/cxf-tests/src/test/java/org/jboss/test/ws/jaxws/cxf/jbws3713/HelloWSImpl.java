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
package org.jboss.test.ws.jaxws.cxf.jbws3713;

import jakarta.jws.WebService;

@WebService(wsdlLocation = "WEB-INF/wsdl/Hello.wsdl",
            name = HelloWs.NAME,
            serviceName = HelloWs.NAME,
            targetNamespace = HelloWs.TARGET_NAMESPACE,
            endpointInterface = "org.jboss.test.ws.jaxws.cxf.jbws3713.HelloWs")
public class HelloWSImpl implements HelloWs
{

   public HelloResponse doHello(HelloRequest request)
   {
      HelloResponse response = new HelloResponse();
      response.getMultiHello().add(request.getInput());
      response.getMultiHello().add("world");
      return response;
   }

}
