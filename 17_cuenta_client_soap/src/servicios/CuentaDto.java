/**
 * CuentaDto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package servicios;

public class CuentaDto  implements java.io.Serializable {
    private servicios.ClienteDto[] clienteDtos;

    private servicios.MovimientoDto[] movimientoDtos;

    private int numeroCuenta;

    private double saldo;

    private java.lang.String tipocuenta;

    public CuentaDto() {
    }

    public CuentaDto(
           servicios.ClienteDto[] clienteDtos,
           servicios.MovimientoDto[] movimientoDtos,
           int numeroCuenta,
           double saldo,
           java.lang.String tipocuenta) {
           this.clienteDtos = clienteDtos;
           this.movimientoDtos = movimientoDtos;
           this.numeroCuenta = numeroCuenta;
           this.saldo = saldo;
           this.tipocuenta = tipocuenta;
    }


    /**
     * Gets the clienteDtos value for this CuentaDto.
     * 
     * @return clienteDtos
     */
    public servicios.ClienteDto[] getClienteDtos() {
        return clienteDtos;
    }


    /**
     * Sets the clienteDtos value for this CuentaDto.
     * 
     * @param clienteDtos
     */
    public void setClienteDtos(servicios.ClienteDto[] clienteDtos) {
        this.clienteDtos = clienteDtos;
    }

    public servicios.ClienteDto getClienteDtos(int i) {
        return this.clienteDtos[i];
    }

    public void setClienteDtos(int i, servicios.ClienteDto _value) {
        this.clienteDtos[i] = _value;
    }


    /**
     * Gets the movimientoDtos value for this CuentaDto.
     * 
     * @return movimientoDtos
     */
    public servicios.MovimientoDto[] getMovimientoDtos() {
        return movimientoDtos;
    }


    /**
     * Sets the movimientoDtos value for this CuentaDto.
     * 
     * @param movimientoDtos
     */
    public void setMovimientoDtos(servicios.MovimientoDto[] movimientoDtos) {
        this.movimientoDtos = movimientoDtos;
    }

    public servicios.MovimientoDto getMovimientoDtos(int i) {
        return this.movimientoDtos[i];
    }

    public void setMovimientoDtos(int i, servicios.MovimientoDto _value) {
        this.movimientoDtos[i] = _value;
    }


    /**
     * Gets the numeroCuenta value for this CuentaDto.
     * 
     * @return numeroCuenta
     */
    public int getNumeroCuenta() {
        return numeroCuenta;
    }


    /**
     * Sets the numeroCuenta value for this CuentaDto.
     * 
     * @param numeroCuenta
     */
    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }


    /**
     * Gets the saldo value for this CuentaDto.
     * 
     * @return saldo
     */
    public double getSaldo() {
        return saldo;
    }


    /**
     * Sets the saldo value for this CuentaDto.
     * 
     * @param saldo
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    /**
     * Gets the tipocuenta value for this CuentaDto.
     * 
     * @return tipocuenta
     */
    public java.lang.String getTipocuenta() {
        return tipocuenta;
    }


    /**
     * Sets the tipocuenta value for this CuentaDto.
     * 
     * @param tipocuenta
     */
    public void setTipocuenta(java.lang.String tipocuenta) {
        this.tipocuenta = tipocuenta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CuentaDto)) return false;
        CuentaDto other = (CuentaDto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.clienteDtos==null && other.getClienteDtos()==null) || 
             (this.clienteDtos!=null &&
              java.util.Arrays.equals(this.clienteDtos, other.getClienteDtos()))) &&
            ((this.movimientoDtos==null && other.getMovimientoDtos()==null) || 
             (this.movimientoDtos!=null &&
              java.util.Arrays.equals(this.movimientoDtos, other.getMovimientoDtos()))) &&
            this.numeroCuenta == other.getNumeroCuenta() &&
            this.saldo == other.getSaldo() &&
            ((this.tipocuenta==null && other.getTipocuenta()==null) || 
             (this.tipocuenta!=null &&
              this.tipocuenta.equals(other.getTipocuenta())));
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
        if (getClienteDtos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getClienteDtos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getClienteDtos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMovimientoDtos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMovimientoDtos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMovimientoDtos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getNumeroCuenta();
        _hashCode += new Double(getSaldo()).hashCode();
        if (getTipocuenta() != null) {
            _hashCode += getTipocuenta().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CuentaDto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicios/", "cuentaDto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clienteDtos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clienteDtos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicios/", "clienteDto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("movimientoDtos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "movimientoDtos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicios/", "movimientoDto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroCuenta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numeroCuenta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("saldo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "saldo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipocuenta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipocuenta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
