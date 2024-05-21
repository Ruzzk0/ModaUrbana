
package NegocioBO;

import PersistenciaDAO.ICategoriaDAO;
import com.mycompany.dominiodto.CategoriaDTO;
import java.util.List;

/**
 *
 * @author Ruzzky
 */
public class CategoriaBO {
private ICategoriaDAO categoriaDAO;

    public CategoriaBO(ICategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }

    public List<CategoriaDTO> obtenerTodasCategorias() {
        return categoriaDAO.obtenerTodas();
    }

    public CategoriaDTO obtenerCategoriaPorNombre(String nombre) {
        return categoriaDAO.obtenerPorNombre(nombre);
    }

    public void crearCategoria(CategoriaDTO categoria) {
        categoriaDAO.crear(categoria);
    }

    public void actualizarCategoria(CategoriaDTO categoria) {
        categoriaDAO.actualizar(categoria);
    }

    public void eliminarCategoria(String nombre) {
        categoriaDAO.eliminar(nombre);
    }

}
