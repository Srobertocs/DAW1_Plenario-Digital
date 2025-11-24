package com.plenariodigital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.plenariodigital.model.Partido;

@Controller
public class PartidoController {
  @GetMapping("/partido/cadastro_partido.html")
  public String abrirCadastro(Partido partido) {
    return "/partido/cadastro_partido.html";
  }
}
