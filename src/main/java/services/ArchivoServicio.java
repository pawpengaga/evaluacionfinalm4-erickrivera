package services;

import java.io.FileWriter;
import java.util.List;
import java.util.Map;

import exceptions.GenerarArchivoException;
import models.Alumno;
import models.Materia;

public class ArchivoServicio {

  public void exportarDatos(AlumnoServicio alumnoServicio, String ruta) throws GenerarArchivoException {

    try(FileWriter writer = new FileWriter(ruta)){

      writer.append("ID, RUT, Nombre, Materia, Notas, Promedio\n");
      int cont = 0;
      for(Map.Entry<String, Alumno> alumnoEnt : alumnoServicio.listar().entrySet()){
        
        Alumno alumno = alumnoEnt.getValue();
        if (alumno.getMaterias().size() > 0){
          for(Materia materia : alumno.getMaterias()){
            writer.append(cont + ", ")
            .append(alumno.getRut() + ", ")
            .append(alumno.getNombre() + " " + alumno.getApellido() + ", ")
            .append(materia.getNombre() + ", ")
            .append(materia.getNotas() + ", ")
            .append(calcularPromedioDos(materia.getNotas()) + "\n");
          }
        } else {
          writer.append(cont + ", ")
          .append(alumno.getRut() + ", ")
          .append(alumno.getNombre() + " " + alumno.getApellido() + ", ")
          .append("NO PRESENTA" + ", ")
          .append("NO PRESENTA" + ", ")
          .append("NO PRESENTA");
        }
        
      }
      System.out.println("****************");
      System.out.println("ARCHIVO GENERADO");
      System.out.println("****************");
    } catch (Exception e){
      throw new GenerarArchivoException("Error al generar archivo: " + e.getMessage());
    }

  }

  public float getPromedioServicio(List<Float> notas){
    return calcularPromedioDos(notas);
  }

  // Aqui iba un metodo para calcular promedios...

  private float calcularPromedioDos(List<Float> notas){
    if (notas.size() > 0) {
      float sum = 0.0F;  
      for (float nota : notas) {
        sum += nota;
      }
      float promedio = sum / notas.size();
      return promedio;
    }
    return 0.0F;
  }

}
