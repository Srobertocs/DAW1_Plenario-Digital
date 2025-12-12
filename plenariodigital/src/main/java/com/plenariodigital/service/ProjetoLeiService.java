package com.plenariodigital.service;

import org.springframework.stereotype.Service;

import com.plenariodigital.repository.projeto.ProjetoRepository;

@Service
public class ProjetoLeiService {

  private final ProjetoRepository repositorio;

  public ProjetoLeiService(ProjetoRepository repositorio) {
    this.repositorio = repositorio;
  }

}
