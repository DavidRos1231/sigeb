package mx.edu.utez.sigeb.controllers.libro;

import mx.edu.utez.sigeb.models.libro.DaoLibro;
import mx.edu.utez.sigeb.models.libro.Libro;
import org.bson.Document;

public class ServiceLibro {
    public Libro getLibro(String id) {
        DaoLibro daoLibro = new DaoLibro();
        Libro libro = daoLibro.getLibro(id);

        return libro;
    };
}
