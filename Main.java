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
        trie.insert("warp");
        trie.insert("we");
        trie.insert("wee");
        trie.insert("will");
        trie.insert("win");
        trie.insert("wish");
        trie.insert("wit");
        trie.insert("yo");


        // Encontrar las k palabras más frecuentes
        int k = 2;
        List<String> topKWords = trie.findTopKFrequentWords(k);
        System.out.println("Top " + k + " words are: " + topKWords);

        trie.draw();
    }
}
