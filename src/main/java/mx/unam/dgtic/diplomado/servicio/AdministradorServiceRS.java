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
import mx.unam.dgtic.diplomado.domain.Administrador;

@Path("/administrador")
@Stateless
public class AdministradorServiceRS {
    @Inject
    private AdministradorService administradorService;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Administrador> listarAdministradors() {
        return administradorService.listarAdministradors();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{rfc}")
    public Administrador encontrarAdministradorPorRfc(@PathParam("rfc") String rfc) {
        return administradorService.encontrarAdministradorPorRfc(new Administrador(rfc));
    }

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response agregarAdministrador(Administrador administrador) {
        try {
            administradorService.registrarAdministrador(administrador);
            return Response.ok().entity(administrador).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{rfc}")
    public Response modificarAdministrador(@PathParam("rfc") String rfc, Administrador administradorModificado) {
        try {
            Administrador persona = administradorService.encontrarAdministradorPorRfc(new Administrador(rfc));
            if (persona != null) {
                administradorService.modificarAdministrador(administradorModificado);
                return Response.ok().entity(administradorModificado).build();
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
    public Response eliminarAdministradorPorRfc(@PathParam("rfc") String rfc) {
        try {
            administradorService.eliminarAdministrador(new Administrador(rfc));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(404).build();
        }
    }
}
