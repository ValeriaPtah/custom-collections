public interface CustomList<T> {

  void add(T el);

  void add(T el, int index);

  T remove(int index);

  T at(int index);

  int size();
}
