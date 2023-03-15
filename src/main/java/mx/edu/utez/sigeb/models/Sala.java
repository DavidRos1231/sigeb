package mx.edu.utez.sigeb.models;

public class Sala {
    private long id;
    private long lugares;
    private boolean disponibilidad;
    private String descripcion;

    public Sala(){}
    public Sala(long id,long lugares,boolean disponibilidad,String descripcion){
        this.id=id;
        this.lugares=lugares;
        this.disponibilidad=disponibilidad;
        this.descripcion=descripcion;
    }

    public long getId() {        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLugares() {
        return lugares;
    }

    public void setLugares(long lugares) {
        this.lugares = lugares;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
