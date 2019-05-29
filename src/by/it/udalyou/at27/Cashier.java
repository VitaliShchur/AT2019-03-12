package by.it.udalyou.at27;



public class Cashier implements Runnable{


    public String name;

    public Cashier(long id) {
        this.name ="\t\tCashier № "+id+" " ;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        System.out.println(this+" opend");
        while (!Dispetcher.marketClosed()){
                 Buyer buyer=QueueBuyers.extract();
            if (buyer!=null){
                System.out.println(this+" started servis of "+buyer);
                Util.sleep(Util.random(2000,5000));
                System.out.println(this+" stoped servis of "+buyer);
                synchronized (buyer){
                    buyer.setWaiting(false);
                    buyer.notifyAll();
                }
            }

        }

        System.out.println(this+" closed");
    }
}
