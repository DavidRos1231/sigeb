package mx.edu.utez.sigeb.services;

import mx.edu.utez.sigeb.models.Usuario.DaoUsuario;
import mx.edu.utez.sigeb.models.Usuario.Usuario;

public class ServiceUsuario {

    public boolean saveUsuario(Usuario usuario){
        DaoUsuario daoUsuario=new DaoUsuario();
        return daoUsuario.saveUsuario(usuario);
    }

}
