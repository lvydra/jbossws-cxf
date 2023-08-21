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
package org.jboss.test.ws.jaxws.cxf.jaxbintros;
       
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlAttribute;
import javax.xml.namespace.QName;

/**
 * <p>Java class for UserType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="UserType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="string" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="qname" type="{http://www.w3.org/2001/XMLSchema}QName"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlRootElement(namespace = "http://org.jboss.ws/provider", name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserType", propOrder = { "string", "qname" })
public class AnnotatedUserType
{

   @XmlAttribute(required = true)
   protected String string;
   @XmlElement(required = true)
   protected QName qname;

   /**
    * Gets the value of the string property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public String getString()
   {
      return string;
   }

   /**
    * Sets the value of the string property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setString(String value)
   {
      this.string = value;
   }

   /**
    * Gets the value of the qname property.
    *
    * @return
    *     possible object is
    *     {@link javax.xml.namespace.QName }
    *
    */
   public QName getQname()
   {
      return qname;
   }

   /**
    * Sets the value of the qname property.
    *
    * @param value
    *     allowed object is
    *     {@link javax.xml.namespace.QName }
    *
    */
   public void setQname(QName value)
   {
      this.qname = value;
   }

}

