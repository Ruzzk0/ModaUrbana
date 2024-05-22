package PersistenciaDAO;

import com.mycompany.dominiodto.ProductoDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ruzzky
 */
public interface IProductoDAO {
    List<ProductoDTO> obtenerTodos();

    ProductoDTO obtenerPorId(String id);

    void crear(ProductoDTO producto);

    void actualizar(ProductoDTO producto);

    void eliminar(String id);

    Map<String, Integer> obtenerTallasCantidades(String id);

    void actualizarTallasCantidades(String id, Map<String, Integer> tallasCantidades);
}