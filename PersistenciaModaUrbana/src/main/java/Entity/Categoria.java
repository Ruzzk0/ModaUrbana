
package Entity;

import java.util.List;

/**
 *
 * @author Ruzzky
 */
public class Categoria {
  
    private String nombre; // Nombre de la categoría (ropa de hombre, ropa de mujer, ropa de niños)
    private List<Producto> productos; // Lista de productos que pertenecen a esta categoría

    public Categoria() {
    }

    public Categoria(String nombre, List<Producto> productos) {
        this.nombre = nombre;
        this.productos = productos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
    
    
}

