package by.it.udalyou.at27;

import java.util.concurrent.atomic.AtomicInteger;

class Dispetcher {
    static final int K_SPEED=200;
   private static final int PLAN=100;

     private static final AtomicInteger buyerInShop=new AtomicInteger(0);
    private static final AtomicInteger buyerCounter=new AtomicInteger(0);

  static boolean marketClosed(){
        return buyerCounter.get()>=PLAN&&
                buyerInShop.get()==0;
    }
   static boolean marketOpend(){

        return buyerCounter.get()<PLAN;
}
     static int buyerIn (){
        buyerInShop.getAndIncrement();
        buyerCounter.getAndIncrement();
        return buyerCounter.get();
    }
    static void buyerOut(){
     buyerInShop.getAndDecrement();
    }

      static void reset(){
          buyerInShop.set(0);
         buyerCounter.set(0);

     }
}
