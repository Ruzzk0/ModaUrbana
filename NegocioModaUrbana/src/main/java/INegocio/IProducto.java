
package INegocio;

import com.mycompany.dominiodto.ProductoDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ruzzky
 */
public interface IProducto {
  List<ProductoDTO> obtenerTodosProductos();

    ProductoDTO obtenerProductoPorId(String id);

    void crearProducto(ProductoDTO producto);

    void actualizarProducto(ProductoDTO producto);

    void eliminarProducto(String id);

    Map<String, Integer> obtenerTallasCantidadesProducto(String id);

    void actualizarTallasCantidadesProducto(String id, Map<String, Integer> tallasCantidades);

}
