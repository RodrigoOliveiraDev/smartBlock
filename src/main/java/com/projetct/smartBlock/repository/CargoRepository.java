package com.projetct.smartBlock.repository;

import com.projetct.smartBlock.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
    Cargo findCargoByDescricaoIgnoreCase (String descricao);

}
