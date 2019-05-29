package by.it.okoyro.at27;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShopRunner {
	public static void main(String[] args) {

		Dispatcher.reset();

		ExecutorService threadsPool = Executors.newFixedThreadPool(2);

		for (int j = 1; j <= 2; j++) {
			Cashier cashier = new Cashier(j);
			threadsPool.execute(cashier);
		}
		threadsPool.shutdown();

		System.out.println("Shop is opened");

		while (Dispatcher.isShopOpened()) {
			Util.sleep(1000);
			int count = Util.random(2); // set max quantity of buyers in one thread
			for (int i = 0; i <= count; i++) {
				if (Dispatcher.isShopOpened()) {
					Buyer buyer = new Buyer(Dispatcher.buyerIn()); // buyerIn method increases total quantity and in shop quantity
					buyer.start();
				}
			}
		}
		while (!threadsPool.isTerminated()) {  // make sure all threads are stopped
			Util.sleep(10);
		}
		System.out.println("Shop is closed");  // shop will be closed when last buyer leaved
	}
}
