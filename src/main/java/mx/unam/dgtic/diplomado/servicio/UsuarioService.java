package mx.unam.dgtic.diplomado.servicio;

import java.util.List;
import javax.ejb.Local;
import mx.unam.dgtic.diplomado.domain.Usuario;

@Local
public interface UsuarioService {
    public List<Usuario> listarUsuarios();
    
    public Usuario encontrarUsuarioPorRfc(Usuario usuario);
        
    public void registrarUsuario(Usuario usuario);
    
    public void modificarUsuario(Usuario usuario);
    
    public void eliminarUsuario(Usuario usuario);
}
