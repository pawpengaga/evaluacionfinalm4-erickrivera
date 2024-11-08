package exceptions;

/**
 * Levanta una excepción ante problemas con la generación de archivos por x razón.
 */
public class GenerarArchivoException extends Exception {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

  public GenerarArchivoException(String message){
    super(message);
  }

}
