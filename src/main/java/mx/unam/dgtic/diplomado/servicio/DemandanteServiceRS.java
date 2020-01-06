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
import mx.unam.dgtic.diplomado.domain.Demandante;

@Path("/demandantes")
@Stateless
public class DemandanteServiceRS {
    @Inject
    private DemandanteService DemandanteService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Demandante> listarDemandantes() {
        return DemandanteService.listarDemandantes();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{rfc}")
    public Demandante encontrarDemandantePorRfc(@PathParam("rfc") String rfc) {
        return DemandanteService.encontrarDemandantePorRfc(new Demandante(rfc));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response agregarDemandante(Demandante demandante) {
        try {
            DemandanteService.registrarDemandante(demandante);
            return Response.ok().entity(demandante).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{rfc}")
    public Response modificarDemandante(@PathParam("rfc") String rfc, Demandante demandanteModificado) {
        try {
            Demandante persona = DemandanteService.encontrarDemandantePorRfc(new Demandante(rfc));
            if (persona != null) {
                DemandanteService.modificarDemandante(demandanteModificado);
                return Response.ok().entity(demandanteModificado).build();
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
    public Response eliminarDemandantePorRfc(@PathParam("rfc") String rfc) {
        try {
            DemandanteService.eliminarDemandante(new Demandante(rfc));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(404).build();
        }
    }
}
