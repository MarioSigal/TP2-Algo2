package aed;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class TrieTests {
  
  String[] nombres = new String[]{"Santiago","Santino","Sandra","Alexander","Alex","Marco","Marcos"};
  String[] nombresOrdenados = new String[]{"Alex","Alexander","Marco","Marcos","Sandra","Santiago","Santino"};
  int[] numeros = new int[]{7,8,10,6,8,8,9};
  @Test
  void definiciones(){
    TrieV2<Integer> miTrie = new TrieV2<>(); 
    miTrie.definir("Santiago", 8);
    miTrie.definir("Santino", 5);
    assertEquals(5, miTrie.obtener("Santino"));
    assertEquals(8, miTrie.obtener("Santiago"));
    miTrie.definir("Santiago", 7);
    miTrie.definir("Santino", 10);
    assertEquals(7, miTrie.obtener("Santiago"));
    assertEquals(10, miTrie.obtener("Santino"));
    assertEquals(2, miTrie.longitud());
    miTrie.definir("Lucas", 0);
    miTrie.definir("Lucas", 20);
    assertEquals(3, miTrie.longitud());
    assertEquals(20, miTrie.obtener("Lucas"));

  }
  @Test 
  void borrado(){
    TrieV2<Integer> miTrie = new TrieV2<>();
    for (int i = 0; i < nombres.length; i++) {
      miTrie.definir(nombres[i],numeros[i]);
    }
    assertEquals(7, miTrie.longitud());
    for (int i = 0; i < nombres.length; i++) {
      assertEquals(numeros[i], miTrie.obtener(nombres[i]));
    }

    miTrie.borrar("Santiago");
    assertEquals(6, miTrie.longitud());
    for (int i = 1; i < nombres.length; i++) {
      assertEquals(true, miTrie.esta(nombres[i]));
      assertEquals(numeros[i], miTrie.obtener(nombres[i]));
    }

    miTrie.borrar("Alex");
    assertEquals(false, miTrie.esta("Alex"));
    assertEquals(true, miTrie.esta("Alexander"));
    assertEquals(5, miTrie.longitud());

    miTrie.borrar("Sandra");
    assertEquals(true, miTrie.esta("Santino"));
    assertEquals(false, miTrie.esta("Sandra"));

    
  }

  @Test
  void inorder(){
    TrieV2<Integer> miTrie = new TrieV2<>();
    for (int i = 0; i < nombres.length; i++) {
      miTrie.definir(nombres[i],numeros[i]);
    }
    ListaEnlazada<String> nombres = miTrie.obtenerElems();
    for (int i = 0; i < this.nombresOrdenados.length; i++) {
      assertEquals(nombresOrdenados[i], nombres.obtener(i));
    }

    miTrie.borrar("Marco");
    nombres = miTrie.obtenerElems(); 
    assertEquals(6, miTrie.longitud());
    assertEquals(6, nombres.longitud());

    nombresOrdenados = new String[]{"Alex","Alexander","Marcos","Sandra","Santiago","Santino"};

    for (int i = 0; i < this.nombresOrdenados.length; i++) {
      assertEquals(nombresOrdenados[i], nombres.obtener(i));
    }

  }
}
