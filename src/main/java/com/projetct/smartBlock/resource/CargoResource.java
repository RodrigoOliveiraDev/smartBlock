package com.projetct.smartBlock.resource;

import com.projetct.smartBlock.aux.CargoDTO;
import com.projetct.smartBlock.model.Cargo;
import com.projetct.smartBlock.model.Pessoa;
import com.projetct.smartBlock.repository.CargoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("cargo")
public class CargoResource {

    @Autowired
    private CargoRepository cargoRepository;

    @PostMapping("/registrar")
    public ResponseEntity register(@RequestBody @Valid CargoDTO cargo){
        try {
            Cargo cargoAux = cargoRepository.findCargoByDescricaoIgnoreCase(cargo.descricao());
            if (cargoAux != null) {
                return ResponseEntity.badRequest().body("Cargo já cadastrado no sistema.");
            }

            cargoAux = new Cargo(cargo.descricao());

            this.cargoRepository.save(cargoAux);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
