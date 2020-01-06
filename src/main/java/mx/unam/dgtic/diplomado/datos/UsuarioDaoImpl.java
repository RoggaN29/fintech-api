package mx.unam.dgtic.diplomado.datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import mx.unam.dgtic.diplomado.domain.Usuario;

@Stateless
public class UsuarioDaoImpl implements UsuarioDao{

    @PersistenceContext(unitName="FintechPU")
    EntityManager em;

    @Override
    public List<Usuario> findAllUsuarios() {
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }

    @Override
    public Usuario findPUsuarioByRFC(Usuario usuario) {
        return em.find(Usuario.class, usuario.getRfc());
    }

    @Override
    public void insertUsuario(Usuario usuario) {
        em.persist(usuario);
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        em.merge(usuario);
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        em.remove(em.merge(usuario));
    }
    
}
