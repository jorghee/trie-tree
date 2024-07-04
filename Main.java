import java.util.List;

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

        
        List<String> topKWords = trie.findTopKFrequentWords(2);
        System.out.println("Top 2 " + "words are: " + topKWords);

        System.out.println(trie.searchByPrefix("wa"));

        trie.draw();
    }
}
