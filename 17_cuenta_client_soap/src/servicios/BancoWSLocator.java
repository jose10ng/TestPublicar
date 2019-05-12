/**
 * BancoWSLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package servicios;

public class BancoWSLocator extends org.apache.axis.client.Service implements servicios.BancoWS {

    public BancoWSLocator() {
    }


    public BancoWSLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BancoWSLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServicioWSBancaPort
    private java.lang.String ServicioWSBancaPort_address = "http://localhost:8080/17_cuenta_server_soap/bancoWS";

    public java.lang.String getServicioWSBancaPortAddress() {
        return ServicioWSBancaPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicioWSBancaPortWSDDServiceName = "ServicioWSBancaPort";

    public java.lang.String getServicioWSBancaPortWSDDServiceName() {
        return ServicioWSBancaPortWSDDServiceName;
    }

    public void setServicioWSBancaPortWSDDServiceName(java.lang.String name) {
        ServicioWSBancaPortWSDDServiceName = name;
    }

    public servicios.ServicioWSBanca getServicioWSBancaPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicioWSBancaPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicioWSBancaPort(endpoint);
    }

    public servicios.ServicioWSBanca getServicioWSBancaPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            servicios.ServicioWSBancaPortBindingStub _stub = new servicios.ServicioWSBancaPortBindingStub(portAddress, this);
            _stub.setPortName(getServicioWSBancaPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicioWSBancaPortEndpointAddress(java.lang.String address) {
        ServicioWSBancaPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (servicios.ServicioWSBanca.class.isAssignableFrom(serviceEndpointInterface)) {
                servicios.ServicioWSBancaPortBindingStub _stub = new servicios.ServicioWSBancaPortBindingStub(new java.net.URL(ServicioWSBancaPort_address), this);
                _stub.setPortName(getServicioWSBancaPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ServicioWSBancaPort".equals(inputPortName)) {
            return getServicioWSBancaPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://servicios/", "bancoWS");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://servicios/", "ServicioWSBancaPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServicioWSBancaPort".equals(portName)) {
            setServicioWSBancaPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
