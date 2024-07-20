package dev.jaidson.dto;



import io.smallrye.common.constraint.NotNull;

import java.time.LocalDate;

public class VeiculoDTO {
   


    @NotNull
    public String veiculo;
    @NotNull
    public String marca;
    @NotNull
    public Integer ano;
    @NotNull
    public String descricao;
    @NotNull
    public String cor;
    @NotNull
    public boolean vendido;
    

}
