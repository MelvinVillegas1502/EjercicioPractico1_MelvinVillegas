package com.gimnasio.controllers;

import com.gimnasio.domain.Reserva;
import com.gimnasio.service.ReservaService;
import com.gimnasio.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private ServicioService servicioService;

    @GetMapping("/reservas")
    public String listar(Model model) {
        var reservas = reservaService.getReservas();
        model.addAttribute("reservas", reservas);
        return "reservas/listado";
    }

@GetMapping("/reservas/nuevo")
public String nuevo(Model model) {
    Reserva reserva = new Reserva();
    reserva.setServicio(new com.gimnasio.domain.Servicio());

    model.addAttribute("reserva", reserva);
    model.addAttribute("servicios", servicioService.getServicios());
    return "reservas/formulario";
}

    @PostMapping("/reservas/guardar")
    public String guardar(Reserva reserva) {
        reservaService.save(reserva);
        return "redirect:/reservas";
    }

    @GetMapping("/reservas/editar/{id}")
    public String editar(@PathVariable("id") Integer id, Model model) {
        Reserva reserva = new Reserva();
        reserva.setId(id);
        reserva = reservaService.getReserva(reserva);
        model.addAttribute("reserva", reserva);
        model.addAttribute("servicios", servicioService.getServicios());
        return "reservas/formulario";
    }

    @GetMapping("/reservas/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id) {
        Reserva reserva = new Reserva();
        reserva.setId(id);
        reservaService.delete(reserva);
        return "redirect:/reservas";
    }
}