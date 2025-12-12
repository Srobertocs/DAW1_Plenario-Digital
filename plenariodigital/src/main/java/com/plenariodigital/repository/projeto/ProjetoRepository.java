package com.plenariodigital.repository.projeto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plenariodigital.model.ProjetoDeLei;;

@Repository
public interface ProjetoRepository extends JpaRepository<ProjetoDeLei, Integer> {
}
