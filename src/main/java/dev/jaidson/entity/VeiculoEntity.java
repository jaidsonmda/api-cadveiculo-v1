package dev.jaidson.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name="veiculos")
public class VeiculoEntity extends PanacheEntityBase {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "veiculos_SEQ")
    private Long id;

    @NotNull @NotBlank
    @Column(name = "veiculo")
    private String veiculo;
    @NotNull @NotBlank
    @Column(name = "marca")
    private String marca;
    @NotNull
    @Column(name = "ano" )
    private Integer ano;
    @NotNull @NotBlank
    @Column(name = "cor")
    private String cor;
    @NotNull @NotBlank
    @Column(name = "descricao")
    private String descricao;
    @NotNull
    @Column(name = "vendido")
    private boolean vendido;
    @Column(name = "created")
    private LocalDate created ;
    @Column(name ="updated" )
    private LocalDate updated ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }

}
