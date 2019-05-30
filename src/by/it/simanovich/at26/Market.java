package by.it.simanovich.at26;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) {

        for (int j = 0; j < 1000; j++) {
            Dispatcher.reset();
            List<Thread> threads = new ArrayList<>();


            for (int i = 1; i <= 2; i++) {
                Cashier cashier = new Cashier(i);
                Thread thread = new Thread(cashier);
                threads.add(thread);
                thread.start();
            }

            System.out.println("Market opened");
            while (Dispatcher.marketOpened()) {
                Util.sleep(1000);
                int count = Util.random(2);
                for (int i = 0; i <= count; i++) {
                    if (Dispatcher.marketOpened()) {
                        Buyer buyer = new Buyer(Dispatcher.buyerIn());
                        threads.add(buyer);
                        buyer.start();
                    }
                }
            }
            for (Thread buyer : threads) {
                try {
                    buyer.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Market close");
        }
    }
}
