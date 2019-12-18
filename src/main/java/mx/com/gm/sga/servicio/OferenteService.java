package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Local;
import mx.com.gm.sga.domain.Oferente;

@Local
public interface OferenteService {
    public List<Oferente> listarOferente();
    
    public Oferente encontrarOferentePorRfc(Oferente oferente);
        
    public void registrarOferente(Oferente oferente);
    
    public void modificarOferente(Oferente oferente);
    
    public void eliminarOferente(Oferente oferente);
}
