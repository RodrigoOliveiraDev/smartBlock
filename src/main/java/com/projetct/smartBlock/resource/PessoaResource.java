package com.projetct.smartBlock.resource;

import com.projetct.smartBlock.aux.PessoaDTO;
import com.projetct.smartBlock.model.Cargo;
import com.projetct.smartBlock.model.Pessoa;
import com.projetct.smartBlock.repository.CargoRepository;
import com.projetct.smartBlock.repository.PessoaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("pessoa")
public class PessoaResource {
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private CargoRepository cargoRepository;

    @PostMapping("/registrar")
    public ResponseEntity register(@RequestBody @Valid PessoaDTO pessoa){
        try {
            Pessoa pessoaAux = pessoaRepository.findByCpf(pessoa.cpf());
            if (pessoaAux != null) {
                return ResponseEntity.badRequest().body("Pessoa com este CPF já existente no sistema!");
            }

            Optional<Cargo> cargo = cargoRepository.findById(pessoa.codCargo());

            if (cargo.isEmpty()) {
                return ResponseEntity.badRequest().body("Cargo não encontrado no sistema.");
            }
            pessoaAux = new Pessoa(pessoa.nome(), pessoa.cpf(), pessoa.indProfessor(), pessoa.indAdministrador(), cargo.get());
            this.pessoaRepository.save(pessoaAux);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
