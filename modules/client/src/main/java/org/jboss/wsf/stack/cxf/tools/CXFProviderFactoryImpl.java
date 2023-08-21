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
package org.jboss.wsf.stack.cxf.tools;

import org.jboss.ws.api.tools.WSContractProvider;
import org.jboss.ws.api.tools.WSContractProviderFactory;

/**
 * A WSContractProviderFactory for the CXF stack
 * 
 * @author alessio.soldano@jboss.com
 * @since 01-Feb-2009
 */
public class CXFProviderFactoryImpl implements WSContractProviderFactory
{
   public WSContractProvider createProvider(ClassLoader loader)
   {
      WSContractProvider metroProvider = new CXFProviderImpl();
      metroProvider.setClassLoader(loader);
      return metroProvider;
   }
}
