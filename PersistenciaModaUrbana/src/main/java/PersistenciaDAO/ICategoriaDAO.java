
package PersistenciaDAO;

import com.mycompany.dominiodto.CategoriaDTO;
import java.util.List;

/**
 *
 * @author Ruzzky
 */
public interface ICategoriaDAO {
    
    List<CategoriaDTO> obtenerTodas();

    CategoriaDTO obtenerPorNombre(String nombre);

    void crear(CategoriaDTO categoria);

    void actualizar(CategoriaDTO categoria);

    void eliminar(String nombre);

}