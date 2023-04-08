package mx.edu.utez.sigeb.services;

import mx.edu.utez.sigeb.models.Usuario.DaoUsuario;
import mx.edu.utez.sigeb.models.Usuario.Usuario;
import org.json.simple.JSONArray;

public class ServiceUsuario {

    public boolean saveUsuario(Usuario usuario){
        DaoUsuario daoUsuario=new DaoUsuario();
        return daoUsuario.saveUsuario(usuario);
    }

    public JSONArray listUsuarios() {
        DaoUsuario daoUsuario = new DaoUsuario();
        JSONArray jsonArray = new JSONArray();
        for (Usuario usuario : daoUsuario.listUsuarios()) {
            jsonArray.add(usuario.toJson());
        }
        return jsonArray;
    };

}
