package aed;

public class ArrayConSig {
  private String[] array; 
  private int siguiente;

  public ArrayConSig(int capacidad){
    this.array = new String[capacidad];
    this.siguiente = 0; 
  }

  public void agregarElem(String elem){
    this.array[siguiente] = elem;
    this.siguiente += 1; 
  }

  public String[] devolverArray(){
    return this.array; 
  }
}
