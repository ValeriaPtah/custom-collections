public interface CustomList<T> {

  void add(T el);

  void add(T el, int index);

  T remove(int index);

  T get(int index);

  int size();
}
