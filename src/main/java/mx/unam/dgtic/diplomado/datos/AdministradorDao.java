package mx.unam.dgtic.diplomado.datos;

import java.util.List;
import mx.unam.dgtic.diplomado.domain.Administrador;


public interface AdministradorDao {
    public List<Administrador> findAllAdministradors();
    
    public Administrador findPAdministradorByRFC(Administrador administrador);
    
    public void insertAdministrador(Administrador administrador);
    
    public void updateAdministrador(Administrador administrador);
    
    public void deleteAdministrador(Administrador administrador);
}