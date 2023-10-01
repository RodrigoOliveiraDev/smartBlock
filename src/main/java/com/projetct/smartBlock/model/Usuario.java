package com.projetct.smartBlock.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "USUARIO")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer codigo;

    @OneToOne
    @JoinColumn (name="codPessoa", nullable = false)
    private Pessoa pessoa;

    private String login;
    private String senha;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of( new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    public Usuario(Integer codigo, Pessoa pessoa, String login, String senha) {
        this.codigo = codigo;
        this.pessoa = pessoa;
        this.login = login;
        this.senha = senha;
    }
    public Usuario(Pessoa pessoa, String login, String senha) {
        this.codigo = codigo;
        this.pessoa = pessoa;
        this.login = login;
        this.senha = senha;
    }

    public Usuario() {
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
