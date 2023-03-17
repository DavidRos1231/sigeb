package mx.edu.utez.sigeb.utils.ignoreMe;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import mx.edu.utez.sigeb.models.Usuario;
import mx.edu.utez.sigeb.utils.Conn;
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
                MongoDatabase database = mongoClient.getDatabase("test").withCodecRegistry(pojoCodecRegistry);

                //this line is for get the collection
                MongoCollection<Usuario> collection = database.getCollection("usuarios", Usuario.class);

                String name= "Juan";
                //this line is for get the first document from the collection
                Usuario usuario = collection.find(eq("name", "Juan")).first();


                //this line is for post a new document in the collection: Usuarios, using POJOS
                Usuario newUser = new Usuario();
                newUser.setName("pedro");

                if (collection.insertOne(newUser)!= null) {
                    System.out.println("se registro el usuario");
                } else {
                    System.out.println("No se pudo registrar el usuario");
                }
            } else {
                System.out.println("No se pudo realizar la conexión");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
