
package mx.unam.dgtic.diplomado.datos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.unam.dgtic.diplomado.domain.Demandante;

public class DemandanteDaoImpl implements DemandanteDao {
    
    @PersistenceContext(unitName="FintechPU")
    EntityManager em;

    @Override
    public List<Demandante> findAllDemandantes() {
        return em.createNamedQuery("Demandante.findAll").getResultList();
    }

    @Override
    public Demandante findPDemandanteByRFC(Demandante demandante) {
        return em.find(Demandante.class, demandante.getRfcRepresentante());
    }

    @Override
    public void insertDemandante(Demandante demandante) {
        em.persist(demandante);
    }

    @Override
    public void updateDemandante(Demandante demandante) {
        em.merge(demandante);
    }

    @Override
    public void deleteDemandante(Demandante demandante) {
        em.remove(em.merge(demandante));
    }
    
}
