package mx.unam.dgtic.diplomado.servicio;

import java.util.List;
import javax.ejb.Local;
import mx.unam.dgtic.diplomado.domain.Prestamo;

@Local
public interface PrestamoService {
    public List<Prestamo> listarPrestamos();
    
    public Prestamo encontrarPrestamoPorFolio(Prestamo prestamo);
        
    public void registrarPrestamo(Prestamo prestamo);
    
    public void modificarPrestamo(Prestamo prestamo);
    
    public void eliminarPrestamo(Prestamo prestamo);
}
