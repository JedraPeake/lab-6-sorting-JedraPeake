package ca.uwo.eng.se2205.lab6;

/**
 * Created by PeakeAndSons on 2017-03-18.
 */
public class SelectionSorter implements Sorter {

    @Override
    public <E> void sort(DelayedList<E> sort, DelayedComparator<E> comparator) {
        for(int i=0; i<sort.size();i++){
            //2,9,4,6,1,5
            int smallestIndex=i;
            for(int j =i; j<sort.size();j++){
                //j<smellesindex
                if(comparator.compare(sort.get(j),sort.get(smallestIndex))<0){
                    smallestIndex = j;
                }
            }
            if(smallestIndex !=i){
                E temp = sort.get(smallestIndex);
                sort.set(smallestIndex, sort.get(i));
                sort.set(i,temp);
            }
        }
    }

//    public static <E> void sortTest(DelayedList<E> sort, DelayedComparator<E> comparator) {
//        for(int i=0; i<sort.size();i++){
//            //2,9,4,6,1,5
//            int smallestIndex=i;
//            for(int j =i; j<sort.size();j++){
//                //j<smellesindex
//                if(comparator.compare(sort.get(j),sort.get(smallestIndex))<0){
//                    smallestIndex = j;
//                }
//            }
//            if(smallestIndex !=i){
//                E temp = sort.get(smallestIndex);
//                sort.set(smallestIndex, sort.get(i));
//                sort.set(i,temp);
//            }
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


