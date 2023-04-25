import java.util.Iterator;

/**
 * @Author: ouyangyameng
 * @Date: 2023/4/25 11:33
 * @Version 1.0
 */
public class M284PeekingIterator {
    class PeekingIterator implements Iterator<Integer> {
        Integer temp;
        Iterator<Integer> iterator;

        public PeekingIterator(Iterator<Integer> iterator) {
            this.iterator = iterator;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (temp != null) {
                return temp;
            } else {
                temp = iterator.next();
                return temp;
            }
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (temp != null) {
                Integer t = temp;
                temp = null;
                return t;
            } else {
                return iterator.next();
            }
        }

        @Override
        public boolean hasNext() {
            if (temp != null) {
                return true;
            } else {
                return iterator.hasNext();
            }
        }
    }
}
