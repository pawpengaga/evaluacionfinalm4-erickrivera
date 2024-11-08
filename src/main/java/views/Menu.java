package views;

public class Menu extends MenuTemplate {

  @Override
  public void exportarDatos() {
    System.out.println("Exportando datos...");
  }

  @Override
  public void crearAlumno() {
    System.out.println("Creando alumno...");
  }

  @Override
  public void agregarMateria() {
    System.out.println("Agregando materia...");
  }

  @Override
  public void agregarNotaPasoUno() {
    System.out.println("Agregando nota: Primer paso.");
  }

  @Override
  public void terminarPrograma() {
    System.out.println("Terminando programa...");
  }

  @Override
  public void listaAlumnos() {
    System.out.println("Listando alumnos...");
  }

  public static void main(String[] args) {

    Menu colegioLatino = new Menu();
    colegioLatino.iniciarMenu();
  }



}
