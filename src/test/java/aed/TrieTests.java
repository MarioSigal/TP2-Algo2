package aed;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class TrieTests {
  
  String[] nombres = new String[]{"Santiago","Sandra","Alexander","Marco","Marcos","Santino","Alex"};
  String[] nombresOrdenados = new String[]{"Alex","Alexander","Marco","Marcos","Sandra","Santiago","Santino"};
  int[] numeros = new int[]{7,8,10,6,8,8,9};
  @Test
  void definiciones(){
    TrieList<Integer> miTrie = new TrieList<>(); 
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
    TrieList<Integer> miTrie = new TrieList<>();
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
    TrieList<Integer> miTrie = new TrieList<>();
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

  @Test
  void inorder2(){
    TrieList<String> trieNombres = new TrieList<>();
    String[] nombres2 = new String[]{"Jose","Juan","Lucia","Jacinto","Luciana","Roberto","Jeremias","Jaime","Mario","Marcos","Manuel"}; 
    
    for(String nombre : nombres2){
      trieNombres.definir(nombre,nombre);
    }

    assertEquals(11, trieNombres.longitud());

    trieNombres.borrar("Jose");
    trieNombres.borrar("Lucia");
    trieNombres.borrar("Marcos");

    assertEquals(8, trieNombres.longitud());

    assertEquals(false, trieNombres.esta("Jose"));
    assertEquals(false, trieNombres.esta("Lucia"));
    assertEquals(false, trieNombres.esta("Marcos"));

    ListaEnlazada<String> lista = trieNombres.obtenerElems(); 
    Iterador<String> iterador = lista.iterador();
    
    String[] nombresOrdenados2 = new String[]{"Jacinto","Jaime","Jeremias","Juan","Luciana","Manuel","Mario","Roberto"};
    
    for(int i = 0 ; i < lista.longitud() ; i++){
      assertEquals(nombresOrdenados2[i], iterador.siguiente());
    }

    trieNombres.definir("Jose","Jose");
    trieNombres.definir("Lucia","Lucia");
    trieNombres.definir("Marcos","Marcos");

    assertEquals(11, trieNombres.longitud());

    assertEquals(true, trieNombres.esta("Jose"));
    assertEquals(true, trieNombres.esta("Lucia"));
    assertEquals(true, trieNombres.esta("Marcos"));


    for (int i = 0; i < nombres2.length; i++) {
      trieNombres.borrar(nombres2[i]);
    }

    assertEquals(0, trieNombres.longitud());

    lista = trieNombres.obtenerElems(); 

    assertEquals(0, lista.longitud());
    assertEquals(false, lista.iterador().haySiguiente());



  }

  @Test
  void redefinir(){
    TrieList<Integer> trie = new TrieList<>(); 
    for (int i = 0; i < nombres.length; i++) {
      trie.definir(nombres[i], numeros[i]);
    }
    assertEquals(7, trie.longitud());

    assertEquals(8, trie.obtener("Sandra"));
    assertEquals(6, trie.obtener("Marco"));
    trie.definir("Sandra", 5);
    trie.definir("Marco", 10);
    assertEquals(7, trie.longitud());
    assertEquals(5, trie.obtener("Sandra"));
    assertEquals(10, trie.obtener("Marco"));
    assertEquals(true, trie.esta("Sandra"));
    trie.borrar("Sandra");
    assertEquals(6, trie.longitud());
    assertEquals(false, trie.esta("Sandra"));
    trie.definir("Sandra", 2);
    assertEquals(7, trie.longitud());
    assertEquals(true, trie.esta("Sandra"));
    assertEquals(2, trie.obtener("Sandra"));


  }
}
