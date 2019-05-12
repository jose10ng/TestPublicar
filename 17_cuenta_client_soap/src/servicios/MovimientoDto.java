/**
 * MovimientoDto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package servicios;

public class MovimientoDto  implements java.io.Serializable {
    private double cantidad;

    private servicios.CuentaDto cuentaDto;

    private java.lang.String cuentaRecibeTransf;

    private java.util.Date fecha;

    private int idMovimiento;

    private java.lang.String operacion;

    public MovimientoDto() {
    }

    public MovimientoDto(
           double cantidad,
           java.util.Date fecha,
           java.lang.String operacion,
           servicios.CuentaDto cuentaDto,
           java.lang.String cuentaRecibeTransf) {
           this.cantidad = cantidad;
           this.cuentaDto = cuentaDto;
           this.cuentaRecibeTransf = cuentaRecibeTransf;
           this.fecha = fecha;
           this.operacion = operacion;
    }

    public MovimientoDto(
           double cantidad,
           java.util.Date fecha,
           java.lang.String operacion,
           servicios.CuentaDto cuentaDto,
           java.lang.String cuentaRecibeTransf,
           int idMovimiento) {
           this.cantidad = cantidad;
           this.cuentaDto = cuentaDto;
           this.cuentaRecibeTransf = cuentaRecibeTransf;
           this.fecha = fecha;
           this.idMovimiento = idMovimiento;
           this.operacion = operacion;
    }


    /**
     * Gets the cantidad value for this MovimientoDto.
     * 
     * @return cantidad
     */
    public double getCantidad() {
        return cantidad;
    }


    /**
     * Sets the cantidad value for this MovimientoDto.
     * 
     * @param cantidad
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }


    /**
     * Gets the cuentaDto value for this MovimientoDto.
     * 
     * @return cuentaDto
     */
    public servicios.CuentaDto getCuentaDto() {
        return cuentaDto;
    }


    /**
     * Sets the cuentaDto value for this MovimientoDto.
     * 
     * @param cuentaDto
     */
    public void setCuentaDto(servicios.CuentaDto cuentaDto) {
        this.cuentaDto = cuentaDto;
    }


    /**
     * Gets the cuentaRecibeTransf value for this MovimientoDto.
     * 
     * @return cuentaRecibeTransf
     */
    public java.lang.String getCuentaRecibeTransf() {
        return cuentaRecibeTransf;
    }


    /**
     * Sets the cuentaRecibeTransf value for this MovimientoDto.
     * 
     * @param cuentaRecibeTransf
     */
    public void setCuentaRecibeTransf(java.lang.String cuentaRecibeTransf) {
        this.cuentaRecibeTransf = cuentaRecibeTransf;
    }


    /**
     * Gets the fecha value for this MovimientoDto.
     * 
     * @return fecha
     */
    public java.util.Date getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this MovimientoDto.
     * 
     * @param fecha
     */
    public void setFecha(java.util.Date fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the idMovimiento value for this MovimientoDto.
     * 
     * @return idMovimiento
     */
    public int getIdMovimiento() {
        return idMovimiento;
    }


    /**
     * Sets the idMovimiento value for this MovimientoDto.
     * 
     * @param idMovimiento
     */
    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }


    /**
     * Gets the operacion value for this MovimientoDto.
     * 
     * @return operacion
     */
    public java.lang.String getOperacion() {
        return operacion;
    }


    /**
     * Sets the operacion value for this MovimientoDto.
     * 
     * @param operacion
     */
    public void setOperacion(java.lang.String operacion) {
        this.operacion = operacion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MovimientoDto)) return false;
        MovimientoDto other = (MovimientoDto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.cantidad == other.getCantidad() &&
            ((this.cuentaDto==null && other.getCuentaDto()==null) || 
             (this.cuentaDto!=null &&
              this.cuentaDto.equals(other.getCuentaDto()))) &&
            ((this.cuentaRecibeTransf==null && other.getCuentaRecibeTransf()==null) || 
             (this.cuentaRecibeTransf!=null &&
              this.cuentaRecibeTransf.equals(other.getCuentaRecibeTransf()))) &&
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha()))) &&
            this.idMovimiento == other.getIdMovimiento() &&
            ((this.operacion==null && other.getOperacion()==null) || 
             (this.operacion!=null &&
              this.operacion.equals(other.getOperacion())));
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
        _hashCode += new Double(getCantidad()).hashCode();
        if (getCuentaDto() != null) {
            _hashCode += getCuentaDto().hashCode();
        }
        if (getCuentaRecibeTransf() != null) {
            _hashCode += getCuentaRecibeTransf().hashCode();
        }
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        _hashCode += getIdMovimiento();
        if (getOperacion() != null) {
            _hashCode += getOperacion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MovimientoDto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicios/", "movimientoDto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantidad");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cantidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cuentaDto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cuentaDto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicios/", "cuentaDto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cuentaRecibeTransf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cuentaRecibeTransf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idMovimiento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idMovimiento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "operacion"));
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
