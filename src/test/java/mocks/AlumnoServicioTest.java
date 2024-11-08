package mocks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import models.Alumno;
import models.Materia;
import models.MateriaEnum;
import services.AlumnoServicio;
import utilitary.EscuelaUtil;

public class AlumnoServicioTest {

  private AlumnoServicio alumnoServicio;
  private AlumnoServicio alumnoServicioMock;
  private Materia matematicas;
  private Materia lenguaje;
  private Alumno alumno;

  @BeforeEach
  @DisplayName("Setup antes de cada prueba")
  public void setup(){
    alumnoServicioMock = mock(AlumnoServicio.class);
    alumnoServicio = new AlumnoServicio();

    matematicas = new Materia(MateriaEnum.MATEMATICAS);
    lenguaje = new Materia(MateriaEnum.LENGUAJE);

    alumno = new Alumno("123", "Ana", "Banana", "Calle 123");
  }

  @Test
  @DisplayName("Se verifica que un alumno este correctamente creado")
  public void crearAlumnoTest(){
  
    alumnoServicio.crear(alumno);

    assertEquals("123", alumnoServicio.leer(alumno.getRut()).getRut());
    assertEquals("Ana", alumnoServicio.leer(alumno.getRut()).getNombre());
    assertEquals("Banana", alumnoServicio.leer(alumno.getRut()).getApellido());
  
    assertEquals(0, alumnoServicio.leer(alumno.getRut()).getMaterias().size());

  }

  @Test
  @DisplayName("Se verifica la adicion de una materia a un alumno")
  public void agregarMateriaTest() {

    alumnoServicio.crear(alumno);
    alumnoServicio.agregarMateria(alumno.getRut(), lenguaje);
    assertEquals(1, alumno.getMaterias().size());
    assertEquals(lenguaje, alumno.getMaterias().get(0));
  }

  @Test
  @DisplayName("Se verfica la entrega de materias por alumno")
  void materiasPorAlumnosTest() {
      // Preparamos la respuesta simulada para el mock
      when(alumnoServicioMock.materiasPorAlumnos(any(String.class))).thenReturn(List.of(matematicas, lenguaje));
      List<Materia> materias = alumnoServicioMock.materiasPorAlumnos(alumno.getRut());

      assertEquals(2, materias.size());
      assertEquals(matematicas, materias.get(0));
      assertEquals(lenguaje, materias.get(1));

      EscuelaUtil.listarIterables(materias.toArray());
  }

  @Test
  @DisplayName("Se verifican las acciones del listado de alumnos completo")
  void listarAlumnosTest() {

    alumnoServicio.crear(alumno);
    Map<String, Alumno> alumnos = alumnoServicio.listar();

    assertEquals(1, alumnos.size());
    for (Map.Entry<String, Alumno> al : alumnos.entrySet()) {
      assertEquals("123", al.getValue().getRut());
      assertEquals("Ana", al.getValue().getNombre());
      assertEquals("Banana", al.getValue().getApellido());
    }
  }


}
