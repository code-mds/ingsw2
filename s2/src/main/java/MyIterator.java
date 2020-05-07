public interface MyIterator<T> {
    void rewind();
    T nextElement();
    boolean hasMoreElements();
}