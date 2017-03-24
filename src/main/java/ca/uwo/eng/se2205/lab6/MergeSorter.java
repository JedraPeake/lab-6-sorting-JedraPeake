package ca.uwo.eng.se2205.lab6;

/**
 * Created by PeakeAndSons on 2017-03-18.
 */
public class MergeSorter implements Sorter {

    @Override
    public <E> void sort(DelayedList<E> sort, DelayedComparator<E> comparator) {
        mergeSort(0, sort.size() - 1, sort, comparator);
    }

//    public static <E> void sortTest(DelayedList<E> sort, DelayedComparator<E> comparator){
//        mergeSort(0, sort.size() - 1, sort, comparator);
//    }

    private <E> void mergeSort(int low, int high, DelayedList<E> sort, DelayedComparator<E> comparator) {
        if(low < high){
            int mid = low + (high - low) / 2;
            mergeSort(low, mid, sort, comparator);
            mergeSort(mid+1, high, sort, comparator);
            merge(low, mid, high, sort, comparator);

        }
    }

    private <E> void merge(int low, int mid, int high, DelayedList<E> sort, DelayedComparator<E> comparator){
        int first =0;
        int second =mid+1;
        boolean done = false;
        //0 , 1
        //1 , 0
        while((first + second) <high+1 ){
            //first[iFirst] < second[iSecond]
            //first<second
            if (comparator.compare(sort.get(first), sort.get(second)) < 0) {
                first++;
            }
            else{
                // 2, 4, 6, 8, 3, 7
                // 2, 4, 6, 7, 8, 3
                E temp = sort.get(second);
                for(int i = second;i>first;i--){
                    sort.set(i, sort.get(i-1));
                }
                sort.set(first,temp);
                first++;
            }
        }
    }

    //    public static <E> void sortTest(DelayedList<E> sort, DelayedComparator<E> comparator) {
//        int left = 0;
//        int right = sort.size() - 1;
//        sortTestRecur1(sort,comparator,left,right);
//    }
//    public static <E> void sortTestRecur1(DelayedList<E> sort, DelayedComparator<E> comparator, int left, int right) {
//        //0,1,2,3,4,5,6,7,8,9
//        //0,1,2,3,4 | 5,6,7,8,9
//        //0,1, 2 ,3,4 | 5,6, 7 ,8,9
//        int pivot;
//        if (left < right) {
//            pivot = (left + right) / 2;
//            sortTestRecur1(sort, comparator, left, pivot);
//            sortTestRecur1(sort, comparator, pivot + 1, right);
//            sortTestRecur2(sort, comparator, left, pivot, right);
//        }
//    }

//        int mid;
//        int temp=0;
//        int num = right - left;
//        if(num == 0|| num ==1){
//            return;
//        }
//        mid = (right + left) / 2;
//        sortTestRecur1(sort, comparator , left,mid);
//        sortTestRecur1(sort, comparator , (mid+1) ,right);

//        sortTestRecur2(sort, comparator ,left, (mid+1), right);

//    public static <E> void sortTestRecur2(DelayedList<E> sort, DelayedComparator<E> comparator, int left, int mid ,int right){
//        int i, left_end, num_elements, tmp_pos;
//        left_end = (mid - 1);
//        tmp_pos = left;
//        num_elements = (right - left + 1);
//
//        while ((left <= left_end) && (mid <= right)) {
//            //left<mid
//            if (comparator.compare(sort.get(left), sort.get(mid)) < 0){
//                E temp = sort.get(tmp_pos);
//                sort.set(tmp_pos, sort.get(left));
//                sort.set(left, temp);
//                tmp_pos++;
//                left++;
//            }
//            else{
//                E temp = sort.get(tmp_pos);
//                sort.set(tmp_pos, sort.get(mid));
//                sort.set(mid, temp);
//                tmp_pos++;
//                mid++;
//            }
//        }
////        while (left <= left_end) {
////            if (comparator.compare(sort.get(tmp_pos), sort.get(left)) < 0) {
////                E temp = sort.get(tmp_pos);
////                sort.set(tmp_pos, sort.get(left));
////                sort.set(left, temp);
////                tmp_pos++;
////            }
////            left++;
////        }
////
////        while (mid <= right) {
////            if (comparator.compare(sort.get(tmp_pos), sort.get(mid)) > 0) {
////                E temp = sort.get(tmp_pos);
////                sort.set(tmp_pos, sort.get(mid));
////                sort.set(mid, temp);
////                tmp_pos++;
////            }
////            mid++;
////        }
//    }
//
//    public static <E> void sortTest(DelayedList<E> sort, DelayedComparator<E> comparator) {
//        sort(sort, comparator, 0, (sort.size()-1));
//    }

//    public static <E> void sortCheck(DelayedList<E> sort, DelayedComparator<E> comparator){
//        int sorted = 0;
//        int unsorted = 1;
//        for(int i=0;i<sort.size();i++){
//            //first[iFirst] < second[iSecond]
//            //unsorted<sorted
//            if (comparator.compare(sort.get(unsorted), sort.get((sorted))) < 0) {
//                int uns = unsorted;
//                int s = sorted;
//                while(){
//                    // 1 5 6 8 13 2
//                    // 1   5 6 8 13
//                    // 1 2 5 6 8 13
//                    E temp = sort.get(uns);
//                    sort.set(uns, sort.get(s));
//                    sort.set(s, temp);
//                    s--;
//                    uns--;
//                }
//            }
//        }
//    }

//    public static <E> void sort(DelayedList<E> sort, DelayedComparator<E> comparator, int min, int max) {
//        //Get the number of elements to sort
//        int num = max - min;
//        //BaseCase - if there are only 1 or 0 elements left, we are done
//        if (num <= 1) return;
//        //Recursively sort left and right halves
//        int mid = (min + max) / 2;
//        sort(sort, comparator, min, mid);
//        sort(sort, comparator, mid + 1, max);
//        //In-place merge
//        int left = min;
//        int right = mid + 1;
//        //Check if we can skip the merge
//        if (comparator.compare(sort.get(mid), sort.get(right)) <= 0) return;
//        while (left <= mid && right <= max) {
//            //go left
//            if (comparator.compare(sort.get(left), sort.get(right)) <= 0)
//                left++;
//                //replace from right
//            else {
//                E moveLeft = sort.get(right);
//                for (int i = 0; i <= right - left; i++) {
//                    E temp = sort.get(left+1);
//                    int index = left+i+1;
//                    sort.set(index, temp);
//                }
//                sort.set(left, moveLeft);
//                //everything moved
//                left++;
//                mid++;
//                right++;
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
//        for (int i = 0; i < 30; i++)
//            test2.add(i,(int) (Math.random() * 100));
//
//        for (int i = 0; i < test2.size(); i++)
//            System.out.print(test2.get(i) + " ");
//
//        System.out.println();
//        sortTest(test2, comp2);
//        QuickSorter check = new QuickSorter();
//        check.sort(test2, comp2);
//
//        for (int i = 0; i < test2.size(); i++)
//            System.out.print(test2.get(i) + " ");
//    }
}
