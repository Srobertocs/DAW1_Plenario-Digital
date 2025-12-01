package com.plenariodigital.service;

import com.plenariodigital.repository.politico.PoliticoRepository;

import org.springframework.stereotype.Service;

import com.plenariodigital.model.Politico;

import jakarta.transaction.Transactional;

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
}
