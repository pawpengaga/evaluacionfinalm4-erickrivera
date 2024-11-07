package models;

import java.util.List;

public class Materia {

  private MateriaEnum nombre;
  private List<Float> notas;


  public Materia() {
  }

  public Materia(MateriaEnum nombre, List<Float> notas) {
    this.nombre = nombre;
    this.notas = notas;
  }

  public MateriaEnum getNombre() {
    return this.nombre;
  }

  public void setNombre(MateriaEnum nombre) {
    this.nombre = nombre;
  }

  public List<Float> getNotas() {
    return this.notas;
  }

  public void setNotas(List<Float> notas) {
    this.notas = notas;
  }
  

  @Override
  public String toString() {
    return "{" +
      " Nombre: '" + getNombre() + "'" +
      ", Notas: '" + getNotas() + "'" +
      " }";
  }


}
