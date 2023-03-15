package mx.edu.utez.sigeb.models;

public class Usuario {
    private String id;
    private String name;
    private String midname;
    private String lastname;
    private String correo;
    private String password;
    private int tipo;

    public Usuario(){}

    public Usuario(String id,String name,String midname,String lastname,String correo,String password,int tipo){
        this.id=id;
        this.name=name;
        this.midname=midname;
        this.lastname=lastname;
        this.correo=correo;
        this.password=password;
        this.tipo=tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
