package models;

import java.util.ArrayList;
import java.util.List;

public class Materia {

  private MateriaEnum nombre;
  private List<Float> notas;
 
  public Materia() {
  }

  public Materia(MateriaEnum nombre) {
    this.nombre = nombre;
    this.notas = new ArrayList<>();
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

  public void setNota(float input){
    this.getNotas().add(input);
  }
  

  @Override
  public String toString() {
    return "'" + getNombre() + "'" +
      ", Notas: '" + getNotas() + "'" +
      "";
  }


}
