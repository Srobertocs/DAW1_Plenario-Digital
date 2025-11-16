package com.plenariodigital.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "partido", schema = "camaralegislativa")
public class Partido implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_partido")
  private Integer id;
  @NotBlank(message = "O nome do partido é obrigatório")
  @Column(name = "nome", length = 100, nullable = false)
  private String nome;
  @NotBlank(message = "O sigla do partido é obrigatório")
  @Column(name = "sigla", length = 50, nullable = false)
  private String sigla;

  // === RELACIONAMENTO ===
  @OneToMany(mappedBy = "partido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<Politico> politicos;

  public Integer getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String getSigla() {
    return sigla;
  }

  public Set<Politico> getPoliticos() {
    return politicos;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setSigla(String sigla) {
    this.sigla = sigla;
  }

  public void setPoliticos(Set<Politico> politicos) {
    this.politicos = politicos;
  }

  @Override
  public String toString() {
    return "Partido [id=" + id + ", nome=" + nome + ", sigla=" + sigla + "]";
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
    Partido other = (Partido) obj;
    return Objects.equals(id, other.id);
  }
}
