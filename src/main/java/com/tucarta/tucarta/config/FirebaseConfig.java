package com.tucarta.tucarta.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import java.io.FileInputStream;
import java.io.IOException;


@Configuration
public class FirebaseConfig {

    @PostConstruct
    public static void initialize() throws IOException {
        // Obtener la ruta del archivo serviceAccountKey.json
        String filePath = FirebaseConfig.class.getClassLoader().getResource("serviceAccountKey.json").getPath();
        System.out.println("Ruta del archivo serviceAccountKey.json: " + filePath);

        // Leer las credenciales desde el archivo
        FileInputStream serviceAccount = new FileInputStream(filePath);

        // Configurar FirebaseOptions
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://tu-carta-f5121-default-rtdb.firebaseio.com")
                .build();

        // Inicializar FirebaseApp
        FirebaseApp.initializeApp(options);
    }
}
