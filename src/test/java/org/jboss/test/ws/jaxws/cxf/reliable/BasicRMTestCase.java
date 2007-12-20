/*
 * JBoss, Home of Professional Open Source
 * Copyright 2005, JBoss Inc., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.test.ws.jaxws.cxf.reliable;

import java.io.File;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;

import junit.framework.Test;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.bus.spring.SpringBusFactory;
import org.jboss.wsf.common.DOMUtils;
import org.jboss.wsf.test.JBossWSTest;
import org.jboss.wsf.test.JBossWSTestSetup;
import org.w3c.dom.Element;

/**
 * Test the CXF WS-ReliableMessaging
 *
 * @author Thomas.Diesler@jboss.org
 * @since 12-Dec-2007
 */
public class BasicRMTestCase extends JBossWSTest
{
   private String endpointURL = "http://" + getServerHost() + ":8080/jaxws-cxf-reliable/TestService";
   private String targetNS = "http://org.jboss.ws.jaxws.cxf/reliable";

   public static Test suite()
   {
      return new JBossWSTestSetup(BasicRMTestCase.class, "jaxws-cxf-reliable.war");
   }

   public void _testWSDLAccess() throws Exception
   {
      URL wsdlURL = new URL(endpointURL + "?wsdl");
      Element wsdl = DOMUtils.parse(wsdlURL.openStream());
      assertNotNull(wsdl);

      System.out.println("FIXME: [CXF-1310] Generated WSDL for an WS-RM endpoint does not contain RM policies");
   }

   public void _testStandardAPIClient() throws Exception
   {
      URL wsdlURL = new File("resources/jaxws/cxf/reliable/reliable.wsdl").toURL();
      QName serviceName = new QName(targetNS, "RMService");

      Service service = Service.create(wsdlURL, serviceName);
      RMEndpoint port = (RMEndpoint)service.getPort(RMEndpoint.class);

      Object retObj = port.echo("Hello");
      assertEquals("Hello", retObj);
   }

   public void testSpringClient() throws Exception
   {
      SpringBusFactory bf = new SpringBusFactory();
      URL cxfConfig = new File("resources/jaxws/cxf/reliable/cxf-client.xml").toURL();
      Bus bus = bf.createBus(cxfConfig);
      BusFactory.setDefaultBus(bus);

      URL wsdlURL = new File("resources/jaxws/cxf/reliable/reliable.wsdl").toURL();
      QName serviceName = new QName(targetNS, "RMService");

      Service service = Service.create(wsdlURL, serviceName);
      RMEndpoint port = (RMEndpoint)service.getPort(RMEndpoint.class);

      // Enable addressing
      BindingProvider bp = (BindingProvider)port;
      bp.getRequestContext().put("org.apache.cxf.ws.addressing.using", Boolean.TRUE);
      
      Object retObj = port.echo("Hello");
      assertEquals("Hello", retObj);
   }
}