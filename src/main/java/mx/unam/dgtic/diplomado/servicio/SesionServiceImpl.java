package mx.unam.dgtic.diplomado.servicio;

import java.util.List;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.annotation.Resource;
import mx.unam.dgtic.diplomado.datos.SesionDao;
import mx.unam.dgtic.diplomado.domain.Sesion;

@Stateless
public class SesionServiceImpl implements SesionService{
    
    @Inject
    private SesionDao sesionDao;

    @Resource
    private SessionContext contexto;

    @Override
    public List<Sesion> listarSesions() {
        return sesionDao.findAllSesions();
    }

    @Override
    public Sesion encontrarSesionPorRfc(Sesion sesion) {
        return sesionDao.findPSesionByRFC(sesion);
    }

    @Override
    public void registrarSesion(Sesion sesion) {
        sesionDao.insertSesion(sesion);
    }

    @Override
    public void modificarSesion(Sesion sesion) {
        try {
            sesionDao.updateSesion(sesion);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarSesion(Sesion sesion) {
        sesionDao.deleteSesion(sesion);
    }
}
