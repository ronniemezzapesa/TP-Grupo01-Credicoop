package ar.edu.dds.libros;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import io.javalin.Javalin;
import io.javalin.http.Context;
import java.net.URI;
import java.net.URISyntaxException;

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

        String[] keys = new String[] { 
            "DATABASE_URL",
            "javax__persistence__jdbc__driver",
            "javax__persistence__jdbc__password",
            "javax__persistence__jdbc__url",
            "javax__persistence__jdbc__user",
            "hibernate__hbm2ddl__auto",
            "hibernate__connection__pool_size", 
            "hibernate__show_sql" 
        };

        for (String key : keys) {
            try {
                if (key.equals("DATABASE_URL")) {
                    String value = env.get(key);
                    URI dbUri = new URI(value);
                    String username = dbUri.getUserInfo().split(":")[0];
                    String password = dbUri.getUserInfo().split(":")[1];

                    // Cambiando a la URL de PostgreSQL
                    value = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
                    configOverrides.put("javax.persistence.jdbc.url", value);
                    configOverrides.put("javax.persistence.jdbc.user", username);
                    configOverrides.put("javax.persistence.jdbc.password", password);
                    configOverrides.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
                }

                // Reemplazando "__" con "." en las claves
                String key2 = key.replace("__", ".");
                if (env.containsKey(key)) {
                    String value = env.get(key);
                    configOverrides.put(key2, value);
                }
            } catch (URISyntaxException e) {
                System.err.println("Invalid URI syntax for DATABASE_URL: " + e.getMessage());
            } catch (Exception ex) {
                System.out.println("Error configurando " + key);    
            }
        }
        
        System.out.println("Config overrides ----------------------");
        for (String key : configOverrides.keySet()) {
            System.out.println(key + ": " + configOverrides.get(key));
        }
        
        return Persistence.createEntityManagerFactory("db", configOverrides);
    }
}
