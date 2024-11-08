package utilitary;

import java.util.Map;

public class EscuelaUtil {
  
  /**
   * Listado generico de clases servicio para imprimir por pantalla
   * @param <K> El tipo de clave primaria del servicio
   * @param <V> El tipo objeto de cada servicio
   * @param servicio_in Recibe un HashMap con toda la info listada de una clase servicio
   */
  public static <K, V> void listarServicios(Map<K, V> servicio_in){
    for (Map.Entry<K, V> mapIn: servicio_in.entrySet()) {
      System.out.println(mapIn.getKey() + " : " + mapIn.getValue());
    }
  }
  /**
   * Generico para iterar arreglos y Lists por medio de conversion .toArray()
   * @param <T> Tipo de dato que se estara iterando
   * @param iterableIn Un arreglo de cualquier tipo
   */
  public static <T> void listarIterables(T iterableIn[]){
    int cont = 1;
    for (T t : iterableIn) {
      System.out.println(cont + ": " + t);
      cont++;
    }
  }

}
