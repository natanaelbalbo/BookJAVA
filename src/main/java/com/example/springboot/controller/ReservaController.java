package com.example.springboot.controller;

import com.example.springboot.model.Reserva;
import com.example.springboot.model.Reserva.StatusReserva;
import com.example.springboot.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservas")
@CrossOrigin
public class ReservaController {

  @Autowired
  private ReservaService reservaService;

  @GetMapping
  public List<Reserva> getAllReservas() {
    return reservaService.getAllReservas();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Reserva> getReservaById(@PathVariable Long id) {
    Optional<Reserva> reserva = reservaService.getReservaById(id);
    return reserva.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/livro/{livroId}")
  public List<Reserva> getReservasByLivro(@PathVariable Long livroId) {
    return reservaService.getReservasByLivro(livroId);
  }

  @GetMapping("/status/{status}")
  public List<Reserva> getReservasByStatus(@PathVariable StatusReserva status) {
    return reservaService.getReservasByStatus(status);
  }

  @GetMapping("/cliente")
  public List<Reserva> getReservasByNomeCliente(@RequestParam String nome) {
    return reservaService.getReservasByNomeCliente(nome);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Reserva createReserva(@RequestBody Reserva reserva) {
    return reservaService.createReserva(reserva);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Reserva> updateReserva(@PathVariable Long id, @RequestBody Reserva reserva) {
    Reserva updatedReserva = reservaService.updateReserva(id, reserva);
    if (updatedReserva != null) {
      return new ResponseEntity<>(updatedReserva, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PatchMapping("/{id}/confirmar")
  public ResponseEntity<Reserva> confirmarReserva(@PathVariable Long id) {
    Reserva reserva = reservaService.confirmarReserva(id);
    if (reserva != null) {
      return new ResponseEntity<>(reserva, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PatchMapping("/{id}/finalizar")
  public ResponseEntity<Reserva> finalizarReserva(@PathVariable Long id) {
    Reserva reserva = reservaService.finalizarReserva(id);
    if (reserva != null) {
      return new ResponseEntity<>(reserva, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteReserva(@PathVariable Long id) {
    reservaService.deleteReserva(id);
  }
}