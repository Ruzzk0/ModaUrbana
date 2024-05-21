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
 *
 * @author Ruzzky
 */
public class CategoriaDAO implements ICategoriaDAO {

    public MongoCollection<CategoriaDTO> obtenerColeccion() {
        MongoDatabase db = MongoDBconexion.getInstance();
        MongoCollection<CategoriaDTO> colleccionClimas = db.getCollection("CategoriaDTO", CategoriaDTO.class);
        return colleccionClimas;
    }

    @Override
    public List<CategoriaDTO> obtenerTodas() {
        List<CategoriaDTO> cate = new ArrayList<>();
        cate = obtenerColeccion().find().into(new ArrayList<>());
        return cate;
    }

    @Override
    public CategoriaDTO obtenerPorNombre(String nombre) {
        CategoriaDTO cate = obtenerColeccion().find(eq("nombre", nombre)).first();
        return cate;
    }

    @Override
    public void crear(CategoriaDTO categoria) {
        MongoCollection<CategoriaDTO> coleccionP = obtenerColeccion();
        try {
            coleccionP.insertOne(categoria);
        } catch (MongoException e) {
        }
    }

    @Override
    public void actualizar(CategoriaDTO categoria) {
         MongoCollection<CategoriaDTO> coleccionP = obtenerColeccion();
        Bson filtro = Filters.eq("nombre", categoria.getNombre());
        Bson actualizacion = Updates.combine(
            Updates.set("productos", categoria.getProductos())// Añadir más propiedades según sea necesario
        );
        try {
            UpdateResult resultado = coleccionP.updateOne(filtro, actualizacion);
            if (resultado.getMatchedCount() == 0) {
                // Manejar caso en el que no se encontró el documento
            }
        } catch (MongoException e) {
            // Manejar excepción
        }
    }

    @Override
    public void eliminar(String nombre) {
        MongoCollection<CategoriaDTO> coleccionP = obtenerColeccion();
        Bson filtro = Filters.eq("nombre", nombre);
        try {
            DeleteResult resultado = coleccionP.deleteOne(filtro);
            if (resultado.getDeletedCount() == 0) {
                // Manejar caso en el que no se encontró el documento
            }
        } catch (MongoException e) {
            // Manejar excepción
        }
    }

}
