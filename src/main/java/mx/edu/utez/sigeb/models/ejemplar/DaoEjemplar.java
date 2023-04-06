package mx.edu.utez.sigeb.models.ejemplar;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import mx.edu.utez.sigeb.models.libro.Libro;
import mx.edu.utez.sigeb.utils.Conn;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class DaoEjemplar {
    CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
    CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

    public List<Ejemplar> listEjemplar(int id){
        List<Ejemplar> listEjenplar = new ArrayList<>();
        try (MongoClient mongoClient = Conn.getConnection()) {
            MongoDatabase database = mongoClient.getDatabase("sigeb").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Ejemplar> collection = database.getCollection("ejemplares", Ejemplar.class);
            MongoCursor<Ejemplar> cursor = collection.find().iterator();
            while (cursor.hasNext()) {
                Ejemplar iter = cursor.next();
                if (iter.getIdlibro() == id) {
                    listEjenplar.add(iter);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listEjenplar;
    }

    public boolean guardarEjemplar(Ejemplar ejemplar, int cantidad){
        boolean flag = false;
        try (MongoClient mongoClient = Conn.getConnection()) {
            MongoDatabase database = mongoClient.getDatabase("sigeb").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Ejemplar> collection = database.getCollection("ejemplares", Ejemplar.class);
            for (int i = 0; i < cantidad; i++) {
                collection.insertOne(ejemplar);
            }
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

}
