package com.gimnasio.controllers;

import com.gimnasio.domain.Categoria;
import com.gimnasio.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categorias")
    public String listar(Model model) {
        var categorias = categoriaService.getCategorias();
        model.addAttribute("categorias", categorias);
        return "categorias/listado";
    }

    @GetMapping("/categorias/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categorias/formulario";
    }

    @PostMapping("/categorias/guardar")
    public String guardar(Categoria categoria) {
        categoriaService.save(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/categorias/editar/{id}")
    public String editar(@PathVariable("id") Integer id, Model model) {
        Categoria categoria = new Categoria();
        categoria.setId(id);
        categoria = categoriaService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "categorias/formulario";
    }

    @GetMapping("/categorias/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id) {
        Categoria categoria = new Categoria();
        categoria.setId(id);
        categoriaService.delete(categoria);
        return "redirect:/categorias";
    }
}
