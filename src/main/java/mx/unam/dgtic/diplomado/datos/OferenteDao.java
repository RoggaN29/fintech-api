package mx.unam.dgtic.diplomado.datos;

import java.util.List;
import mx.unam.dgtic.diplomado.domain.Oferente;


public interface OferenteDao {
    public List<Oferente> findAllOferentes();
    
    public Oferente findPOferenteByRFC(Oferente oferente);
    
    public void insertOferente(Oferente oferente);
    
    public void updateOferente(Oferente oferente);
    
    public void deleteOferente(Oferente oferente);
}
