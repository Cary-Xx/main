package seedu.address;

import java.util.Comparator;
import java.util.function.IntFunction;
import java.util.function.Predicate;

/**
 * Utility class that provides methods for finding the first and the last keys using binary search algorithm.
 */
public class Search {

    /**
     * Searches the specified array for the specified value using modification of binary
     * search algorithm and returns the index of the first key in a[] that equals the search key,
     * or -1 if no such key were found.
     * The array must be sorted into ascending order according to the specified
     * comparator, otherwise the results are undefined.
     *
     * @param a          - the array of keys to be searched
     * @param key        - the value to be searched for
     * @param comparator - the comparator by which array is ordered
     * @return - the index of the first key in a[] that equals the search key, -1 if not found
     * @throws NullPointerException - if a == null
     * @throws NullPointerException - if key == null
     * @throws NullPointerException - if comparator == null
     */
    public static <T> int firstIndexOf(T[] a, T key, Comparator<T> comparator) {
        if (a == null) {
            throw new NullPointerException("a cannot be null");
        }
        if (key == null) {
            throw new NullPointerException("key cannot be null");
        }
        if (comparator == null) {
            throw new NullPointerException("comparator cannot be null");
        }

        if (a.length == 0) {
            return -1;
        }
        if (comparator.compare(a[0], key) == 0) {
            return 0;
        }

        int lo = 0;
        int hi = a.length;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = comparator.compare(a[mid], key);

            if (cmp >= 1) {
                hi = mid - 1;
            } else if (cmp <= -1) {
                lo = mid + 1;
            } else if (comparator.compare(a[mid - 1], a[mid]) == 0) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * Searches the specified array for the specified value using modification of binary
     * search algorithm and returns the index of the last key in a[] that equals the search key,
     * or -1 if no such key were found.
     * The array must be sorted into ascending order according to the specified
     * comparator, otherwise the results are undefined.
     *
     * @param a          - the array of keys to be searched
     * @param key        - the value to be searched for
     * @param comparator - the comparator by which array is ordered
     * @return - the index of the last key in a[] that equals the search key, -1 if not found
     * @throws NullPointerException - if a == null
     * @throws NullPointerException - if key == null
     * @throws NullPointerException - if comparator == null
     */
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        if (a == null) {
            throw new NullPointerException("array of keys cannot be null");
        }
        if (key == null) {
            throw new NullPointerException("key cannot be null");
        }
        if (comparator == null) {
            throw new NullPointerException("comparator cannot be null");
        }

        if (a.length == 0) {
            return -1;
        }
        if (comparator.compare(a[a.length - 1], key) == 0) {
            return a.length - 1;
        }

        int lo = 0;
        int hi = a.length;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = comparator.compare(a[mid], key);

            if (cmp >= 1) {
                hi = mid - 1;
            } else if (cmp <= -1) {
                lo = mid + 1;
            } else if (comparator.compare(a[mid + 1], a[mid]) == 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

//    /**
//     * Return the index of given key in a[]
//     *
//     * @param a                   - the array of keys to be searched
//     * @param key                 -  the value to be searched for
//     * @param comparator          - the comparator by which array is ordered
//     * @param eqTest              - predicate of integer to check if matched
//     * @param eqLowChangeFunction - the function to apply to the temp value
//     * @return - the index of given key in a[] that equals the search key, -1 if not found
//     */
//    private static <T> int indexOf(T[] a,
//                                   T key,
//                                   Comparator<T> comparator,
//                                   Predicate<Integer> eqTest,
//                                   IntFunction<Integer> eqLowChangeFunction) {
//        // null checks
//
//        if (a.length == 0) {
//            return -1;
//        }
//
//        int lo = 0;
//        int hi = a.length;
//
//        while (lo <= hi) {
//            int mid = lo + (hi - lo) / 2;
//            int cmp = comparator.compare(a[mid], key);
//
//            if (cmp >= 1) {
//                hi = mid - 1;
//            } else if (cmp <= -1) {
//                lo = mid + 1;
//            } else if (eqTest.test(mid)) {
//                lo = eqLowChangeFunction.apply(mid);
//            } else {
//                return mid;
//            }
//        }
//        return -1;
//    }
}
