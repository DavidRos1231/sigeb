package mx.edu.utez.sigeb.controllers.libro;

import mx.edu.utez.sigeb.models.libro.DaoLibro;
import mx.edu.utez.sigeb.models.libro.Libro;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

public class ServiceLibro {


    public JSONArray listLibros() {
        DaoLibro daoLibro = new DaoLibro();
        JSONArray jsonArray = new JSONArray();
        for (Libro libro : daoLibro.listLibros()) {
            jsonArray.add(libro.toJson());
        }
        return jsonArray;
    };
    public JSONObject getLibro(long id) {
        DaoLibro daoLibro = new DaoLibro();
        Libro libro = daoLibro.getLibro(id);

        return libro.toJson();
    };

    public boolean saveLibro(Libro libro){
        DaoLibro daoLibro=new DaoLibro();
        return daoLibro.saveLibro(libro);
    }


}
