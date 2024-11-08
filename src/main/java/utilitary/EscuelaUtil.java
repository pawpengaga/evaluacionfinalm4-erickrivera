package utilitary;

import java.util.List;

public class EscuelaUtil {
  
  public static <T> void listarServicios(List<T> servicio_in){
    servicio_in.forEach(System.out::println);
  }

}
