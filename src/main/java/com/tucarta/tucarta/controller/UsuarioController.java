package com.tucarta.tucarta.controller;


import com.tucarta.tucarta.model.Usuario;
import com.tucarta.tucarta.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/crear/{password}")
    public CompletableFuture<ResponseEntity<Usuario>> crearUsuario(@RequestBody Usuario usuario, @PathVariable String password) {
        return usuarioService.registrarUsuario(usuario, password)
                .thenApply(nuevoUsuario -> ResponseEntity.ok().body(nuevoUsuario))
                .exceptionally(exception -> {

                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
                });
    }
}
