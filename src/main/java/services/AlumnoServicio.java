package services;

import java.util.List;
import java.util.Map;

import interfaces.IAlumno;
import models.Alumno;
import models.Materia;

public class AlumnoServicio implements IAlumno {

  Map<String, Alumno> listaAlumnos;

  // METODOS PROPIOS DEL CRUD DEL ALUMNO
  @Override
  public void crear(Alumno objeto) {

  }

  @Override
  public Alumno leer(String id) {
    return null;
  }

  @Override
  public void actualizar(Alumno objeto) {

  }

  // @Override
  // public void eliminar(String id) {

  // }

  @Override
  public Map<String, Alumno> listar() {
    return null;
  }

  // METODOS DE UTILIDADES COOPERATIVAS

  @Override
  public void agregarMateria(String rut, Materia currenMateria) {

  }

  @Override
  public List<Materia> materiasPorAlumnos(String rut) {
    return null;
  }

}
