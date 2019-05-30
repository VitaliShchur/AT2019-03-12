package by.it.simanovich.at26;

class Dispatcher {

    static final int K_SPEED = 5000;

    private static final int PLAN = 100;
    private static volatile int buyerInShop = 0;
    private static volatile int buyerCounter = 0;

    static synchronized boolean marketClosed() {
        return buyerCounter >= PLAN &&
                buyerInShop == 0;
    }

    static synchronized boolean marketOpened(){
        return buyerCounter<PLAN;
    }

    static synchronized int buyerIn(){
        buyerCounter++;
        buyerInShop++;
        return buyerCounter;
    }

    static synchronized void buyerOut(){
        buyerInShop--;
    }

    synchronized static void reset() {
        buyerInShop = 0;
        buyerCounter = 0;
    }
}
