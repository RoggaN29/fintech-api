package mx.unam.dgtic.diplomado.servicio;

import java.util.List;
import javax.ejb.Local;
import mx.unam.dgtic.diplomado.domain.Oferente;

@Local
public interface OferenteService {
    public List<Oferente> listarOferentes();
    
    public Oferente encontrarOferentePorRfc(Oferente oferente);
        
    public void registrarOferente(Oferente oferente);
    
    public void modificarOferente(Oferente oferente);
    
    public void eliminarOferente(Oferente oferente);
}
