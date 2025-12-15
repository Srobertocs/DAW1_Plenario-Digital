package com.plenariodigital.repository.projeto;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plenariodigital.model.ProjetoDeLei;

import java.util.List;

@Repository
public interface ProjetoRepository extends JpaRepository<ProjetoDeLei, Integer> {

  @Override
  @EntityGraph(attributePaths = { "politico" })
  List<ProjetoDeLei> findAll();
}
