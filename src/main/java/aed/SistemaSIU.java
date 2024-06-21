package aed;

import aed.interfaces.Iterador;
import aed.interfaces.Sistema;

/**
 * MODULO CON INVARIANTE DE REPRESENTACION:
 *  Modulo SistemaSIU implementa Sistema{
 *    carreras: CarrerasImpl;
 * estudiantes: EstudiantesImpl; 
 *   InvRep(S: SistemaSiu){
 *      S.carreras != null && 
 *      S.estdiantes != null     
 *      }
 *   }
 */

public class SistemaSIU implements Sistema {
    private CarrerasImpl carreras; 
    private EstudiantesImpl estudiantes; 

    public enum CargoDocente{
        AY2,
        AY1,
        JTP,
        PROF
    }

    public SistemaSIU(InfoMateria[] materiasEnCarreras, String[] libretasUniversitarias){
        this.carreras = new CarrerasImpl();
        this.estudiantes = new EstudiantesImpl();

        for(String lu : libretasUniversitarias){         // O(|libretas universitarias|) = O(cant de estudiantes)
            this.estudiantes.registrarEnelSistema(lu);  // O(1) pues estudiantes es de tipo Estudiantes y |lu| es acotada
        }
        // Complejidad = O(cant de estudiantes) * O(1) = O(cantEstudiantes)


        for(InfoMateria info : materiasEnCarreras){
            ParCarreraMateria[] pares = info.getParesCarreraMateria();          // O(1)
            DataMateria data = new DataMateria();                               // O(1)

            for(ParCarreraMateria par : pares){                                 
                String carrera = par.getCarrera();                              // O(1)
                String nombreMateria = par.getNombreMateria();                  // O(1)
                data.agregarNombre(nombreMateria);                              // O(1) pues data es de tipo DataMateria               

                if(!this.carreras.estaRegistrada(carrera)){                     // O(|carrera|) pues carreras es de tipo Carreras           
                    MateriasImpl materias = new MateriasImpl();                 // O(1)
                    this.carreras.agregarCarrera(carrera, materias);            // O(|carrera|)
                    materias.agregarMateria(nombreMateria, data);               // O(|nombreMateria|) pues materias es de tipo materiasImpl
                    data.agregarTrie(materias);                                 // O(1) pues data es DataMateria

                }
                else{
                    MateriasImpl materiasCarrera = this.carreras.obtenerMateriasCarrera(carrera);   // O(|carrera|) pues carreras es de tipo Carreras           
                    materiasCarrera.agregarMateria(nombreMateria, data);        // O(|nombreMateria|) pues materiasCarrera es de tipo materiasImpl                     
                    data.agregarTrie(materiasCarrera);                          // O(1) pues data es DataMateria
                }

            }
        }
    }
/*  La complejidad es : O(cant de estudiantes) + O(suma de las longitudes de las carreras
    por su cant de materias) + O(suma de las longitudes de los nombres de la materia para cada materia).

    La complejidad del segundo termino se explica por lo que hace el segundo ciclo. Para cada
    carrera se fija si ya esta registrada (costo : O(|carrera|)) y , en base a eso, la registra 
    (costo : O(|carrera|) ) o obtiene sus materias (costo : O(|carrera|) ). Esto lo hace por carrera
    tantas veces como materias tenga ya que despues debe registrarlas. Por lo tanto, para cada carrera
    la complejidad es O( 2 * |carrera| * cant de materias de la carrera) = 
    O(|carrera| * cant de materias de la carrera). 

    En paralelo, el segundo ciclo también va recorriendo cada materia y para cada uno de sus nombres la
    va registrando en su carrera correspondiente lo que cuesta O(|nombreMateria|) para cada nombre. 
    Asi, para cada materia , registrarla cuesta O(suma de las longitudes de los nombres de la materia) 
    lo cual explica la complejidad del tercer termino.   
*/


    public void inscribir(String estudiante, String carrera, String materia){
        this.estudiantes.inscribirAMateria(estudiante);                                // O(1) pues estudiantes es de Tipo EstudiantesImpl y |estudiante| es acotada
        MateriasImpl materiasCarrera =  this.carreras.obtenerMateriasCarrera(carrera); // O(|carrera|) pues carreras es de tipo CarrerasImpl
        DataMateria  materiaCarrera = materiasCarrera.obtenerMateria(materia);         // O(|materia|) pues materiasCarrera es de tipo MateriasImpl
        materiaCarrera.agregarAlumno(estudiante);                                      // O(1) pues materiaCarrera es de tipo DataMateria
    }
/*  Complejidad : O(1) + O(|carrera|) + O(|materia|) + O(1) = O(|carrera|) + O(|materia|) = 
*   O(|carrera| + |materia|)
*/


