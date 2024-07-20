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

@Path("/veiculos")
public class VeiculoResource {
    @Inject
    VeiculoService veiculoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornaVeiculos() {
        return Response.status(Response.Status.OK)
                .entity(listaVeiculos(veiculoService
                        .buscarVeiculos())).build();
    }

    @GET
    @Path("?marca={marca}&ano={ano}&cor={cor}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornaVeiculos(@PathParam("marca") String marca,
                                    @PathParam("ano") Integer ano,
                                    @PathParam("cor") String cor) {
        return Response.status(Response.Status.OK)
                .entity(listaVeiculos(veiculoService
                        .buscarVeiculos(marca, ano, cor))).build();
    }

    @GET
    @Path("/{id}")
    public Response retornaVeiculo(@PathParam("id") Integer id) {
        return Response.status(Response.Status.OK)
                .entity(entityToDomain(veiculoService
                        .buscarVeiculo(id))).build();
    }

    @POST
    public Response adicionaVeiculo(@RequestBody VeiculoDTO dto) {
        return Response.status(Response.Status.CREATED)
                .entity(entityToDomain(veiculoService
                        .adicionarVeiculo(dto))).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizaVeiculo(@RequestBody VeiculoDTO dto,
                                    @PathParam("id") Long id) {
        return Response.status(Response.Status.OK).entity(entityToDomain(veiculoService.atualizarVeiculo(dto,id))).build();
    }

    @PATCH
    @Path("/vender/{id}")
    public Response atualizaVendaVeiculo(@PathParam("id") Long id) {
        return Response.status(Response.Status.OK).entity(entityToDomain(veiculoService.venderVeiculo(id))).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletaVeiculo(@PathParam("id") Long id) {
        return Response.status(Response.Status.NO_CONTENT).build();
    }


}
