package views;

import models.Alumno;
import models.Materia;
import models.MateriaEnum;
import services.AlumnoServicio;
import utilitary.EscuelaUtil;

public class Menu extends MenuTemplate {

  // SETS DE DATOS

  private AlumnoServicio alumnoServicio = new AlumnoServicio();

  // METODOS GENERALES DEL MENU

  @Override
  public void exportarDatos() {
    System.out.println("Exportando datos...");
  }

  @Override
  public void crearAlumno() {
    System.out.println("--- CREAR ALUMNO ---");
    
    System.out.println("Ingrese el rut del alumno");
    String rutInput = myscan.nextLine();

    System.out.println("Ingrese el nombre del alumno");
    String nombreInput = myscan.nextLine();

    System.out.println("Ingrese el apellido del alumno");
    String apellidoInput = myscan.nextLine();

    System.out.println("Ingrese direccion del alumno");
    String direccionInput = myscan.nextLine();

    Alumno alumnoInput = new Alumno(rutInput, nombreInput, apellidoInput, direccionInput);

    alumnoServicio.crear(alumnoInput);
    EscuelaUtil.listarServicios(alumnoServicio.listar());
  }

  @Override
  public void agregarMateria() {

    System.out.println("Ingrese el rut del alumno para que el desea obtener los datos...");
    System.out.println("Listando Alumnos...");
    EscuelaUtil.listarServicios(alumnoServicio.listar());

    String rutAlumnoInput = myscan.nextLine();

    System.out.println("Ingrese la nueva materia");
    System.out.println("Listando materias...");
    System.out.println();
    EscuelaUtil.listarIterables(MateriaEnum.values());

    int opcionMateria = myscan.nextInt();
    myscan.nextLine();

    Materia materiaInput = new Materia(MateriaEnum.values()[opcionMateria - 1]);

    alumnoServicio.agregarMateria(rutAlumnoInput, materiaInput);

    System.out.println();

    EscuelaUtil.listarServicios(alumnoServicio.listar());
  }

  @Override
  public void agregarNotaPasoUno() {
    System.out.println("Ingrese el rut del alumno para que el desea ingresar notas...");
    System.out.println("Listando Alumnos...");
    EscuelaUtil.listarServicios(alumnoServicio.listar());

    String rutInput = myscan.nextLine();
    Alumno alumnoBuscado = alumnoServicio.leer(rutInput);
    
    System.out.println("El alumno tiene la siguientes materias agregadas:");
    EscuelaUtil.listarIterables(alumnoBuscado.getMaterias().toArray());

    int opcionMateria = myscan.nextInt();
    myscan.nextLine();
    Materia materiaSeleccionada = alumnoBuscado.getMaterias().get(opcionMateria - 1);

    System.out.println("Ingresar nota:");
    float notaInput = myscan.nextFloat();
    myscan.nextLine();

    materiaSeleccionada.setNota(notaInput);
    System.out.println("Nota agregada!");
    EscuelaUtil.listarIterables(alumnoBuscado.getMaterias().toArray());
  }

  @Override
  public void terminarPrograma() {
    System.out.println("Terminando programa...");
    salir = true;
  }

  @Override
  public void listaAlumnos() {
    System.out.println("Listando alumnos...");
    EscuelaUtil.listarServicios(alumnoServicio.listar());
    System.out.println();
  }

  // MENU EN SI
  
  public static void main(String[] args) {

    Menu colegioLatino = new Menu();
    colegioLatino.iniciarMenu();
  }



}
