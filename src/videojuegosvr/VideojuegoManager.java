
package videojuegosvr;

import java.util.ArrayList;
import java.util.List;


public class VideojuegoManager implements CrudOperations<Videojuego> {
    private List<Videojuego> videojuegos = new ArrayList<>();
    private int nextId = 1;

    @Override
    public void agregar(Videojuego videojuego) {
        videojuego = new Videojuego(nextId++, videojuego.getNombre(), videojuego.getPrecio(), videojuego.getGenero(), videojuego.getPlataforma());
        videojuegos.add(videojuego);
        System.out.println("Videojuego agregado: " + videojuego);
    }

    @Override
    public List<Videojuego> consultar() {
        if (videojuegos.isEmpty()) {
            System.out.println("No hay videojuegos registrados.");
            return new ArrayList<>();
        }
        return videojuegos;
    }

    @Override
    public Videojuego buscar(String criterio) {
        return videojuegos.stream()
                .filter(v -> v.getGenero().equalsIgnoreCase(criterio))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void actualizar(int id, Videojuego nuevoVideojuego) {
        for (Videojuego v : videojuegos) {
            if (v.getId() == id) {
                v.setNombre(nuevoVideojuego.getNombre());
                v.setPrecio(nuevoVideojuego.getPrecio());
                v.setGenero(nuevoVideojuego.getGenero());
                v.setPlataforma(nuevoVideojuego.getPlataforma());
                System.out.println("Videojuego actualizado: " + v);
                return;
            }
        }
        System.out.println("Videojuego con ID " + id + " no encontrado.");
    }

    @Override
    public void eliminar(int id) {
        if (videojuegos.removeIf(v -> v.getId() == id)) {
            System.out.println("Videojuego con ID " + id + " eliminado.");
        } else {
            System.out.println("Videojuego con ID " + id + " no encontrado.");
        }
    }
}
