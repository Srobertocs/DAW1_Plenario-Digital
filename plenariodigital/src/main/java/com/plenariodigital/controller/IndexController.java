package com.plenariodigital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.plenariodigital.service.ProjetoLeiService;
import com.plenariodigital.model.ProjetoDeLei;

import org.springframework.ui.Model;

import java.util.List;

@Controller
public class IndexController {

  private final ProjetoLeiService projetoServico;

  public IndexController(ProjetoLeiService projetoServico) {
    this.projetoServico = projetoServico;
  }

  @GetMapping(value = { "/", "/index.html" })
  public String index(Model model) {

    List<ProjetoDeLei> listaDeProjetos = projetoServico.BuscaProjetos();

    model.addAttribute("projetos", listaDeProjetos);

    return "index";
  }
}
