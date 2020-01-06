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
import mx.unam.dgtic.diplomado.domain.Prestamo;

@Path("/prestamos")
@Stateless
public class PrestamoServiceRS {
    @Inject
    private PrestamoService prestamoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Prestamo> listarPrestamos() {
        return prestamoService.listarPrestamos();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{folio}")
    public Prestamo encontrarPrestamoPorRfc(@PathParam("folio") int folio) {
        return prestamoService.encontrarPrestamoPorFolio(new Prestamo(folio));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response agregarPrestamo(Prestamo prestamo) {
        try {
            prestamoService.registrarPrestamo(prestamo);
            return Response.ok().entity(prestamo).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{folio}")
    public Response modificarPrestamo(@PathParam("folio") int folio, Prestamo prestamoModificado) {
        try {
            Prestamo persona = prestamoService.encontrarPrestamoPorFolio(new Prestamo(folio));
            if (persona != null) {
                prestamoService.modificarPrestamo(prestamoModificado);
                return Response.ok().entity(prestamoModificado).build();
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
    public Response eliminarPrestamoPorRfc(@PathParam("folio") int folio) {
        try {
            prestamoService.eliminarPrestamo(new Prestamo(folio));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(404).build();
        }
    }
}
