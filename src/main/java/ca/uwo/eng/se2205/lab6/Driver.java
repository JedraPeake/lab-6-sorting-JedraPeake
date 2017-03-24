package ca.uwo.eng.se2205.lab6;

import java.io.IOException;

/**
 * Created by PeakeAndSons on 2017-03-22.
 */
public class Driver {
    public static void main(String[] args) throws IOException {
        BatchRunner batch = new BatchRunner();
        batch.enqueue(new myrunnable());
        batch.run();

    }

}
