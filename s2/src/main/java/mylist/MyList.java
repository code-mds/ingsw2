package mylist;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MyList<T> implements IMyList<T> {
    private ArrayList<T> internalList = new ArrayList<>();

    @Override
    public void addElement(T ob) {
        internalList.add(ob);
    }

    @Override
    public int length() {
        return internalList.size();
    }

    @Override
    public T getElement(int pos) {
        return internalList.get(pos);
    }

    @Override
    public MyIterator<T> getForwardIterator() {
        return new ForwardIterator();
    }

    @Override
    public MyIterator<T> getBackwardIterator() {
        return new BackwardIterator();
    }

    private class ForwardIterator implements MyIterator<T> {
        int cursor = 0;       // index of next element to return

        @Override
        public void rewind() {
            cursor = 0;
        }

        @Override
        public T nextElement() {
            T val;
            if(cursor < MyList.this.length()) {
                val = MyList.this.getElement(cursor);
                cursor++;
            } else
                throw new NoSuchElementException();

            return val;
        }

        @Override
        public boolean hasMoreElements() {
            return cursor < MyList.this.length();
        }
    }

    private class BackwardIterator implements MyIterator<T> {
        int cursor = MyList.this.length() -1;       // index of next element to return

        @Override
        public void rewind() {
            cursor = MyList.this.length() -1;
        }

        @Override
        public T nextElement() {

            T val;
            if(cursor >= 0) {
                val = MyList.this.getElement(cursor);
                cursor--;
            } else
                throw new NoSuchElementException();

            return val;
        }

        @Override
        public boolean hasMoreElements() {
            return cursor >= 0;
        }
    }

}

