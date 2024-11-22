
package videojuegosvr;

import java.util.List;

public interface CrudOperations<T> {
    void agregar(T item);
    List<T> consultar();
    T buscar(String criterio);
    void actualizar(int id, T item);
    void eliminar(int id);
}
