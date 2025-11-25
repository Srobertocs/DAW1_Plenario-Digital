package com.plenariodigital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.plenariodigital.model.Partido;

@Controller
public class PartidoController {
  @GetMapping("/partido/cadastro_partido")
  public String abrirCadastro(Partido partido,
      @RequestHeader(value = "HX-Request", required = false) String hxRequestHeader) {
    if (hxRequestHeader != null) {
      return "partido/cadastro_partido :: formulario";
    } else {
      return "partido/cadastro_partido";
    }
  }
}
