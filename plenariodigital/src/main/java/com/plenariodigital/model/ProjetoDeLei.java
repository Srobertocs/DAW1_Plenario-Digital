package com.plenariodigital.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.plenariodigital.model.enums.resultadoVotacao;

import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "projetodelei", schema = "camaralegislativa")
public class ProjetoDeLei implements Serializable {
  private static final Long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_projetodelei")
  private Integer id;

  @NotBlank(message = "O título do projeto de lei é obrigatório")
  @Column(name = "titulo", length = 200, nullable = false)
  private String titulo;

  @Column(name = "votos_favoraveis", nullable = false)
  private int votosFavoraveis;

  @Column(name = "votos_contrarios", nullable = false)
  private int votosContrarios;

  @NotNull(message = "Coloque o status que se encontra o projeto de lei")
  @Enumerated(EnumType.STRING)
  @Column(name = "resultado", length = 50, nullable = false)
  private resultadoVotacao resultado;

  @NotBlank(message = "O projeto de lei precisar ter um resumo de detalhamento")
  @Column(name = "resumo_lei", length = 500, nullable = false)
  private String resumoLei;

  @NotNull(message = "Coloque uma data para a votação do projeto")
  @Column(name = "data_votacao", nullable = false)
  private LocalDate data;

  // === RELACIONAMENTO ===
  @NotNull(message = "Um vereador autor precisa ser selecionado")
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_fkpolitico", nullable = false)
  private Politico politico;

  public Integer getId() {
    return id;
  }

  public String getTitulo() {
    return titulo;
  }

  public String getResumoLei() {
    return resumoLei;
  }

  public LocalDate getData() {
    return data;
  }

  public int getVotosFavoraveis() {
    return votosFavoraveis;
  }

  public int getVotosContrarios() {
    return votosContrarios;
  }

  public resultadoVotacao getResultado() {
    return resultado;
  }

  public Politico getPolitico() {
    return politico;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public void setVotosFavoraveis(int votosFavoraveis) {
    this.votosFavoraveis = votosFavoraveis;
  }

  public void setVotosContrarios(int votosContrarios) {
    this.votosContrarios = votosContrarios;
  }

  public void setResultado(resultadoVotacao resultado) {
    this.resultado = resultado;
  }

  public void setPolitico(Politico politico) {
    this.politico = politico;
  }

  public void setResumoLei(String resumoLei) {
    this.resumoLei = resumoLei;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "ProjetoDeLei [id=" + id + ", titulo=" + titulo + ", votosFavoraveis=" + votosFavoraveis
        + ", votosContrarios=" + votosContrarios + ", resultado=" + resultado + ", politico=" + politico + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ProjetoDeLei other = (ProjetoDeLei) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
