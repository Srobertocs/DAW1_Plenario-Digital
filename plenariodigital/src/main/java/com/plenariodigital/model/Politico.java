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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "politico", schema = "camaralegislativa")
public class Politico implements Serializable {
  private static final Long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_politico")
  private Integer id;
  @NotBlank(message = "O nome do politico é obrigatório")
  @Column(name = "nome", length = 100, nullable = false)
  private String nome;
  @NotBlank(message = "O e-mail do politico é obrigatório")
  @Column(name = "email", length = 200, nullable = false)
  private String email;
  @NotBlank(message = "O cpf do politico é obrigatório")
  @Column(name = "cpf", length = 14, unique = true, nullable = false)
  private String cpf;

  // === RELACIONAMENTOS ==

  // Relacionamento com partido
  @NotNull(message = "O partido é obrigatorio")
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_fkpartido", nullable = false)
  private Partido partido;

  // Relacionamento com usuario
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_fkusuario", unique = true, nullable = true)
  private Usuario usuario;

  @OneToMany(mappedBy = "politico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<ProjetoDeLei> projetoDeLei;

  public Integer getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String getEmail() {
    return email;
  }

  public String getCpf() {
    return cpf;
  }

  public Partido getPartido() {
    return partido;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public void setPartido(Partido partido) {
    this.partido = partido;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  @Override
  public String toString() {
    return "Politico [id=" + id + ", nome=" + nome + ", endereco=" + email + ", cpf=" + cpf + "]";
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
    Politico other = (Politico) obj;
    if (id != other.id)
      return false;
    return true;
  }

}
