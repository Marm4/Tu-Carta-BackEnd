package com.tucarta.tucarta.service;

import com.google.firebase.database.*;
import com.tucarta.tucarta.model.Comercio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ComercioService {


    private final DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Usuarios");

    public CompletableFuture<Integer> guardarComercio(Comercio comercio, String usuarioId) {
        CompletableFuture<Integer> future = new CompletableFuture<>();

        if (comercio.getId() == null || comercio.getId().isEmpty()) {
            DatabaseReference nuevoComercioRef = ref.child(usuarioId).child("comercios").push();
            String nuevoId = nuevoComercioRef.getKey();
            comercio.setId(nuevoId);
        }

        DatabaseReference usuarioRef = ref.child(usuarioId);
        DatabaseReference comercioRef = usuarioRef.child("comercios").child(comercio.getId());

        comercioRef.setValue(comercio, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError error, DatabaseReference ref) {
                if (error != null) {
                    System.out.println("Error al guardar el comercio: " + error.getMessage());
                    future.complete(0);
                } else {
                    System.out.println("Comercio guardado con éxito.");
                    future.complete(1);
                }
            }
        });

        return future;
    }

    public CompletableFuture<Integer> actualizarComercio(Comercio comercio, String usuario){
        return guardarComercio(comercio, usuario);
    }

    public CompletableFuture<Integer> eliminarComercio(String usuarioId, String comercioId) {
        CompletableFuture<Integer> future = new CompletableFuture<>();

        DatabaseReference usuarioRef = ref.child(usuarioId);
        DatabaseReference comercioRef = usuarioRef.child("comercios").child(comercioId);

        // Eliminar el comercio de la base de datos
        comercioRef.removeValue(new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError error, DatabaseReference ref) {
                if (error != null) {
                    System.out.println("Error al eliminar el comercio: " + error.getMessage());
                    future.complete(0);
                } else {
                    System.out.println("Comercio eliminado con éxito.");
                    future.complete(1);
                }
            }
        });

        return future;
    }

    public CompletableFuture<Comercio> obtenerComercioPorId(String usuarioId, String comercioId) {
        DatabaseReference usuarioRef = ref.child(usuarioId);
        DatabaseReference comercioRef = usuarioRef.child("comercios").child(comercioId);
        CompletableFuture<Comercio> future = new CompletableFuture<>();

        comercioRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Comercio comercio = dataSnapshot.getValue(Comercio.class);
                future.complete(comercio);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                future.completeExceptionally(databaseError.toException());
            }
        });

        return future;
    }

    public CompletableFuture<List<Comercio>> obtenerComerciosDeUsuario(String usuarioId) {
        CompletableFuture<List<Comercio>> future = new CompletableFuture<>();

        DatabaseReference comerciosRef = ref.child(usuarioId).child("comercios");

        comerciosRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Comercio> comercios = new ArrayList<>();
                for (DataSnapshot comercioSnapshot : dataSnapshot.getChildren()) {
                    Comercio comercio = comercioSnapshot.getValue(Comercio.class);
                    comercios.add(comercio);
                }
                future.complete(comercios);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                future.completeExceptionally(databaseError.toException());
            }
        });

        return future;
    }
}
