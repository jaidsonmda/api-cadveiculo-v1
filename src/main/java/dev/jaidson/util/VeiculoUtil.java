package dev.jaidson.util;

import dev.jaidson.domain.Veiculo;
import dev.jaidson.dto.VeiculoDTO;
import dev.jaidson.entity.VeiculoEntity;

import java.util.ArrayList;
import java.util.List;

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
        return veiculo;
    }
    public static VeiculoEntity dtoToEntity(VeiculoDTO dto) {
        VeiculoEntity veiculoEntity = new VeiculoEntity();
        veiculoEntity.setAno(dto.ano);
        veiculoEntity.setVeiculo(dto.veiculo);
        veiculoEntity.setDescricao(dto.descricao);
        veiculoEntity.setMarca(dto.marca);
        veiculoEntity.setVendido(dto.vendido);
        return veiculoEntity;
    }
}
