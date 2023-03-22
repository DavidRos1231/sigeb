package mx.edu.utez.sigeb.models.libro;


import org.json.simple.JSONObject;

public class Libro {
    private long libroId;
    private String nombre;
    private long stock;
    private String autor;
    private String categoria;

    //no falta un enable??
    public Libro() {
    }
    public Libro(String nombre, String autor, String categoria) {
        this.nombre = nombre;
        this.autor = autor;
        this.categoria = categoria;
    }
    public long getLibroId() {
        return libroId;
    }
    public void setLibroId(long libroId) {
        this.libroId = libroId;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public long getStock() {
        return stock;
    }
    public void setStock(long stock) {
        this.stock = stock;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String datos(int num){
        String datos[]={libroId +"", nombre,stock+"", autor,categoria};
        return datos[num];
    }
    public String getdatos(int num){
        String datos[]={getLibroId()+"", getNombre(),getStock()+"", getAutor(),getCategoria()};
        return datos[num];
    }
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("id", this.libroId);
        json.put("nombre", this.nombre);
        json.put("stock", this.stock);
        json.put("autor", this.autor);
        json.put("categoria", this.categoria);
        return json;
    }
}
