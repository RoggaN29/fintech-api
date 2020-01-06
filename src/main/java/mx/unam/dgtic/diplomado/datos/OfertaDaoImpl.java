package mx.unam.dgtic.diplomado.datos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.unam.dgtic.diplomado.domain.Oferta;

public class OfertaDaoImpl implements OfertaDao {
    
    @PersistenceContext(unitName="FintechPU")
    EntityManager em;

    @Override
    public List<Oferta> findAllOfertas() {
        return em.createNamedQuery("Oferta.findAll").getResultList();
    }

    @Override
    public Oferta findPOfertaByFolio(Oferta oferta) {
        return em.find(Oferta.class, oferta.getEstadoOferta());
    }

    @Override
    public void insertOferta(Oferta oferta) {
        em.persist(oferta);
    }

    @Override
    public void updateOferta(Oferta oferta) {
        em.merge(oferta);
    }

    @Override
    public void deleteOferta(Oferta oferta) {
        em.remove(em.merge(oferta));
    }
    
}
