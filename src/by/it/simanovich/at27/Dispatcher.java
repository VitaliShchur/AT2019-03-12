package by.it.simanovich.at27;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    static final int K_SPEED = 5000;

    private static final int PLAN = 100;
    private static final AtomicInteger buyerInShop=new AtomicInteger(0);
    private static final AtomicInteger buyerCounter = new AtomicInteger(0);

    static boolean marketClosed() {
        return buyerCounter.get() >= PLAN &&
                buyerInShop.get() == 0;
    }

    static boolean marketOpened(){
        return buyerCounter.get()<PLAN;
    }

    static int buyerIn(){
        buyerCounter.getAndIncrement();
        buyerInShop.getAndIncrement();
        return buyerCounter.get();
    }

    static void buyerOut(){
        buyerInShop.getAndDecrement();
    }

    static void reset() {
        buyerInShop.set(0);
        buyerCounter.set(0);
    }
}
