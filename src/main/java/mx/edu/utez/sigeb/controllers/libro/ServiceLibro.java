package mx.edu.utez.sigeb.controllers.libro;

import mx.edu.utez.sigeb.models.libro.DaoLibro;
import mx.edu.utez.sigeb.models.libro.Libro;

public class ServiceLibro {
    public Libro getLibro(long id) {
        DaoLibro daoLibro = new DaoLibro();
        Libro libro = daoLibro.getLibro(id);

        return libro;
    };

    public boolean saveLibro(Libro libro){
        DaoLibro daoLibro=new DaoLibro();
        return daoLibro.saveLibro(libro);
    }

}
