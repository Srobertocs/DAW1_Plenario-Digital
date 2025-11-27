package com.plenariodigital.service;

import org.springframework.stereotype.Service;
import com.plenariodigital.model.Partido;

import com.plenariodigital.repository.partido.PartidoRepository;

import jakarta.transaction.Transactional;

@Service
public class PartidoService {
  private final PartidoRepository repositorio;

  public PartidoService(PartidoRepository repositorio) {
    this.repositorio = repositorio;
  }

  @Transactional
  public void salvar(Partido partido) {
    this.repositorio.save(partido);
  }
}
