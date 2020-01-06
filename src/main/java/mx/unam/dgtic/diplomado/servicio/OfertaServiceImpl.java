package mx.unam.dgtic.diplomado.servicio;

import java.util.List;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.annotation.Resource;
import mx.unam.dgtic.diplomado.datos.OfertaDao;
import mx.unam.dgtic.diplomado.domain.Oferta;

@Stateless
public class OfertaServiceImpl implements OfertaService{
    
    @Inject
    private OfertaDao OfertaDao;

    @Resource
    private SessionContext contexto;

    @Override
    public List<Oferta> listarOfertas() {
        return OfertaDao.findAllOfertas();
    }

    @Override
    public Oferta encontrarOfertaPorFolio(Oferta oferta) {
        return OfertaDao.findPOfertaByFolio(oferta);
    }

    @Override
    public void registrarOferta(Oferta oferta) {
        OfertaDao.insertOferta(oferta);
    }

    @Override
    public void modificarOferta(Oferta oferta) {
        try {
            OfertaDao.updateOferta(oferta);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarOferta(Oferta oferta) {
        OfertaDao.deleteOferta(oferta);
    }
}
