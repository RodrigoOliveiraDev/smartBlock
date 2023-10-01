package com.projetct.smartBlock.aux;

import jakarta.validation.constraints.NotBlank;

public record CargoDTO(@NotBlank(message = "{descricaoCargo.not.blank}") String descricao) {
}
