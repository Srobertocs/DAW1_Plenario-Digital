package com.plenariodigital.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.plenariodigital.service.ProjetoLeiService;
import com.plenariodigital.service.PoliticoService;

import jakarta.validation.Valid;

import com.plenariodigital.model.ProjetoDeLei;
import com.plenariodigital.model.enums.resultadoVotacao;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import com.plenariodigital.model.Politico;
import org.springframework.web.bind.annotation.RequestParam;

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

    carregarInformacoesFormulario(model);

    if (hxRequestHeader != null) {
      return "projeto/cadastro_projeto :: formulario";
    } else {
      return "projeto/cadastro_projeto";
    }
  }

  @PostMapping("/projeto/cadastro_projeto")
  public String cadastrarProjeto(@Valid ProjetoDeLei projetoDeLei, BindingResult resultado,
      RedirectAttributes atributos, Model model,
      @RequestHeader(value = "HX-Request", required = false) String hxRequestHeader) {

    if (resultado.hasErrors()) {
      logger.info("O projeto é inválido para cadastro");
      logger.info("Erros encontrados:");

      carregarInformacoesFormulario(model);

      for (FieldError erro : resultado.getFieldErrors()) {
        logger.info("Erro de campo: {}", erro);
      }

      for (ObjectError erro : resultado.getGlobalErrors()) {
        logger.info("Erro global: {}", erro);
      }

      if (hxRequestHeader != null) {
        return "projeto/cadastro_projeto :: formulario";
      } else {
        return "projeto/cadastro_projeto";
      }

    } else {
      projetoServico.salvar(projetoDeLei);

      atributos.addFlashAttribute("mensagemSucesso", "rojeto de lei cadastrado com sucesso!");
      return "redirect:/projeto/cadastro_projeto";
    }
  }

  @GetMapping("/projetos/excluir/{id}")
  public String excluirProjeto(@PathVariable Integer id, Model model,
      @RequestHeader(value = "HX-Request", required = false) String hxRequestHeader) {

    projetoServico.ExcluirProjeto(id);

    return "layout/fragments/tabela_projetos :: conteudo_tabela_projeto";
  }

  public void carregarInformacoesFormulario(Model model) {
    model.addAttribute("statusVotacao", resultadoVotacao.values());
    List<Politico> politicos = politicoServico.buscaPoliticos();
    model.addAttribute("politicos", politicos);
    model.addAttribute("dataAtual", LocalDate.now());
  }

}
