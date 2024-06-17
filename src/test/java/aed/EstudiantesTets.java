package aed;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class EstudiantesTets {
  @Test
  void test1(){
    Estudiantes estudiantes = new Estudiantes();
    estudiantes.inscribirAMateria("Juan");
    estudiantes.inscribirAMateria("Pedro");
    estudiantes.inscribirAMateria("Lucia");
    estudiantes.inscribirAMateria("Pedro");
    estudiantes.inscribirAMateria("Lucia");
    estudiantes.inscribirAMateria("Roberto");
    estudiantes.inscribirAMateria("Juan");
    estudiantes.inscribirAMateria("Lucia");

    assertEquals(2, estudiantes.cantMateriasInscriptas("Juan"));
    assertEquals(1, estudiantes.cantMateriasInscriptas("Roberto"));
    assertEquals(3, estudiantes.cantMateriasInscriptas("Lucia"));

    estudiantes.desinscribir("Juan");
    estudiantes.desinscribir("Pedro");
    estudiantes.desinscribir("Pedro");
    estudiantes.desinscribir("Lucia");
    estudiantes.desinscribir("Roberto");

    assertEquals(1, estudiantes.cantMateriasInscriptas("Juan"));
    assertEquals(0, estudiantes.cantMateriasInscriptas("Roberto"));
    assertEquals(2, estudiantes.cantMateriasInscriptas("Lucia"));
    assertEquals(0, estudiantes.cantMateriasInscriptas("Pedro"));
    
    

  }
}
