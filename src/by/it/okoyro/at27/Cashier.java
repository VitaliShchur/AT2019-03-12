package by.it.okoyro.at27;

public class Cashier implements Runnable {

	private String name;

	public Cashier(long id) {
		this.name = "\t\tCashier # " + id + " ";
	}

	@Override
	public void run() {
		System.out.println(this + " opens");

		while (!Dispatcher.isShopReadyToClose()) {
			Buyer buyer = BuyersQueue.extract();
			if (buyer != null) {
				System.out.println(this + " starts service of " + buyer);
				Util.sleep(Util.random(2000, 5000));
				synchronized (buyer){ // синхронизация на объекте buyer
					buyer.setWaiting(false);
					buyer.notifyAll();  // "разбудить" buyer
				}
				System.out.println(this + " finishes service of " + buyer);
			}
		}
		System.out.println(this + " closes");
	}

	@Override
	public String toString() {
		return name;
	}
}
