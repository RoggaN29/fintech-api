package mx.unam.dgtic.diplomado.servicio;

import java.util.List;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.annotation.Resource;
import mx.unam.dgtic.diplomado.datos.OferenteDao;
import mx.unam.dgtic.diplomado.domain.Oferente;

@Stateless
public class OferenteServiceImpl implements OferenteService{
    
    @Inject
    private OferenteDao oferenteDao;

    @Resource
    private SessionContext contexto;

    @Override
    public List<Oferente> listarOferente() {
        return oferenteDao.findAllOferentes();
    }

    @Override
    public Oferente encontrarOferentePorRfc(Oferente oferente) {
        return oferenteDao.findPOferenteByRFC(oferente);
    }

    @Override
    public void registrarOferente(Oferente oferente) {
        oferenteDao.insertOferente(oferente);
    }

    @Override
    public void modificarOferente(Oferente oferente) {
        try {
            oferenteDao.updateOferente(oferente);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarOferente(Oferente oferente) {
        oferenteDao.deleteOferente(oferente);
    }
}
