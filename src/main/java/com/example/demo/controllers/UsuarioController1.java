package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.UsuarioModels;
import com.example.demo.services.UsuarioService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UsuarioController1 {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/hello1")
    public String hello(Model model){
        model.addAttribute("message", "Hola Mundo");
        return "helloworld";
    }

    @GetMapping("/listar")
    public String hello1(Model model){
        ArrayList<UsuarioModels> listas = usuarioService.obtenerUsuarios();
        model.addAttribute("listas", listas);
        return "iteracion";
    }

    @GetMapping("/nuevo")
	public String mostrarFormularioDeRegistrarContacto(Model modelo) {
		modelo.addAttribute("contacto", new UsuarioModels());
		return "nuevo";
	}

    @PostMapping("/nuevo")
	public String guardarContacto(@Validated UsuarioModels contacto,BindingResult bindingResult,RedirectAttributes redirect,Model modelo) {
		if(bindingResult.hasErrors()) {
			modelo.addAttribute("contacto", contacto);
			return "nuevo";
		}
		
		usuarioService.guardarUsuario(contacto);
		//redirect.addFlashAttribute("msgExito", "El contacto ha sido agregado con exito");
		return "redirect:/listar";
	}

    @GetMapping("/{id}/editar")
    public String obtenerUsuarioPorId(@PathVariable Long id,Model modelo) {
		Optional<UsuarioModels> contacto = usuarioService.obtenerPorId(id);
		modelo.addAttribute("contacto", contacto);
		return "nuevo1";
    }

    @PostMapping("/{id}/editar")
    public String actualizarContacto(@PathVariable Long id,@Validated UsuarioModels contacto,BindingResult bindingResult,RedirectAttributes redirect,Model modelo) {
        Optional<UsuarioModels> contactoDB = usuarioService.obtenerPorId(id);
        if(bindingResult.hasErrors()) {
            modelo.addAttribute("contacto", contacto);
        }

        //contactoDB.setNombre(contacto.getNombre());
        //contactoDB.setEmail(contacto.getEmail());
        //contactoDB.setPrioridad(contacto.getPrioridad());

        usuarioService.guardarUsuario(contacto);
		return "redirect:/listar";
    }
}
