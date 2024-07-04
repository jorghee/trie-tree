import java.util.*;

class TrieNode {
  Map<Character, TrieNode> children = new HashMap<>();
  int frequency = 0;
  boolean isEndOfWord = false;
}