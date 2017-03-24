package ca.uwo.eng.se2205.lab6;

/**
 * Created by PeakeAndSons on 2017-03-18.
 */
public class InsertionSorter implements Sorter {
    @Override
    public <E> void sort(DelayedList<E> sort, DelayedComparator<E> comparator) {
        int unsortedIndex =1;
        int sortedIndex =0;
        while (sortedIndex != sort.size()-1) {
            //unsorted<sorted
            //swap needed
            if (comparator.compare(sort.get(unsortedIndex), sort.get(sortedIndex)) < 0) {
                //2,4,6,3,8
                //2,4,6,hole(3),8
                E temp = sort.get(unsortedIndex);
                int hole = unsortedIndex;
                boolean noHole = false;
                int uns = unsortedIndex;
                int s = sortedIndex;
                while (!noHole && s > -1 && uns > 0) {
                    //shift the hole
                    if (comparator.compare(sort.get(uns), sort.get(s)) < 0) {
                        //2,4,6,3,8
                        //2,4,6,hole(3),8
                        //2,4,hole(3),6,8
                        sort.set(uns, sort.get(s));
                        sort.set(s, temp);
                        s--;
                        uns--;
                    } else {
                        noHole = true;
                    }
                }
            }
            //no swap needed
            sortedIndex++;
            unsortedIndex++;
        }
    }

//    public static <E> void sortTest(DelayedList<E> sort, DelayedComparator<E> comparator) {
//        int unsortedIndex =1;
//        int sortedIndex =0;
//        while (sortedIndex != sort.size()-1){
//            //unsorted<sorted
//            //swap needed
//            if(comparator.compare(sort.get(unsortedIndex),sort.get(sortedIndex))<0){
//                //2,4,6,3,8
//                //2,4,6,hole(3),8
//                E temp = sort.get(unsortedIndex);
//                int hole = unsortedIndex;
//                boolean noHole = false;
//                int uns = unsortedIndex;
//                int s=sortedIndex;
//                while (!noHole && s>-1 && uns>0){
//                    //shift the hole
//                    if(comparator.compare(sort.get(uns),sort.get(s))<0){
//                        //2,4,6,3,8
//                        //2,4,6,hole(3),8
//                        //2,4,hole(3),6,8
//                        sort.set(uns,sort.get(s));
//                        sort.set(s,temp);
//                        s--;
//                        uns--;
//                    }
//                    else{
//                        noHole = true;
//                    }
//                }
//            }
//            //no swap needed
//            sortedIndex++;
//            unsortedIndex++;
//        }
//    }
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