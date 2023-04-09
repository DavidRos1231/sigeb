package mx.edu.utez.sigeb.models.Usuario;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import mx.edu.utez.sigeb.utils.Conn;
import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class DaoUsuario {
    CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
    CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
    public List<Usuario> listUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try (MongoClient mongoClient = Conn.getConnection()) {
            MongoDatabase database = mongoClient.getDatabase("sigeb").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Usuario> collection = database.getCollection("usuarios", Usuario.class);
            MongoCursor<Usuario> cursor = collection.find().iterator();
            while (cursor.hasNext()) {
                usuarios.add((Usuario) cursor.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return usuarios;
        }
        return usuarios;
    }


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

    public Usuario getUsuario(long id) {
        Usuario usuario = new Usuario();
        try (MongoClient mongoClient = Conn.getConnection()) {
            MongoDatabase database = mongoClient.getDatabase("sigeb").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Usuario> collection = database.getCollection("usuarios", Usuario.class);
            MongoCursor cursor = collection.find().iterator();
            while (cursor.hasNext()) {
                Usuario iter = (Usuario) cursor.next();
                if (iter.getUsuarioId() == id) {
                    usuario = iter;
                    break;
                } else {
                    usuario = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return usuario;
        }
        return usuario;
    }

    public boolean updateUsuario(Usuario usuario) {
        boolean result = false;
        try (MongoClient mongoClient = Conn.getConnection()) {
            MongoDatabase database = mongoClient.getDatabase("sigeb").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Usuario> collection = database.getCollection("usuarios", Usuario.class);
            Bson filter = eq("usuarioId", usuario.getUsuarioId());
            collection.replaceOne(filter, usuario);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
        return result;
    }

    public boolean deleteUsuario(long id) {
        boolean result = false;
        try(MongoClient mongoClient = Conn.getConnection()){
            MongoDatabase database = mongoClient.getDatabase("sigeb").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Usuario> collection = database.getCollection("usuarios", Usuario.class);
            collection.updateOne(eq("usuarioId", id), new Document("$set", new Document("enable", 0)));
            result = true;
        }catch (Exception e){
            e.printStackTrace();
            return result;
        }
        return result;
    }
}
