package by.it.agrinkevich.at27;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {
    public static void main(String[] args) {

        Dispatcher.reset();

        ExecutorService threadPool= Executors.newFixedThreadPool(2);
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            threadPool.execute(cashier);
        }

        threadPool.shutdown();

        System.out.println("Market opened");
        while (Dispatcher.marketOpened()) {
            Util.sleep(1000);
            int count = Util.random(2);
            for (int i = 0; i <= count; ++i) {
                if (Dispatcher.marketOpened()) {
                    Buyer buyer = new Buyer(Dispatcher.buyerIn());
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
