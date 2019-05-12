/**
 * ServicioLibros.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package servicios;

public interface ServicioLibros extends java.rmi.Remote {
    public boolean altaCliente(java.lang.String arg0) throws java.rmi.RemoteException;
    public boolean loginAdmin(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public java.lang.String listaVentasEntreFechas(java.util.Date arg0, java.util.Date arg1) throws java.rmi.RemoteException;
    public java.lang.String buscarClienteComprobar(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public java.lang.String listaLibrosDeUnTema(int arg0) throws java.rmi.RemoteException;
    public java.lang.String listaHistoricosDeUnCliente(int arg0) throws java.rmi.RemoteException;
    public boolean realizarVentasEHistorico(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public java.lang.String listaLibros() throws java.rmi.RemoteException;
    public java.lang.String buscarCliente(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public java.lang.String buscarLibro(int arg0) throws java.rmi.RemoteException;
    public java.lang.String listaTemas() throws java.rmi.RemoteException;
    public boolean modificarCliente(int arg0, java.lang.String arg1) throws java.rmi.RemoteException;
}
