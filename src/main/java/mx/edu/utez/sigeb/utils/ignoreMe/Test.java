package mx.edu.utez.sigeb.utils.ignoreMe;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import mx.edu.utez.sigeb.controllers.libro.ServiceLibro;
import mx.edu.utez.sigeb.models.Usuario;
import mx.edu.utez.sigeb.models.libro.DaoLibro;
import mx.edu.utez.sigeb.models.libro.Libro;
import mx.edu.utez.sigeb.utils.Conn;
import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import static com.mongodb.client.model.Filters.eq;

public class Test {



    public static void main(String[] args) {
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
        // Replace the uri string with your MongoDB deployment's connection string


        try (MongoClient mongoClient = Conn.getConnection()){
            if (mongoClient != null) {
                //this line is for get the database
                MongoDatabase database = mongoClient.getDatabase("sigeb").withCodecRegistry(pojoCodecRegistry);

                //this line is for get the collection
                MongoCollection<Usuario> collection = database.getCollection("usuarios", Usuario.class);

                Libro libro = new Libro("Dios aquí","Enrique Cevallos","Historia");

                List<Libro> listado = new ArrayList<>();
               ServiceLibro serviceLibro = new ServiceLibro();
               listado = serviceLibro.listLibros();
                //imprimir listado
                for (Libro libro1 : listado) {
                    System.out.println(libro1.toJson());
                }
            } else {
                System.out.println("No se pudo realizar la conexión");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
