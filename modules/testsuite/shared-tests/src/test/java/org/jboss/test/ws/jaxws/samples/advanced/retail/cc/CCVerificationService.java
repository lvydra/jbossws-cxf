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
package org.jboss.test.ws.jaxws.samples.advanced.retail.cc;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceFeature;

/**
 * This class was generated by the JAXWS SI.
 * JAX-WS RI 2.1-10/21/2006 12:56 AM(vivek)-EA2
 * Generated source version: 2.0
 *
 */
@WebServiceClient(name = "CCVerificationService", targetNamespace = "http://org.jboss.ws/samples/retail/cc", wsdlLocation = "resources/jaxws/samples/retail/META-INF/wsdl/CCVerificationService.wsdl")
public class CCVerificationService
    extends Service
{

    private final static URL CCVERIFICATIONSERVICE_WSDL_LOCATION;

    static {
        URL url = null;
        try {
            url = new URL("http://somehost:8080/jaxws-samples-retail/CCVerificationBean?wsdl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        CCVERIFICATIONSERVICE_WSDL_LOCATION = url;
    }

    public CCVerificationService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CCVerificationService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
       super(wsdlLocation, serviceName, features);
   }

    public CCVerificationService() {
        super(CCVERIFICATIONSERVICE_WSDL_LOCATION, new QName("http://org.jboss.ws/samples/retail/cc", "CCVerificationService"));
    }

    /**
     *
     * @return
     *     returns CCVerification
     */
    @WebEndpoint(name = "CCVerificationPort")
    public CCVerification getCCVerificationPort() {
        return (CCVerification)super.getPort(new QName("http://org.jboss.ws/samples/retail/cc", "CCVerificationPort"), CCVerification.class);
    }
}
