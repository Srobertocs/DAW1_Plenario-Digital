package com.plenariodigital.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.PostMapping;

import com.plenariodigital.model.Partido;
import com.plenariodigital.service.PartidoService;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import jakarta.validation.Valid;

@Controller
public class PartidoController {

  private static final Logger logger = LoggerFactory.getLogger(PartidoController.class);

  private final PartidoService servico;

  public PartidoController(PartidoService servico) {
    this.servico = servico;
  }

  /* Requisição para exibir o formulario de cadastro do partido */
  @GetMapping("/partido/cadastro_partido")
  public String abrirCadastro(Partido partido,
      @RequestHeader(value = "HX-Request", required = false) String hxRequestHeader) {
    if (hxRequestHeader != null) {
      return "partido/cadastro_partido :: formulario";
    } else {
      return "partido/cadastro_partido";
    }
  }

  @PostMapping("/partido/cadastro_partido")
  public String cadastrarPartido(@Valid Partido partido, BindingResult resultado, RedirectAttributes atributos,
      @RequestHeader(value = "HX-Request", required = false) String hxRequestHeader) {

    if (resultado.hasErrors()) {
      logger.info("O partido é inválido para cadastro");
      logger.info("Erros encontrados:");
      for (FieldError erro : resultado.getFieldErrors()) {
        logger.info("Erro de campo: {}", erro);
      }

      for (ObjectError erro : resultado.getGlobalErrors()) {
        logger.info("Erro global: {}", erro);
      }

      if (hxRequestHeader != null) {
        return "partido/cadastro_partido :: formulario";
      } else {
        return "partido/cadastro_partido";
      }

    } else {

      servico.salvar(partido);

      atributos.addFlashAttribute("mensagemSucesso", "Partido cadastrado com sucesso!");
      return "redirect:/partido/cadastro_partido";
    }
  }
}
