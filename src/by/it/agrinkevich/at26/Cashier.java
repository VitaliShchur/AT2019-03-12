package by.it.agrinkevich.at26;

public class Cashier implements Runnable {

    private String name;

    public Cashier(long id) {
        this.name = "\t\tCashier № " + id + " ";
    }

    @Override
    public void run() {
        System.out.println(this + "opened");
        while (!Dispatcher.marketIsClosed()) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {
                System.out.println(this + "started service of " + buyer);
                Util.sleep(Util.random(2000, 5000));
                synchronized (buyer){
                    buyer.notify();
                }
                System.out.println(this + "stopped service of " + buyer);
            }
            else
                Util.sleep(10);
        }
        System.out.println(this + "closed");
    }

    @Override
    public String toString() {
        return name;
    }
}
