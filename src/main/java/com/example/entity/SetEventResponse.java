
package com.example.entity;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="statusContainer" type="{https://github.com/no0ker/MyExampleVer2Application}statusContainer" maxOccurs="10" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name",
    "statusContainer"
})
@XmlRootElement(name = "setEventResponse", namespace = "https://github.com/no0ker/MyExampleVer2Application")
public class SetEventResponse {

    @XmlElement(namespace = "https://github.com/no0ker/MyExampleVer2Application", required = true)
    protected String name;
    @XmlElement(namespace = "https://github.com/no0ker/MyExampleVer2Application")
    protected List<StatusContainer> statusContainer;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the statusContainer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the statusContainer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStatusContainer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StatusContainer }
     * 
     * 
     */
    public List<StatusContainer> getStatusContainer() {
        if (statusContainer == null) {
            statusContainer = new ArrayList<StatusContainer>();
        }
        return this.statusContainer;
    }

}
