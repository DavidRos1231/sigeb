package mx.edu.utez.sigeb.utils;

import com.mongodb.MongoException;
import com.mongodb.client.*;



public class Conn {

    static String uri = "mongodb+srv://20213tn128:9MuEp7pR5btT1xVb@dbsigeb.pyhq9x8.mongodb.net/?retryWrites=true&w=majority";

    public static MongoClient getConnection() {
        try {
            return MongoClients.create(uri);
        } catch (MongoException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        if (getConnection() != null) {
            System.out.println("Correcta conexión");
        } else {
            System.out.println("Conexión no realizada");
        }
        //the next lines are for testing the connection and getting the first document from the collection
       /*MongoDatabase database = mongoClient.getDatabase("test"); // test is the name of the database like the default database "test"
        MongoCollection<Document> collection = database.getCollection("usuarios");
        Document myDoc = collection.find(eq("nombre", "Juan")).first();
        if(myDoc != null){
            System.out.println(myDoc.toJson());
        }else{
            System.out.println("No se encontro el documento");
        }*/
    }
}
