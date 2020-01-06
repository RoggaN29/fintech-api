package mx.unam.dgtic.diplomado.servicio;

import java.util.List;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.annotation.Resource;
import mx.unam.dgtic.diplomado.datos.DemandanteDao;
import mx.unam.dgtic.diplomado.domain.Demandante;

@Stateless
public class DemandanteServiceImpl implements DemandanteService{
    
    @Inject
    private DemandanteDao DemandanteDao;

    @Resource
    private SessionContext contexto;

    @Override
    public List<Demandante> listarDemandantes() {
        return DemandanteDao.findAllDemandantes();
    }

    @Override
    public Demandante encontrarDemandantePorRfc(Demandante demandante) {
        return DemandanteDao.findPDemandanteByRFC(demandante);
    }

    @Override
    public void registrarDemandante(Demandante demandante) {
        DemandanteDao.insertDemandante(demandante);
    }

    @Override
    public void modificarDemandante(Demandante demandante) {
        try {
            DemandanteDao.updateDemandante(demandante);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarDemandante(Demandante demandante) {
        DemandanteDao.deleteDemandante(demandante);
    }
}
