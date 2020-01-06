package mx.unam.dgtic.diplomado.servicio;

import java.util.List;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.annotation.Resource;
import mx.unam.dgtic.diplomado.datos.UsuarioDao;
import mx.unam.dgtic.diplomado.domain.Usuario;

@Stateless
public class UsuarioServiceImpl implements UsuarioService{
    
    @Inject
    private UsuarioDao usuarioDao;

    @Resource
    private SessionContext contexto;

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioDao.findAllUsuarios();
    }

    @Override
    public Usuario encontrarUsuarioPorRfc(Usuario usuario) {
        return usuarioDao.findPUsuarioByRFC(usuario);
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        usuarioDao.insertUsuario(usuario);
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
        try {
            usuarioDao.updateUsuario(usuario);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuarioDao.deleteUsuario(usuario);
    }
}
