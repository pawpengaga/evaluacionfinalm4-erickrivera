package views;

import exceptions.GenerarArchivoException;
import models.Alumno;
import models.Materia;
import models.MateriaEnum;
import services.AlumnoServicio;
import services.ArchivoServicio;
import utilitary.EscuelaUtil;

  /**
   * EVALUACION MODULO 4 PARA ECAMP
   * @author Erick Rivera
   * @version 0.1
   * @since 11/2024.
   */
public class Menu extends MenuTemplate {

  // SETS DE DATOS

  private AlumnoServicio alumnoServicio = new AlumnoServicio();
  private ArchivoServicio archivoServicio = new ArchivoServicio();

  // METODOS GENERALES DEL MENU

  @Override
  public void exportarDatos() throws GenerarArchivoException {
    System.out.println("Exportando datos...");
    archivoServicio.exportarDatos(alumnoServicio, "evaluacionfinalm4/notas.csv");
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

    if (rutInput.isEmpty() || rutInput.isEmpty() || nombreInput.isEmpty() || apellidoInput.isEmpty() || direccionInput.isEmpty()){
      System.out.println("Los campos no pueden estar vacios... Intente nuevamente.");
      crearAlumno();
    }

    Alumno alumnoInput = new Alumno(rutInput, nombreInput, apellidoInput, direccionInput);

    alumnoServicio.crear(alumnoInput);
    EscuelaUtil.listarServicios(alumnoServicio.listar());
  }

  @Override
  public void agregarMateria() {

    if (alumnoServicio.listar().size() == 0) {
      System.out.println("Debe crear un alumno primero...");
      crearAlumno();
    }

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
    if (rutAlumnoInput.isEmpty() || (opcionMateria <= 0 || opcionMateria > MateriaEnum.values().length)){
      System.out.println("Hubo un problema con su solicitud... Intente nuevamente.");
      agregarMateria();
    }


    alumnoServicio.agregarMateria(rutAlumnoInput, materiaInput);

    System.out.println();

    EscuelaUtil.listarServicios(alumnoServicio.listar());

  }

  @Override
  public void agregarNotaPasoUno() {
    if (alumnoServicio.listar().size() == 0) {
      System.out.println("Debe crear un alumno primero...");
      crearAlumno();
    }

    System.out.println("Ingrese el rut del alumno para que el desea ingresar notas...");
    System.out.println("Listando Alumnos...");
    EscuelaUtil.listarServicios(alumnoServicio.listar());

    String rutInput = myscan.nextLine();

    if (rutInput.isEmpty()) {
      System.out.println("Hubo un problema con su solicitud... Intente nuevamente.");
      agregarNotaPasoUno();
    }

    Alumno alumnoBuscado = alumnoServicio.leer(rutInput);

    if (alumnoBuscado.getMaterias().size() == 0){
      System.out.println("El alumno no tiene materias a las que ponerle nota...");
      agregarMateria();
    }
    
    System.out.println("El alumno tiene la siguientes materias agregadas:");
    EscuelaUtil.listarIterables(alumnoBuscado.getMaterias().toArray());

    int opcionMateria = myscan.nextInt();
    myscan.nextLine();

    if (opcionMateria <= 0 || opcionMateria > alumnoBuscado.getMaterias().size()){
      System.out.println("Hubo un problema con su solicitud... Intente nuevamente.");
      return;
    }

    Materia materiaSeleccionada = alumnoBuscado.getMaterias().get(opcionMateria - 1);

    System.out.println("Ingresar nota:");
    float notaInput = myscan.nextFloat();
    myscan.nextLine();

    materiaSeleccionada.setNota(notaInput);
    System.out.println("Nota agregada!");
    EscuelaUtil.listarIterables(alumnoBuscado.getMaterias().toArray());

    System.out.println("***************************************");
    System.out.println("El promedio hasta ahora es: " + alumnoServicio.promedioPorAlumno(rutInput, opcionMateria));
  }

  @Override
  public void terminarPrograma() {
    System.out.println("Terminando programa...");
    salir = true;
  }

  @Override
  public void listaAlumnos() {
    if (alumnoServicio.listar().size() == 0) {
      System.out.println("Debe crear un alumno primero...");
      crearAlumno();
    }
    System.out.println("Listando alumnos...");
    EscuelaUtil.listarServicios(alumnoServicio.listar());
    System.out.println();
  }

  // MENU EN SI
  
  public static void main(String[] args) throws GenerarArchivoException {

    Menu colegioLatino = new Menu();
    colegioLatino.iniciarMenu();
  }



}
