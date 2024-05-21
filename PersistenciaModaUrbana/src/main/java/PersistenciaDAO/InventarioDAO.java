package PersistenciaDAO;

import Conexion.MongoDBconexion;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Updates;
import com.mycompany.dominiodto.CategoriaDTO;
import com.mycompany.dominiodto.InventarioDTO;
import com.mycompany.dominiodto.ProductoDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.bson.conversions.Bson;

/**
 *
 * @author Ruzzky
 */
public class InventarioDAO implements IInventarioDAO {

    public MongoCollection<InventarioDTO> obtenerColeccion() {
        MongoDatabase db = MongoDBconexion.getInstance();
        MongoCollection<InventarioDTO> colleccionInventario = db.getCollection("InventarioDTO", InventarioDTO.class);
        return colleccionInventario;
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
        Bson filtro = Filters.and(); // Reemplazar Filters.empty() por Filters.and()
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
        Bson filtro = Filters.and(); // Reemplazar Filters.empty() por Filters.and()
        Bson actualizacion = Updates.set("categorias", categorias);
        try {
            coleccionInventario.updateOne(filtro, actualizacion);
        } catch (MongoException e) {
            // Manejar excepción
        }
    }
}