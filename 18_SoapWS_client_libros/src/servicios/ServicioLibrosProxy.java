package servicios;

public class ServicioLibrosProxy implements servicios.ServicioLibros {
  private String _endpoint = null;
  private servicios.ServicioLibros servicioLibros = null;
  
  public ServicioLibrosProxy() {
    _initServicioLibrosProxy();
  }
  
  public ServicioLibrosProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicioLibrosProxy();
  }
  
  private void _initServicioLibrosProxy() {
    try {
      servicioLibros = (new servicios.LibroswsLocator()).getServicioLibrosPort();
      if (servicioLibros != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicioLibros)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicioLibros)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servicioLibros != null)
      ((javax.xml.rpc.Stub)servicioLibros)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public servicios.ServicioLibros getServicioLibros() {
    if (servicioLibros == null)
      _initServicioLibrosProxy();
    return servicioLibros;
  }
  
  public boolean altaCliente(java.lang.String arg0) throws java.rmi.RemoteException{
    if (servicioLibros == null)
      _initServicioLibrosProxy();
    return servicioLibros.altaCliente(arg0);
  }
  
  public boolean loginAdmin(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (servicioLibros == null)
      _initServicioLibrosProxy();
    return servicioLibros.loginAdmin(arg0, arg1);
  }
  
  public java.lang.String listaVentasEntreFechas(java.util.Date arg0, java.util.Date arg1) throws java.rmi.RemoteException{
    if (servicioLibros == null)
      _initServicioLibrosProxy();
    return servicioLibros.listaVentasEntreFechas(arg0, arg1);
  }
  
  public java.lang.String buscarClienteComprobar(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (servicioLibros == null)
      _initServicioLibrosProxy();
    return servicioLibros.buscarClienteComprobar(arg0, arg1);
  }
  
  public java.lang.String listaLibrosDeUnTema(int arg0) throws java.rmi.RemoteException{
    if (servicioLibros == null)
      _initServicioLibrosProxy();
    return servicioLibros.listaLibrosDeUnTema(arg0);
  }
  
  public java.lang.String listaHistoricosDeUnCliente(int arg0) throws java.rmi.RemoteException{
    if (servicioLibros == null)
      _initServicioLibrosProxy();
    return servicioLibros.listaHistoricosDeUnCliente(arg0);
  }
  
  public boolean realizarVentasEHistorico(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (servicioLibros == null)
      _initServicioLibrosProxy();
    return servicioLibros.realizarVentasEHistorico(arg0, arg1);
  }
  
  public java.lang.String listaLibros() throws java.rmi.RemoteException{
    if (servicioLibros == null)
      _initServicioLibrosProxy();
    return servicioLibros.listaLibros();
  }
  
  public java.lang.String buscarCliente(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (servicioLibros == null)
      _initServicioLibrosProxy();
    return servicioLibros.buscarCliente(arg0, arg1);
  }
  
  public java.lang.String buscarLibro(int arg0) throws java.rmi.RemoteException{
    if (servicioLibros == null)
      _initServicioLibrosProxy();
    return servicioLibros.buscarLibro(arg0);
  }
  
  public java.lang.String listaTemas() throws java.rmi.RemoteException{
    if (servicioLibros == null)
      _initServicioLibrosProxy();
    return servicioLibros.listaTemas();
  }
  
  public boolean modificarCliente(int arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (servicioLibros == null)
      _initServicioLibrosProxy();
    return servicioLibros.modificarCliente(arg0, arg1);
  }
  
  
}