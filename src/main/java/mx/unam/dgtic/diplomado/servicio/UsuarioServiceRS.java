package mx.unam.dgtic.diplomado.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mx.unam.dgtic.diplomado.domain.Usuario;

@Path("/usuarios")
@Stateless
public class UsuarioServiceRS {
    @Inject
    private UsuarioService usuarioService;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{rfc}")
    public Usuario encontrarUsuarioPorRfc(@PathParam("rfc") String rfc) {
        return usuarioService.encontrarUsuarioPorRfc(new Usuario(rfc));
    }

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response agregarUsuario(Usuario usuario) {
        try {
            usuarioService.registrarUsuario(usuario);
            return Response.ok().entity(usuario).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{rfc}")
    public Response modificarUsuario(@PathParam("rfc") String rfc, Usuario usuarioModificado) {
        try {
            Usuario persona = usuarioService.encontrarUsuarioPorRfc(new Usuario(rfc));
            if (persona != null) {
                usuarioService.modificarUsuario(usuarioModificado);
                return Response.ok().entity(usuarioModificado).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("{rfc}")
    public Response eliminarUsuarioPorRfc(@PathParam("rfc") String rfc) {
        try {
            usuarioService.eliminarUsuario(new Usuario(rfc));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(404).build();
        }
    }
}
