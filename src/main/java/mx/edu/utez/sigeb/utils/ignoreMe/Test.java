package mx.edu.utez.sigeb.utils.ignoreMe;
import mx.edu.utez.sigeb.models.Usuario.Usuario;
import mx.edu.utez.sigeb.models.libro.Libro;
import mx.edu.utez.sigeb.services.ServiceLibro;
import mx.edu.utez.sigeb.services.ServiceUsuario;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class Test {
    public static void main(String[] args) {
       //pruebas de usuario
        ServiceUsuario serviceUsuario = new ServiceUsuario();
        //guardar un usuario

       /* Usuario usuario = new Usuario("Juan", "Perez", "Ramiez","correo@gmail.com","122" ,1 );
        if (serviceUsuario.saveUsuario(usuario)){
            System.out.println("se guardo");
        }else {
            System.out.println("no se guardo");
        }*/
        JSONArray usuarios = serviceUsuario.listUsuarios();
        System.out.println(usuarios);




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
