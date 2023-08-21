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
package org.jboss.test.ws.jaxws.jbws1694;

import org.jboss.ws.api.annotation.WebContext;

import jakarta.ejb.Stateless;
import jakarta.jws.WebService;
import jakarta.xml.ws.Holder;

/**
 * @author Heiko.Braun@jboss.com
 */
@WebService(endpointInterface = "org.jboss.test.ws.jaxws.jbws1694.JBWS1694EndpointSEI")
@Stateless
@WebContext(contextRoot = "jbws1694")
public class JBWS1694Endpoint implements JBWS1694EndpointSEI
{
    public Receipt submitBasket(

               Holder<Header> header,

               Basket request) 
      throws Exception
    {
       if(null==header)
         throw new IllegalArgumentException("inout header was null");

       Receipt receipt = new Receipt();
       receipt.setMsg(header.value.getUuid());
       return receipt;
    }
}
