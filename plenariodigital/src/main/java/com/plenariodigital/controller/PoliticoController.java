package com.plenariodigital.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.plenariodigital.service.PartidoService;
import com.plenariodigital.service.PoliticoService;

import jakarta.validation.Valid;

import com.plenariodigital.model.Partido;
import com.plenariodigital.model.Politico;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PoliticoController {
  private static final Logger logger = LoggerFactory.getLogger(PoliticoController.class);

  private final PartidoService partidoServico;
  private final PoliticoService politicoServico;

  public PoliticoController(PartidoService partidoServico, PoliticoService politicoServico) {
    this.partidoServico = partidoServico;
    this.politicoServico = politicoServico;
  }

  @GetMapping("/politico/cadastro_politico")
  public String abrirCadastro(Politico politico, Model model,
      @RequestHeader(value = "HX-Request", required = false) String hxRequestHeader) {

    carregarInformacaoFormulario(model);

    if (hxRequestHeader != null) {
      return "politico/cadastro_politico :: formulario";
    } else {
      return "politico/cadastro_politico";
    }
  }

  @PostMapping("/politico/cadastro_politico")
  public String cadastrarPolitico(@Valid Politico politico, BindingResult resultado, RedirectAttributes atributos,
      Model model,
      @RequestHeader(value = "HX-Request", required = false) String hxRequestHeader) {

    if (resultado.hasErrors()) {
      logger.info("O politico é inválido para cadastro");
      logger.info("Erros encontrados:");

      carregarInformacaoFormulario(model);

      for (FieldError erro : resultado.getFieldErrors()) {
        logger.info("Erro de campo: {}", erro);
      }

      for (ObjectError erro : resultado.getGlobalErrors()) {
        logger.info("Erro global: {}", erro);
      }

      if (hxRequestHeader != null) {
        return "politico/cadastro_politico :: formulario";
      } else {
        return "politico/cadastro_politico";
      }

    } else {

      politicoServico.salvar(politico);

      atributos.addFlashAttribute("mensagemSucesso", "Politico cadastrado com sucesso!");
      return "redirect:/politico/cadastro_politico";
    }

  }

  private void carregarInformacaoFormulario(Model model) {
    List<Partido> partidos = partidoServico.BuscaPartidos();
    model.addAttribute("partidos", partidos);
  }
}
