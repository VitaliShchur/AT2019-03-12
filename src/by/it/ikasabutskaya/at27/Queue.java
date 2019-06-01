package by.it.ikasabutskaya.at27;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

class Queue {
    private Queue(){

    }
    private static final BlockingDeque<Buyer> QUEUE = new LinkedBlockingDeque<>(30);

    static void addToQueue(Buyer buyer){

            QUEUE.addLast(buyer);

    }

    static Buyer extract(){

        try {
            return QUEUE.pollFirst(10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
