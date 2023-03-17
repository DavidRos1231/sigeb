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
        Libro libroObject = new Libro();
        try(
                MongoClient mongoClient = Conn.getConnection();
                ){
            MongoDatabase database = mongoClient.getDatabase("test").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Libro> collection = database.getCollection("libros", Libro.class);
            //libro = collection.find(eq("_id", id)).first();
            libroObject = collection.find(eq("name", id)).first();
        }catch (Exception e){
            e.printStackTrace();
        }

        return libroObject;
    }

    /*public BeanProducto getProducto(int id_producto){
        BeanProducto producto = new BeanProducto();
        try(
                Connection con = MysqlConexion.getConnection();
                PreparedStatement pstm = con.prepareStatement("select * from productos where id_producto=?");
        ){
            pstm.setInt(1,id_producto);
            ResultSet rs= pstm.executeQuery();
            while (rs.next()){
                producto.setId_producto(rs.getInt("id_producto"));
                producto.setId_categoria(rs.getInt("id_categoria"));
                producto.setNombre_producto(rs.getString("nombre_producto"));
                producto.setPrecio(rs.getInt("precio"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setDescripcion(rs.getString("descripcion"));

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return producto;
    }*/

    /*MongoClient mongoClient = new MongoClient("localhost", 27017); // Crear un objeto MongoClient
    MongoDatabase database = mongoClient.getDatabase("myDatabase"); // Obtener la base de datos
    MongoCollection<Document> collection = database.getCollection("productos"); // Obtener la colección de productos

    Document query = new Document("id_producto", id_producto); // Crear un objeto Document con el filtro de búsqueda
    Document producto = collection.find(query).first(); // Realizar la búsqueda y obtener el primer documento encontrado

    // Obtener los valores del documento y asignarlos a un objeto BeanProducto
    BeanProducto productoBean = new BeanProducto();
productoBean.setId_producto(producto.getInteger("id_producto"));
productoBean.setId_categoria(producto.getInteger("id_categoria"));
productoBean.setNombre_producto(producto.getString("nombre_producto"));
productoBean.setPrecio(producto.getInteger("precio"));
productoBean.setCantidad(producto.getInteger("cantidad"));
productoBean.setDescripcion(producto.getString("descripcion"));

mongoClient.close(); // Cerrar la conexión
return productoBean; // Devolver el objeto BeanProducto*/

}
