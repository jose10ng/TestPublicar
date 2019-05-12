package servicios;

public class ServicioWSBancaProxy implements servicios.ServicioWSBanca {
  private String _endpoint = null;
  private servicios.ServicioWSBanca servicioWSBanca = null;
  
  public ServicioWSBancaProxy() {
    _initServicioWSBancaProxy();
  }
  
  public ServicioWSBancaProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicioWSBancaProxy();
  }
  
  private void _initServicioWSBancaProxy() {
    try {
      servicioWSBanca = (new servicios.BancoWSLocator()).getServicioWSBancaPort();
      if (servicioWSBanca != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicioWSBanca)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicioWSBanca)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servicioWSBanca != null)
      ((javax.xml.rpc.Stub)servicioWSBanca)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public servicios.ServicioWSBanca getServicioWSBanca() {
    if (servicioWSBanca == null)
      _initServicioWSBancaProxy();
    return servicioWSBanca;
  }
  
  public servicios.CuentaDto buscarCuenta(int arg0) throws java.rmi.RemoteException{
    if (servicioWSBanca == null)
      _initServicioWSBancaProxy();
    return servicioWSBanca.buscarCuenta(arg0);
  }
  
  public boolean actualizarCuenta(servicios.MovimientoDto arg0) throws java.rmi.RemoteException{
    if (servicioWSBanca == null)
      _initServicioWSBancaProxy();
    return servicioWSBanca.actualizarCuenta(arg0);
  }
  
  public servicios.ClienteDto[] clientesPorSaldo(double arg0) throws java.rmi.RemoteException{
    if (servicioWSBanca == null)
      _initServicioWSBancaProxy();
    return servicioWSBanca.clientesPorSaldo(arg0);
  }
  
  public boolean transferir(int arg0, int arg1, double arg2) throws java.rmi.RemoteException{
    if (servicioWSBanca == null)
      _initServicioWSBancaProxy();
    return servicioWSBanca.transferir(arg0, arg1, arg2);
  }
  
  public servicios.MovimientoDto[] listaMov(int arg0) throws java.rmi.RemoteException{
    if (servicioWSBanca == null)
      _initServicioWSBancaProxy();
    return servicioWSBanca.listaMov(arg0);
  }
  
  public void registrarMov(servicios.MovimientoDto arg0) throws java.rmi.RemoteException{
    if (servicioWSBanca == null)
      _initServicioWSBancaProxy();
    servicioWSBanca.registrarMov(arg0);
  }
  
  
}