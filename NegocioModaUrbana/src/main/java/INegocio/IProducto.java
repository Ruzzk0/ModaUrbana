package INegocio;

import com.mycompany.dominiodto.ProductoDTO;
import java.util.List;
import java.util.Map;

/**
 * Interfaz que define las operaciones de negocio para gestionar productos.
 * @autor Ruzzky
 */
public interface IProducto {

    /**
     * Obtiene una lista de todos los productos.
     * 
     * @return Una lista de objetos ProductoDTO que representan todos los productos.
     */
    List<ProductoDTO> obtenerTodosProductos();

    /**
     * Obtiene un producto por su identificador único.
     * 
     * @param id El identificador único del producto que se desea obtener.
     * @return Un objeto ProductoDTO que representa el producto encontrado, o null si no se encuentra.
     */
    ProductoDTO obtenerProductoPorId(String id);

    /**
     * Crea un nuevo producto.
     * 
     * @param producto El objeto ProductoDTO que contiene los datos del nuevo producto.
     */
    void crearProducto(ProductoDTO producto);

    /**
     * Actualiza un producto existente.
     * 
     * @param producto El objeto ProductoDTO que contiene los nuevos datos del producto.
     */
    void actualizarProducto(ProductoDTO producto);

    /**
     * Elimina un producto por su identificador único.
     * 
     * @param id El identificador único del producto que se desea eliminar.
     */
    void eliminarProducto(String id);

    /**
     * Obtiene las tallas y cantidades de un producto específico.
     * 
     * @param id El identificador único del producto del cual se desean obtener las tallas y cantidades.
     * @return Un mapa donde la clave es la talla y el valor es la cantidad en stock correspondiente.
     */
    Map<String, Integer> obtenerTallasCantidadesProducto(String id);

    /**
     * Actualiza las tallas y cantidades de un producto específico.
     * 
     * @param id El identificador único del producto del cual se desean actualizar las tallas y cantidades.
     * @param tallasCantidades El nuevo mapa de tallas y cantidades a actualizar para el producto.
     */
    void actualizarTallasCantidadesProducto(String id, Map<String, Integer> tallasCantidades);
}
