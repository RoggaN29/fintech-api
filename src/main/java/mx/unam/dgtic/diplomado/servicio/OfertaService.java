package mx.unam.dgtic.diplomado.servicio;

import java.util.List;
import javax.ejb.Local;
import mx.unam.dgtic.diplomado.domain.Oferta;

@Local
public interface OfertaService {
    public List<Oferta> listarOfertas();
    
    public Oferta encontrarOfertaPorFolio(Oferta oferta);
        
    public void registrarOferta(Oferta oferta);
    
    public void modificarOferta(Oferta oferta);
    
    public void eliminarOferta(Oferta oferta);
}
