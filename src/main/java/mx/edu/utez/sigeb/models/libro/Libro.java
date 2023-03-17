package mx.edu.utez.sigeb.models.libro;



public class Libro {
    private long id;
    private String name;
    private long stock;
    private String autor;
    private String categoria;
    public Libro() {
    }
    public Libro(long id, String name, long stock, String autor, String categoria, String file_name) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.autor = autor;
        this.categoria = categoria;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
}