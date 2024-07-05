import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("am");
    trie.insert("walk");
    trie.insert("want");
    trie.insert("war");
    trie.insert("war");
    trie.insert("warp");
    trie.insert("warp");
    trie.insert("we");
    trie.insert("wee");
    trie.insert("will");
    trie.insert("win");
    trie.insert("wish");
    trie.insert("wit");
    trie.insert("yo");
    
    System.out.println("Representacion del trie: \n");

    trie.draw();

    System.out.println("\nSe encuentra la palabra win en el trie : " + trie.search("win"));
    System.out.println("Se encuentra la palabra lose en el trie : " + trie.search("lose"));

    // Reemplazar palabras en un texto
    String text = "I wish to walk and win, but war and want make it hard.";
    Map<String, String> replacements = new HashMap<>();
    replacements.put("walk", "stroll");
    replacements.put("war", "conflict");
    replacements.put("wish", "desire");

    String replacedText = trie.replaceWordsInText(text, replacements);
    System.out.println("Texto Original: " + text);
    System.out.println("Texto Reemplazado: " + replacedText);

    List<String> topKWords = trie.findTopKFrequentWords(2);
    System.out.println("Las primeras 2 palabras con la mayor frecuencia son: " + topKWords );
    System.out.println("Las palabras con el prefijo wa son : " + trie.searchByPrefix("wa") + "\n");
  }
}
