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
package org.jboss.test.ws.jaxws.cxf.jbws3792.wsdlImportGamma;

import java.io.File;
import java.net.URL;
import java.util.Iterator;

import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.wsf.test.JBossWSTest;
import org.jboss.wsf.test.JBossWSTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test imported wsdl and its referenced schema is NOT co-located with the
 * importing wsdl.  The imported wsdl and its referenced schema are located
 * in the same directory as the importing wsdl.
 * 
 * @author rsearls@redhat.com
 */
@RunWith(Arquillian.class)
public class JBWS3792GammaTestCase extends JBossWSTest {

   @ArquillianResource
   private URL baseURL;
   
   @Deployment(testable = false)
   public static WebArchive createDeployment() {
      WebArchive archive = ShrinkWrap.create(WebArchive.class, "jbws3792-wsdlImportGamma.war");
      archive .setManifest( new StringAsset("Manifest-Version: 1.0\n"
                 + "Dependencies: org.jboss.ws.cxf.jbossws-cxf-client\n"))
         .addClass(org.jboss.test.ws.jaxws.cxf.jbws3792.wsdlImportGamma.GreetingsWsImpl.class)
         .addClass(org.jboss.test.ws.jaxws.cxf.jbws3792.wsdlImportGamma.GreetingsWs.class)
         .addAsWebInfResource(new File(JBossWSTestHelper.getTestResourcesDir() + "/jaxws/cxf/jbws3792/wsdlImportGamma/WEB-INF/wsdl/Greeting_Simplest.wsdl"), "wsdl/Greeting_Simplest.wsdl")
         .addAsWebInfResource(new File(JBossWSTestHelper.getTestResourcesDir() + "/jaxws/cxf/jbws3792/wsdlImportGamma/WEB-INF/wsdl/A/b/Hello.wsdl"), "wsdl/A/b/Hello.wsdl")
         .addAsWebInfResource(new File(JBossWSTestHelper.getTestResourcesDir() + "/jaxws/cxf/jbws3792/wsdlImportGamma/WEB-INF/wsdl/A/b/Hello_schema2.xsd"), "wsdl/A/b/Hello_schema2.xsd");
      return archive;
   }

   @Test
   @RunAsClient
   public void testImportSimplest() throws Exception
   {
      URL wsdlURL = new URL(baseURL + "/GreetingsService?wsdl");
      QName qname = new QName("http://hello/test", "HelloService");
      Service service = Service.create(wsdlURL, qname);
      Iterator<QName> it = service.getPorts();
      int cnt = 0;
      while (it.hasNext())
      {
         cnt++;
         QName qn = (QName) it.next();
         assertTrue("{http://hello/test}HelloServicePort".equals(qn.toString()));
      }
      assertTrue("Expected cnt to be 1 but cnt is " + cnt, cnt == 1);
   }
}
