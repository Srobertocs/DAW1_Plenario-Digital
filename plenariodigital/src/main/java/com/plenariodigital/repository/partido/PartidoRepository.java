package com.plenariodigital.repository.partido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plenariodigital.model.Partido;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Integer> {
}
