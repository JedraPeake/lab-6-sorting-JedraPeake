package ca.uwo.eng.se2205.lab6;

/**
 * Created by PeakeAndSons on 2017-03-18.
 */
public class QuickSorter implements Sorter {
    @Override
    public <E> void sort(DelayedList<E> sort, DelayedComparator<E> comparator) {
        int low = 0;
        int high = sort.size() - 1;
        sortTest(sort, comparator, low, high);
    }

//    public static <E> void sortTest(DelayedList<E> sort, DelayedComparator<E> comparator) {
//        int low = 0;
//        int high = sort.size() - 1;
//        sortTest(sort, comparator, low, high);
//    }

    private <E> void sortTest(DelayedList<E> sort, DelayedComparator<E> comparator, int lo, int hi) {
        if (sort.isEmpty() || lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        E pivot = sort.get(mid);

        int i = lo;
        int j = hi;

        while (i <= j) {
            //element at i < pivot)
            while (comparator.compare(sort.get(i), pivot) < 0) {
                i++;
            }
            //element at j > pivot)
            while (comparator.compare(sort.get(j), pivot) > 0) {
                j--;
            }
            if (i <= j) {
                E temp = sort.get(i);
                sort.set(i, sort.get(j));
                sort.set(j, temp);
                i++;
                j--;
            }
        }
        //Recursively sort two sub parts
        if (lo < j) {
            sortTest(sort, comparator, lo, j);
        }

        if (hi > i) {
            sortTest(sort, comparator, i, hi);
        }
    }

//    public static void main(String[] args) {
//        LinkedList<Integer> test = new LinkedList<>();
//        DelayedList<Integer> test2 = DelayedList.create(Delayed.Time.Fast, test);
//        Comparator<Integer> comp = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if(o1>o2) return 1;
//                if (o1==o2) return 0;
//                return -1;
//            }
//        };
//        DelayedComparator<Integer> comp2 = DelayedComparator.create(comp, Delayed.Time.Fast);
//        for (int i = 0; i < 10; i++)
//            test2.add(i,(int) (Math.random() * 100));
//
//        for (int i = 0; i < test2.size(); i++)
//            System.out.print(test2.get(i) + " ");
//
//        System.out.println();
//        sortTest(test2, comp2);
//
//        for (int i = 0; i < test2.size(); i++)
//            System.out.print(test2.get(i) + " ");
//    }
}
