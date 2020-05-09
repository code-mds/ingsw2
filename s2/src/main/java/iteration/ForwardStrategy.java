package iteration;

import mylist.IMyList;
import mylist.MyIterator;

public class ForwardStrategy implements IteratorStrategy {
    @Override
    public <T> MyIterator<T> getIterator(IMyList<T> myList) {
        return myList.getForwardIterator();
    }
}
