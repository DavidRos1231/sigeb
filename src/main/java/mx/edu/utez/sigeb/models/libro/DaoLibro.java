package mx.edu.utez.sigeb.models.libro;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import mx.edu.utez.sigeb.models.Usuario;
import mx.edu.utez.sigeb.utils.Conn;
import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import static com.mongodb.client.model.Filters.eq;

public class DaoLibro {

    CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
    CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
    public Libro getLibro(String id) {
        Libro libro = new Libro();
        try(
                MongoClient mongoClient = Conn.getConnection();
                ){
            MongoDatabase database = mongoClient.getDatabase("test").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Libro> collection = database.getCollection("libros", Libro.class);
            //libro = collection.find(eq("_id", id)).first();
           Libro libroObject = collection.find(eq("name", id)).first();
           libro.setName(libroObject.getName());
        }catch (Exception e){
            e.printStackTrace();
        }

        return libro;
    }
}
