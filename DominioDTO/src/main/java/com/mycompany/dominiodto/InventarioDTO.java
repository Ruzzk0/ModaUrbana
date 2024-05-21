
package com.mycompany.dominiodto;

import java.util.Map;

/**
 *
 * @author Ruzzky
 */
public class InventarioDTO {
     private Map<String, ProductoDTO> productos;
    private Map<String, CategoriaDTO> categorias;

    // Constructores, getters y setters

    public InventarioDTO() {}

    public InventarioDTO(Map<String, ProductoDTO> productos, Map<String, CategoriaDTO> categorias) {
        this.productos = productos;
        this.categorias = categorias;
    }

    public Map<String, ProductoDTO> getProductos() {
        return productos;
    }

    public void setProductos(Map<String, ProductoDTO> productos) {
        this.productos = productos;
    }

    public Map<String, CategoriaDTO> getCategorias() {
        return categorias;
    }

    public void setCategorias(Map<String, CategoriaDTO> categorias) {
        this.categorias = categorias;
    }

    
    
}