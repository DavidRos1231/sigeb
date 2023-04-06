package mx.edu.utez.sigeb.models.prestamo;

public class Prestamo {
    private int id;
    private int idejemplar;
    private int intstatus;
    private String nomejemplar;
    private String userid;
    private String fechainicial;
    private String fechafinal;
    private int dias;
    private int status;
    private String descripcion;

    public Prestamo() {
    }

    public Prestamo(int id, int idejemplar, int intstatus, String nomejemplar, String userid, String fechainicial, String fechafinal, int dias, int status, String descripcion) {
        this.id = id;
        this.idejemplar = idejemplar;
        this.intstatus = intstatus;
        this.nomejemplar = nomejemplar;
        this.userid = userid;
        this.fechainicial = fechainicial;
        this.fechafinal = fechafinal;
        this.dias = dias;
        this.status = status;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdejemplar() {
        return idejemplar;
    }

    public void setIdejemplar(int idejemplar) {
        this.idejemplar = idejemplar;
    }

    public int getIntstatus() {
        return intstatus;
    }

    public void setIntstatus(int intstatus) {
        this.intstatus = intstatus;
    }

    public String getNomejemplar() {
        return nomejemplar;
    }

    public void setNomejemplar(String nomejemplar) {
        this.nomejemplar = nomejemplar;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFechainicial() {
        return fechainicial;
    }

    public void setFechainicial(String fechainicial) {
        this.fechainicial = fechainicial;
    }

    public String getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(String fechafinal) {
        this.fechafinal = fechafinal;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
