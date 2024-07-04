public class TestTrie {
  public static void main(String[] args) {
    Trie<String> trie = new Trie<>();

    // Insertar palabras en el Trie
    trie.insert("apple", "A sweet red fruit");
    trie.insert("app", "Short for application");
    trie.insert("apricot", "A yellow-orange fruit");
    trie.insert("banana", "A long yellow fruit");

    // Probar el método contains
    System.out.println("Contains 'apple': " + trie.contains("apple")); // true
    System.out.println("Contains 'app': " + trie.contains("app"));     // true
    System.out.println("Contains 'apricot': " + trie.contains("apricot")); // true
    System.out.println("Contains 'banana': " + trie.contains("banana")); // true
    System.out.println("Contains 'orange': " + trie.contains("orange")); // false

    // Probar el método get
    System.out.println("Get 'apple': " + trie.get("apple")); // "A sweet red fruit"
    System.out.println("Get 'app': " + trie.get("app"));     // "Short for application"
    System.out.println("Get 'apricot': " + trie.get("apricot")); // "A yellow-orange fruit"
    System.out.println("Get 'banana': " + trie.get("banana")); // "A long yellow fruit"
    System.out.println("Get 'orange': " + trie.get("orange")); // null

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
