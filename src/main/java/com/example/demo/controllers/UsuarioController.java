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


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModels> obtenerUsuarios(){

        ArrayList<UsuarioModels> lista = usuarioService.obtenerUsuarios();

        for (UsuarioModels b: lista) {
            System.out.println(b.toString());
        }


        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public UsuarioModels guardarUsuario(@RequestBody UsuarioModels usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }
}

