package dev.jaidson.resource;

import dev.jaidson.domain.Veiculo;
import dev.jaidson.dto.VeiculoDTO;
import dev.jaidson.entity.VeiculoEntity;
import dev.jaidson.service.VeiculoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import static dev.jaidson.util.VeiculoUtil.entityToDomain;
import static dev.jaidson.util.VeiculoUtil.listaVeiculos;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VeiculoResource {
    @Inject
    VeiculoService veiculoService;

    @GET
    @Path("veiculos")
    public Response retornaVeiculos() {
        return Response.status(Response.Status.OK)
                .entity(listaVeiculos(veiculoService
                        .buscarVeiculos())).build();
    }
    @Path("veiculos/veiculos")
    @GET
    public Response retornaVeiculosComParametros(@QueryParam("marca") String marca,
                                    @QueryParam("ano") Integer ano,
                                    @QueryParam("cor") String cor) {
        return Response.status(Response.Status.OK)
                .entity(listaVeiculos(veiculoService
                        .buscarVeiculosComParametros(marca, ano, cor))).build();
    }

    @GET
    @Path("veiculos/{id}")
    public Response retornaVeiculo(@PathParam("id") Integer id) {
        return Response.status(Response.Status.OK)
                .entity(entityToDomain(veiculoService
                        .buscarVeiculo(id))).build();
    }

    @POST
    @Path("veiculos")
    public Response adicionaVeiculo(@RequestBody VeiculoDTO dto) {
        return Response.status(Response.Status.CREATED)
                .entity(entityToDomain(veiculoService
                        .adicionarVeiculo(dto))).build();
    }

    @PUT
    @Path("veiculos/{id}")
    public Response atualizaVeiculo(@RequestBody VeiculoDTO dto,
                                    @PathParam("id") Long id) {
        return Response.status(Response.Status.OK).entity(entityToDomain(veiculoService.atualizarVeiculo(dto,id))).build();
    }

    @PATCH
    @Path("veiculos/{id}")
    public Response atualizaVendaVeiculo(@RequestBody VeiculoDTO dto,@PathParam("id") Long id) {
        return Response.status(Response.Status.OK).entity(entityToDomain(veiculoService.venderVeiculo(dto,id))).build();
    }

    @DELETE
    @Path("veiculos/{id}")
    public Response deletaVeiculo(@PathParam("id") Long id) {
        veiculoService.excluiVeiculo(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }


}
