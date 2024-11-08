package services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import interfaces.IAlumno;
import models.Alumno;
import models.Materia;

public class AlumnoServicio implements IAlumno {

  Map<String, Alumno> listaAlumnos = new HashMap<>();

  // METODOS PROPIOS DEL CRUD DEL ALUMNO
  @Override
  public void crear(Alumno alumno) {
    if (listaAlumnos.containsKey(alumno.getRut())) {
      System.out.println("El alumno ya existe...");
    } else {
      listaAlumnos.put(alumno.getRut(), alumno);
      System.out.println("Alumno registrado exitosamente el sistema!");
    }
  }

  @Override
  public Alumno leer(String rut) {

    Alumno alumnoBuscado = listaAlumnos.get(rut);

    if (alumnoBuscado == null) {
      System.out.println("El alumno que busca no existe...");
      return null;
    }
    return alumnoBuscado;
  }

  @Override
  public void actualizar(Alumno alumno) {

    Alumno nuevoAlumno = listaAlumnos.get(alumno.getRut());

    if (nuevoAlumno == null) {
      System.out.println("El alumno que busca para editar no existe...");
    } else {
      listaAlumnos.put(alumno.getRut(), alumno);
    }
  }

  // @Override
  // public void eliminar(String id) {

  // }

  @Override
  public Map<String, Alumno> listar() {
    return listaAlumnos;
  }

  // METODOS DE UTILIDADES COOPERATIVAS

  @Override
  public void agregarMateria(String rut, Materia currenMateria) {

    Alumno alumnoBuscado = listaAlumnos.get(rut);



    if (alumnoBuscado != null) {
      if (listaAlumnos.containsKey(alumnoBuscado.getRut())){
        boolean materiaBuscada = alumnoBuscado.getMaterias().stream().anyMatch(materia -> materia.getNombre().equals(currenMateria.getNombre()));
      
        if (!(materiaBuscada)) {
          System.out.println("Agregando materia...");
          alumnoBuscado.getMaterias().add(currenMateria);
        } else {
          System.out.println("El alumno ya tiene la materia asignada");
        }
      } else {
        System.out.println("El alumno que busca no existe...");
      }
  
      listaAlumnos.put(rut, alumnoBuscado);
    } else {
      System.out.println("El alumno que busca no existe...");
    }

  }

  @Override
  public List<Materia> materiasPorAlumnos(String rut) {
    
    Alumno alumnoBuscado = listaAlumnos.get(rut);

    if (alumnoBuscado == null) {
      System.out.println("El alumno que busca no existe...");
      return null;
    }

    return alumnoBuscado.getMaterias();

  }

}
