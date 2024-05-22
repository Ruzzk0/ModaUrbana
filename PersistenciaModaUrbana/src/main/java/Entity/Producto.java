package Entity;

import java.util.Map;
import org.bson.types.ObjectId;

/**
 * Clase que representa un producto en el inventario.
 * 
 * @autor Ruzzky
 */
public class Producto {
    
    // Identificador único del producto
    private ObjectId id;
    
    // Nombre del producto
    private String nombre;
    
    // Descripción del producto
    private String descripcion;
    
    // Categoría a la que pertenece el producto (Objeto de la clase Categoria)
    private Categoria categoria;
    
    // Precio del producto
    private double precio;
    
    // Mapa de tallas y cantidades, donde la clave es la talla y el valor es la cantidad en stock
    private Map<String, Integer> tallasCantidades;

    /**
     * Constructor por defecto.
     */
    public Producto() {
    }

    /**
     * Constructor con parámetros.
     * 
     * @param nombre El nombre del producto.
     * @param descripcion La descripción del producto.
     * @param categoria La categoría a la que pertenece el producto.
     * @param precio El precio del producto.
     * @param tallasCantidades El mapa de tallas y cantidades del producto.
     */
    public Producto(String nombre, String descripcion, Categoria categoria, double precio, Map<String, Integer> tallasCantidades) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
        this.tallasCantidades = tallasCantidades;
    }

    public ObjectId getId() {
        return id;
    }

    /**
     * Obtiene el identificador único del producto.
     * 
     * @return El identificador del producto.
     */
    /**
     * Establece el identificador único del producto.
     * 
     * @param id El nuevo identificador del producto.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del producto.
     * 
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     * 
     * @param nombre El nuevo nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la descripción del producto.
     * 
     * @return La descripción del producto.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del producto.
     * 
     * @param descripcion La nueva descripción del producto.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la categoría del producto.
     * 
     * @return La categoría del producto.
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Establece la categoría del producto.
     * 
     * @param categoria La nueva categoría del producto.
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * Obtiene el precio del producto.
     * 
     * @return El precio del producto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     * 
     * @param precio El nuevo precio del producto.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el mapa de tallas y cantidades del producto.
     * 
     * @return El mapa de tallas y cantidades del producto.
     */
    public Map<String, Integer> getTallasCantidades() {
        return tallasCantidades;
    }

    /**
     * Establece el mapa de tallas y cantidades del producto.
     * 
     * @param tallasCantidades El nuevo mapa de tallas y cantidades del producto.
     */
    public void setTallasCantidades(Map<String, Integer> tallasCantidades) {
        this.tallasCantidades = tallasCantidades;
    }
}
