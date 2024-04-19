package com.tucarta.tucarta.controller;

import com.tucarta.tucarta.model.Comercio;
import com.tucarta.tucarta.service.ComercioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/comercios")
public class ComercioController {

    private final ComercioService comercioService;

    @Autowired
    public ComercioController(ComercioService comercioService) {
        this.comercioService = comercioService;
    }

    // Endpoint para crear un nuevo comercio
    @PostMapping("/guardar/{usuario}")
    public CompletableFuture<ResponseEntity<Integer>> crearComercio(@RequestBody Comercio comercio, @PathVariable String usuario) {
        return comercioService.guardarComercio(comercio, usuario)
                .thenApply(resultado -> ResponseEntity.status(HttpStatus.CREATED).body(resultado));
    }

    // Endpoint para obtener todos los comercios


    // Endpoint para obtener un comercio por su ID
    @GetMapping("/{usuarioId}/{comercioId}")
    public CompletableFuture<ResponseEntity<Comercio>> obtenerComercioPorId(@PathVariable String usuarioId, @PathVariable String comercioId) {
        return comercioService.obtenerComercioPorId(usuarioId, comercioId)
                .thenApply(comercio -> {
                    if (comercio != null) {
                        return ResponseEntity.ok(comercio);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                });
    }

    @PutMapping("/actualizar/{id}")
    public CompletableFuture<ResponseEntity<Integer>> actualizarComercio(@RequestBody Comercio comercio, @PathVariable String usuario) {
        return comercioService.actualizarComercio(comercio, usuario)
                .thenApply(resultado -> {
                    if (resultado == 1) {
                        return ResponseEntity.ok(resultado);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                });
    }

    // Endpoint para eliminar un comercio
    @DeleteMapping("/{usuarioId}/{comercioId}")
    public CompletableFuture<ResponseEntity<Void>> eliminarComercio(@PathVariable String usuarioId, @PathVariable String comercioId) {
        return comercioService.eliminarComercio(usuarioId, comercioId)
                .thenApply(resultado -> {
                    if (resultado == 1) {
                        return ResponseEntity.noContent().<Void>build();
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                });
    }

    @GetMapping("/{usuarioId}")
    public CompletableFuture<ResponseEntity<List<Comercio>>> obtenerComerciosUsuario(@PathVariable String usuarioId){
        return comercioService.obtenerComerciosDeUsuario(usuarioId)
                .thenApply(comercios -> {
                    if (comercios != null) {
                        return ResponseEntity.ok(comercios);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                });
    }
}
