package ar.edu.dds.libros;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import io.javalin.Javalin;
import io.javalin.http.Context;

public class AppLibros {

    public static EntityManagerFactory entityManagerFactory;

    public static void main(String[] args) throws Exception {
        
        Map<String, String> env = System.getenv();
        for (String string : env.keySet()) {
            System.out.println(string + ": " + env.get(string));
        }
        
        entityManagerFactory = createEntityManagerFactory();
        String strport = System.getenv("PORT");
        if (strport == null) {
            strport = "8080";
        }
        Integer port = Integer.parseInt(strport);

        Javalin app = Javalin.create().start(port);
        
        LibrosController controller = new LibrosController(entityManagerFactory); 
        
        app.get("/libros", controller::listLibros);
        app.post("/libros", controller::addLibro);
    }

    public static EntityManagerFactory createEntityManagerFactory() throws Exception {
        Map<String, String> env = System.getenv();
        Map<String, Object> configOverrides = new HashMap<>();

        // Obtener la URL de la base de datos y las credenciales desde las variables de entorno
        String url = env.get("POSTGRES_URL");
        String username = env.get("POSTGRES_USER");
        String password = env.get("POSTGRES_PASSWORD");

        if (url != null) {
            configOverrides.put("javax.persistence.jdbc.url", url);
        } else {
            System.err.println("POSTGRES_URL no está configurada.");
        }

        if (username != null) {
            configOverrides.put("javax.persistence.jdbc.user", username);
        } else {
            System.err.println("POSTGRES_USER no está configurada.");
        }

        if (password != null) {
            configOverrides.put("javax.persistence.jdbc.password", password);
        } else {
            System.err.println("POSTGRES_PASSWORD no está configurada.");
        }

        configOverrides.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
        
        System.out.println("Config overrides ----------------------");
        for (String key : configOverrides.keySet()) {
            System.out.println(key + ": " + configOverrides.get(key));
        }
        
        return Persistence.createEntityManagerFactory("db", configOverrides);
    }
}
