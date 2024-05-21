
package Excepciones;

/**
 *
 * @author Ruzzky
 */
public class PersistenciaException extends Exception {

    public PersistenciaException() {
        super();
    }

    public PersistenciaException(String message) {
        super(message);
    }

    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistenciaException(Throwable cause) {
        super(cause);
    }
}

/**
 * Excepción lanzada cuando no se encuentra un recurso en la capa de persistencia.
 */
//public class RecursoNoEncontradoException extends PersistenciaException {
//
//    public RecursoNoEncontradoException() {
//        super();
//    }
//
//    public RecursoNoEncontradoException(String message) {
//        super(message);
//    }
//
//    public RecursoNoEncontradoException(String message, Throwable cause) {
//        super(message, cause);
//    }
//
//    public RecursoNoEncontradoException(Throwable cause) {
//        super(cause);
//    }
//}