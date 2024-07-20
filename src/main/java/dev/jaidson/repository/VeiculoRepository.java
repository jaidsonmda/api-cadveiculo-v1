package dev.jaidson.repository;

import dev.jaidson.entity.VeiculoEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class VeiculoRepository {
    @Transactional
    public VeiculoEntity create(VeiculoEntity veiculoEntity){
        veiculoEntity.setCreated(LocalDate.now());
        veiculoEntity.setUpdated(LocalDate.now());

        veiculoEntity.persist();
        return veiculoEntity;
    }
    @Transactional
    public List<VeiculoEntity> findAll() {
        return VeiculoEntity.find("SELECT ve FROM VeiculoEntity ve").list();
    }

    public List<VeiculoEntity> findAll(String marca, Integer ano, String cor) {
        return VeiculoEntity.find("SELECT ve FROM VeiculoEntity ve WHERE ve.marca=?1 AND ve.ano =?2 AND cor=?3", marca,ano,cor).list();
    }

    public VeiculoEntity findById(Integer id) {
        return VeiculoEntity.findById(id);
    }
    @Transactional
    public VeiculoEntity update(VeiculoEntity veiculoEntity) {
        veiculoEntity.setUpdated(LocalDate.now());
        VeiculoEntity.persist(veiculoEntity);
        return veiculoEntity;
    }
    @Transactional
    public VeiculoEntity updateVenda(Long id) {
        VeiculoEntity.update("vendido= true where id =?1", id);
        return VeiculoEntity.findById(id);
    }
}
