package mx.unam.dgtic.diplomado.datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import mx.unam.dgtic.diplomado.domain.Sesion;

@Stateless
public class SesionDaoImpl implements SesionDao{

    @PersistenceContext(unitName="FintechPU")
    EntityManager em;

    @Override
    public List<Sesion> findAllSesions() {
        return em.createNamedQuery("Sesion.findAll").getResultList();
    }

    @Override
    public Sesion findPSesionByRFC(Sesion sesion) {
        return em.find(Sesion.class, sesion.getRfcUsuario());
    }

    @Override
    public void insertSesion(Sesion sesion) {
        em.persist(sesion);
    }

    @Override
    public void updateSesion(Sesion sesion) {
        em.merge(sesion);
    }

    @Override
    public void deleteSesion(Sesion sesion) {
        em.remove(em.merge(sesion));
    }
    
}
