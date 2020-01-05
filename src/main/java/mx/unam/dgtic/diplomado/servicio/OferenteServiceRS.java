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
import mx.unam.dgtic.diplomado.domain.Oferente;

@Path("/oferentes")
@Stateless
public class OferenteServiceRS {
    @Inject
    private OferenteService oferenteService;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Oferente> listarPersonas() {
        return oferenteService.listarOferente();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{rfc}")
    public Oferente encontrarOferentePorRfc(@PathParam("rfc") String rfc) {
        return oferenteService.encontrarOferentePorRfc(new Oferente(rfc));
    }

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response agregarOferente(Oferente oferente) {
        try {
            oferenteService.registrarOferente(oferente);
            return Response.ok().entity(oferente).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{rfc}")
    public Response modificarOferente(@PathParam("rfc") String rfc, Oferente oferenteModificado) {
        try {
            Oferente persona = oferenteService.encontrarOferentePorRfc(new Oferente(rfc));
            if (persona != null) {
                oferenteService.modificarOferente(oferenteModificado);
                return Response.ok().entity(oferenteModificado).build();
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
    public Response eliminarOferentePorRfc(@PathParam("rfc") String rfc) {
        try {
            oferenteService.eliminarOferente(new Oferente(rfc));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(404).build();
        }
    }
}
