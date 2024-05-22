package INegocio;

import com.mycompany.dominiodto.CategoriaDTO;
import java.util.List;

/**
 * Interfaz que define las operaciones de negocio para gestionar categorías.
 * 
 * @autor Ruzzky
 */
public interface ICategoria {

    /**
     * Obtiene una lista de todas las categorías.
     * 
     * @return Una lista de objetos CategoriaDTO que representan todas las categorías.
     */
    List<CategoriaDTO> obtenerTodasCategorias();

    /**
     * Obtiene una categoría por su nombre.
     * 
     * @param nombre El nombre de la categoría que se desea obtener.
     * @return Un objeto CategoriaDTO que representa la categoría encontrada, o null si no se encuentra.
     */
    CategoriaDTO obtenerCategoriaPorNombre(String nombre);

    /**
     * Crea una nueva categoría.
     * 
     * @param categoria El objeto CategoriaDTO que contiene los datos de la nueva categoría.
     */
    void crearCategoria(CategoriaDTO categoria);

    /**
     * Actualiza una categoría existente.
     * 
     * @param categoria El objeto CategoriaDTO que contiene los nuevos datos de la categoría.
     */
    void actualizarCategoria(CategoriaDTO categoria);

    /**
     * Elimina una categoría por su nombre.
     * 
     * @param nombre El nombre de la categoría que se desea eliminar.
     */
    void eliminarCategoria(String nombre);
}
