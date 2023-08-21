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
package org.jboss.test.ws.jaxws.jbws3034;

import java.io.File;
import java.net.URL;

import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.wsf.test.JBossWSTest;
import org.jboss.wsf.test.JBossWSTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class JBWS3034TestCase extends JBossWSTest
{
   @ArquillianResource
   private URL baseURL;

   @Deployment(testable = false)
   public static WebArchive createDeployments() {
      WebArchive archive = ShrinkWrap.create(WebArchive.class, "jaxws-jbws3034.war");
         archive
               .addManifest()
               .addAsResource(new File(JBossWSTestHelper.getTestResourcesDir() + "/jaxws/jbws3034/handlers.xml"), "handlers.xml")
               .addClass(org.jboss.test.ws.jaxws.jbws3034.Endpoint.class)
               .addClass(org.jboss.test.ws.jaxws.jbws3034.EndpointImpl.class)
               .addClass(org.jboss.test.ws.jaxws.jbws3034.ServerSOAPHandler.class)
               .addAsWebInfResource(new File(JBossWSTestHelper.getTestResourcesDir() + "/jaxws/jbws3034/WEB-INF/jboss-web.xml"), "jboss-web.xml")
               .setWebXML(new File(JBossWSTestHelper.getTestResourcesDir() + "/jaxws/jbws3034/WEB-INF/web.xml"));
      return archive;
   }

   @Test
   @RunAsClient
   public void testCall() throws Exception
   {
      URL wsdlURL = new URL(baseURL + "?wsdl");
      Service service = Service.create(wsdlURL, new QName("http://ws.jboss.org/jbws3034", "EndpointService"));
      Endpoint port = service.getPort(new QName("http://ws.jboss.org/jbws3034", "EndpointPort"), Endpoint.class);
      String response = port.echo("testJBWS3034");
      assertEquals("PutByServerSOAPHandler", response);
   }
}