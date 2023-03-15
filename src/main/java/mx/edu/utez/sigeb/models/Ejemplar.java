package mx.edu.utez.sigeb.models;

public class Ejemplar {
    private int id;
    private int idlibro;
    private String name;
    private boolean estado;
    private String descripcion;
    private String editorial;

    public Ejemplar(){}
    public Ejemplar(int id,int idlibro,String name,boolean estado,String descripcion,String editorial){
        this.id=id;
        this.idlibro=idlibro;
        this.name=name;
        this.estado=estado;
        this.descripcion=descripcion;
        this.editorial=editorial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(int idlibro) {
        this.idlibro = idlibro;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

}
