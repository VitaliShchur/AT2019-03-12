package by.it.okoyro.at27;

public class Buyer extends Thread implements IBuyer {

	private boolean waiting = false;

	public void setWaiting(boolean waiting) {
		this.waiting = waiting;
	}

	public Buyer(long number) {
		super("Buyer #" + number + " ");
	}

	@Override
	public void run() {
		enterTheShop();
		chooseGoods();
		toQueue();
		goOut();
	}

	@Override
	public void enterTheShop() {
		System.out.println(this + "gets in to the Shop");
	}

	@Override
	public void chooseGoods() {
		System.out.println(this + "starts to choose goods");
		int timeout = Util.random(500, 3000);
		System.out.println(this + "waits for " + timeout + " seconds");
		Util.sleep(timeout);
		System.out.println(this + "finishes to choose goods");

	}

	@Override
	public void toQueue() {
		BuyersQueue.add(this); // buyer adds itself to a queue
		synchronized (this) {  // buyer synchronises itself
			waiting = true;
			while (waiting) {
				try {
					this.wait();  // buyer sleep
				}
				catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	@Override
	public void goOut() {
		System.out.println(this + "gets out of the Shop");
		Dispatcher.buyerOut();
	}

	@Override
	public String toString() {
		return getName(); // метод из Thread, вернет имя, которое мы передаем в конструкторе выше (для удобства печати)
	}
}
