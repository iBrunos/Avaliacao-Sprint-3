package br.com.bruno.estados.controller.form;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.bruno.estados.model.Estado;
import br.com.bruno.estados.model.StatusRegiao;
import br.com.bruno.estados.repository.EstadoRepository;

public class AtualizacaoEstadoForm {
    @NotNull @NotEmpty @Length(min = 3)
    private String nome;
    @Enumerated(EnumType.STRING)
    private StatusRegiao regiao;
    private int populacao;
    @NotNull @NotEmpty @Length(min = 3)
    private String capital;
    private int area;

    public String getNome() {
        return nome;
    }
    public StatusRegiao getRegiao() {
        return regiao;
    }
    public int getPopulacao() {
        return populacao;
    }
    public String getCapital() {
        return capital;
    }
    public float getArea() {
        return area;
    }
public Estado atualizar(Long id, EstadoRepository estadosRepository){
    Estado  estado = estadosRepository.getOne(id);
    estado.setNome(this.nome);
    estado.setPopulacao(this.populacao);
    estado.setCapital(this.capital);
    estado.setArea(this.area);

    return estado;
}
    
}
