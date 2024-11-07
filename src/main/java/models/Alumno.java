package models;

import java.util.List;

public class Alumno {

  private String rut;
  private String nombre;
  private String apellido;
  private String direccion;
  
  private List<Materia> materias;

  public Alumno() {
  }

  public Alumno(String rut, String nombre, String apellido, String direccion, List<Materia> materias) {
    this.rut = rut;
    this.nombre = nombre;
    this.apellido = apellido;
    this.direccion = direccion;
    this.materias = materias;
  }

  public String getRut() {
    return this.rut;
  }

  public void setRut(String rut) {
    this.rut = rut;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return this.apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getDireccion() {
    return this.direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public List<Materia> getMaterias() {
    return this.materias;
  }

  public void setMaterias(List<Materia> materias) {
    this.materias = materias;
  }

  @Override
  public String toString() {
    return "{" +
      " RUT: '" + getRut() + "'" +
      ", Nombre: '" + getNombre() + "'" +
      ", Apellido: '" + getApellido() + "'" +
      ", Direccion: '" + getDireccion() + "'" +
      ", Materias: '" + getMaterias() + "'" +
      " }";
  }

}
