package mx.unam.dgtic.diplomado.datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import mx.unam.dgtic.diplomado.domain.Oferente;

@Stateless 
public class OferenteDaoImpl implements OferenteDao{

    @PersistenceContext(unitName="FintechPU")
    EntityManager em;

    @Override
    public List<Oferente> findAllOferentes() {
        return em.createNamedQuery("Oferente.findAll").getResultList();
    }

    @Override
    public Oferente findPOferenteByRFC(Oferente oferente) {
        return em.find(Oferente.class, oferente.getRfcOferente());
    }

    @Override
    public void insertOferente(Oferente oferente) {
        em.persist(oferente);
    }

    @Override
    public void updateOferente(Oferente oferente) {
        em.merge(oferente);
    }

    @Override
    public void deleteOferente(Oferente oferente) {
        em.remove(em.merge(oferente));
    }
    
}
