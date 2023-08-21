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
package org.jboss.test.ws.jaxws.jbws1798.generated;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;

/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.1-b03-
 * Generated source version: 2.0
 */
@WebService(name = "ServiceType", targetNamespace = "http://jbws1798.jaxws.ws.test.jboss.org/")
public interface ServiceType {


    /**
     * 
     * @return
     *     returns org.jboss.test.ws.jaxws.jbws1798.generated.GetCountryCodesResponse.Response
     */
    @WebMethod(action = "countryCodesAction")
    @WebResult(name = "response", targetNamespace = "http://jbws1798.jaxws.ws.test.jboss.org/")
    @RequestWrapper(localName = "getCountryCodes", targetNamespace = "http://jbws1798.jaxws.ws.test.jboss.org/", className = "org.jboss.test.ws.jaxws.jbws1798.generated.GetCountryCodes")
    @ResponseWrapper(localName = "getCountryCodesResponse", targetNamespace = "http://jbws1798.jaxws.ws.test.jboss.org/", className = "org.jboss.test.ws.jaxws.jbws1798.generated.GetCountryCodesResponse")
    public org.jboss.test.ws.jaxws.jbws1798.generated.GetCountryCodesResponse.Response getCountryCodes();

    /**
     * 
     * @param parameters
     * @return
     *     returns org.jboss.test.ws.jaxws.jbws1798.generated.CurrencyCodeType
     */
    @WebMethod(action = "currencyAction")
    @WebResult(name = "getCurrencyResponse", targetNamespace = "http://jbws1798.jaxws.ws.test.jboss.org/", partName = "parameters")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public CurrencyCodeType getCurrency(
        @WebParam(name = "getCurrency", targetNamespace = "http://jbws1798.jaxws.ws.test.jboss.org/", partName = "parameters")
        CountryCodeType parameters);

    /**
     * 
     * @return
     *     returns org.jboss.test.ws.jaxws.jbws1798.generated.GetCurrencyCodesResponse.Response
     */
    @WebMethod(action = "currencyCodesAction")
    @WebResult(name = "response", targetNamespace = "http://jbws1798.jaxws.ws.test.jboss.org/")
    @RequestWrapper(localName = "getCurrencyCodes", targetNamespace = "http://jbws1798.jaxws.ws.test.jboss.org/", className = "org.jboss.test.ws.jaxws.jbws1798.generated.GetCurrencyCodes")
    @ResponseWrapper(localName = "getCurrencyCodesResponse", targetNamespace = "http://jbws1798.jaxws.ws.test.jboss.org/", className = "org.jboss.test.ws.jaxws.jbws1798.generated.GetCurrencyCodesResponse")
    public org.jboss.test.ws.jaxws.jbws1798.generated.GetCurrencyCodesResponse.Response getCurrencyCodes();

}
