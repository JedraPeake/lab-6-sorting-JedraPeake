package ca.uwo.eng.se2205.lab6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static ca.uwo.eng.se2205.lab6.Delayed.Time.*;

/**
 * Created by PeakeAndSons on 2017-03-22.
 */
public class myrunnable implements Runnable {

    //DIFFERENT PARTS FOR SWAPING COMPARETERS AND SWAPPING N's



    //part 1
//    @Override
//    public void run() {
//        //CHANGED EVERY TIME FOR EACH SORTING ALGORITHM
//        QuickSorter a = new QuickSorter();
//        List<Integer> test = RandomNumbers.get(40);
//        DelayedList<Integer> test2 = DelayedList.create(Fast, test);
//        Comparator<Integer> comp = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if(o1>o2) return 1;
//                if (o1==o2) return 0;
//                return -1;
//            }
//        };
//        List<Delayed.Time> t = new ArrayList<>();
//        t.add(0,Fast);
//        t.add(1,Normal);
//        t.add(2,Slow);
//        for (int i = 0; i<3;i++){
//            DelayedComparator<Integer> comp2 = DelayedComparator.create(comp, t.get(i));
//            long firstStart =System.nanoTime();
//            a.sort(test2, comp2);
//            long firstTotal = System.nanoTime() - firstStart;
//            System.out.println("List Comparisions preformed "+test2.getOperationsPerformed());
//            System.out.println("List Speed "+t.get(i)+" is:"+firstTotal);
//            System.out.println();
//            for(int j =0; j<3;j++){
//                DelayedComparator<Integer> myComp = DelayedComparator.create(comp, t.get(i));
//                DelayedList<Integer> test3 = DelayedList.create(t.get(j), test);
//                long secondStart =System.nanoTime();
//                a.sort(test3, myComp);
//                System.out.println("Comparisions preformed "+myComp.getComparisonsPerformed());
//                long secondTime = System.nanoTime() - secondStart;
//                System.out.println("Comparator "+t.get(j)+" is:"+(secondTime+firstTotal));
//
//            }
//            System.out.println();
//        }
//    }

    //part 2
    @Override
    public void run() {
        //5,10,20,40,100
        List<Integer> n = new ArrayList<>();
        n.add(0,5);
        n.add(1,10);
        n.add(2,20);
        n.add(3,40);
        n.add(4,100);

        //CHANGED EVERY TIME FOR EACH SORTING ALGORITHM
        SelectionSorter a = new SelectionSorter();
        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2) return 1;
                if (o1==o2) return 0;
                return -1;
            }
        };

        for (int i = 0; i<5;i++){
            List<Integer> test = RandomNumbers.get(n.get(i));
            System.out.println("Number "+n.get(i));
            DelayedList<Integer> test2 = DelayedList.create(Fast, test);
            DelayedComparator<Integer> myComp = DelayedComparator.create(comp, Fast);
            long Start =System.nanoTime();
            a.sort(test2,myComp);
            long End =System.nanoTime()-Start;
            System.out.println("Time: "+End);
            System.out.println("List Comparisons: "+test2.getOperationsPerformed());
            System.out.println("Comparater: "+myComp.getComparisonsPerformed());
            System.out.println();
        }

    }
}
