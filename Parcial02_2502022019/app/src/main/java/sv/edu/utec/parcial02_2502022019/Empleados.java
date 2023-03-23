package sv.edu.utec.parcial02_2502022019;

public class Empleados {

    private String Nombre;
    private String Cargo;
    private String Compañia;
    private int avatar;

    public Empleados(String nombre, String cargo, String compañia, int avatar) {
        Nombre = nombre;
        Cargo = cargo;
        Compañia = compañia;
        this.avatar = avatar;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String cargo) {
        Cargo = cargo;
    }

    public String getCompañia() {
        return Compañia;
    }

    public void setCompañia(String compañia) {
        Compañia = compañia;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
}
