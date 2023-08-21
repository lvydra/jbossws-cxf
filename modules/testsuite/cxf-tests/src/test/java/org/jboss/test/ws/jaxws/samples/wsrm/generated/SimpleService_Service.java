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
package org.jboss.test.ws.jaxws.samples.wsrm.generated;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import org.jboss.test.ws.jaxws.samples.wsrm.generated.SimpleService;

/**
 * This class was generated by Apache CXF (incubator) 2.0.5-incubator
 * Wed Apr 16 14:19:06 CEST 2008
 * Generated source version: 2.0.5-incubator
 */
@WebServiceClient
(
    name = "SimpleService",
    targetNamespace = "http://www.jboss.org/jbossws/ws-extensions/wsrm",
    wsdlLocation = "file:/home/opalka/TODO/TUTORIAL/cxf/step1/java2wsdl/generated/wsdl/SimpleService.wsdl"
)
public class SimpleService_Service extends Service {

    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("http://www.jboss.org/jbossws/ws-extensions/wsrm", "SimpleService");
    public final static QName SimpleServicePort = new QName("http://www.jboss.org/jbossws/ws-extensions/wsrm", "SimpleServicePort");
    static
    {
        URL url = null;
        try
        {
            url = new URL("file:/home/opalka/TODO/TUTORIAL/cxf/step1/java2wsdl/generated/wsdl/SimpleService.wsdl");
        }
        catch (MalformedURLException e)
        {
            System.err.println("Can not initialize the default wsdl from file:/home/opalka/TODO/TUTORIAL/cxf/step1/java2wsdl/generated/wsdl/SimpleService.wsdl");
            // e.printStackTrace();
        }
        WSDL_LOCATION = url;
    }

    public SimpleService_Service(URL wsdlLocation)
    {
        super(wsdlLocation, SERVICE);
    }

    public SimpleService_Service(URL wsdlLocation, QName serviceName)
    {
        super(wsdlLocation, serviceName);
    }

    public SimpleService_Service()
    {
        super(WSDL_LOCATION, SERVICE);
    }

    @WebEndpoint(name = "SimpleServicePort")
    public SimpleService getSimpleServicePort()
    {
        return super.getPort(SimpleServicePort, SimpleService.class);
    }

}
