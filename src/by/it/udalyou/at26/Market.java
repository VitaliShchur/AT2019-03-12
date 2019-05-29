package by.it.udalyou.at26;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Market {
    public static void main(String[] args) {
        Map<String, Double> good;

        for (int j = 0; j < 2; j++) {
            System.out.println("проверочный цикл "+j);

            Dispetcher.reset();
            List<Thread> threads = new ArrayList<>();


            System.out.println("Ассортимент магазина:\n");
            good=Util.getGoods();
            System.out.println(good);
            for (int i = 1; i <= 2; i++) {
                Cashier cashier = new Cashier(i);
                Thread thread = new Thread(cashier);
                threads.add(thread);
                thread.start();
            }
     /*   Cashier cashier2=new Cashier(2);
        Cashier cashier2=new Cashier(2);
        new Thread (cashier1).start();
        new Thread(cashier2).start();
*/

            System.out.println("Market is open");

            //int buyerCounter=0;
            while (Dispetcher.marketOpend()) {
                Util.sleep(1000);
                int count = Util.random(2);
                for (int i = 0; i <= count; i++) {
                    if (Dispetcher.marketOpend()) {
                        Buyer buyer = new Buyer(Dispetcher.buyerIn());
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

            System.out.println("Market is close");
        }
    }
}
