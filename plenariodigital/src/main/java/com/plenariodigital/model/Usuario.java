package com.plenariodigital.model;

import java.io.Serializable;
import java.util.Objects;

import com.plenariodigital.model.enums.tipoUsuario;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
@Table(name = "usuario", schema = "camaralegislativa")
public class Usuario implements Serializable {
  private static final Long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_usuario")
  private Integer id;
  @NotBlank(message = "O login é obrigatório")
  @Column(name = "login", length = 100, nullable = false, unique = true)
  private String login;
  @NotBlank(message = "A senha é obrigatória")
  @Column(name = "senha", length = 255, nullable = false)
  private String senha;
  @Enumerated(EnumType.STRING)
  @Column(name = "tipo", length = 50, nullable = false)
  private tipoUsuario tipo;

  // === RELACIONAMENTO ==
  @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Politico politico;

  public Integer getId() {
    return id;
  }

  public String getLogin() {
    return login;
  }

  public String getSenha() {
    return senha;
  }

  public tipoUsuario getTipo() {
    return tipo;
  }

  public Politico getPolitico() {
    return politico;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public void setTipo(tipoUsuario tipo) {
    this.tipo = tipo;
  }

  public void setPolitico(Politico politico) {
    this.politico = politico;
  }

  @Override
  public String toString() {
    return "Usuario [id=" + id + ", login=" + login + ", senha=" + senha + ", tipo=" + tipo + "]";
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
    Usuario other = (Usuario) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
