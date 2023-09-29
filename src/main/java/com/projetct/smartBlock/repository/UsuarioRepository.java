package com.projetct.smartBlock.repository;

import com.projetct.smartBlock.model.Pessoa;
import com.projetct.smartBlock.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByLogin(String login);

    Usuario findByPessoa(Pessoa pessoa);

}
