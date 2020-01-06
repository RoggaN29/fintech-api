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
import mx.unam.dgtic.diplomado.domain.Sesion;

@Path("/sesions")
@Stateless
public class SesionServiceRS {
    @Inject
    private SesionService sesionService;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Sesion> listarSesions() {
        return sesionService.listarSesions();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{rfc}")
    public Sesion encontrarSesionPorRfc(@PathParam("rfc") String rfcUsuario) {
        return sesionService.encontrarSesionPorRfc(new Sesion(rfcUsuario));
    }

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response agregarSesion(Sesion sesion) {
        try {
            sesionService.registrarSesion(sesion);
            return Response.ok().entity(sesion).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{rfc}")
    public Response modificarSesion(@PathParam("rfc") String rfcUsuario, Sesion sesionModificado) {
        try {
            Sesion persona = sesionService.encontrarSesionPorRfc(new Sesion(rfcUsuario));
            if (persona != null) {
                sesionService.modificarSesion(sesionModificado);
                return Response.ok().entity(sesionModificado).build();
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
    public Response eliminarSesionPorRfc(@PathParam("rfc") String rfcUsuario) {
        try {
            sesionService.eliminarSesion(new Sesion(rfcUsuario));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(404).build();
        }
    }
}
