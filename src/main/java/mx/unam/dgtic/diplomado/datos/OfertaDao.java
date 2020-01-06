
package mx.unam.dgtic.diplomado.datos;

import java.util.List;
import mx.unam.dgtic.diplomado.domain.Oferta;


public interface OfertaDao {
    public List<Oferta> findAllOfertas();
    
    public Oferta findPOfertaByFolio(Oferta oferta);
    
    public void insertOferta(Oferta oferta);
    
    public void updateOferta(Oferta oferta);
    
    public void deleteOferta(Oferta oferta);
}
