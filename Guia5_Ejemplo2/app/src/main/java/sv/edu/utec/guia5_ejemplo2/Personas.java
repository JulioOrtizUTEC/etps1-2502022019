package sv.edu.utec.guia5_ejemplo2;

public class Personas {
    private String nombre;
    private char genero;
    public Personas(String nombre, char genero) {
        this.nombre=nombre;
        this.genero=genero;
    }
    public String getNombre() {
        return nombre;
    }
    public char getGenero() {
        return genero;
    }
}
