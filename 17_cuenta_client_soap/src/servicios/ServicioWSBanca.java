/**
 * ServicioWSBanca.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package servicios;

public interface ServicioWSBanca extends java.rmi.Remote {
    public servicios.CuentaDto buscarCuenta(int arg0) throws java.rmi.RemoteException;
    public boolean actualizarCuenta(servicios.MovimientoDto arg0) throws java.rmi.RemoteException;
    public servicios.ClienteDto[] clientesPorSaldo(double arg0) throws java.rmi.RemoteException;
    public boolean transferir(int arg0, int arg1, double arg2) throws java.rmi.RemoteException;
    public servicios.MovimientoDto[] listaMov(int arg0) throws java.rmi.RemoteException;
    public void registrarMov(servicios.MovimientoDto arg0) throws java.rmi.RemoteException;
}
