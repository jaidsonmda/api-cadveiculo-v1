package dev.jaidson.repository;

import dev.jaidson.dto.VeiculoDTO;
import dev.jaidson.entity.VeiculoEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static dev.jaidson.util.VeiculoUtil.atualizacao;
import static java.util.Objects.nonNull;

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
        System.out.println("findAll()");
        return VeiculoEntity.find("SELECT ve FROM VeiculoEntity ve").list();
    }

    public List<VeiculoEntity> findVeiculoComParametros(String marca, Integer ano, String cor) {
        System.out.println(marca+" "+ano+" "+cor);
        return VeiculoEntity.list("SELECT ve FROM VeiculoEntity ve WHERE ve.marca=?1 AND ve.ano =?2 AND ve.cor=?3", marca,ano,cor);
    }

    public VeiculoEntity findById(Integer id) {
        return VeiculoEntity.findById(id);
    }
    @Transactional
    public VeiculoEntity update(VeiculoDTO dto, Long id) {
        VeiculoEntity veiculoEntitybanco = VeiculoEntity.findById(id);
        atualizacao(dto, veiculoEntitybanco);

        veiculoEntitybanco.setUpdated(LocalDate.now());

        veiculoEntitybanco.persist();
        return veiculoEntitybanco;

    }



    @Transactional
    public VeiculoEntity updateVenda(Long id) {
        VeiculoEntity.update("vendido= true where id =?1", id);
        return VeiculoEntity.findById(id);
    }


    @Transactional
    public void delete(Long id) {
        VeiculoEntity veiculoEntity = VeiculoEntity.findById(id);
        if(nonNull(veiculoEntity)) {
            veiculoEntity.delete();
        }else {
            throw new BadRequestException("Veiculo não encontrado!");
        }
    }
}
