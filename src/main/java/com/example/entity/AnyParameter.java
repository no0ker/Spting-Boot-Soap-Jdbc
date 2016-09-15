
package com.example.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anyParameter.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="anyParameter">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="value1"/>
 *     &lt;enumeration value="value2"/>
 *     &lt;enumeration value="value4"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "anyParameter", namespace = "https://github.com/no0ker/MyExampleVer2Application")
@XmlEnum
public enum AnyParameter {

    @XmlEnumValue("value1")
    VALUE_1("value1"),
    @XmlEnumValue("value2")
    VALUE_2("value2"),
    @XmlEnumValue("value4")
    VALUE_4("value4");
    private final String value;

    AnyParameter(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AnyParameter fromValue(String v) {
        for (AnyParameter c: AnyParameter.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
