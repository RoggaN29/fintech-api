package mx.unam.dgtic.diplomado.servicio;

import java.util.List;
import javax.ejb.Local;
import mx.unam.dgtic.diplomado.domain.Demandante;

@Local
public interface DemandanteService {
    public List<Demandante> listarDemandantes();
    
    public Demandante encontrarDemandantePorRfc(Demandante demandante);
        
    public void registrarDemandante(Demandante demandante);
    
    public void modificarDemandante(Demandante demandante);
    
    public void eliminarDemandante(Demandante demandante);
}
