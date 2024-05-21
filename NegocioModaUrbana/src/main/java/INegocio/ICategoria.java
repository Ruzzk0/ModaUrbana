
package INegocio;

import com.mycompany.dominiodto.CategoriaDTO;
import java.util.List;

/**
 *
 * @author Ruzzky
 */
public interface ICategoria {
    List<CategoriaDTO> obtenerTodasCategorias();

    CategoriaDTO obtenerCategoriaPorNombre(String nombre);

    void crearCategoria(CategoriaDTO categoria);

    void actualizarCategoria(CategoriaDTO categoria);

    void eliminarCategoria(String nombre);
}
