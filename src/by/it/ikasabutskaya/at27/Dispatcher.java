package by.it.ikasabutskaya.at27;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    static final int K_SPEED=100;

    private static final int PLAN = 8;
    private static final AtomicInteger buyerCounter = new AtomicInteger(0);
    private static final AtomicInteger buyerInShop = new AtomicInteger(0);

    static boolean marketOpened(){
        return buyerCounter.get()<PLAN;
    }

    static boolean marketClosed(){
        return (buyerCounter.get() >= PLAN) && (buyerInShop.get() == 0);

    }

    static int buyerIn(){
        buyerCounter.getAndIncrement();
        buyerInShop.getAndIncrement();
        return buyerCounter.get();
    }

    static void buyerOut(){
        buyerInShop.getAndDecrement();
    }



}