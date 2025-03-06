package com.example.springboot.repository;

import com.example.springboot.model.Reserva;
import com.example.springboot.model.Livro;
import com.example.springboot.model.Reserva.StatusReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

  List<Reserva> findByLivro(Livro livro);

  List<Reserva> findByStatus(StatusReserva status);

  List<Reserva> findByNomeClienteContainingIgnoreCase(String nomeCliente);

  @Query("SELECT r FROM Reserva r WHERE r.livro.id = :livroId AND r.status IN ('PENDENTE', 'CONFIRMADA')")
  List<Reserva> findReservasAtivasByLivroId(Long livroId);
}