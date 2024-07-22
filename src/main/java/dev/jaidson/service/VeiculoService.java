package dev.jaidson.service;

import dev.jaidson.dto.VeiculoDTO;
import dev.jaidson.entity.VeiculoEntity;
import dev.jaidson.repository.VeiculoRepository;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

import static dev.jaidson.util.VeiculoUtil.dtoToEntity;


@ApplicationScoped
public class VeiculoService {
    @Inject
    VeiculoRepository veiculoRepository;

    public List<VeiculoEntity> buscarVeiculos() {
        return veiculoRepository.findAll();
    }

    public List<VeiculoEntity> buscarVeiculosComParametros(String marca, Integer ano, String cor) {
        return veiculoRepository.findVeiculoComParametros(marca,ano,cor);
    }

    public VeiculoEntity buscarVeiculo(Integer id) {
        return veiculoRepository.findById(id);
    }

    @Transactional
    public VeiculoEntity adicionarVeiculo(VeiculoDTO dto) {
        VeiculoEntity veiculoEntity = dtoToEntity(dto);
       return veiculoRepository.create(veiculoEntity);
    }

    @Transactional
    public VeiculoEntity atualizarVeiculo(VeiculoDTO dto, Long id) {
        VeiculoEntity veiculoEntity = dtoToEntity(dto);
        veiculoEntity.setId(id);
        return veiculoRepository.update(dto,id);
    }
    @Transactional
    public VeiculoEntity venderVeiculo(VeiculoDTO dto,Long id) {
        return veiculoRepository.updateVenda(id);
    }
    @Transactional
    public void excluiVeiculo(Long id) {
     veiculoRepository.delete(id);
    }
}
