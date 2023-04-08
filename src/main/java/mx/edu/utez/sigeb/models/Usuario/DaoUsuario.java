package mx.edu.utez.sigeb.models.Usuario;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import mx.edu.utez.sigeb.utils.Conn;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class DaoUsuario {
    CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
    CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));


    public boolean saveUsuario(Usuario usuario) {
        boolean result = false;

        try (MongoClient mongoClient = Conn.getConnection()) {
            MongoDatabase database = mongoClient.getDatabase("sigeb").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Usuario> collection = database.getCollection("usuarios", Usuario.class);
            collection.insertOne(usuario);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
        return result;
    }
}
