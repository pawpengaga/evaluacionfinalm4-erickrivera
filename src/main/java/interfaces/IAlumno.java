package interfaces;

import java.util.List;

import models.Alumno;
import models.Materia;

public interface IAlumno extends CRUD<Alumno, String> {

  public void agregarMateria(String rut, Materia currenMateria);
  public List<Materia> materiasPorAlumnos(String rut);

}
