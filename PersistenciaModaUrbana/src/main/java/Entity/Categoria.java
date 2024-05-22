package Entity;

import java.util.List;

/**
 * Clase que representa una categoría de productos.
 * 
 * @author Ruzzky
 */
public class Categoria {

    // Nombre de la categoría (e.g., ropa de hombre, ropa de mujer, ropa de niños)
    private String nombre;
    
    // Lista de productos que pertenecen a esta categoría
    private List<Producto> productos;

    /**
     * Constructor por defecto.
     */
    public Categoria() {
    }

    /**
     * Constructor con parámetros.
     * 
     * @param nombre El nombre de la categoría.
     * @param productos La lista de productos pertenecientes a esta categoría.
     */
    public Categoria(String nombre, List<Producto> productos) {
        this.nombre = nombre;
        this.productos = productos;
    }

    /**
     * Obtiene el nombre de la categoría.
     * 
     * @return El nombre de la categoría.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la categoría.
     * 
     * @param nombre El nuevo nombre de la categoría.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la lista de productos de la categoría.
     * 
     * @return La lista de productos de la categoría.
     */
    public List<Producto> getProductos() {
        return productos;
    }

    /**
     * Establece la lista de productos de la categoría.
     * 
     * @param productos La nueva lista de productos de la categoría.
     */
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}

