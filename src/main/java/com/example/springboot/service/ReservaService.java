package com.example.springboot.service;

import com.example.springboot.model.Reserva;
import com.example.springboot.model.Livro;
import com.example.springboot.model.Reserva.StatusReserva;
import com.example.springboot.repository.ReservaRepository;
import com.example.springboot.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

  @Autowired
  private ReservaRepository reservaRepository;

  @Autowired
  private LivroRepository livroRepository;

  // Buscar todas as reservas
  public List<Reserva> getAllReservas() {
    return reservaRepository.findAll();
  }

  // Buscar reserva por ID
  public Optional<Reserva> getReservaById(Long id) {
    return reservaRepository.findById(id);
  }

  // Buscar reservas por livro
  public List<Reserva> getReservasByLivro(Long livroId) {
    Optional<Livro> livro = livroRepository.findById(livroId);
    return livro.map(reservaRepository::findByLivro).orElse(List.of());
  }

  // Buscar reservas por status
  public List<Reserva> getReservasByStatus(StatusReserva status) {
    return reservaRepository.findByStatus(status);
  }

  // Buscar reservas por nome do cliente
  public List<Reserva> getReservasByNomeCliente(String nomeCliente) {
    return reservaRepository.findByNomeClienteContainingIgnoreCase(nomeCliente);
  }

  // Criar uma reserva
  public Reserva createReserva(Reserva reserva) {
    // Verificar se o livro tem reservas ativas (pendentes ou confirmadas)
    List<Reserva> reservasAtivas = reservaRepository.findReservasAtivasByLivroId(reserva.getLivro().getId());

    // Se não houver status definido, definir como PENDENTE por padrão
    if (reserva.getStatus() == null) {
      reserva.setStatus(StatusReserva.PENDENTE);
    }

    // Definir a data da reserva como a data atual se não for especificada
    if (reserva.getDataReserva() == null) {
      reserva.setDataReserva(LocalDate.now());
    }

    return reservaRepository.save(reserva);
  }

  // Atualizar uma reserva
  public Reserva updateReserva(Long id, Reserva reserva) {
    Optional<Reserva> existingReserva = reservaRepository.findById(id);
    if (existingReserva.isPresent()) {
      reserva.setId(id);
      return reservaRepository.save(reserva);
    }
    return null;
  }

  // Confirmar uma reserva
  public Reserva confirmarReserva(Long id) {
    Optional<Reserva> optionalReserva = reservaRepository.findById(id);
    if (optionalReserva.isPresent()) {
      Reserva reserva = optionalReserva.get();
      reserva.setStatus(StatusReserva.CONFIRMADA);
      return reservaRepository.save(reserva);
    }
    return null;
  }

  // Finalizar uma reserva
  public Reserva finalizarReserva(Long id) {
    Optional<Reserva> optionalReserva = reservaRepository.findById(id);
    if (optionalReserva.isPresent()) {
      Reserva reserva = optionalReserva.get();
      reserva.setStatus(StatusReserva.FINALIZADA);
      reserva.setDataFinalizada(LocalDate.now());
      return reservaRepository.save(reserva);
    }
    return null;
  }

  // Excluir uma reserva
  public void deleteReserva(Long id) {
    reservaRepository.deleteById(id);
  }
}