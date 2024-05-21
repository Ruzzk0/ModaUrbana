
package NegocioBO;

import PersistenciaDAO.IInventarioDAO;
import com.mycompany.dominiodto.CategoriaDTO;
import com.mycompany.dominiodto.InventarioDTO;
import com.mycompany.dominiodto.ProductoDTO;
import java.util.Map;

/**
 *
 * @author Ruzzky
 */
public class InventarioBO {
 private IInventarioDAO inventarioDAO;

    public InventarioBO(IInventarioDAO inventarioDAO) {
        this.inventarioDAO = inventarioDAO;
    }

    public InventarioDTO obtenerInventario() {
        return inventarioDAO.obtener();
    }

    public Map<String, ProductoDTO> obtenerProductos() {
        return inventarioDAO.obtenerProductos();
    }

    public Map<String, CategoriaDTO> obtenerCategorias() {
        return inventarioDAO.obtenerCategorias();
    }

    public void actualizarProductos(Map<String, ProductoDTO> productos) {
        inventarioDAO.actualizarProductos(productos);
    }

    public void actualizarCategorias(Map<String, CategoriaDTO> categorias) {
        inventarioDAO.actualizarCategorias(categorias);
    }
}