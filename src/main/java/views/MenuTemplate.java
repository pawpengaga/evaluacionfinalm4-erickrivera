package views;

import java.util.Scanner;

public abstract class MenuTemplate {

  public static Scanner myscan = new Scanner(System.in);
  public static boolean salir = false;

  public abstract void exportarDatos();
  public abstract void crearAlumno();
  public abstract void agregarMateria();
  public abstract void agregarNotaPasoUno();
  public abstract void listaAlumnos();
  public abstract void terminarPrograma();
  
  public void iniciarMenu(){

    System.out.println("*** BIENVENDIDO AL MENU DE LA ESCUELA ***");
    System.out.println("--------------------------------------------");

    while (!salir) {
      System.out.println("");
      System.out.println("1. Crear Alumnos");
      System.out.println("2. Listar Alumnos");
      System.out.println("3. Agregar Materias");
      System.out.println("4. Agregar Notas");
      System.out.println("5. Salir");
      System.out.println("6. Exportar Datos");
      System.out.println("");
      System.out.println("INTRODUZCA UNA OPCIÓN PARA CONTINUAR: ");

      int opcion = myscan.nextInt();
      myscan.nextLine();
  
      switch (opcion){
        case 1 -> crearAlumno();
        case 2 -> listaAlumnos();
        case 3 -> agregarMateria();
        case 4 -> agregarNotaPasoUno();
        case 5 -> terminarPrograma();
        case 6 -> terminarPrograma();
      }
    }

  }

}
