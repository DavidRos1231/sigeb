package mx.edu.utez.sigeb.models.Usuario;

import org.json.simple.JSONObject;

import java.util.Date;

public class Usuario {
    private long usuarioId;
    private String name;
    private String midname;
    private String lastname;
    private String correo;
    private String password;

    private Date tiempo;
    private int tipo;

    public Usuario(){}

    public Usuario(long usuarioId, String name, String midname, String lastname, String correo, String password, Date tiempo, int tipo) {
        this.usuarioId = usuarioId;
        this.name = name;
        this.midname = midname;
        this.lastname = lastname;
        this.correo = correo;
        this.password = password;
        this.tiempo = tiempo;
        this.tipo = tipo;
    }

    public Usuario(String juan, String perez, String ramiez, String mail, String number, int tipo) {
        this.name = juan;
        this.midname = perez;
        this.lastname = ramiez;
        this.correo = mail;
        this.password = number;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Usuario{}";
    }

    public long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMidname() {
        return midname;
    }

    public void setMidname(String midname) {
        this.midname = midname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getTiempo() {
        return tiempo;
    }

    public void setTiempo(Date tiempo) {
        this.tiempo = tiempo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("usuarioId", this.usuarioId);
        jsonObject.put("name", this.name);
        jsonObject.put("midname", this.midname);
        jsonObject.put("lastname", this.lastname);
        jsonObject.put("correo", this.correo);
        jsonObject.put("password", this.password);
        jsonObject.put("tiempo", this.tiempo);
        jsonObject.put("tipo", this.tipo);
        return jsonObject;

    }
}
