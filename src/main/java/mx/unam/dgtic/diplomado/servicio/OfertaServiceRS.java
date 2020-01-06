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
import mx.unam.dgtic.diplomado.domain.Oferta;

@Path("/ofertas")
@Stateless
public class OfertaServiceRS {
    @Inject
    private OfertaService ofertaService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Oferta> listarOfertas() {
        return ofertaService.listarOfertas();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{folio}")
    public Oferta encontrarOfertaPorRfc(@PathParam("folio") int folio) {
        return ofertaService.encontrarOfertaPorFolio(new Oferta(folio));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response agregarOferta(Oferta oferta) {
        try {
            ofertaService.registrarOferta(oferta);
            return Response.ok().entity(oferta).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{folio}")
    public Response modificarOferta(@PathParam("folio") int folio, Oferta ofertaModificado) {
        try {
            Oferta persona = ofertaService.encontrarOfertaPorFolio(new Oferta(folio));
            if (persona != null) {
                ofertaService.modificarOferta(ofertaModificado);
                return Response.ok().entity(ofertaModificado).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("{folio}")
    public Response eliminarOfertaPorRfc(@PathParam("folio") int folio) {
        try {
            ofertaService.eliminarOferta(new Oferta(folio));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(404).build();
        }
    }
}
