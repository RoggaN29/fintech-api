package mx.unam.dgtic.diplomado.servicio;

import java.util.List;
import javax.ejb.Local;
import mx.unam.dgtic.diplomado.domain.Sesion;

@Local
public interface SesionService {
    public List<Sesion> listarSesions();
    
    public Sesion encontrarSesionPorRfc(Sesion sesion);
        
    public void registrarSesion(Sesion sesion);
    
    public void modificarSesion(Sesion sesion);
    
    public void eliminarSesion(Sesion sesion);
}
