package interfaces;

import java.util.Map;


/**
 * CRUD generico
 * @param T El tipo de objeto recibido para aplicar CRUD
 * @param K El tipo de cada clave primaria
 */
public interface CRUD<T, K> {

  public void crear(T objeto);
  public T leer(K id);
  public void actualizar(T objeto);
  // public void eliminar(K id);
  public Map<K, T> listar();

}
