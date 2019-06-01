package by.it.ikasabutskaya.at27;

public class Cashier implements Runnable{

    private String name;

    Cashier(long id) {
        this.name = "\tCashier № " + id;
    }

    @Override
    public void run() {
        System.out.println(this + " opened");
        while (!Dispatcher.marketClosed()){
            Buyer buyer = Queue.extract();
            if (buyer!=null){
                System.out.println(this +" started service of "+buyer.getName());
                Util.sleep(Util.random(200,500));
                synchronized (buyer){
                    buyer.setWaiting(false);
                    buyer.notifyAll();
                }
                System.out.println(this +" stopped service of "+buyer.getName());
            }
        }

        System.out.println(this + " closed");
    }

    @Override
    public String toString() {
        return name;
    }
}
