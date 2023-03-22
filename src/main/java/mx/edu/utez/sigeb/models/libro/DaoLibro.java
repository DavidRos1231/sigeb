package mx.edu.utez.sigeb.models.libro;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import mx.edu.utez.sigeb.models.Usuario;
import mx.edu.utez.sigeb.utils.Conn;
import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import static com.mongodb.client.model.Filters.eq;

public class DaoLibro {
    CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
    CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

    public List<Libro> listLibros() {
        List<Libro> listLibros = new ArrayList<>();
        try (MongoClient mongoClient = Conn.getConnection()) {
            MongoDatabase database = mongoClient.getDatabase("sigeb").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Libro> collection = database.getCollection("listLibros", Libro.class);
            MongoCursor<Libro> cursor = collection.find().iterator();
            while (cursor.hasNext()) {
                listLibros.add(cursor.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listLibros;
    }

    public Libro getLibro(long id) {
        System.out.println(id);
        Libro libroObject = new Libro();
        try (MongoClient mongoClient = Conn.getConnection();) {
            MongoDatabase database = mongoClient.getDatabase("sigeb").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Libro> collection = database.getCollection("libros", Libro.class);
            libroObject = collection.find(eq("id", id)).first();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(libroObject);
        return libroObject;
    }


    public boolean saveLibro(Libro libro) {
        boolean result = false;

        try (MongoClient mongoClient = Conn.getConnection();) {
            MongoDatabase database = mongoClient.getDatabase("sigeb").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Libro> collection = database.getCollection("libros", Libro.class);
            collection.insertOne(libro);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
        return result;
    }


}
