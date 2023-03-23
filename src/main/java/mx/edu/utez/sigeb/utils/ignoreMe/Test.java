package mx.edu.utez.sigeb.utils.ignoreMe;
import mx.edu.utez.sigeb.models.libro.Libro;
import mx.edu.utez.sigeb.services.ServiceLibro;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class Test {
    public static void main(String[] args) {
        JSONArray listado = new JSONArray();
        ServiceLibro serviceLibro = new ServiceLibro();
        listado = serviceLibro.listLibros();
        //imprimir listado
        System.out.println(listado);

        //obtener un libro
        JSONObject libro = serviceLibro.getLibro(8);
        System.out.println("a"+ libro);

        //actualizar un libro
       /* Libro libro1 = new Libro();
        libro1 = libro1.fromJson(libro);
        libro1.setCategoria("Clásicos");
        if (serviceLibro.updateLibro(libro1)){
            System.out.println("se actualizo");
        }else {
            System.out.println("no se actualizo");
        }*/

       /* //eliminar un libro
        if (serviceLibro.deleteLibro(7)) {
            System.out.println("se elimino");
        }else {
            System.out.println("no se elimino");
        }*/
    }
}
