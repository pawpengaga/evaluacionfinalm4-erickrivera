package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import services.ArchivoServicio;

public class PromedioServicioTest {

  private ArchivoServicio calculadorDePromedio = new ArchivoServicio();
  private List<Float> notasTest = new ArrayList<>();

  @AfterEach
  @DisplayName("Vacia las notas despues de cada uso")
  public void limpiarNotas(){
    notasTest.clear();
  }

  @Test
  @DisplayName("Prueba del calculo de promedios")
  public void testCalcularPromedioTotal(){

    notasTest.add(4.5F);
    notasTest.add(6.4F);
    notasTest.add(3.4F);
    notasTest.add(1.0F);

    assertEquals(3.8249998092651367F, calculadorDePromedio.getPromedioServicio(notasTest));

  }

  @Test
  @DisplayName("Calculo del promedio cuando existe solo un valor")
  public void testCalcularPromedioSingle(){
    notasTest.add(4.5F);

    assertEquals(4.5F, calculadorDePromedio.getPromedioServicio(notasTest));
  }

  @Test
  @DisplayName("Calculo de promedio cuando no hay nada en la lista")
  public void testCalcularPromedioVacio(){

    assertEquals(0.0F, calculadorDePromedio.getPromedioServicio(notasTest));

  }

}
