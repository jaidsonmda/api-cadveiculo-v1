package dev.jaidson.domain;

import io.smallrye.common.constraint.NotNull;

import java.time.LocalDate;

public class Veiculo {
    public Long id;


    public String veiculo;

    public String marca;

    public Integer ano;
    @NotNull
    public String cor;

    public String descricao;

    public boolean vendido;


}
