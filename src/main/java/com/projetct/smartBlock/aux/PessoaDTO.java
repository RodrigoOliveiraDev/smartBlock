package com.projetct.smartBlock.aux;

import com.projetct.smartBlock.model.Pessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PessoaDTO(@NotBlank(message = "{nome.not.blank}")String nome
                    , @NotBlank(message = "{cpf.not.blank}") String cpf
                    , @NotNull (message = "{indProfessor.not.null}") Integer indProfessor
                    , @NotNull (message = "{indAdministrador.not.null}") Integer indAdministrador
                    , @NotNull (message = "{codCargo.not.null}")Long codCargo) {




}
