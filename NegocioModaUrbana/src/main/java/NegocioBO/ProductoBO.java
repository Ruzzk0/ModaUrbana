
package NegocioBO;

import PersistenciaDAO.IProductoDAO;
import com.mycompany.dominiodto.ProductoDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ruzzky
 */
public class ProductoBO {
 private IProductoDAO productoDAO;

    public ProductoBO(IProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }

    public List<ProductoDTO> obtenerTodosProductos() {
        return productoDAO.obtenerTodos();
    }

    public ProductoDTO obtenerProductoPorId(String id) {
        return productoDAO.obtenerPorId(id);
    }

    public void crearProducto(ProductoDTO producto) {
        productoDAO.crear(producto);
    }

    public void actualizarProducto(ProductoDTO producto) {
        productoDAO.actualizar(producto);
    }

    public void eliminarProducto(String id) {
        productoDAO.eliminar(id);
    }

    public Map<String, Integer> obtenerTallasCantidadesProducto(String id) {
        return productoDAO.obtenerTallasCantidades(id);
    }

    public void actualizarTallasCantidadesProducto(String id, Map<String, Integer> tallasCantidades) {
        productoDAO.actualizarTallasCantidades(id, tallasCantidades);
    }
}

