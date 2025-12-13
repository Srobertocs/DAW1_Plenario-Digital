package com.plenariodigital.service;

import org.springframework.stereotype.Service;

import com.plenariodigital.model.ProjetoDeLei;
import com.plenariodigital.repository.projeto.ProjetoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProjetoLeiService {

  private final ProjetoRepository repositorio;

  public ProjetoLeiService(ProjetoRepository repositorio) {
    this.repositorio = repositorio;
  }

  @Transactional
  public void salvar(ProjetoDeLei projetoDeLei){
    this.repositorio.save(projetoDeLei);
  }
}
