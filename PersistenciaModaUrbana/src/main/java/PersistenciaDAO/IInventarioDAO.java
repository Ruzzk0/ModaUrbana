
package PersistenciaDAO;


import com.mycompany.dominiodto.CategoriaDTO;
import com.mycompany.dominiodto.InventarioDTO;
import com.mycompany.dominiodto.ProductoDTO;
import java.util.Map;

/**
 *
 * @author Ruzzky
 */
public interface IInventarioDAO {
    InventarioDTO obtener();

    Map<String, ProductoDTO> obtenerProductos();

    Map<String, CategoriaDTO> obtenerCategorias();

    void actualizarProductos(Map<String, ProductoDTO> productos);

    void actualizarCategorias(Map<String, CategoriaDTO> categorias);
}