    public void agregarDocente(CargoDocente cargo, String carrera, String materia){
        MateriasImpl materiasCarrera = this.carreras.obtenerMateriasCarrera(carrera); // O(|carrera|) pues carreras es de tipo CarrerasImpl
        DataMateria materiaCarrera = materiasCarrera.obtenerMateria(materia);         // O(|materia|) pues materiasCarrera es de tipo MateriasImpl
        materiaCarrera.agregarDocente(cargo);                                         // O(1) pues materiaCarrera es de tipo DataMateria  
    }
    // Complejidad : O(1) + O(|carrera|) + O(|materia|) = O(|carrera|) + O(|materia|) = O(|carrera| + |materia|) 



    public int[] plantelDocente(String materia, String carrera){
        MateriasImpl materiasCarrera = this.carreras.obtenerMateriasCarrera(carrera);  // O(|carrera|) pues carreras es de tipo CarrerasImpl
        DataMateria materiaCarrera = materiasCarrera.obtenerMateria(materia);          // O(|materia|) pues materiasCarrera es de tipo MateriasImpl 
        return materiaCarrera.obtenerPlantel();                                        // O(1) pues materiaCarrera es de tipo DataMateria 
    }
    // Complejidad : O(1) + O(|carrera|) + O(|materia|) = O(|carrera|) + O(|materia|) = O(|carrera| + |materia|) 

    


    public void cerrarMateria(String materia, String carrera){
        MateriasImpl materiasCarrera = this.carreras.obtenerMateriasCarrera(carrera);  // O(|carrera|) pues carreras es CarrerasImpl 
        DataMateria materiaCarrera = materiasCarrera.obtenerMateria(materia);          // O(|materia|) pues materiasCarrera es MateriaImpl    
        ListaEnlazada<String> alumnosInscriptos = materiaCarrera.obtenerInscriptos();  // O(1) pues materiaCarrera es DataMateria
        Iterador<String> iteradorAlumnos = alumnosInscriptos.iterador();               // O(1) pues alumnosIncriptos es ListaEnlazada 
        for(int i = 0 ; i < alumnosInscriptos.longitud(); i ++){                       // O(cantidad de alumnos inscriptos a la materia) 
            String luAlumno = iteradorAlumnos.siguiente();                             // O(1) pues iteradorAlumnops es un iterador de listaEnlazada
            this.estudiantes.desinscribir(luAlumno);                                   // O(1) pues estudiantes es de tipo Estudiantes y |luAlumno| es acotada
        }
        materiaCarrera.cerrarMateria();                                                // O(suma de las longitudes de los nombres de la materia) pues materiaCarrera es de tipo DataMateria 
    }
/*  Complejidad : O(|carrera|) + O(|materia|) + O(1) + O(cantidad de alumnos inscriptos a la materia) + O(1) + 
*   + O(suma de las longitudes de los nombres de la materia) = 
    O(|carrera| + |materia| + cantidad de alumnos inscriptos en la materia + suma de las longitudes de los nombres de la materia )
*/



    public int inscriptos(String materia, String carrera){
        MateriasImpl materiasCarrera = this.carreras.obtenerMateriasCarrera(carrera);   // O(|carrera|) pues carreras es de tipo CarrerasImpl
        DataMateria materiaCarrera = materiasCarrera.obtenerMateria(materia);           // O(|materia|) pues materiasCarrera es de tipo MateriasImpl 
        return materiaCarrera.cantInscriptos();                                         // O(1) pues materiaCarrera es de tipo DataMateria 
    }
    // Complejidad : O(1) + O(|carrera|) + O(|materia|) = O(|carrera|) + O(|materia|) = O(|carrera| + |materia|) 



    public boolean excedeCupo(String materia, String carrera){
        MateriasImpl materiasCarrera = this.carreras.obtenerMateriasCarrera(carrera);   // O(|carrera|) pues carreras es de tipo CarrerasImpl
        DataMateria materiaCarrera = materiasCarrera.obtenerMateria(materia);           // O(|materia|) pues materiasCarrera es de tipo MateriasImpl 
        return materiaCarrera.excedeCupo();                                             // O(1) pues materiaCarrera es de tipo DataMateria 
    }
    // Complejidad : O(1) + O(|carrera|) + O(|materia|) = O(|carrera|) + O(|materia|) = O(|carrera| + |materia|) 
    



    public String[] carreras(){
        return this.carreras.obtenerListaDeCarreras();                                  
    }
    // Complejidad : O(suma de las longitudes de las carreras) ya que carreras es de tipo carrerasImpl




    public String[] materias(String carrera){
        MateriasImpl materiasCarrera = this.carreras.obtenerMateriasCarrera(carrera);   // O(|carrera|) pues carreras es de tipo CarrerasImpl
        return materiasCarrera.obtenerListaDeMaterias();                                // O(suma de las longitudes de las materias) pues materiasCarrera es de tipo MateriasImpl
    }
/*  Complejidad = O(|carrera|) + O(suma de las longitudes de las longitudes de las materias) = 
    O(|carrera| + suma de las longitudes de las materias )
*/



    public int materiasInscriptas(String estudiante){
        return estudiantes.cantMateriasInscriptas(estudiante); 
    }
    // Complejidad : O(1) pues estudiantes es de tipo estudiantes y |estudiante| es acotada. 
}
