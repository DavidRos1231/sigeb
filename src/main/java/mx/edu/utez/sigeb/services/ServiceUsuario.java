package mx.edu.utez.sigeb.services;

import mx.edu.utez.sigeb.models.Usuario.DaoUsuario;
import mx.edu.utez.sigeb.models.Usuario.Usuario;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ServiceUsuario {

    public JSONArray listUsuarios() {
        DaoUsuario daoUsuario = new DaoUsuario();
        JSONArray jsonArray = new JSONArray();
        for (Usuario usuario : daoUsuario.listUsuarios()) {
            jsonArray.add(usuario.toJson());
        }
        return jsonArray;
    };

    public JSONObject getUsuario(long id){
        DaoUsuario daoUsuario=new DaoUsuario();
        return daoUsuario.getUsuario(id).toJson();
    }
    public boolean saveUsuario(Usuario usuario){
        DaoUsuario daoUsuario=new DaoUsuario();
        return daoUsuario.saveUsuario(usuario);
    }

    public boolean updateUsuario(Usuario usuario){
        DaoUsuario daoUsuario=new DaoUsuario();
        return daoUsuario.updateUsuario(usuario);
    }

    public boolean deleteUsuario(long id){
        DaoUsuario daoUsuario=new DaoUsuario();
        return daoUsuario.deleteUsuario(id);
    }




}
