package com.plenariodigital.service;

import org.springframework.stereotype.Service;

import com.plenariodigital.model.ProjetoDeLei;
import com.plenariodigital.repository.projeto.ProjetoRepository;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class ProjetoLeiService {

  private final ProjetoRepository repositorio;

  public ProjetoLeiService(ProjetoRepository repositorio) {
    this.repositorio = repositorio;
  }

  @Transactional
  public void salvar(ProjetoDeLei projetoDeLei) {
    this.repositorio.save(projetoDeLei);
  }

  @Transactional
  public List<ProjetoDeLei> BuscaProjetos() {
    return this.repositorio.findAll();
  }

  @Transactional
  public void ExcluirProjeto(Integer id){
    this.repositorio.deleteById(id);
  }
}
