package com.example.springboot.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reserva")
public class Reserva {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "livro_id", nullable = false)
  private Livro livro;

  @Column(nullable = false)
  private String nomeCliente;

  @Column(nullable = false)
  private String emailCliente;

  private String telefoneCliente;

  @Column(nullable = false)
  private LocalDate dataReserva;

  private LocalDate dataFinalizada;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private StatusReserva status;

  private String observacao;

  public enum StatusReserva {
    PENDENTE, // A reserva foi criada, mas ainda não confirmada
    CONFIRMADA, // A reserva foi confirmada
    FINALIZADA // A reserva foi concluída (check-out ou evento ocorrido)
  }

  // Construtores
  public Reserva() {
  }

  public Reserva(Livro livro, String nomeCliente, String emailCliente, String telefoneCliente,
      LocalDate dataReserva, StatusReserva status) {
    this.livro = livro;
    this.nomeCliente = nomeCliente;
    this.emailCliente = emailCliente;
    this.telefoneCliente = telefoneCliente;
    this.dataReserva = dataReserva;
    this.status = status;
  }

  // Getters e Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Livro getLivro() {
    return livro;
  }

  public void setLivro(Livro livro) {
    this.livro = livro;
  }

  public String getNomeCliente() {
    return nomeCliente;
  }

  public void setNomeCliente(String nomeCliente) {
    this.nomeCliente = nomeCliente;
  }

  public String getEmailCliente() {
    return emailCliente;
  }

  public void setEmailCliente(String emailCliente) {
    this.emailCliente = emailCliente;
  }

  public String getTelefoneCliente() {
    return telefoneCliente;
  }

  public void setTelefoneCliente(String telefoneCliente) {
    this.telefoneCliente = telefoneCliente;
  }

  public LocalDate getDataReserva() {
    return dataReserva;
  }

  public void setDataReserva(LocalDate dataReserva) {
    this.dataReserva = dataReserva;
  }

  public LocalDate getDataFinalizada() {
    return dataFinalizada;
  }

  public void setDataFinalizada(LocalDate dataFinalizada) {
    this.dataFinalizada = dataFinalizada;
  }

  public StatusReserva getStatus() {
    return status;
  }

  public void setStatus(StatusReserva status) {
    this.status = status;
  }

  public String getObservacao() {
    return observacao;
  }

  public void setObservacao(String observacao) {
    this.observacao = observacao;
  }
}