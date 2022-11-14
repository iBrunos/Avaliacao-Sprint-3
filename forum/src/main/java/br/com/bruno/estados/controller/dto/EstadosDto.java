package br.com.bruno.estados.controller.dto;

public class EstadosDto {
   
    private int id;
    private String nome;
    private String regiao;
    private Long populacao;
    private Long capital;
    private float area;
    
    public EstadosDto(String nome, String regiao, Long populacao, Long capital, float area) {
        this.nome = nome;
        this.regiao = regiao;
        this.populacao = populacao;
        this.capital = capital;
        this.area = area;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getRegiao() {
        return regiao;
    }

    public Long getPopulacao() {
        return populacao;
    }

    public Long getCapital() {
        return capital;
    }

    public float getArea() {
        return area;
    }

}
