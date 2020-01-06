package mx.unam.dgtic.diplomado.datos;

import java.util.List;
import mx.unam.dgtic.diplomado.domain.Usuario;


public interface UsuarioDao {
    public List<Usuario> findAllUsuarios();
    
    public Usuario findPUsuarioByRFC(Usuario usuario);
    
    public void insertUsuario(Usuario usuario);
    
    public void updateUsuario(Usuario usuario);
    
    public void deleteUsuario(Usuario usuario);
}
