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
import java.util.ArrayList;
import java.util.List;
import org.bson.conversions.Bson;

/**
 * Clase que implementa las operaciones de acceso a datos para la entidad CategoriaDTO en MongoDB.
 * 
 * <p>Esta clase proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * sobre documentos de categorías almacenados en una colección MongoDB.</p>
 * 
 * @see CategoriaDTO
 * 
 * @autor Ruzzky
 */
public class CategoriaDAO implements ICategoriaDAO {

    /**
     * Obtiene la colección MongoDB para la entidad CategoriaDTO.
     * 
     * @return La colección MongoDB para la entidad CategoriaDTO.
     */
    public MongoCollection<CategoriaDTO> obtenerColeccion() {
        MongoDatabase db = MongoDBconexion.getInstance();
        MongoCollection<CategoriaDTO> coleccionCategorias = db.getCollection("CategoriaDTO", CategoriaDTO.class);
        return coleccionCategorias;
    }

    @Override
    public List<CategoriaDTO> obtenerTodas() {
        List<CategoriaDTO> categorias = new ArrayList<>();
        categorias = obtenerColeccion().find().into(new ArrayList<>());
        return categorias;
    }

    @Override
    public CategoriaDTO obtenerPorNombre(String nombre) {
        CategoriaDTO categoria = obtenerColeccion().find(eq("nombre", nombre)).first();
        return categoria;
    }

    @Override
    public void crear(CategoriaDTO categoria) {
        MongoCollection<CategoriaDTO> coleccionCategorias = obtenerColeccion();
        try {
            coleccionCategorias.insertOne(categoria);
        } catch (MongoException e) {
            // Manejar excepción
        }
    }

    @Override
    public void actualizar(CategoriaDTO categoria) {
        MongoCollection<CategoriaDTO> coleccionCategorias = obtenerColeccion();
        Bson filtro = Filters.eq("nombre", categoria.getNombre());
        Bson actualizacion = Updates.combine(
            Updates.set("productos", categoria.getProductos()) // Añadir más propiedades según sea necesario
        );
        try {
            UpdateResult resultado = coleccionCategorias.updateOne(filtro, actualizacion);
            if (resultado.getMatchedCount() == 0) {
                // Manejar caso en el que no se encontró el documento
            }
        } catch (MongoException e) {
            // Manejar excepción
        }
    }

    @Override
    public void eliminar(String nombre) {
        MongoCollection<CategoriaDTO> coleccionCategorias = obtenerColeccion();
        Bson filtro = Filters.eq("nombre", nombre);
        try {
            DeleteResult resultado = coleccionCategorias.deleteOne(filtro);
            if (resultado.getDeletedCount() == 0) {
                // Manejar caso en el que no se encontró el documento
            }
        } catch (MongoException e) {
            // Manejar excepción
        }
    }
}
