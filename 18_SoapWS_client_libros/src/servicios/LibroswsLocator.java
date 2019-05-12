/**
 * LibroswsLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package servicios;

public class LibroswsLocator extends org.apache.axis.client.Service implements servicios.Librosws {

    public LibroswsLocator() {
    }


    public LibroswsLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public LibroswsLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServicioLibrosPort
    private java.lang.String ServicioLibrosPort_address = "http://localhost:8080/18_SoapWS_server_libros/librosws";

    public java.lang.String getServicioLibrosPortAddress() {
        return ServicioLibrosPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicioLibrosPortWSDDServiceName = "ServicioLibrosPort";

    public java.lang.String getServicioLibrosPortWSDDServiceName() {
        return ServicioLibrosPortWSDDServiceName;
    }

    public void setServicioLibrosPortWSDDServiceName(java.lang.String name) {
        ServicioLibrosPortWSDDServiceName = name;
    }

    public servicios.ServicioLibros getServicioLibrosPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicioLibrosPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicioLibrosPort(endpoint);
    }

    public servicios.ServicioLibros getServicioLibrosPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            servicios.ServicioLibrosPortBindingStub _stub = new servicios.ServicioLibrosPortBindingStub(portAddress, this);
            _stub.setPortName(getServicioLibrosPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicioLibrosPortEndpointAddress(java.lang.String address) {
        ServicioLibrosPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (servicios.ServicioLibros.class.isAssignableFrom(serviceEndpointInterface)) {
                servicios.ServicioLibrosPortBindingStub _stub = new servicios.ServicioLibrosPortBindingStub(new java.net.URL(ServicioLibrosPort_address), this);
                _stub.setPortName(getServicioLibrosPortWSDDServiceName());
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
        if ("ServicioLibrosPort".equals(inputPortName)) {
            return getServicioLibrosPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://servicios/", "librosws");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://servicios/", "ServicioLibrosPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServicioLibrosPort".equals(portName)) {
            setServicioLibrosPortEndpointAddress(address);
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
