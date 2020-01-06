package mx.unam.dgtic.diplomado.servicio;

import java.util.List;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.annotation.Resource;
import mx.unam.dgtic.diplomado.datos.PrestamoDao;
import mx.unam.dgtic.diplomado.domain.Prestamo;

@Stateless
public class PrestamoServiceImpl implements PrestamoService{
    
    @Inject
    private PrestamoDao PrestamoDao;

    @Resource
    private SessionContext contexto;

    @Override
    public List<Prestamo> listarPrestamos() {
        return PrestamoDao.findAllPrestamos();
    }

    @Override
    public Prestamo encontrarPrestamoPorFolio(Prestamo prestamo) {
        return PrestamoDao.findPPrestamoByFolio(prestamo);
    }

    @Override
    public void registrarPrestamo(Prestamo prestamo) {
        PrestamoDao.insertPrestamo(prestamo);
    }

    @Override
    public void modificarPrestamo(Prestamo prestamo) {
        try {
            PrestamoDao.updatePrestamo(prestamo);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarPrestamo(Prestamo prestamo) {
        PrestamoDao.deletePrestamo(prestamo);
    }
}
