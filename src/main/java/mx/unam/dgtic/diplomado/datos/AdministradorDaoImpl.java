package mx.unam.dgtic.diplomado.datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import mx.unam.dgtic.diplomado.domain.Administrador;

@Stateless
public class AdministradorDaoImpl implements AdministradorDao{

    @PersistenceContext(unitName="FintechPU")
    EntityManager em;

    @Override
    public List<Administrador> findAllAdministradors() {
        return em.createNamedQuery("Administrador.findAll").getResultList();
    }

    @Override
    public Administrador findPAdministradorByRFC(Administrador administrador) {
        return em.find(Administrador.class, administrador.getRfcAdministrador());
    }

    @Override
    public void insertAdministrador(Administrador administrador) {
        em.persist(administrador);
    }

    @Override
    public void updateAdministrador(Administrador administrador) {
        em.merge(administrador);
    }

    @Override
    public void deleteAdministrador(Administrador administrador) {
        em.remove(em.merge(administrador));
    }
    
}
