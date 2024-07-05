public class TestTrie {
  public static void main(String[] args) {
    Trie trie = new Trie();

    // Insertar palabras en el Trie
    trie.insert("apple");
    trie.insert("apple");
    trie.insert("apple");
    trie.insert("app");
    trie.insert("banana");
    trie.insert("band");
    trie.insert("appleel");
    trie.insert("cojudo");
    trie.insert("cojuda");
    trie.insert("cojuda");

    // Probar el método contains
    System.out.println("Contains 'apple': " + trie.contains("apple")); // true
    System.out.println("Contains 'app': " + trie.contains("app"));     // true
    System.out.println("Contains 'banana': " + trie.contains("banana")); // true
    System.out.println("Contains 'orange': " + trie.contains("orange")); // false

    // Probar el método remove
    System.out.println("Remove 'app': " + trie.remove("app")); // true
    System.out.println("Contains 'app' after removal: " + trie.contains("app")); // false
    System.out.println("Get 'app' after removal: " + trie.get("app")); // null

    System.out.println();

    // Dibujar el Trie
    System.out.println("Current Trie structure:");
    trie.printTrie();
  }
}
