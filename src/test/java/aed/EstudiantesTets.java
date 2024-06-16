package aed;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class EstudiantesTets {
  @Test
  void test1(){
    Estudiantes estudiantes = new Estudiantes();
    estudiantes.inscribirAlumno("Juan");
    estudiantes.inscribirAlumno("Pedro");
    estudiantes.inscribirAlumno("Lucia");
    estudiantes.inscribirAlumno("Pedro");
    estudiantes.inscribirAlumno("Lucia");
    estudiantes.inscribirAlumno("Roberto");
    estudiantes.inscribirAlumno("Juan");
    estudiantes.inscribirAlumno("Lucia");

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
