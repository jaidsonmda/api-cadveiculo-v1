package dev.jaidson.resource;

import dev.jaidson.domain.Veiculo;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;
@QuarkusTest
class VeiculoResourceTest {

    @Test
    void retornaVeiculos() {
        given().when().get("/veiculos").then().statusCode(200);
    }

    @Test
    void retornaVeiculosComParametros() {
        given().queryParam("ano",2000)
                .queryParam("marca","Fiat")
                .queryParam("cor","Azul").when().get("/veiculos/veiculos").then().statusCode(200);
    }

    @Test
    void retornaVeiculo() {
        given().pathParam("id", 103).when().get("/veiculos/{id}").then().statusCode(200);
    }

    @Test
    void adicionaVeiculo() {
        given().body(new Veiculo()).when().post("/veiculos").then().statusCode(415);
    }

    @Test
    void atualizaVeiculo() {
    }

    @Test
    void atualizaVendaVeiculo() {
    }

    @Test
    void deletaVeiculo() {
    }
}