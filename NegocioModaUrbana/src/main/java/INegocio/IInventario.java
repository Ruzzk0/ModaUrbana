package INegocio;

import com.mycompany.dominiodto.CategoriaDTO;
import com.mycompany.dominiodto.InventarioDTO;
import com.mycompany.dominiodto.ProductoDTO;
import java.util.Map;

/**
 * Interfaz que define las operaciones de negocio para gestionar el inventario.
 * 
 * @autor Ruzzky
 */
public interface IInventario {

    /**
     * Obtiene el inventario completo.
     * 
     * @return Un objeto InventarioDTO que representa el inventario completo.
     */
    InventarioDTO obtenerInventario();

    /**
     * Obtiene un mapa de todos los productos en el inventario.
     * 
     * @return Un mapa donde la clave es el identificador único del producto y el valor es el objeto ProductoDTO correspondiente.
     */
    Map<String, ProductoDTO> obtenerProductos();

    /**
     * Obtiene un mapa de todas las categorías en el inventario.
     * 
     * @return Un mapa donde la clave es el nombre de la categoría y el valor es el objeto CategoriaDTO correspondiente.
     */
    Map<String, CategoriaDTO> obtenerCategorias();

    /**
     * Actualiza el mapa de productos en el inventario.
     * 
     * @param productos El nuevo mapa de productos a actualizar en el inventario.
     */
    void actualizarProductos(Map<String, ProductoDTO> productos);

    /**
     * Actualiza el mapa de categorías en el inventario.
     * 
     * @param categorias El nuevo mapa de categorías a actualizar en el inventario.
     */
    void actualizarCategorias(Map<String, CategoriaDTO> categorias);
}
