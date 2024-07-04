public interface ITrie {
  void insert(String word);
  boolean contains(String word);
  String get(String word);
  boolean remove(String word);
}
