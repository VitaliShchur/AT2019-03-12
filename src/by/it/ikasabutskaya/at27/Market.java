package by.it.ikasabutskaya.at27;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Market opened");
        List<Thread> threads = new ArrayList<>();

        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 2 ; i++) {
            Cashier cashier = new Cashier(i);
            threadPool.execute(cashier);
        }

        threadPool.shutdown();


        while (Dispatcher.marketOpened()) {
            int count = Util.random(2);
            for (int i = 0; i < count; i++) {
                if (Dispatcher.marketOpened()) {
                    Buyer buyer = new Buyer(Dispatcher.buyerIn());
                    threads.add(buyer);
                    buyer.start();
                }
            }
        }

        while (!threadPool.isTerminated()){
            Util.sleep(10);
        }

        System.out.println("Market closed");

    }


}

