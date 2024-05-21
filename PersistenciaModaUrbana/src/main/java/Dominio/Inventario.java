
package Dominio;

import java.util.Map;

/**
 *
 * @author Ruzzky
 */
public class Inventario {
    
     private Map<String, Producto> productos; //  Objeto Producto
    private Map<String, Categoria> categorias; //  Nombre de la categoría, Objeto Categoria

    public Inventario() {
    }

    public Inventario(Map<String, Producto> productos, Map<String, Categoria> categorias) {
        this.productos = productos;
        this.categorias = categorias;
    }

    public Map<String, Producto> getProductos() {
        return productos;
    }

    public void setProductos(Map<String, Producto> productos) {
        this.productos = productos;
    }

    public Map<String, Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Map<String, Categoria> categorias) {
        this.categorias = categorias;
    }
    
    
    
}
