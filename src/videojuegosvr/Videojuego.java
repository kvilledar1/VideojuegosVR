
package videojuegosvr;

public class Videojuego extends Producto {
    private String genero;
    private String plataforma;

    public Videojuego(int id, String nombre, double precio, String genero, String plataforma) {
        super(id, nombre, precio);
        this.genero = genero;
        this.plataforma = plataforma;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    @Override
    public String toString() {
        return super.toString() + ", Genero: " + genero + ", Plataforma: " + plataforma;
    }
}
