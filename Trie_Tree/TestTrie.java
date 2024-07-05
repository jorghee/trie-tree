import java.util.Scanner;

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

      if (op[0].equals("insert"))
        trie.insert(op[1]);
      else if (op[0].equals("remove"))
        System.out.println(trie.remove(op[1]));
      else if (op[0].equals("contains"))
        System.out.println(trie.contains(op[1]));
      else if (op[0].equals("show"))
        trie.printTrie();
      else if (op[0].equals("quit")) {
        break;
      } else
        System.out.println("Command not find.");
    }
  }

  private static void menu() {
    System.out.println("Bienvenido, contruye tu arbol binario de busqueda :)\n");
    System.out.println(
        "---------------------------------------------------------------\n" +
        "insert \t\t-> \tInsert a word\n" +
        "remove \t\t-> \tRemove a word\n" +
        "contains \t-> \tVerify if contains a word\n" +
        "show \t\t-> \tShow the trie tree\n" +
        "quit \t\t-> \tExit program\n" +
        "---------------------------------------------------------------\n");
  }
}
