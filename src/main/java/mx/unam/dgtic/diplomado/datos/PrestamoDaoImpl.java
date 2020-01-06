package mx.unam.dgtic.diplomado.datos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.unam.dgtic.diplomado.domain.Prestamo;

public class PrestamoDaoImpl implements PrestamoDao {
    
    @PersistenceContext(unitName="FintechPU")
    EntityManager em;

    @Override
    public List<Prestamo> findAllPrestamos() {
        return em.createNamedQuery("Prestamo.findAll").getResultList();
    }

    @Override
    public Prestamo findPPrestamoByFolio(Prestamo prestamo) {
        return em.find(Prestamo.class, prestamo.getEstadoPrestamo());
    }

    @Override
    public void insertPrestamo(Prestamo prestamo) {
        em.persist(prestamo);
    }

    @Override
    public void updatePrestamo(Prestamo prestamo) {
        em.merge(prestamo);
    }

    @Override
    public void deletePrestamo(Prestamo prestamo) {
        em.remove(em.merge(prestamo));
    }
    
}
