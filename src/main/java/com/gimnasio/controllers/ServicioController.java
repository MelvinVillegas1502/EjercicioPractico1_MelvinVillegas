package com.gimnasio.controllers;

import com.gimnasio.domain.Servicio;
import com.gimnasio.service.CategoriaService;
import com.gimnasio.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/servicios")
    public String listar(Model model) {
        var servicios = servicioService.getServicios();
        model.addAttribute("servicios", servicios);
        return "servicios/listado";
    }

   @GetMapping("/servicios/nuevo")
public String nuevo(Model model) {
    Servicio servicio = new Servicio();
    servicio.setCategoria(new com.gimnasio.domain.Categoria());

    model.addAttribute("servicio", servicio);
    model.addAttribute("categorias", categoriaService.getCategorias());
    return "servicios/formulario";
}

    @PostMapping("/servicios/guardar")
    public String guardar(Servicio servicio) {
        servicioService.save(servicio);
        return "redirect:/servicios";
    }

    @GetMapping("/servicios/editar/{id}")
    public String editar(@PathVariable("id") Integer id, Model model) {
        Servicio servicio = new Servicio();
        servicio.setId(id);
        servicio = servicioService.getServicio(servicio);
        model.addAttribute("servicio", servicio);
        model.addAttribute("categorias", categoriaService.getCategorias());
        return "servicios/formulario";
    }

    @GetMapping("/servicios/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id) {
        Servicio servicio = new Servicio();
        servicio.setId(id);
        servicioService.delete(servicio);
        return "redirect:/servicios";
    }
}
