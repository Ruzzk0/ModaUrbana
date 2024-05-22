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
import com.mycompany.dominiodto.CategoriaDTO;
import com.mycompany.dominiodto.ProductoDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * Clase que implementa las operaciones de acceso a datos para la entidad ProductoDTO en MongoDB.
 * 
 * Esta clase proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * sobre documentos de productos almacenados en una colección MongoDB.
 * @autor Ruzzky
 */
public class ProductoDAO implements IProductoDAO {

    
    private MongoDatabase database;

   public ProductoDAO() {
        this.database = MongoDBconexion.getInstance();
    }

   public void guardarProducto(ProductoDTO producto) {
        MongoCollection<Document> collection = database.getCollection("productos");
        Document doc = new Document("nombre", producto.getNombre())
                            .append("descripcion", producto.getDescripcion())
                            .append("categoria", producto.getCategoria().getNombre())
                            .append("precio", producto.getPrecio())
                            .append("tallasCantidades", producto.getTallasCantidades());
        collection.insertOne(doc);
    }

    public List<ProductoDTO> obtenerTodos() {
        MongoCollection<Document> collection = database.getCollection("productos");
        List<ProductoDTO> productos = new ArrayList<>();

        for (Document doc : collection.find()) {
            ProductoDTO producto = new ProductoDTO();
            producto.setId(doc.getObjectId("_id"));
            producto.setNombre(doc.getString("nombre"));
            producto.setDescripcion(doc.getString("descripcion"));
            CategoriaDTO categoria = new CategoriaDTO();
            categoria.setNombre(doc.getString("categoria"));
            producto.setCategoria(categoria);
            producto.setPrecio(doc.getDouble("precio"));
            producto.setTallasCantidades((Map<String, Integer>) doc.get("tallasCantidades"));

            productos.add(producto);
        }
        return productos;
    }
    
    /**
     * Obtiene la colección MongoDB para la entidad ProductoDTO.
     * 
     * @return La colección MongoDB para la entidad ProductoDTO.
     */
    public MongoCollection<ProductoDTO> obtenerColeccion() {
        MongoDatabase db = MongoDBconexion.getInstance();
        MongoCollection<ProductoDTO> coleccionProductos = db.getCollection("ProductoDTO", ProductoDTO.class);
        return coleccionProductos;
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
    Bson filtro = Filters.eq("_id", new ObjectId(id));
    try {
        DeleteResult resultado = coleccionProductos.deleteOne(filtro);
        if (resultado.getDeletedCount() == 0) {
            // Manejar caso en el que no se encontró el documento
            System.out.println("No se encontró el documento con id: " + id);
        }
    } catch (MongoException e) {
        // Manejar excepción
        e.printStackTrace();
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
    Bson filtro = Filters.eq("_id", new ObjectId(id)); 
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