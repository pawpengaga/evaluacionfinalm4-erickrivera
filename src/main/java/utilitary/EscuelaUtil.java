package utilitary;

import java.util.Map;

public class EscuelaUtil {
  
  public static <K, V> void listarServicios(Map<K, V> servicio_in){
    for (Map.Entry<K, V> mapIn: servicio_in.entrySet()) {
      System.out.println(mapIn.getKey() + " : " + mapIn.getValue());
    }
  }
  
  public static <T> void listarIterables(T iterableIn[]){
    int cont = 1;
    for (T t : iterableIn) {
      System.out.println(cont + ": " + t);
      cont++;
    }
  }

}
