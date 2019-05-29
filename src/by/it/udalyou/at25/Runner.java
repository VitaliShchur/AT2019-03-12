package by.it.udalyou.at25;

import java.util.*;

public class Runner {
    private static Map<String, Double> good;

    public static void main(String[] args) {
    List<Buyer> buyers =new ArrayList<>();
        System.out.println("Market is open");

        System.out.println("Ассортимент магазина:\n");
        good=Util.getGoods();
        System.out.println(good);

     //   Set<Map.Entry<String, Double>> sgoods=good.entrySet();
     //   System.out.println(sgoods);
     //   List<String> keyList = new ArrayList<String>(good.keySet());

        for (int time = 0; time <120 ; time++) {
            Util.sleep(1000);
            int count=Util.random(2);
            for (int i = 0; i <=count ; i++) {
                Buyer buyer=new Buyer(++Dispetcher.buyerCounter);
                buyers.add(buyer);
                buyer.start();
            }


        }
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
                
        System.out.println("Market is close");
    }
}
