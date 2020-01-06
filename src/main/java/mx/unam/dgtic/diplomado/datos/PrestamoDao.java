
package mx.unam.dgtic.diplomado.datos;

import java.util.List;
import mx.unam.dgtic.diplomado.domain.Prestamo;


public interface PrestamoDao {
    public List<Prestamo> findAllPrestamos();
    
    public Prestamo findPPrestamoByFolio(Prestamo prestamo);
    
    public void insertPrestamo(Prestamo prestamo);
    
    public void updatePrestamo(Prestamo prestamo);
    
    public void deletePrestamo(Prestamo prestamo);
}
