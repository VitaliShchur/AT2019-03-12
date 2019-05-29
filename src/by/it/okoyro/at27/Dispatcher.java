package by.it.okoyro.at27;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

	static final int K_SPEED = 100; // is used to increase speed

	private static final int PLAN = 100;

	private static final AtomicInteger totalBuyersCounter = new AtomicInteger(0);
	private static final AtomicInteger buyersInShop = new AtomicInteger(0);

	static boolean isShopReadyToClose() {
		return totalBuyersCounter.get() >= PLAN &&
			   buyersInShop.get() == 0;
	}

	static boolean isShopOpened() {
		return totalBuyersCounter.get() < PLAN;
	}

	static int buyerIn() {   // method has to be
		totalBuyersCounter.getAndIncrement();
		buyersInShop.getAndIncrement();
		return totalBuyersCounter.get();
	}

	static void buyerOut() {
		buyersInShop.getAndDecrement();
	}

	static void reset() {
		totalBuyersCounter.set(0);
        buyersInShop.set(0);
    }
}
