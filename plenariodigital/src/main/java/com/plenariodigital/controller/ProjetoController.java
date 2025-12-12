package com.plenariodigital.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.plenariodigital.model.ProjetoDeLei;
import com.plenariodigital.model.enums.resultadoVotacao;
import com.plenariodigital.service.ProjetoLeiService;
import com.plenariodigital.service.PoliticoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import com.plenariodigital.model.Politico;

@Controller
public class ProjetoController {

  private static final Logger logger = LoggerFactory.getLogger(ProjetoController.class);

  private final ProjetoLeiService projetoServico;
  private final PoliticoService politicoServico;

  public ProjetoController(ProjetoLeiService projetoServico, PoliticoService politicoServico) {
    this.projetoServico = projetoServico;
    this.politicoServico = politicoServico;
  }

  @GetMapping("/projeto/cadastro_projeto")
  public String abrirCadastro(ProjetoDeLei projetoDeLei, Model model,
      @RequestHeader(value = "HX-Request", required = false) String hxRequestHeader) {

    model.addAttribute("statusVotacao", resultadoVotacao.values());

    List<Politico> politicos = politicoServico.buscaPoliticos();
    model.addAttribute("politicos", politicos);

    if (hxRequestHeader != null) {
      return "projeto/cadastro_projeto :: formulario";
    } else {
      return "projeto/cadastro_projeto";
    }
  }

}
