package com.tucarta.tucarta.service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.tucarta.tucarta.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class UsuarioService {

    private final FirebaseAuth auth = FirebaseAuth.getInstance();
    private final DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Usuarios");


    public CompletableFuture<Usuario> registrarUsuario(Usuario usuario, String password) {
        CompletableFuture<Usuario> future = new CompletableFuture<>();
        String email = usuario.getEmail();
        try {
            UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                    .setEmail(email)
                    .setPassword(password);

            UserRecord userRecord = auth.createUser(request);
            String userId = userRecord.getUid();
            System.out.println("Usuario creado exitosamente: " + userId);

            DatabaseReference usuarioRef = ref.child(userId);
            usuario.setId(userId);

            usuarioRef.setValue(usuario, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError error, DatabaseReference ref) {
                    if (error != null) {
                        System.out.println("Error al guardar el usuario: " + error.getMessage());
                        future.completeExceptionally(new RuntimeException("Error al guardar el usuario"));
                    } else {
                        System.out.println("Usuario guardado con éxito en " + ref.getKey());
                        future.complete(usuario);
                    }
                }
            });

        } catch (FirebaseAuthException e) {
            System.err.println("Error al crear el usuario: " + e.getMessage());
            future.completeExceptionally(new RuntimeException("Error al crear el usuario"));
        }

        return future;
    }

}
