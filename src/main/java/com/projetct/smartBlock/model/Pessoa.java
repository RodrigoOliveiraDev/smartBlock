package com.projetct.smartBlock.model;

import jakarta.persistence.*;

@Entity
@Table(name = "PESSOA")
public class Pessoa {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer codigo;
    private String nome;
    private String cpf;
    private Integer indProfessor;
    private Integer indAdministrador;

    @Transient
    private Long codCargo;

    @OneToOne
    @JoinColumn(name="codCargo", unique = true, nullable = false)
    private Cargo cargo;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getIndProfessor() {
        return indProfessor;
    }

    public void setIndProfessor(Integer indProfessor) {
        this.indProfessor = indProfessor;
    }

    public Integer getIndAdministrador() {
        return indAdministrador;
    }

    public void setIndAdministrador(Integer indAdministrador) {
        this.indAdministrador = indAdministrador;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Long getCodCargo() {
        return codCargo;
    }

    public void setCodCargo(Long codCargo) {
        this.codCargo = codCargo;
    }
}
