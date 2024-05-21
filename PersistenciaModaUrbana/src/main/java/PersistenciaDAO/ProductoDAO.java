package PersistenciaDAO;

import Conexion.MongoDBconexion;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.mycompany.dominiodto.ProductoDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.bson.conversions.Bson;

/**
 *
 * @author Ruzzky
 */
public class ProductoDAO implements IProductoDAO {

    public MongoCollection<ProductoDTO> obtenerColeccion() {
        MongoDatabase db = MongoDBconexion.getInstance();
        MongoCollection<ProductoDTO> colleccionProductos = db.getCollection("ProductoDTO", ProductoDTO.class);
        return colleccionProductos;
    }

    @Override
    public List<ProductoDTO> obtenerTodos() {
        List<ProductoDTO> productos = new ArrayList<>();
        productos = obtenerColeccion().find().into(new ArrayList<>());
        return productos;
    }

    @Override
    public ProductoDTO obtenerPorId(String id) {
        ProductoDTO producto = obtenerColeccion().find(eq("_id", id)).first();
        return producto;
    }

    @Override
    public void crear(ProductoDTO producto) {
        MongoCollection<ProductoDTO> coleccionProductos = obtenerColeccion();
        try {
            coleccionProductos.insertOne(producto);
        } catch (MongoException e) {
            // Manejar excepción
        }
    }

    @Override
    public void actualizar(ProductoDTO producto) {
        MongoCollection<ProductoDTO> coleccionProductos = obtenerColeccion();
        Bson filtro = Filters.eq("_id", producto.getId());
        Bson actualizacion = Updates.combine(
                Updates.set("nombre", producto.getNombre()),
                Updates.set("precio", producto.getPrecio()),
                Updates.set("descripcion", producto.getDescripcion()),
                Updates.set("tallasCantidades", producto.getTallasCantidades())
        );
        try {
            UpdateResult resultado = coleccionProductos.updateOne(filtro, actualizacion);
            if (resultado.getMatchedCount() == 0) {
                // Manejar caso en el que no se encontró el documento
            }
        } catch (MongoException e) {
            // Manejar excepción
        }
    }

    @Override
    public void eliminar(String id) {
        MongoCollection<ProductoDTO> coleccionProductos = obtenerColeccion();
        Bson filtro = Filters.eq("_id", id);
        try {
            DeleteResult resultado = coleccionProductos.deleteOne(filtro);
            if (resultado.getDeletedCount() == 0) {
                // Manejar caso en el que no se encontró el documento
            }
        } catch (MongoException e) {
            // Manejar excepción
        }
    }

    @Override
    public Map<String, Integer> obtenerTallasCantidades(String id) {
        ProductoDTO producto = obtenerPorId(id);
        return producto.getTallasCantidades();
    }

    @Override
    public void actualizarTallasCantidades(String id, Map<String, Integer> tallasCantidades) {
        MongoCollection<ProductoDTO> coleccionProductos = obtenerColeccion();
        Bson filtro = Filters.eq("_id", id);
        Bson actualizacion = Updates.set("tallasCantidades", tallasCantidades);
        try {
            UpdateResult resultado = coleccionProductos.updateOne(filtro, actualizacion);
            if (resultado.getMatchedCount() == 0) {
                // Manejar caso en el que no se encontró el documento
            }
        } catch (MongoException e) {
            // Manejar excepción
        }
    }
}