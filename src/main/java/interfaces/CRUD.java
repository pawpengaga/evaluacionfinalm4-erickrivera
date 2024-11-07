package interfaces;

import java.util.Map;


// CRUD ahora admite cualquier tipo de dato para interfaz, y cualquier tipo de dato para la Clave primaria yeiiiiiiiiiiii
public interface CRUD<T, K> {

  public void crear(T objeto);
  public T leer(K id);
  public void actualizar(T objeto);
  // public void eliminar(K id);
  public Map<K, T> listar();

}
