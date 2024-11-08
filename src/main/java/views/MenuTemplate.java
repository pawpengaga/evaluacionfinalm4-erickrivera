package views;

import java.util.Scanner;

public abstract class MenuTemplate {

  public static Scanner myscan = new Scanner(System.in);

  public abstract void exportarDatos();
  public abstract void crearAlumno();
  public abstract void agregarMateria();
  public abstract void agregarNotaPasoUno();
  public abstract void listaAlumnos();
  public abstract void terminarPrograma();
  
  public void iniciarMenu(){

    System.out.println("*** BIENVENDIDO AL MENU DE LA ESCUELA ***");
    System.out.println("1. Crear Alumnos");
    System.out.println("INTRODUZCA UNA OPCIÓN PARA CONTINUAR: ");
    System.out.println("--------------------------------------------");
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
