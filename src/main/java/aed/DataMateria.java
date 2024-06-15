package aed;

import aed.SistemaSIU.CargoDocente;

public class DataMateria {
  private int[] plantelDocente;
  private ListaEnlazada<String> inscriptos; 
  private ListaEnlazada<String> otrosNombres; 
  private ListaEnlazada<Materias> otrosTries; 
  
  public DataMateria(){
    this.plantelDocente = new int[4];
    this.inscriptos = new ListaEnlazada<>();
    this.otrosNombres = new ListaEnlazada<>();
    this.otrosTries = new ListaEnlazada<>();
  }

  public void agregarAlumno(String lu){
    this.inscriptos.agregarAtras(lu);
  }

  public void agregarNombre(String nombreMateria){
    this.otrosNombres.agregarAtras(nombreMateria);
  }
   
  public void agregarTrie(Materias trieMateria){
    this.otrosTries.agregarAtras(trieMateria);
  }

  public int[] obtenerPlantel (){
    return this.plantelDocente; 
    // Quizas deberia copiar el array original y devolver uno nuevo.
  }

  public void agregarDocente(CargoDocente cargo){
    if(cargo == CargoDocente.PROF){
      this.plantelDocente[0] += 1; 
    }
    else if(cargo == CargoDocente.JTP){
      this.plantelDocente[1] += 1;
    }
    else if(cargo == CargoDocente.AY1){
      this.plantelDocente[2] += 1;
    }
    else{
      this.plantelDocente[3] += 1;
    }
  }

  public int cantInscriptos(){
    return this.inscriptos.longitud(); 
  }

  public boolean excedeCupo(){
    int cupo;
    int cupoSegunAY2 = this.plantelDocente[3] * 30;
    int cupoSegunAY1 = this.plantelDocente[2] * 20;
    int cupoSegunJTP = this.plantelDocente[1] * 100;
    int cupoSegunPROF = this.plantelDocente[0] * 250;

    cupo = min(min(cupoSegunAY2,cupoSegunAY1),min(cupoSegunJTP,cupoSegunPROF));
    
    return (cantInscriptos() <= cupo); 

  }

  private int min(int num1, int num2){
    if(num1 < num2){
      return num1;
    }
    else{
      return num2; 
    }
  } 

}