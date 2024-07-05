import java.util.HashMap;
import java.util.Map;

public class Trie implements ITrie {
  private TrieNode root;

  public Trie() {
    // El nodo raiz que representa el caracter nulo
    root = new TrieNode('\0');
  }

  private static class TrieNode {
    int count = 0;
    char ch;
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode(char ch) {
      children = new HashMap<>();
      isEndOfWord = false;
      this.ch = ch;
    }
  }

  @Override
  public void insert(String word) {
    TrieNode current = root;
    for (char ch : word.toCharArray())
      current = current.children.computeIfAbsent(ch, c -> new TrieNode(c));

    current.isEndOfWord = true;
    current.count++;
  }

  @Override
  public boolean contains(String word) {
    TrieNode current = root;
    for (char ch : word.toCharArray()) {
      // The get() is the HashMap method
      current = current.children.get(ch);
      if (current == null)
        return false;
    }
    return current.isEndOfWord;
  }

  @Override
  public String get(String word) {
    TrieNode current = root;
    for (char ch : word.toCharArray()) {
      current = current.children.get(ch);
      if (current == null)
        return null;
    }
    return current.isEndOfWord ? word : null;
  }

  @Override
  public boolean remove(String word) {
    return delete(root, word, 0);
  }

  private boolean delete(TrieNode current, String word, int index) {
    if (index == word.length()) {
      if (!current.isEndOfWord)
        return false;

      current.isEndOfWord = false;
      return current.children.isEmpty();
    }

    char ch = word.charAt(index);
    TrieNode node = current.children.get(ch);
    if (node == null)
      return false;

    boolean shouldDeleteCurrentNode = delete(node, word, index + 1);
    if (shouldDeleteCurrentNode) {
      current.children.remove(ch);
      return current.children.isEmpty();
    }
    return false;
  }

  // Imprimir el árbol digital
  public void printTrie() {
    printTrie(root, "", true);
  }

  private void printTrie(TrieNode node, String prefix, boolean isTail) {
    if (node != null) {
      System.out.println(prefix + (isTail ? "└── " : "├── ") +
                        (node.ch != '\0' ? node.ch : "") +
                        (node.isEndOfWord ? "(" + node.count + ")" : ""));

      int children = node.children.size();
      int i = 0;
      for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
        printTrie(entry.getValue(), prefix + (isTail ? "    " : "│   "), ++i == children);
      }
    }
  }
}
