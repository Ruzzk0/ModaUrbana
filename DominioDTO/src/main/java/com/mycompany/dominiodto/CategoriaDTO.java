
package com.mycompany.dominiodto;
import java.util.List;

/**
 *
 * @author Ruzzky
 */
public class CategoriaDTO {
        private String nombre;
    private List<ProductoDTO> productos;

    // Constructores, getters y setters
    
    public CategoriaDTO() {}

    public CategoriaDTO(String nombre, List<ProductoDTO> productos) {
        this.nombre = nombre;
        this.productos = productos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ProductoDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoDTO> productos) {
        this.productos = productos;
    }
    
    
}
