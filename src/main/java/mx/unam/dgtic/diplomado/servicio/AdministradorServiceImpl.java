package mx.unam.dgtic.diplomado.servicio;

import java.util.List;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.annotation.Resource;
import mx.unam.dgtic.diplomado.datos.AdministradorDao;
import mx.unam.dgtic.diplomado.domain.Administrador;

@Stateless
public class AdministradorServiceImpl implements AdministradorService{
    
    @Inject
    private AdministradorDao administradorDao;

    @Resource
    private SessionContext contexto;

    @Override
    public List<Administrador> listarAdministradors() {
        return administradorDao.findAllAdministradors();
    }

    @Override
    public Administrador encontrarAdministradorPorRfc(Administrador administrador) {
        return administradorDao.findPAdministradorByRFC(administrador);
    }

    @Override
    public void registrarAdministrador(Administrador administrador) {
        administradorDao.insertAdministrador(administrador);
    }

    @Override
    public void modificarAdministrador(Administrador administrador) {
        try {
            administradorDao.updateAdministrador(administrador);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarAdministrador(Administrador administrador) {
        administradorDao.deleteAdministrador(administrador);
    }
}
