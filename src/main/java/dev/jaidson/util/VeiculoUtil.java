package dev.jaidson.util;

import dev.jaidson.domain.Veiculo;
import dev.jaidson.dto.VeiculoDTO;
import dev.jaidson.entity.VeiculoEntity;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

public class VeiculoUtil {
    public static List<Veiculo> listaVeiculos(List<VeiculoEntity> veiculoEntityList){
        List<Veiculo> veiculoList = new ArrayList<>();
        for(VeiculoEntity ve:veiculoEntityList){
            veiculoList.add(entityToDomain(ve));

        }
        return veiculoList;
    }
    public static Veiculo entityToDomain(VeiculoEntity veiculoEntity) {

        Veiculo veiculo = new Veiculo();
        veiculo.id=veiculoEntity.getId();
        veiculo.veiculo=veiculoEntity.getVeiculo();
        veiculo.marca=veiculoEntity.getMarca();
        veiculo.descricao=veiculoEntity.getDescricao();
        veiculo.vendido=veiculoEntity.isVendido();
        veiculo.ano= veiculoEntity.getAno();
        veiculo.cor= veiculoEntity.getCor();
        veiculo.created =veiculoEntity.getCreated();
        veiculo.updated=veiculoEntity.getUpdated();
        return veiculo;
    }
    public static VeiculoEntity dtoToEntity(VeiculoDTO dto) {
        VeiculoEntity veiculoEntity = new VeiculoEntity();
        veiculoEntity.setAno(dto.ano);
        veiculoEntity.setVeiculo(dto.veiculo);
        veiculoEntity.setDescricao(dto.descricao);
        veiculoEntity.setMarca(dto.marca);
        veiculoEntity.setVendido(dto.vendido);
        veiculoEntity.setCor(dto.cor);
        veiculoEntity.setCreated(dto.created);
        return veiculoEntity;
    }
    public static void atualizacao(VeiculoDTO dto, VeiculoEntity veiculoEntitybanco) {
        if (nonNull(dto.veiculo)) {
            veiculoEntitybanco.setVeiculo(dto.veiculo);
        }
        if (nonNull(dto.ano)) {
            veiculoEntitybanco.setAno(dto.ano);
        }
        if (nonNull(dto.vendido)) {
            veiculoEntitybanco.setVendido(dto.vendido);
        }
        if (nonNull(dto.descricao)) {
            veiculoEntitybanco.setDescricao(dto.descricao);
        }
        if (nonNull(dto.marca)) {
            veiculoEntitybanco.setMarca(dto.marca);
        }
        if (nonNull(dto.cor)) {
            veiculoEntitybanco.setCor(dto.cor);
        }
    }
}
