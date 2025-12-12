package com.plenariodigital.service;

import com.plenariodigital.repository.politico.PoliticoRepository;
import com.plenariodigital.model.Politico;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class PoliticoService {
  private final PoliticoRepository repositorio;

  public PoliticoService(PoliticoRepository repositorio) {
    this.repositorio = repositorio;
  }

  @Transactional
  public void salvar(Politico politico) {
    this.repositorio.save(politico);
  }

  @Transactional
  public List<Politico> buscaPoliticos() {
    return this.repositorio.findAll();
  }
}
