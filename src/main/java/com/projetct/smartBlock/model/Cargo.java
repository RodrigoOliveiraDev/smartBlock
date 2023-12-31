package com.projetct.smartBlock.model;

import jakarta.persistence.*;


@Entity
@Table(name = "CARGO")
public class Cargo {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;
    private String descricao;

    public Cargo(String descricao) {
        this.descricao = descricao;
    }

    public Cargo(){

    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
