
package Entity;
import java.util.Map;
import org.bson.types.ObjectId;
/**
 *
 * @author Ruzzky
 */
public class Producto {

    private String id; // Identificador único del producto
    private String nombre;
    private String descripcion;
    private Categoria categoria; // Objeto de la clase Categoria
    private double precio;
    private Map<String, Integer> tallasCantidades; //  talla,  cantidad en stock

    public Producto() {
    }

    public Producto(String nombre, String descripcion, Categoria categoria, double precio, Map<String, Integer> tallasCantidades) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
        this.tallasCantidades = tallasCantidades;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Map<String, Integer> getTallasCantidades() {
        return tallasCantidades;
    }

    public void setTallasCantidades(Map<String, Integer> tallasCantidades) {
        this.tallasCantidades = tallasCantidades;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre="
                + nombre + ", descripcion=" + descripcion 
                + ", categoria=" + categoria + ", precio=" 
                + precio + ", tallasCantidades=" + tallasCantidades + '}';
    }
    
    
    
}
