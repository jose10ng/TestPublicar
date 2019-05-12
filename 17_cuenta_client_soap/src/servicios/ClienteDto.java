/**
 * ClienteDto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package servicios;

public class ClienteDto  implements java.io.Serializable {
    private servicios.CuentaDto[] cuentaDtos;

    private java.lang.String direccion;

    private int dni;

    private java.lang.String nombre;

    private int telefono;

    public ClienteDto() {
    }

    public ClienteDto(
           servicios.CuentaDto[] cuentaDtos,
           java.lang.String direccion,
           int dni,
           java.lang.String nombre,
           int telefono) {
           this.cuentaDtos = cuentaDtos;
           this.direccion = direccion;
           this.dni = dni;
           this.nombre = nombre;
           this.telefono = telefono;
    }


    /**
     * Gets the cuentaDtos value for this ClienteDto.
     * 
     * @return cuentaDtos
     */
    public servicios.CuentaDto[] getCuentaDtos() {
        return cuentaDtos;
    }


    /**
     * Sets the cuentaDtos value for this ClienteDto.
     * 
     * @param cuentaDtos
     */
    public void setCuentaDtos(servicios.CuentaDto[] cuentaDtos) {
        this.cuentaDtos = cuentaDtos;
    }

    public servicios.CuentaDto getCuentaDtos(int i) {
        return this.cuentaDtos[i];
    }

    public void setCuentaDtos(int i, servicios.CuentaDto _value) {
        this.cuentaDtos[i] = _value;
    }


    /**
     * Gets the direccion value for this ClienteDto.
     * 
     * @return direccion
     */
    public java.lang.String getDireccion() {
        return direccion;
    }


    /**
     * Sets the direccion value for this ClienteDto.
     * 
     * @param direccion
     */
    public void setDireccion(java.lang.String direccion) {
        this.direccion = direccion;
    }


    /**
     * Gets the dni value for this ClienteDto.
     * 
     * @return dni
     */
    public int getDni() {
        return dni;
    }


    /**
     * Sets the dni value for this ClienteDto.
     * 
     * @param dni
     */
    public void setDni(int dni) {
        this.dni = dni;
    }


    /**
     * Gets the nombre value for this ClienteDto.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this ClienteDto.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the telefono value for this ClienteDto.
     * 
     * @return telefono
     */
    public int getTelefono() {
        return telefono;
    }


    /**
     * Sets the telefono value for this ClienteDto.
     * 
     * @param telefono
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ClienteDto)) return false;
        ClienteDto other = (ClienteDto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cuentaDtos==null && other.getCuentaDtos()==null) || 
             (this.cuentaDtos!=null &&
              java.util.Arrays.equals(this.cuentaDtos, other.getCuentaDtos()))) &&
            ((this.direccion==null && other.getDireccion()==null) || 
             (this.direccion!=null &&
              this.direccion.equals(other.getDireccion()))) &&
            this.dni == other.getDni() &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            this.telefono == other.getTelefono();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCuentaDtos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCuentaDtos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCuentaDtos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDireccion() != null) {
            _hashCode += getDireccion().hashCode();
        }
        _hashCode += getDni();
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        _hashCode += getTelefono();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ClienteDto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicios/", "clienteDto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cuentaDtos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cuentaDtos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicios/", "cuentaDto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("direccion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "direccion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dni");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dni"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefono");
        elemField.setXmlName(new javax.xml.namespace.QName("", "telefono"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
