package mylist;

public interface IMyList<T> {
    void addElement(T ob);
    int length();
    T getElement(int pos);
    MyIterator<T> getForwardIterator();
    MyIterator<T> getBackwardIterator();
}
