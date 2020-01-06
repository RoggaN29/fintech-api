package mx.unam.dgtic.diplomado.datos;

import java.util.List;
import mx.unam.dgtic.diplomado.domain.Sesion;


public interface SesionDao {
    public List<Sesion> findAllSesions();
    
    public Sesion findPSesionByRFC(Sesion sesion);
    
    public void insertSesion(Sesion sesion);
    
    public void updateSesion(Sesion sesion);
    
    public void deleteSesion(Sesion sesion);
}