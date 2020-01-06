package mx.unam.dgtic.diplomado.servicio;

import java.util.List;
import javax.ejb.Local;
import mx.unam.dgtic.diplomado.domain.Administrador;

@Local
public interface AdministradorService {
    public List<Administrador> listarAdministradors();
    
    public Administrador encontrarAdministradorPorRfc(Administrador administrador);
        
    public void registrarAdministrador(Administrador administrador);
    
    public void modificarAdministrador(Administrador administrador);
    
    public void eliminarAdministrador(Administrador administrador);
}
