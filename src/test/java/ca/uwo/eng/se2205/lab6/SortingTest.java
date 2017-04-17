package ca.uwo.eng.se2205.lab6;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by kevin on 09/03/2017.
 */
public class SortingTest {


    private final List<Integer> unsorted = Arrays.asList(4, 8, 8, 2, 1, 6);
    private final List<Integer> sorted = Arrays.asList(1, 2, 4, 6, 8, 8);

    private void check(Sorter sorter) {
        DelayedList<Integer> toSort = DelayedList.create(Delayed.Time.Fast, unsorted);
        sorter.sort(toSort, DelayedComparator.create(Integer::compareTo, Delayed.Time.Fast));

        assertEquals("Check sort", sorted, toSort);
    }

    @Test
    public void insertion() throws Exception {
        check(new InsertionSorter());
    }

    @Test
    public void selection() throws Exception {
        check(new SelectionSorter());
    }

    @Test
    public void merge() throws Exception {
        check(new MergeSorter());
    }

    @Test
    public void quick() throws Exception {
        check(new QuickSorter());
    }

}