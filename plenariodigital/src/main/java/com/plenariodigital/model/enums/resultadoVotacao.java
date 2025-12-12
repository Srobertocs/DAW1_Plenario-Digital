package com.plenariodigital.model.enums;

public enum resultadoVotacao {
  APROVADO("Aprovado"),
  NEGADO("Negado"),
  NAO_VOTADO("Não votado");

  private final String descricao;

  resultadoVotacao(String descricao) {
    this.descricao = descricao;
  }

  public String getDescricao() {
    return this.descricao;
  }
}
