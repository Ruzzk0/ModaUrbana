package Entity;

import java.util.Map;

/**
 * Clase que representa un inventario que contiene productos y categorías.
 * 
 * @autor Ruzzky
 */
public class Inventario {

    // Mapa de productos, donde la clave es el identificador del producto y el valor es el objeto Producto
    private Map<String, Producto> productos;
    
    // Mapa de categorías, donde la clave es el nombre de la categoría y el valor es el objeto Categoria
    private Map<String, Categoria> categorias;

    /**
     * Constructor por defecto.
     */
    public Inventario() {
    }

    /**
     * Constructor con parámetros.
     * 
     * @param productos El mapa de productos, donde la clave es el identificador del producto y el valor es el objeto Producto.
     * @param categorias El mapa de categorías, donde la clave es el nombre de la categoría y el valor es el objeto Categoria.
     */
    public Inventario(Map<String, Producto> productos, Map<String, Categoria> categorias) {
        this.productos = productos;
        this.categorias = categorias;
    }

    /**
     * Obtiene el mapa de productos.
     * 
     * @return El mapa de productos, donde la clave es el identificador del producto y el valor es el objeto Producto.
     */
    public Map<String, Producto> getProductos() {
        return productos;
    }

    /**
     * Establece el mapa de productos.
     * 
     * @param productos El nuevo mapa de productos, donde la clave es el identificador del producto y el valor es el objeto Producto.
     */
    public void setProductos(Map<String, Producto> productos) {
        this.productos = productos;
    }

    /**
     * Obtiene el mapa de categorías.
     * 
     * @return El mapa de categorías, donde la clave es el nombre de la categoría y el valor es el objeto Categoria.
     */
    public Map<String, Categoria> getCategorias() {
        return categorias;
    }

    /**
     * Establece el mapa de categorías.
     * 
     * @param categorias El nuevo mapa de categorías, donde la clave es el nombre de la categoría y el valor es el objeto Categoria.
     */
    public void setCategorias(Map<String, Categoria> categorias) {
        this.categorias = categorias;
    }
}
