package com.plenariodigital.repository.politico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plenariodigital.model.Politico;

@Repository
public interface PoliticoRepository extends JpaRepository<Politico, Integer> {
}
