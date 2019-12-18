package mx.com.gm.sga.datos;

import java.util.List;
import mx.com.gm.sga.domain.Oferente;


public interface OferenteDao {
    public List<Oferente> findAllOferentes();
    
    public Oferente findPOferenteByRFC(Oferente oferente);
    
    public void insertOferente(Oferente oferente);
    
    public void updateOferente(Oferente oferente);
    
    public void deleteOferente(Oferente oferente);
}
