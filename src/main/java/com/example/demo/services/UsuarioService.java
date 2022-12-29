package com.example.demo.services;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.UsuarioModels;
import com.example.demo.repositories.UsuarioRepositorio;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepositorio usuarioRepository;

    public ArrayList<UsuarioModels> obtenerUsuarios(){
        return (ArrayList<UsuarioModels>) usuarioRepository.findAll();
    }

    public UsuarioModels guardarUsuario(UsuarioModels usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModels> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public ArrayList<UsuarioModels>  obtenerPorPrioridad(Integer prioridad) {
        return usuarioRepository.findByPrioridad(prioridad);
    }
}
