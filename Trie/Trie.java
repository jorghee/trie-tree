import java.util.*;

class Trie {
  private TrieNode root;   
  public Trie() {
      root = new TrieNode();
  }    
  public void insert(String word) {
      TrieNode node = root;
      for (char c : word.toCharArray()) {
          node.children.putIfAbsent(c, new TrieNode());
          node = node.children.get(c);
      }
      node.frequency++;
      node.isEndOfWord = true;
  }    
  public boolean search(String word) {
      TrieNode node = root;
      for (char c : word.toCharArray()) {
          node = node.children.get(c);
          if (node == null) {
              return false;
          }
      }
      return node.isEndOfWord;
  }    
  public List<String> findTopKFrequentWords(int k) {
      PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
      Map<String, Integer> wordFrequencyMap = new HashMap<>();
      findTopKFrequentWordsHelper(root, "", wordFrequencyMap);     
      for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
          minHeap.offer(entry);
          if (minHeap.size() > k) {
              minHeap.poll();
          }
      }    
      List<String> result = new ArrayList<>();
      while (!minHeap.isEmpty()) {
          result.add(minHeap.poll().getKey());
      }
      Collections.reverse(result);
      return result;
  }    
  private void findTopKFrequentWordsHelper(TrieNode node, String word, Map<String, Integer> wordFrequencyMap) {
      if (node == null) {
          return;
      }    
      if (node.isEndOfWord) {
          wordFrequencyMap.put(word, node.frequency);
      }    
      for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
          findTopKFrequentWordsHelper(entry.getValue(), word + entry.getKey(), wordFrequencyMap);
      }
  }    
  public String replaceWordsInText(String text, Map<String, String> replacements) {
      StringBuilder result = new StringBuilder();
      String[] words = text.split("\\s+");
      for (String word : words) {
          if (search(word)) {
              result.append(replacements.getOrDefault(word, word)).append(" ");
          } else {
              result.append(word).append(" ");
          }
      }
      return result.toString().trim();
  }    
  public void draw() {
      drawHelper(root, new StringBuilder(), "");
  }    
  private void drawHelper(TrieNode node, StringBuilder prefix, String childrenPrefix) {
      if (node == null) {
          return;
      }    
      for (Iterator<Map.Entry<Character, TrieNode>> it = node.children.entrySet().iterator(); it.hasNext(); ) {
          Map.Entry<Character, TrieNode> entry = it.next();
          char character = entry.getKey();
          TrieNode childNode = entry.getValue();   
          System.out.print(prefix);
          if (it.hasNext()) {
              System.out.println("├── " + character + " (" + childNode.frequency + ")");
              drawHelper(childNode, new StringBuilder(childrenPrefix).append("│   "), childrenPrefix + "│   ");
          } else {
              System.out.println("└── " + character + " (" + childNode.frequency + ")");
              drawHelper(childNode, new StringBuilder(childrenPrefix).append("    "), childrenPrefix + "    ");
          }
      }
  }
  private void collectWords(TrieNode node, String prefix, List<String> words) {
      if (node.isEndOfWord) {
          words.add(prefix);
      }
      for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
          collectWords(entry.getValue(), prefix + entry.getKey(), words);
      }
  }    
  private TrieNode searchNode(String prefix) {
      TrieNode node = root;
      for (char c : prefix.toCharArray()) {
          node = node.children.get(c);
          if (node == null) {
              return null;
          }
      }
      return node;
  }    
  public List<String> searchByPrefix(String prefix){
      List<String> words = new ArrayList<>();
      TrieNode node = searchNode(prefix);
      if( node != null){
          collectWords(node, prefix , words);
      }
      
      return words;
  }
}