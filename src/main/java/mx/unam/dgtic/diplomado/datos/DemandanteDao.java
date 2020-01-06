
package mx.unam.dgtic.diplomado.datos;

import java.util.List;
import mx.unam.dgtic.diplomado.domain.Demandante;


public interface DemandanteDao {
    public List<Demandante> findAllDemandantes();
    
    public Demandante findPDemandanteByRFC(Demandante demandante);
    
    public void insertDemandante(Demandante demandante);
    
    public void updateDemandante(Demandante demandante);
    
    public void deleteDemandante(Demandante demandante);
}
