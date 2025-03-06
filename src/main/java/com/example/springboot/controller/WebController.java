package com.example.springboot.controller;

import com.example.springboot.model.Livro;
import com.example.springboot.model.Reserva;
import com.example.springboot.service.LivroService;
import com.example.springboot.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

  @Autowired
  private LivroService livroService;

  @Autowired
  private ReservaService reservaService;

  @GetMapping("/")
  public String index() {
    return "redirect:/livros-page";
  }

  // Páginas de Livros
  @GetMapping("/livros-page")
  public String livrosPage(Model model) {
    model.addAttribute("livros", livroService.getAllLivros());
    return "livros";
  }

  @GetMapping("/livro-form")
  public String livroForm(Model model) {
    model.addAttribute("livro", new Livro());
    return "livro-form";
  }

  @GetMapping("/livro-editar/{id}")
  public String livroEditar(@PathVariable Long id, Model model) {
    model.addAttribute("livro", livroService.getLivroById(id).orElse(new Livro()));
    return "livro-form";
  }

  // Páginas de Reservas
  @GetMapping("/reservas-page")
  public String reservasPage(Model model) {
    model.addAttribute("reservas", reservaService.getAllReservas());
    return "reservas";
  }

  @GetMapping("/reserva-form")
  public String reservaForm(Model model) {
    model.addAttribute("reserva", new Reserva());
    model.addAttribute("livros", livroService.getAllLivros());
    model.addAttribute("statusOpcoes", Reserva.StatusReserva.values());
    return "reserva-form";
  }

  @GetMapping("/reserva-editar/{id}")
  public String reservaEditar(@PathVariable Long id, Model model) {
    model.addAttribute("reserva", reservaService.getReservaById(id).orElse(new Reserva()));
    model.addAttribute("livros", livroService.getAllLivros());
    model.addAttribute("statusOpcoes", Reserva.StatusReserva.values());
    return "reserva-form";
  }
}