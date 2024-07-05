import java.util.*;

public class TestTrie {
  private static final Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
    Trie trie = new Trie();
    menu();
    String command;
    String op[];
    while (true) {
      System.out.print("\ntrie[string]> ");
      command = sc.nextLine();
      op = command.split(" ");
      switch (op[0]) {
        case "insert":
          trie.insert(op[1]);
          break;
        case "remove":
          System.out.println(trie.remove(op[1]));
          break;
        case "contains":
          System.out.println(trie.contains(op[1]));
          break;
        case "show":
          trie.printTrie();
          break;
        case "prefix":
          List<String> words = trie.searchByPrefix(op[1]);
          System.out.println("Words with prefix \"" + op[1] + "\": " + words);
          break;
        case "replace":
          Map<String, String> replacements = new HashMap<>();
          for (int i = 1; i < op.length; i += 2) {
              replacements.put(op[i], op[i + 1]);
          }
          System.out.println("Enter text:");
          String text = sc.nextLine();
          System.out.println("Replaced text: " + trie.replaceWordsInText(text, replacements));
          break;
        case "topk":
          int k = Integer.parseInt(op[1]);
          List<String> topWords = trie.findTopKFrequentWords(k);
          System.out.println("Top " + k + " frequent words: " + topWords);
          break;
        case "quit":
          return;
        default:
          System.out.println("Command not found.");
          break;
      }
    }
  }
  private static void menu() {
      System.out.println("Bienvenido, construye tu propio arbol digital :)\n");
      System.out.println(
        "---------------------------------------------------------------\n" +
          "insert \t\t-> \tInsert a word\n" +
          "remove \t\t-> \tRemove a word\n" +
          "contains \t-> \tVerify if contains a word\n" +
          "show \t\t-> \tShow the trie tree\n" +
          "prefix \t\t-> \tSearch words by prefix\n" +
          "replace \t-> \tReplace words in text\n" +
          "topk \t\t-> \tFind top k frequent words\n" +
          "quit \t\t-> \tExit program\n" +
        "---------------------------------------------------------------\n");
  }
}
