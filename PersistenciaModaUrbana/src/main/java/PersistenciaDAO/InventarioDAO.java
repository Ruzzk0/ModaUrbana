package PersistenciaDAO;

import Conexion.MongoDBconexion;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.and;
import com.mongodb.client.model.Updates;
import com.mycompany.dominiodto.CategoriaDTO;
import com.mycompany.dominiodto.InventarioDTO;
import com.mycompany.dominiodto.ProductoDTO;
import java.util.Map;
import org.bson.conversions.Bson;

/**
 * Clase que implementa las operaciones de acceso a datos para el inventario en MongoDB.
 * 
 * Esta clase proporciona métodos para obtener y actualizar el inventario,
 * incluyendo los mapas de productos y categorías asociados al mismo.

 * 
 * @autor Ruzzky
 */
public class InventarioDAO implements IInventarioDAO {

    /**
     * Obtiene la colección MongoDB para el inventario.
     * 
     * @return La colección MongoDB para el inventario.
     */
    public MongoCollection<InventarioDTO> obtenerColeccion() {
        MongoDatabase db = MongoDBconexion.getInstance();
        MongoCollection<InventarioDTO> coleccionInventario = db.getCollection("InventarioDTO", InventarioDTO.class);
        return coleccionInventario;
    }

    @Override
    public InventarioDTO obtener() {
        InventarioDTO inventario = obtenerColeccion().find().first();
        return inventario;
    }

    @Override
    public Map<String, ProductoDTO> obtenerProductos() {
        InventarioDTO inventario = obtener();
        return inventario.getProductos();
    }

    @Override
    public Map<String, CategoriaDTO> obtenerCategorias() {
        InventarioDTO inventario = obtener();
        return inventario.getCategorias();
    }

    @Override
    public void actualizarProductos(Map<String, ProductoDTO> productos) {
        MongoCollection<InventarioDTO> coleccionInventario = obtenerColeccion();
        Bson filtro = and(); // Reemplazar Filters.empty() por and()
        Bson actualizacion = Updates.set("productos", productos);
        try {
            coleccionInventario.updateOne(filtro, actualizacion);
        } catch (MongoException e) {
            // Manejar excepción
        }
    }

    @Override
    public void actualizarCategorias(Map<String, CategoriaDTO> categorias) {
        MongoCollection<InventarioDTO> coleccionInventario = obtenerColeccion();
        Bson filtro = and(); // Reemplazar Filters.empty() por and()
        Bson actualizacion = Updates.set("categorias", categorias);
        try {
            coleccionInventario.updateOne(filtro, actualizacion);
        } catch (MongoException e) {
            // Manejar excepción
        }
    }
}
